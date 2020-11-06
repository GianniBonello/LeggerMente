package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Noleggio;
import model.Utente;

@WebServlet("/ConvalidaNoleggio")
public class ConvalidaNoleggio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConvalidaNoleggio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Noleggio n = Utility.trovaNoleggio(Integer.parseInt(request.getParameter("idNoleggio")));
		
		if(request.getSession().getAttribute("utenteLoggato") != null &&
				((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff() &&
				request.getParameter("idNoleggio") != null && 
				n != null) {
			
			if(n.getInCorso()) {
				n.setInCorso(false);
				Utility.modificaNoleggio(n);
				n.getLib().setQuantita(n.getLib().getQuantita()+1);
				Utility.modificaLibro(n.getLib());
			}
			else {
				n.setInCorso(true);
				Utility.modificaNoleggio(n);
				n.getLib().setQuantita(n.getLib().getQuantita()-1);
				Utility.modificaLibro(n.getLib());
			}
			
			request.setAttribute("convalidaNoleggio", "effettuata");
			//request.getRequestDispatcher("/listaNoleggiLavoratori.jsp");
		}else request.setAttribute("convalidaNoleggio", "nonRiuscita");
		
		request.getRequestDispatcher("/listaNoleggiLavoratori.jsp");
		
	}//TODO nell'else ci entra sia se non è loggato, sia se non è staff, sia se non esiste un noleggio

}
