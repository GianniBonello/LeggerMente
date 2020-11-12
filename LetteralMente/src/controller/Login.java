package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("username")!= null && request.getParameter("password")!= null) {
		Utente u=Utility.trovaUtente(request.getParameter("username").trim(), request.getParameter("password"));
			if( u!=null ) {
				System.out.println("ciao giulia");
				//u=listaUtenti.get(listaUtenti.indexOf(u));
				request.getSession().setAttribute("utenteLoggato", u);
				if(u.getIsStaff()) {
					System.out.println("è un utente staff");
					response.sendRedirect("/homeGestionale.jsp");	
				}
				else {
					System.out.println("è un utente qualunque");
					request.getRequestDispatcher("ControlloIniziale").forward(request, response);
				}
			}else {
				request.setAttribute("loginFallito", "errorLogin");
				System.out.println("Scrivi bene sta password");
				request.getRequestDispatcher("ControlloIniziale").forward(request, response);
			}
		}
	}

}
