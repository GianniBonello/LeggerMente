package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;
import model.Utente;

@WebServlet("/ControlloIniziale")
public class ControlloIniziale extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControlloIniziale() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u= (Utente)request.getSession().getAttribute("UtenteLoggato");
		request.setAttribute("listaLibri", Utility.leggiLibroHome());
		//System.out.println(Utility.leggiLibroHome());
		String path = u!= null && u.getIsStaff()? "/view/homestaff.jsp":"/WEB-INF/view/home.jsp";
		
		if(u!=null) {
			if(u.getIsStaff()) {
				request.getRequestDispatcher(path).forward(request, response);
			}else {
				request.getRequestDispatcher(path).forward(request, response);
			}
		}else {
			request.getRequestDispatcher(path).forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
