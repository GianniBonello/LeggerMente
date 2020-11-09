package controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;


@WebServlet("/ListaPrenotazioniStaff")
public class ListaPrenotazioniStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaPrenotazioniStaff() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaPreonotazioni", Utility.leggiPrenotazione()); 
		request.getRequestDispatcher("/listaPrenotazioni.jsp").forward(request, response);
		//TODO FILTRI
		/*Collection<String> filtered = Collection.filter(Utility.leggiPrenotazione(),
			       Predicates.containsPattern("How"));
			System.out.println(filtered);*/
	}
}
