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
import model.Prenotazione;


@WebServlet("/ListaPrenotazioniStaff")
public class ListaPrenotazioniStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaPrenotazioniStaff() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Prenotazione>listaPrenotazioni= Utility.leggiPrenotazione();		

		if(request.getParameter("codicePrenotazione")!=null && request.getParameter("codicePrenotazione")!=null
				&& listaPrenotazioni.contains(Utility.trovaPrenotazione(Integer.parseInt(request.getParameter("codicePrenotazione"))))) {
			//svuoto array 
			listaPrenotazioni.clear();
			//riempio array con la prenotazione che stavo cercando
			listaPrenotazioni.add(Utility.trovaPrenotazione(Integer.parseInt(request.getParameter("codicePrenotazione"))));
		}

		request.setAttribute("listaPreonotazioni", listaPrenotazioni); 
		request.getRequestDispatcher("/listaPrenotazioni.jsp").forward(request, response);
	}
}
