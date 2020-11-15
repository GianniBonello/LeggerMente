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


@WebServlet("/CancellaPrenotazioneUtente")
public class CancellaPrenotazioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CancellaPrenotazioneUtente() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente)request.getSession().getAttribute("utenteLoggato");
		
		if(u!=null  && !u.getIsStaff()) {
			
			if (request.getParameter("cancella")!=null) {
				Prenotazione p = Utility.trovaPrenotazione(Integer.parseInt(request.getParameter("cancella")));
				if (p.getData()==null && p.getU().getIdUtente()==u.getIdUtente()) {
					Utility.eliminaPrenotazione(Integer.parseInt(request.getParameter("cancella")));
				}
				//se la prenotazione con quell'id esiste
				
			}
			
			request.setAttribute("listaPrenotazioni", Utility.trovaPrenotazione(u));
			request.getRequestDispatcher("/view/storicoprenotazioni.jsp").include(request, response);
			
		
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response); 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
