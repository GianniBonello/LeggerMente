package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;

@WebServlet("/EliminaLibri")
public class EliminaLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EliminaLibri() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utenteLog = (Utente)request.getSession().getAttribute("utenteLoggato");
		System.out.println("ciao sono nella servlet elimina libri");

		if(request.getParameter("elimina") != null && utenteLog.getUsername().equals("Admin")) {
			System.out.println("entra nell elimina");
			try {
				Utility.eliminaLibro(Integer.parseInt(request.getParameter("elimina")));
				request.setAttribute("libroEliminato", "eliminato");
			} catch (IllegalArgumentException e) {
				request.setAttribute("libroEliminato", "errore");
			}
			request.getRequestDispatcher("ListaLibri").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
