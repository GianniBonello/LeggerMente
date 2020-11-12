package controller;

import java.io.IOException;
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
		if(request.getSession().getAttribute("UtenteLoggato") != null && ((Utente)request.getSession().getAttribute("UtenteLoggato")).getIsStaff()) {
			if(request.getParameter("campo") != null && request.getParameter("ricerca") != null) {
				request.setAttribute("listaUtenti", UtilityRicerca.ricercaUtente(request.getParameter("campo"), request.getParameter("ricerca")));
			}else request.setAttribute("listaUtenti", Utility.leggiUtente());
			
			request.getRequestDispatcher("/listaUtenti.jsp").forward(request, response);
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
