package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;
import model.Utente;

/**
 * Servlet implementation class CancellareNoleggio
 */
@WebServlet("/CancellareNoleggio")
public class CancellareNoleggio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellareNoleggio() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(request.getSession().getAttribute("utenteLoggato") != null &&
			request.getParameter("idNoleggio")!= null  && 
			((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff() && 
			((Utente)request.getSession().getAttribute("utenteLoggato")).getUsername().equals("Admin")){
			try {
				
				Utility.eliminaNoleggio(Integer.parseInt(request.getParameter("idNoleggio")));
				request.setAttribute("eliminaNoleggio", "effettuato");
				
				//Libro l = Utility.trovaNoleggio(Integer.parseInt(request.getParameter("idNoleggio"))).getLib();
				//l.setQuantita(l.getQuantita()+1);
				//Utility.modificaLibro();
				
			}catch(IllegalArgumentException e) {
				request.setAttribute("eliminaNoleggio", "nonEsiste");
			}
			//TODO rivedere i nomi delle jsp insieme!
			request.getRequestDispatcher("/listaNoleggiStaff.jsp").forward(request, response);
		}else request.getRequestDispatcher("/listaNoleggiStaff.jsp").forward(request, response);
		
	}

}
