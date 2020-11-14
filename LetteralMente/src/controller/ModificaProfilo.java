package controller;

import java.io.IOException;
import java.util.Base64;

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
		//request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);
		response.sendRedirect("/LeggerMente/view/ilmioprofilo.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email"),comune=request.getParameter("comune"),cap=request.getParameter("cap"),
				indirizzo=request.getParameter("indirizzo"),username=request.getParameter("username"),password=request.getParameter("password");
		Utente u = (Utente) request.getSession().getAttribute("utenteLoggato");
		if(Base64.getEncoder().encodeToString((request.getParameter("password")).getBytes()).equals(u.getPassword())) {
			
			if(email != null && comune != null && cap != null 
					&& indirizzo != null && username != null 
					&& password != null) {

				//Utente u = (Utente) request.getSession().getAttribute("utenteLoggato");
				u.setEmail(email);
				u.setComune(comune);
				u.setCap(cap);
				u.setIndirizzo(indirizzo);
				u.setUsername(username);
				//u.setPassword(password);	
				try {					
					Utility.modificaUtente(u);					
					request.setAttribute("modifica", "successo");
					request.getSession().setAttribute("utenteLoggato", u);
					request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);
				} catch (RollbackException e) {					
					request.setAttribute("modifica", "giaEsistenti");
					request.getRequestDispatcher("ModificaProfilo").forward(request, response);
					
				}
				
			}else {request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);}
		}else {
			request.setAttribute("modifica", "passwordErrata");
			request.getRequestDispatcher("/view/ilmioprofilo.jsp").include(request, response);
		}

		
	}

}
