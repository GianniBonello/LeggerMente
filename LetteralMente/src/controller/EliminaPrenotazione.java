package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;

@WebServlet("/EliminaPrenotazione")
public class EliminaPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EliminaPrenotazione() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utenteLog = (Utente)request.getSession().getAttribute("utenteLoggato");

		if(request.getParameter("idPrenotazione") != null && utenteLog.getUsername().equals("Admin")) {
			try {
				Utility.eliminaPrenotazione(Integer.parseInt(request.getParameter("idPrenotazione")));
				request.setAttribute("prenotazioneEliminata", "eliminata");
				request.getRequestDispatcher("/listaPrenotazioni.jsp");
			} catch (IllegalArgumentException e) {
				request.setAttribute("prenotazioneEliminata", "errore");
			}
		}
	}

}
