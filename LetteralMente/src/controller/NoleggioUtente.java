package controller;

import java.io.IOException;
import java.util.Calendar;
import java.sql.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Noleggio;


@WebServlet("/NoleggioUtente")
public class NoleggioUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public NoleggioUtente() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("idLibro")!=null && request.getParameter("dataInizio")!=null && request.getParameter("dataFine")!=null 
				&& !request.getParameter("dataInizio").equals("") && !request.getParameter("dataFine").equals("")
				&& Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))).getQuantita()>0) {

			Noleggio n= new Noleggio();

			n.setDataInizio(Date.valueOf(request.getParameter("dataInizio")));
			n.setDataFine(Date.valueOf(request.getParameter("dataFine")));
			n.setInCorso(true);		
			Utility.inserisciNoleggio(n, Integer.parseInt(request.getParameter("idLibro")), Integer.parseInt(request.getParameter("idUtente")));
			//diminuisco di 1 la quantità
			Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))).setQuantita(Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))).getQuantita()-1);
		}
	}

}
