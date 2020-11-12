package controller;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;


@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registrazione() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("bella mattè");
		//Controllo che l'utente abbia inserito testo in tutti i campi
		if(request.getParameter("nome")!=null && !request.getParameter("nome").equals("")&&
				request.getParameter("cognome")!=null && !request.getParameter("cognome").equals("")&&
				request.getParameter("dataDiNascita")!=null && !request.getParameter("dataDiNascita").equals("")&&
				request.getParameter("cf")!=null && !request.getParameter("cf").equals("")&&
				request.getParameter("email")!=null && !request.getParameter("email").equals("")&&
				request.getParameter("username")!=null && !request.getParameter("username").equals("")&&
				request.getParameter("password")!=null && !request.getParameter("password").equals("")&&
				request.getParameter("comune")!=null && !request.getParameter("comune").equals("")&&
				request.getParameter("indirizzo")!=null && !request.getParameter("indirizzo").equals("")&&
				request.getParameter("cap")!=null && !request.getParameter("cap").equals("")) {
			//Ora creo l'utente da inserire 
			System.out.println("a bello so entrato nell'if");
			Utente u=new Utente();
			u.setNome(request.getParameter("nome"));
			u.setCognome(request.getParameter("cognome"));
			u.setDataDiNascita(Date.valueOf(request.getParameter("dataDiNascita")));//Sistemare per la Date
			u.setCf(request.getParameter("cf"));
			u.setEmail(request.getParameter("email").toLowerCase());
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			u.setComune(request.getParameter("comune"));
			u.setIndirizzo(request.getParameter("indirizzo"));
			u.setCap(request.getParameter("cap"));
			//con l'eccezione riesco a controllare se l'utente è già presente 
			try {
				System.out.println("so entrato nel tri");
				Utility.inserisciUtente(u);
				//TODO Far Comparire qualcosa per L'AVVENUTA REGISTRAZIONE
				request.setAttribute("registrazione", "successo");
				request.getRequestDispatcher("ControlloIniziale").forward(request, response);
			} catch (RollbackException e) {
				System.out.println("bella catch");
				request.setAttribute("registrazione", "errore");
				request.getRequestDispatcher("registrazione.jsp").forward(request, response);
			}
	
		}else {
			request.setAttribute("registrazione", "errore");
			request.getRequestDispatcher("registrazione.jsp").forward(request, response);
		}	
	}
}


