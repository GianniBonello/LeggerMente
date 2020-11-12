package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;

@WebServlet("/DettagliPrenotazione")
public class DettagliPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DettagliPrenotazione() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("isbn") != null) {
			request.setAttribute("libro", Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))));
			request.getRequestDispatcher("DettagliPrenotazione.jsp").forward(request, response);;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
