package controller;

import java.io.IOException;
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
		Utente u=new Utente();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		if(Utility.leggiUtente().contains(u)) {
			u=Utility.leggiUtente().get(Utility.leggiUtente().indexOf(u));
			request.getSession().setAttribute("UtenteLoggato", u);
			if(u.getIsStaff()) 
				response.sendRedirect("/homeGestionale.jsp");		
		}else
		 	request.setAttribute("loginFallito", "errorLogin");
	}

}
