package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;

@WebServlet("/ListaLibri")
public class ListaLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListaLibri() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaLibri", Utility.leggiLibro());
		if (((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()) {
			request.getRequestDispatcher("/ListaLibriStaff.jsp").forward(request, response);
		}else request.getRequestDispatcher("/ListaLibri.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
