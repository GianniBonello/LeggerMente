package controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;

@WebServlet("/ModificaProfilo")
public class ModificaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaProfilo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utente u = (Utente) request.getSession().getAttribute("utenteLoggato");
		request.getSession().setAttribute("utenteLoggato",u);
	//	response.sendRedirect("/LeggerMente/view/ilmioprofilo.jsp");
		request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email"),comune=request.getParameter("comune"),cap=request.getParameter("cap"),
				indirizzo=request.getParameter("indirizzo"),username=request.getParameter("username"),password=request.getParameter("password"),
				nome = request.getParameter("nome"), cognome = request.getParameter("cognome"), cf = request.getParameter("cf"), dataDiNascita = request.getParameter("datadinascita");
		
		Utente u = (Utente) request.getSession().getAttribute("utenteLoggato");
		Utente uMod = new Utente(u.getIdUtente(),u.getCap(),u.getCf(),u.getCognome(),u.getComune(),u.getDataDiNascita(),u.getEmail(),u.getIndirizzo(),u.getNome(),u.getPassword(),u.getUsername());
		System.out.println(u.getNome()+" "+uMod.getNome()+" "+nome);
		if(password != null && Base64.getEncoder().encodeToString((request.getParameter("password")).getBytes()).equals(u.getPassword())) {
			
			if(email != null && comune != null && cap != null && indirizzo != null && username != null 
					&& comune!=null && indirizzo != null ) {

				//Utente u = (Utente) request.getSession().getAttribute("utenteLoggato");
				uMod.setEmail(email);
				uMod.setComune(comune);
				uMod.setCap(cap);
				uMod.setIndirizzo(indirizzo);
				uMod.setUsername(username);
				//u.setPassword(password);	
				try {					
					Utility.modificaUtente(uMod);
					
					request.setAttribute("modifica", "successo");
					request.getSession().setAttribute("utenteLoggato", uMod);
					//request.getSession().setAttribute("utenteLoggato", uMod);
					request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);
				} catch (RollbackException e) {		
					//request.getSession().setAttribute("utenteLoggato", u);
					request.setAttribute("modifica", "giaEsistenti");
					request.getRequestDispatcher("ControlloIniziale").forward(request, response);
					
				}
				
			}else if ((nome!=null && !nome.equals(u.getNome())) || (cognome!=null && !cognome.equals(u.getCognome())) ||(cf!=null && !cf.equals(u.getCf ( ) ) ) ) {
				System.out.println("if campi non modificabili servlet");
				request.setAttribute("modifica", "campiNonModificabili");
				request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);
			}else {request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);}
		}else {
			System.out.println(password+" pass");
			if(password != null && !password.equals(" "))
				request.setAttribute("modifica", "passwordErrata");
			else 
				request.setAttribute("modifica", "passwordNonInserita");
			request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);
		}

		
	}

}
