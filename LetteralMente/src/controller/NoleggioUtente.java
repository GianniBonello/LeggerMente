package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;
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

		if (request.getParameter("idLibro")!=null && request.getParameter("dataFine")!=null 
				&& !request.getParameter("dataFine").equals("")
				&& Utility.trovaLibro(Integer.parseInt(request.getParameter("isbn"))).getQuantita()>0 &&
				 LocalDate.now().isBefore(LocalDate.parse(request.getParameter("dataFine")))) {

			Noleggio n= new Noleggio();
			//controllare che la prima data è minore della seconda
			//controllare che quel libro non ha altri noleggi con la data di riconsegna maggiore della data di partenza di questo noleggio allora non lo puo noleggiare solo se la quantita è 1
				Utility.inserisciNoleggio(n, Integer.parseInt(request.getParameter("idLibro")), Integer.parseInt(request.getParameter("idUtente")));
				//diminuisco di 1 la quantità
				n.setDataInizio(Date.valueOf(LocalDate.now()));
				n.setDataFine(Date.valueOf(LocalDate.parse(request.getParameter("dataFine"))));
				//.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))).setQuantita(Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))).getQuantita()-1);
				Libro l = Utility.trovaLibro(Integer.parseInt(request.getParameter("isbn")));
				l.setQuantita(l.getQuantita()-1);
				Utility.modificaLibro(l);
				request.setAttribute("noleggio", "effettuato");
			}else request.setAttribute("noleggio", "error");
		
		request.getRequestDispatcher("ListaLibri").forward(request, response);

			//n.setDataInizio(Date.valueOf(request.getParameter("dataInizio")));
			//n.setDataFine(Date.valueOf(request.getParameter("dataFine")));
			//n.setInCorso(true);		
			
		}
	}
