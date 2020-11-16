package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

import Util.Utility;
import Util.UtilityRicerca;
import model.Libro;
import model.Utente;

@WebServlet("/ListaLibri")
public class ListaLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaLibri() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



		if(request.getParameter("campo") != null && request.getParameter("ricerca")!= null) {
			request.setAttribute("listaLibri", UtilityRicerca.ricercaLibro(request.getParameter("campo"), request.getParameter("ricerca")));
		} else request.setAttribute("listaLibri", Utility.leggiLibro());

		//////////////////////ricerca da homepage
		if(request.getParameter("cercaLibro")!=null){
			request.setAttribute("listaLibri", UtilityRicerca.ricercaLibro("titolo", request.getParameter("cercaLibro")));
			//System.out.println("QUESTOOOOOOOOO " + UtilityRicerca.ricercaLibro("titolo", request.getParameter("cercaLibro")));
		}

		if (request.getSession().getAttribute("utenteLoggato")!=null && ((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()) {
			request.getRequestDispatcher("/view/gestionelibri.jsp").forward(request, response);
		}else request.getRequestDispatcher("/view/listalibri.jsp").forward(request, response);




	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
