package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Prenotazione;
import model.Utente;


@WebServlet("/ConvalidaPrenotazione")
public class ConvalidaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ConvalidaPrenotazione() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Prenotazione p =  Utility.trovaPrenotazione(Integer.parseInt(request.getParameter("idPrenotazione")));

		if(request.getSession().getAttribute("utenteLoggato")!=null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()
				&& request.getParameter("idPrenotazione")!=null && p!=null) {


			p.setInCorso(false);
			//diminuiamo di 1 la quantità del libro
			Utility.trovaLibro(request.getParameter("isbn")).setQuantita(Utility.trovaLibro(request.getParameter("isbn")).getQuantita()-1);
			request.setAttribute("convalidaPrenotazione", "effettuata");


		}else request.setAttribute("convalidaPrenotazione", "nonRiuscita");

		request.getRequestDispatcher("listaPrenotazioni").forward(request, response);
	}

}
