package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import Util.UtilityRicerca;
import model.Utente;


@WebServlet("/ListaUtenti")
public class ListaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ListaUtenti() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Utente utenteLog = (Utente)request.getSession().getAttribute("utenteLoggato");
		System.out.println("sono nel doget");
		if(request.getSession().getAttribute("utenteLoggato") != null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()) {
			System.out.println("sono uno dello staff");
			 if(request.getParameter("elimina")!=null && utenteLog.getUsername().equals("Admin")){
				 System.out.println("voglio eliminare e sono un admin");
					//elimina
					try {
						Utility.eliminaUtente(Integer.parseInt(request.getParameter("elimina")));
						request.setAttribute("utenteEliminato", "utente eliminato con successo");
					} catch (IllegalArgumentException e) {
						// TODO: handle exception
						request.setAttribute("utenteEliminato", "operazione non riuscita");
					}				
				}else if(request.getParameter("elimina")!=null && !utenteLog.getUsername().equals("Admin") && !Utility.trovaUtente(Integer.parseInt(request.getParameter("elimina"))).getIsStaff()){
					System.out.println("voglio eliminare non sono un admin e l utente non è staff");
					try {
						Utility.eliminaUtente(Integer.parseInt(request.getParameter("elimina")));
						request.setAttribute("utenteEliminato", "utente eliminato con successo");
					} catch (IllegalArgumentException e) {
						// TODO: handle exception
						request.setAttribute("utenteEliminato", "operazione non riuscita");
					}		
				}
			 
			 if (request.getParameter("id")!=null) {
					System.out.println("ID" + request.getParameter("id"));
					Utente a = Utility.trovaUtente(Integer.parseInt(request.getParameter("id")));
					
					if(a.getIsStaff()) {
						
						a.setIsStaff(false);
						Utility.modificaUtente(a);
						
					}else {
						a.setIsStaff(true);
						Utility.modificaUtente(a);
					}
					
				
				}
			
			if(request.getParameter("campo") != null && request.getParameter("ricerca") != null) {
				System.out.println("sono entrato nell'if di ricerca");
				request.setAttribute("listaUtenti", UtilityRicerca.ricercaUtente(request.getParameter("campo"), request.getParameter("ricerca")));
			}else request.setAttribute("listaUtenti", Utility.leggiUtente());
			
			
			/////////////SWITCH
			
			
			
			request.getRequestDispatcher("/view/gestioneutenti.jsp").include(request, response);
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utenteLog = (Utente)request.getSession().getAttribute("utenteLoggato");
		Utente gener = Utility.trovaUtente(Integer.parseInt(request.getParameter("idUtente")));
		System.out.println("sono entrata nel dopost");
		String nome = request.getParameter("nome"), cognome = request.getParameter("cognome"), dataDiNascita = request.getParameter("dataDiNascita"),
		cf = request.getParameter("cf"), email = request.getParameter("email"),username = request.getParameter("username"), password = request.getParameter("password"),
		comune = request.getParameter("comune"), indirizzo = request.getParameter("indirizzo"), cap = request.getParameter("cap");

		if(utenteLog.getUsername().equals("Admin")) {//se sei admin
			System.out.println("sono un admin");
			if(nome!=null && !nome.equals("")&&//se hai tutti i paramentri
					cognome!=null && !cognome.equals("")&&dataDiNascita!=null && !dataDiNascita.equals("")&&cf!=null && !cf.equals("")&&
					email!=null && !email.equals("")&&username!=null && !username.equals("")&&password!=null && !password.equals("")&&
					comune!=null && !comune.equals("")&&indirizzo!=null && !indirizzo.equals("")&&cap!=null && !cap.equals("")) {
				
				if(LocalDate.parse(dataDiNascita).isBefore(LocalDate.now().plusYears(-15))&&LocalDate.parse(dataDiNascita).isAfter(LocalDate.now().plusYears(-110))) {
					Utente g = new Utente(gener.getIdUtente(), cap,cf,cognome,comune,Date.valueOf(dataDiNascita),email,indirizzo,nome,password,username);
					Utility.modificaUtente(g);
					request.setAttribute("utenteModificato", "utente modificato con successo");
				}request.setAttribute("utenteModificato", "errore");
				

			}
		}else if(utenteLog.getIsStaff()  && !gener.getIsStaff()) {//se non è admin
			System.out.println("non sono un admin");
			if(nome!=null && !nome.equals("")&&//se hai tutti i paramentri
					cognome!=null && !cognome.equals("")&&
					dataDiNascita!=null && !dataDiNascita.equals("")&&
					cf!=null && !cf.equals("")&&
					email!=null && !email.equals("")&&
					username!=null && !username.equals("")&&
					password!=null && !password.equals("")&&
					comune!=null && !comune.equals("")&&
					indirizzo!=null && !indirizzo.equals("")&&
					cap!=null && !cap.equals("")) {
				System.out.println("voglio fare una modifica!");
				
				if(LocalDate.parse(dataDiNascita).isBefore(LocalDate.now().plusYears(-15))&&LocalDate.parse(dataDiNascita).isAfter(LocalDate.now().plusYears(-110))) {
					Utente g = new Utente(gener.getIdUtente(), cap,cf,cognome,comune,Date.valueOf(dataDiNascita),email,indirizzo,nome,password,username);
					Utility.modificaUtente(g);
					request.setAttribute("utenteModificato", "successo");
				}else request.setAttribute("utenteModificato", "errore");

			}else request.setAttribute("operazioneNonRiuscita", "operazione non riuscita");

		}
		doGet(request,response);

	}
}
