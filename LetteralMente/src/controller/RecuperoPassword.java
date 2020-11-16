package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import Util.UtilityRicerca;
import model.Utente;


@WebServlet("/RecuperoPassword")
public class RecuperoPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RecuperoPassword() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/inserimentoemail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("email")!=null) {
			Utente u = Utility.trovaUtente(request.getParameter("email"));
			if (u!=null) {
				UtilityRicerca.mailRecuperoPassword(u);
				
				request.setAttribute("recupero", "successo");
			}else request.setAttribute("recupero", "error");
		}
		
		doGet(request, response);
		
	}
}
