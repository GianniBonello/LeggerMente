package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import Util.UtilityRicerca;
import model.Utente;


@WebServlet("/ListaNoleggiStaff")
public class ListaNoleggiStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListaNoleggiStaff() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("utenteLoggato") != null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()) {
			if(request.getParameter("campo") != null && request.getParameter("ricerca") != null) {
				request.setAttribute("listaNoleggi", UtilityRicerca.ricercaNoleggio(request.getParameter("campo"), request.getParameter("ricerca")));
			}else request.setAttribute("listaNoleggi", Utility.leggiNoleggio());
			
			request.getRequestDispatcher("/view/gestionenoleggi.jsp").forward(request, response);//TODO non sappiamo come si chiama la jsp dei noleggi che vedono gli staff
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
