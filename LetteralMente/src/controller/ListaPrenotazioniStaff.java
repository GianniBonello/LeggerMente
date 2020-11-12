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
		
		if(request.getSession().getAttribute("UtenteLoggato") != null && ((Utente)request.getSession().getAttribute("UtenteLoggato")).getIsStaff()) {
			if(request.getParameter("campo") != null && request.getParameter("ricerca") != null) {
				request.setAttribute("listaPrenotazioni", UtilityRicerca.ricercaPrenotazione(request.getParameter("campo"), request.getParameter("ricerca")));
			}else request.setAttribute("listaPrenotazioni", Utility.leggiPrenotazione());
			
			request.getRequestDispatcher("/listaPrenotazioni.jsp").forward(request, response);//TODO non sappiamo come si chiama la jsp dei prenotazione che vedono gli staff
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
}
