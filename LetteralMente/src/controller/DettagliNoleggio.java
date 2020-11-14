package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;

/**
 * Servlet implementation class DettagliNoleggio
 */
@WebServlet("/DettagliNoleggio")
public class DettagliNoleggio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DettagliNoleggio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("idLibro") != null && request.getSession().getAttribute("utenteLoggato")!=null) {
			Libro l = Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro")));
			request.setAttribute("libro", l);
			if(l.getQuantita()>0 && l.getIsUsato()) {
				request.getRequestDispatcher("/view/dettaglinoleggio.jsp").forward(request,response);
			}else if(l.getQuantita()>=0) {
				request.getRequestDispatcher("ListaLibri").forward(request,response);
			}
		}else request.getRequestDispatcher("ControlloIniziale").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
