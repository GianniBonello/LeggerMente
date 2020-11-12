package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;
import model.Prenotazione;
import model.Utente;

@WebServlet("/Prenotazione")
public class PrenotazioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrenotazioneUtente() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idLibro")!= null) {
			Libro l = Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro")));
			Utente u = (Utente)request.getSession().getAttribute("utenteLoggato");
				//TODO dobbiamo rivedere se il libro ha quantita < 0 non devo settare la data e va messo in lista
				if(l.getQuantita()>0) {
						Prenotazione p = new Prenotazione();
						p.setData(new Date());
						Utility.inserisciPrenotazione(p, Integer.parseInt(request.getParameter("idLibro")), u.getIdUtente());
						/*passaggio del parametro per stampare la conferma*/
						request.setAttribute("prenotazione", Utility.trovaPrenotazione(u.getIdUtente(), l.getIsbn()));
						request.getRequestDispatcher("confermaprenotazione.jsp").forward(request, response);
				}else if(l.getQuantita() <= 0){
						//request.setAttribute("prenotazione", "libriFiniti");
						Prenotazione p = new Prenotazione();
						//prenotazioniInCoda.add(p);
						Utility.inserisciPrenotazione(p, Integer.parseInt(request.getParameter("idLibro")), u.getIdUtente());
						request.setAttribute("dettagliPrenotazioneEffettuata.jsp", Utility.trovaPrenotazione(u.getIdUtente(), l.getIsbn()));
				}
		}else {
			request.setAttribute("idLibro", request.getParameter("idLibro"));
			request.getRequestDispatcher("DettaglioLibro").forward(request, response);
		}
			
			
	}

}
