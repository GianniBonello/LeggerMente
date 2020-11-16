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
import model.Utente;


@WebServlet("/NoleggioUtente")
public class NoleggioUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public NoleggioUtente() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dataFine=request.getParameter("dataFine"),idLibro=request.getParameter("idLibro");
		Utente u = (Utente)request.getSession().getAttribute("utenteLoggato");
		System.out.println(idLibro);
		
		if (idLibro!=null &&!idLibro.equals("") && dataFine!=null && !dataFine.equals("")	&& LocalDate.now().isBefore(LocalDate.parse(dataFine))
				&& u!=null && LocalDate.parse(dataFine).isBefore(LocalDate.now().plusMonths(2).plusDays(1))) {
			Libro li = Utility.trovaLibro(Integer.parseInt(idLibro));
			System.out.println("primo if noleggio");
			if(li.getQuantita()>0) {
				System.out.println("secondo if noleggio");
				Noleggio n= new Noleggio();				
				n.setDataInizio(Date.valueOf(LocalDate.now()));
				n.setDataFine(Date.valueOf(LocalDate.parse(dataFine)));
				Utility.inserisciNoleggio(n, Integer.parseInt(idLibro), u.getIdUtente());				
				li.setQuantita(li.getQuantita()-1);
				Utility.modificaLibro(li);
				request.getSession().setAttribute("noleggio", Utility.trovaNoleggio(u.getIdUtente(), li.getId_libro()));
				request.setAttribute("libro", li);
				response.sendRedirect("ConfermaNoleggio");
				}else {
					System.out.println("primo else noleggio");
					request.setAttribute("noleggio", "error");
					request.getRequestDispatcher("ControlloIniziale").forward(request, response);				
				}
		}else {
			System.out.println("primo else noleggio");
			request.setAttribute("noleggio", "error");
			request.getRequestDispatcher("ControlloIniziale").forward(request, response);
		}
		//request.getRequestDispatcher("ListaLibri").forward(request, response);

		//n.setDataInizio(Date.valueOf(request.getParameter("dataInizio")));
		//n.setDataFine(Date.valueOf(request.getParameter("dataFine")));
		//n.setInCorso(true);		

	}
}
