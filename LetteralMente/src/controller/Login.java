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
		String username=request.getParameter("username");
		
		String psw=request.getParameter("password");
		if(username!= null && psw!= null) {
			username=username.trim();
		Utente u=Utility.trovaUtente(username, psw);
			if( u!=null ) {
				System.out.println("ciao giulia");
				//u=listaUtenti.get(listaUtenti.indexOf(u));
				request.getSession().setAttribute("utenteLoggato", u);
				if(u.getIsStaff()) {
					System.out.println("è un utente staff");
					request.getRequestDispatcher("/view/homestaff.jsp").forward(request, response);
				}else if(!u.getIsStaff() && request.getParameter("idLibro")!=null) {
					request.setAttribute("libro", Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro"))));
					request.getRequestDispatcher("/view/dettagliolibro.jsp").forward(request, response);
				}else {
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
