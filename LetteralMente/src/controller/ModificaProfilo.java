package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;

@WebServlet("/ModificaProfilo")
public class ModificaProfilo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ModificaProfilo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("email") != null && request.getParameter("comune") != null && request.getParameter("cap") != null && request.getParameter("indirizzo") != null && request.getParameter("username") != null && request.getParameter("password") != null) {
			
			Utente u = (Utente) request.getSession().getAttribute("utenteLoggato");
			u.setEmail(request.getParameter("email"));
			u.setComune(request.getParameter("comune"));
			u.setCap(request.getParameter("cap"));
			u.setIndirizzo(request.getParameter("indirizzo"));
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			
			Utility.modificaUtente(u);
			request.getSession().setAttribute("utenteLoggato", u);
		}
		
		request.setAttribute("utente", (Utente)request.getSession().getAttribute("utenteLoggato"));
		request.getRequestDispatcher("IlMioProfilo").forward(request, response);
	}

}
