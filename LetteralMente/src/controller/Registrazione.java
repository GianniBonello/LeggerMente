package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

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
		request.getRequestDispatcher("/view/registrazione.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("bella mattè");
		String nome=request.getParameter("nome"),cognome=request.getParameter("cognome"),dataDiNascita =request.getParameter("dataDiNascita"),
				cf = request.getParameter("cf"),email = request.getParameter("email"),username = request.getParameter("username"), 
				password = request.getParameter("password"), comune = request.getParameter("comune"), indirizzo = request.getParameter("indirizzo"), 
				cap= request.getParameter("cap");
		System.out.println(LocalDate.parse(dataDiNascita).isBefore(LocalDate.now().plusYears(-15))+" "+LocalDate.now().plusYears(-15) +" "+LocalDate.parse(dataDiNascita));
				
		
		
		if(nome!=null && !nome.equals("")&&cognome!=null && !cognome.equals("")&&dataDiNascita!=null && !dataDiNascita.equals("")&&
				cf!=null && !cf.equals("")&&email!=null && !email.equals("")&&username!=null && !username.equals("")&&password!=null && 
				!password.equals("")&&comune!=null && !comune.equals("")&&indirizzo!=null && !indirizzo.equals("")&&cap!=null && !cap.equals("")&&
				LocalDate.parse(dataDiNascita).isBefore(LocalDate.now().plusYears(-15))&&LocalDate.parse(dataDiNascita).isAfter(LocalDate.now().plusYears(-110))) {
			
			//Ora creo l'utente da inserire 
			System.out.println("a bello so entrato nell'if");

			Utente u=new Utente();
			u.setNome(nome);
			u.setCognome(cognome);
			u.setDataDiNascita(Date.valueOf(dataDiNascita));//Sistemare per la Date
			u.setCf(cf.toUpperCase());
			u.setEmail(email.toLowerCase());
			u.setUsername(username);
			u.setPassword(password);
			u.setComune(comune);
			u.setIndirizzo(indirizzo);
			u.setCap(cap);
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
				request.getRequestDispatcher("/view/registrazione.jsp").include(request, response);
			}
		}else if(!LocalDate.parse(dataDiNascita).isBefore(LocalDate.now().plusYears(-15)) || !LocalDate.parse(dataDiNascita).isAfter(LocalDate.now().plusYears(-110))) {
			System.out.println("if data sbagliata");
			request.setAttribute("registrazione", "erroreData");
			request.getRequestDispatcher("/view/registrazione.jsp").include(request, response);
		}else {		
			System.out.println("if finale");
			request.setAttribute("registrazione", "errore");
			request.getRequestDispatcher("/view/registrazione.jsp").include(request, response);
		}	
	}
}


