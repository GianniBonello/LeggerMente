package controller;

import java.io.IOException;
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
			
			if(request.getParameter("idLibro")!= null && Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))).getQuantita()>0) {
					Prenotazione p = new Prenotazione();
					p.setData(new Date());
					Utility.inserisciPrenotazione(p, Integer.parseInt(request.getParameter("idLibro")), ((Utente)request.getSession().getAttribute("utenteLoggato")).getIdUtente());
					/*passaggio del parametro per stampare la conferma*/
					request.setAttribute("prenotazione", "effettuata");
				}else {
					request.setAttribute("prenotazione", "libriFiniti");
			}
			//torna alla servlet che setta i libri
			request.getRequestDispatcher("ListaLibri").forward(request, response);
	}

}
