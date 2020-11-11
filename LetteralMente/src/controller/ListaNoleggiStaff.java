package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;


@WebServlet("/ListaNoleggiStaff")
public class ListaNoleggiStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListaNoleggiStaff() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaNoleggi", Utility.leggiPrenotazione()); 
		request.getRequestDispatcher("/listaNoleggi.jsp").forward(request, response);
	}

}
