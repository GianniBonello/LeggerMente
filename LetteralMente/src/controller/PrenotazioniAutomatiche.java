package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;
import model.Prenotazione;

/**
 * Servlet implementation class PrenotazioniAutomatiche
 */
@WebServlet("/PrenotazioniAutomatiche")
public class PrenotazioniAutomatiche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrenotazioniAutomatiche() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro l = (Libro)request.getAttribute("libro");
		int cont=0;
		if(request.getAttribute("libro") != null) {
			//mi devo riprende dal database le prenotazioni che hanno quel libro
			List<Prenotazione> lista = Utility.trovaPrenotazione(l);
			for(Prenotazione p : lista) {
				if(l.getQuantita()>0) {
					//TODO dobbiamo inviare le email!
					//contiamo quante modifiche fa e poi richiamiamo solo 1 volta il database per modificare la quantita
					p.setData(new Date());
					p.setInCorso(true);
					Utility.modificaPrenotazione(p);
					cont++;
				}else break;
			}
			
			l.setQuantita(l.getQuantita()-cont);
			Utility.modificaLibro(l);
		}
		request.getRequestDispatcher("ListaLibri").forward(request, response);
	}

}
