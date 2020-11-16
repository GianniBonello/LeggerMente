package controller;

import java.io.IOException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;

@WebServlet("/ModificaPassword")
public class ModificaPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModificaPassword() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")!=null && !request.getParameter("id").equals("")){
			Utente u=Utility.trovaUtente(Integer.parseInt(request.getParameter("id")));
			//Controllo che l'email inserita corrisponda all'utente con l'id preso dall'URL
			if(u.getEmail().equals(request.getParameter("email"))) {
				if(request.getParameter("password").equals(request.getParameter("passwordConfermata"))) {
					u.setPassword(request.getParameter("password"));
					Utility.modificaUtente(u);	
					request.setAttribute("successo", "modificata");
				}else {
					request.setAttribute("errore", "pswDiverse");
				}
			}else {
				request.setAttribute("errore", "email");
			}
		}
		request.getRequestDispatcher("/view/modificapassword.jsp").include(request, response);
	}

}
