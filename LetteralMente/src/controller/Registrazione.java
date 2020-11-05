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
		//Controllo che l'utente abbia inserito testo in tutti i campi
		if((request.getParameter("nome")!=null||request.getParameter("nome")!="")&&
				(request.getParameter("cognome")!=null||request.getParameter("cognome")!="")&&
				(request.getParameter("dataDiNascita")!=null||request.getParameter("dataDiNascita")!="")&&
				(request.getParameter("cf")!=null||request.getParameter("cf")!="")&&
				(request.getParameter("email")!=null||request.getParameter("email")!="")&&
				(request.getParameter("username")!=null||request.getParameter("username")!="")&&
				(request.getParameter("password")!=null||request.getParameter("password")!="")&&
				(request.getParameter("comune")!=null||request.getParameter("comune")!="")&&
				(request.getParameter("indirizzo")!=null||request.getParameter("indirizzo")!="")&&
				(request.getParameter("cap")!=null||request.getParameter("cap")!="")) {
			//Ora creo l'utente da inserire
			Utente u=new Utente();
			u.setNome(request.getParameter("nome"));
			u.setCognome(request.getParameter("cognome"));
			u.setDataDiNascita(Date.valueOf(request.getParameter("dataDiNascita")));//Sistemare per la Date
			u.setCf(request.getParameter("cf"));
			u.setEmail(request.getParameter("email"));
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			u.setComune(request.getParameter("comune"));
			u.setIndirizzo(request.getParameter("indirizzo"));
			u.setCap(request.getParameter("cap"));
			//con l'eccezione riesco a controllare se l'utente è già presente
			try {
				Utility.inserisciUtente(u);
				//TODO Far Comparire qualcosa per L'AVVENUTA REGISTRAZIONE
				request.getRequestDispatcher("/home.jsp").forward(request, response);
			} catch (RollbackException e) {
				request.setAttribute("RegistrazioneFallita", "errorReg");
				request.getRequestDispatcher("/registrazione.jsp").forward(request, response);
			}
			
			
			
		}
		
			
	}
}


