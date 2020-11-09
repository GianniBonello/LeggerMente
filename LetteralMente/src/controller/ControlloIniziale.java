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
		List<Libro> listaLibri=Utility.leggiLibro();
		Libro[][] matrice =new Libro[2][3];
		
		for(int i = 0; i < matrice.length; i++) {
			for(int k = 0; k < matrice[i].length; k++) {
				if(listaLibri.size()<=0) {
					break;
				}
				matrice[i][k] = listaLibri.remove(listaLibri.size()-1);
			}
			if(listaLibri.size()<=0)break;
		}
		request.setAttribute("matriceLibri", matrice);
		if(u!=null) {
			if(u.getIsStaff()) {
				request.getRequestDispatcher("/homeGestionale.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/body.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("/body.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
