package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import Util.UtilityRicerca;
import model.Noleggio;
import model.Utente;


@WebServlet("/ListaNoleggiStaff")
public class ListaNoleggiStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListaNoleggiStaff() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("utenteLoggato") != null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()) {
			System.out.println("ID " + request.getParameter("id"));
			if (request.getParameter("id")!=null) {
				System.out.println("sono dentro");
				Noleggio n = Utility.trovaNoleggio(Integer.parseInt(request.getParameter("id")));
				if (n.getInCorso()) {
					n.setInCorso(false);
					
				}else n.setInCorso(true);
				
				Utility.modificaNoleggio(n);
			}
			
			
			if(request.getParameter("inCorso") != null) {
				//TODO fare il controllo che quando il checkbox cambia devo cambiare il incorso del noleggio da false a true e viceversa
				request.setAttribute("listaNoleggi", Utility.leggiNoleggio());
			}else if(request.getParameter("campo") != null && request.getParameter("ricerca") != null) {
				request.setAttribute("listaNoleggi", UtilityRicerca.ricercaNoleggio(request.getParameter("campo"), request.getParameter("ricerca")));
			}else request.setAttribute("listaNoleggi", Utility.leggiNoleggio());
			
			request.getRequestDispatcher("/view/gestionenoleggi.jsp").include(request, response);//TODO non sappiamo come si chiama la jsp dei noleggi che vedono gli staff
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
