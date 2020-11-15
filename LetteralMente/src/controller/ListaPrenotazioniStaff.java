package controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import Util.UtilityRicerca;
import model.Prenotazione;
import model.Utente;


@WebServlet("/ListaPrenotazioniStaff")
public class ListaPrenotazioniStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaPrenotazioniStaff() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession().getAttribute("utenteLoggato") != null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()) {
			System.out.println(request.getParameter("idPrenotazione"));
			if(request.getParameter("idPrenotazione")!=null) {
				Prenotazione p =  Utility.trovaPrenotazione(Integer.parseInt(request.getParameter("idPrenotazione")));
				System.out.println(p.getIdprenotazione()+" id prenotazione");
				System.out.println("sei entrato nell'if giusto!");
				p.setInCorso(false);
				Utility.modificaPrenotazione(p);
				request.setAttribute("convalidaPrenotazione", "effettuata");
				request.setAttribute("listaPrenotazioni", Utility.leggiPrenotazione());

			}else if(request.getParameter("campo") != null && request.getParameter("ricerca") != null) {
				request.setAttribute("listaPrenotazioni", UtilityRicerca.ricercaPrenotazione(request.getParameter("campo"), request.getParameter("ricerca")));
				request.getRequestDispatcher("/view/gestioneprenotazioni.jsp").include(request, response);
			}else request.setAttribute("listaPrenotazioni", Utility.leggiPrenotazione());
			
			request.getRequestDispatcher("/view/gestioneprenotazioni.jsp").include(request, response);//TODO non sappiamo come si chiama la jsp dei prenotazione che vedono gli staff
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
}
