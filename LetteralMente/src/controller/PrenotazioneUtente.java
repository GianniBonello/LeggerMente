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

@WebServlet("/PrenotazioneUtente")
public class PrenotazioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PrenotazioneUtente() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idLibro")!= null && request.getAttribute("idLibro")==null) {
			Libro l = Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro")));
			Utente u = (Utente)request.getSession().getAttribute("utenteLoggato");
				//TODO dobbiamo rivedere se il libro ha quantita < 0 non devo settare la data e va messo in lista
				if(l.getQuantita()>0) {
					System.out.println("sono nell  if quantita maggiore 0");
						Prenotazione p = new Prenotazione();
						p.setData(new Date());
						p.setInCorso(true);
						Utility.inserisciPrenotazione(p, Integer.parseInt(request.getParameter("idLibro")), u.getIdUtente());
						l.setQuantita(l.getQuantita()-1);
						Utility.modificaLibro(l);
						/*passaggio del parametro per stampare la conferma*/
						request.setAttribute("prenotazione", Utility.trovaPrenotazione(u.getIdUtente(), l.getId_libro()));
						request.getRequestDispatcher("/view/confermaprenotazione.jsp").include(request, response);
				}else if(l.getQuantita() <= 0){
					System.out.println("sono nell else if quantita minore 0");
						//request.setAttribute("prenotazione", "libriFiniti");
						Prenotazione p = new Prenotazione();
						p.setInCorso(false);
						//prenotazioniInCoda.add(p);
						Utility.inserisciPrenotazione(p, Integer.parseInt(request.getParameter("idLibro")), u.getIdUtente());
						request.setAttribute("prenotazione", Utility.trovaPrenotazione(u.getIdUtente(), l.getId_libro()));
						request.setAttribute("attesa", Utility.trovaPrenotazione(l).size());
						request.getRequestDispatcher("/view/confermaincoda.jsp").include(request, response);
				}
		}else {
			System.out.println("else");
			request.setAttribute("idLibro", request.getParameter("idLibro"));
			request.getRequestDispatcher("DettaglioLibro").forward(request, response);
		}
		request.setAttribute("idLibro","basta");
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
	}

}
