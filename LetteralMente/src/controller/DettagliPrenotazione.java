package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;

@WebServlet("/DettagliPrenotazione")
public class DettagliPrenotazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DettagliPrenotazione() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro l = Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro")));
		if(l != null) {
			request.setAttribute("libro", l);
				if(l.getQuantita()>0)
					request.getRequestDispatcher("/view/dettagliprenotazione.jsp").forward(request, response);
				else
					request.getRequestDispatcher("/view/dettaglinoleggio.jsp").forward(request, response);
		}else
				request.getRequestDispatcher("ListaLibri").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
