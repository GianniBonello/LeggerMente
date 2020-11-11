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
			//TODO dobbiamo rivedere se il libro ha quantita < 0 non devo settare la data e va messo in lista
			if(request.getParameter("isbn")!= null && Utility.trovaLibro(request.getParameter("isbn")).getQuantita()>0) {

					Prenotazione p = new Prenotazione();
					p.setData(new Date());
					Utility.inserisciPrenotazione(p, request.getParameter("isbn"), ((Utente)request.getSession().getAttribute("utenteLoggato")).getIdUtente());
					/*passaggio del parametro per stampare la conferma*/
					request.setAttribute("prenotazione", "effettuata");
				}else {
					//request.setAttribute("prenotazione", "libriFiniti");
					Prenotazione p = new Prenotazione();
					//prenotazioniInCoda.add(p);
					Utility.inserisciPrenotazione(p, request.getParameter("isbn"), ((Utente)request.getSession().getAttribute("utenteLoggato")).getIdUtente());
			}
			//torna alla servlet che setta i libri
			request.getRequestDispatcher("ListaLibri").forward(request, response);
	}

}
