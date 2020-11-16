package Util;



import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Libro;
import model.Noleggio;
import model.Prenotazione;
import model.Utente;


public class UtilityRicerca {

	/*private String getFileName(final Part part) {
		//System.out.println(part.getHeader("content-disposition"));
		for(String content : part.getHeader("content-disposition").split(" ")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(
						content.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}*/

	private static EntityManager getManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeggerMente");
		EntityManager em = emf.createEntityManager();
		return em;
	}


	/*-----------------------------------------Ricerche database-------------------------------------------*/

	public static List<Utente> ricercaUtente(String campo, String ricerca){
		switch (campo.trim().toLowerCase()) {
		case "email":case "e-mail":
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.email LIKE :ricerca",ricerca);
		case "username":
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.username LIKE :ricerca",ricerca);
		case "nome":
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.nome LIKE :ricerca",ricerca);
		case "cognome":
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.cognome LIKE :ricerca",ricerca);

		default:
			return new ArrayList<Utente>();

		}
	}

	private static List<Utente> ricercaUtenteGenerica(String query, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
		Query q=em.createQuery(query);
		q.setParameter("ricerca", "%"+ricerca+"%");
		return q.getResultList();
	}


	public static List<Prenotazione> ricercaPrenotazione(String campo, String ricerca){
		switch (campo.trim().toLowerCase()) {
		case "idprenotazione":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.idprenotazione LIKE :ricerca",ricerca);
		case "username":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.u.username LIKE :ricerca",ricerca);
		case "isbn":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.lib.isbn LIKE :ricerca",ricerca);
		case "titolo":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.lib.titolo LIKE :ricerca",ricerca);
		case "cognome":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.u.cognome LIKE :ricerca",ricerca);
		case "email":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.u.email LIKE :ricerca",ricerca);
		default:
			return new ArrayList<Prenotazione>();
		}

	}
	private static List<Prenotazione> ricercaPrenotazioneGenerica(String query, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
		Query q=em.createQuery(query);
		q.setParameter("ricerca", "%"+ricerca+"%");
		return q.getResultList();
	}

	public static List<Noleggio> ricercaNoleggio(String campo, String ricerca){
		switch (campo.trim().toLowerCase()) {
		case "id_noleggio":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.id_noleggio LIKE :ricerca",ricerca);
		case "username":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.u.username LIKE :ricerca",ricerca);
		case "isbn":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.lib.isbn LIKE :ricerca",ricerca);
		case "titolo":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.lib.titolo LIKE :ricerca",ricerca);
		case "cognome":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.u.cognome LIKE :ricerca",ricerca);
		case "email":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.u.email LIKE :ricerca",ricerca);
		default:
			return new ArrayList<Noleggio>();
		}
	}


	private static List<Noleggio> ricercaNoleggioGenerica(String query, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
		Query q=em.createQuery(query);
		q.setParameter("ricerca", "%"+ricerca+"%");
		return q.getResultList();
	}

	public static List<Libro> ricercaLibro(String campo, String ricerca){
		switch (campo.trim().toLowerCase()) {
		case "autore":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.autore LIKE :ricerca",ricerca);
		case "genere":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.genere LIKE :ricerca",ricerca);
		case "isbn":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isbn LIKE :ricerca",ricerca);
		case "titolo":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.titolo LIKE :ricerca",ricerca);
		case "casaeditrice":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.casaEditrice LIKE :ricerca",ricerca);
		default:
			return new ArrayList<Libro>();
		}
	}
	public static List<Libro> ricercaLibroNuovo(String campo, String ricerca){
		switch (campo.trim().toLowerCase()) {
		case "autore":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=false AND l.autore LIKE :ricerca",ricerca);
		case "genere":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=false AND l.genere LIKE :ricerca",ricerca);
		case "isbn":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=false AND l.isbn LIKE :ricerca",ricerca);
		case "titolo":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=false AND l.titolo LIKE :ricerca",ricerca);
		case "casaeditrice":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=false AND l.casaEditrice LIKE :ricerca",ricerca);
		default:
			return new ArrayList<Libro>();
		}
	}
	public static List<Libro> ricercaLibroUsato(String campo, String ricerca){
		switch (campo.trim().toLowerCase()) {
		case "autore":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=true AND l.autore LIKE :ricerca",ricerca);
		case "genere":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=true AND l.genere LIKE :ricerca",ricerca);
		case "isbn":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=true AND l.isbn LIKE :ricerca",ricerca);
		case "titolo":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=true AND l.titolo LIKE :ricerca",ricerca);
		case "casaeditrice":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isUsato=true AND l.casaEditrice LIKE :ricerca",ricerca);
		default:
			return new ArrayList<Libro>();
		}
	}

	private static List<Libro> ricercaLibroGenerica(String query, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
		Query q=em.createQuery(query);
		q.setParameter("ricerca","%"+ ricerca +"%");
		return q.getResultList();
	}


	/*-----------------------------------------Ricerche senza database-------------------------------------------*/

	public static String[] spezzaStringhe(String str) { 
		String[] splited = str.toLowerCase().split(" ");
		return splited;
	}

	public static void mailPrenotazioni(Prenotazione p) {

		String to = p.getU().getEmail();
		String subject = "Leggermente - Prenotazione effettuata ordine n° " + p.getIdprenotazione(); //OGGETTO DELLA MAIL
		String msg ="La tua prenotazione con codice: " + p.getIdprenotazione() + " del libro " + p.getLib().getTitolo() + " "
				+ "è stata effetuata e sarà valida entro il giorno " + LocalDate.now().plusDays(7) + ".\nGrazie per aver scelto Leggermente,\nA presto!";
		String from ="leggermente.roma@gmail.com";
		String password ="Letteralmente";


		Properties props = new Properties();  
		props.setProperty("mail.transport.protocol", "smtp");     
		props.setProperty("mail.host", "smtp.gmail.com");  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port", "465");  
		props.put("mail.debug", "true");  
		props.put("mail.smtp.socketFactory.port", "465");  
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.socketFactory.fallback", "false");  
		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(from,password);  
			}  
		});  

		//session.setDebug(true);  
		try {
			Transport transport = session.getTransport();  
			InternetAddress addressFrom = new InternetAddress(from);  

			MimeMessage message = new MimeMessage(session);  
			message.setSender(addressFrom);  
			message.setSubject(subject);  
			message.setContent(msg, "text/plain");  //SE METTIAMO HTML
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

			transport.connect();  
			Transport.send(message);  
			transport.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void mailNoleggi(Noleggio p) {

		String to = p.getU().getEmail();
		String subject = "Leggermente - Noleggio effettuata ordine n° " + p.getIdNoleggio(); //OGGETTO DELLA MAIL
		String msg ="Il tuo noleggio con codice: " + p.getIdNoleggio() + " del libro " + p.getLib().getTitolo() + " "
				+ "è stato effetuato, ricordati di ritararlo entro il " + LocalDate.now().plusDays(7) + ".\nGrazie per aver scelto LeggerMente,\nA presto!";
		String from ="leggermente.roma@gmail.com";
		String password ="Letteralmente";


		Properties props = new Properties();  
		props.setProperty("mail.transport.protocol", "smtp");     
		props.setProperty("mail.host", "smtp.gmail.com");  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port", "465");  
		props.put("mail.debug", "true");  
		props.put("mail.smtp.socketFactory.port", "465");  
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.socketFactory.fallback", "false");  
		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(from,password);  
			}  
		});  

		//session.setDebug(true);  
		try {
			Transport transport = session.getTransport();  
			InternetAddress addressFrom = new InternetAddress(from);  

			MimeMessage message = new MimeMessage(session);  
			message.setSender(addressFrom);  
			message.setSubject(subject);  
			message.setContent(msg, "text/plain");  //SE METTIAMO HTML
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

			transport.connect();  
			Transport.send(message);  
			transport.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void mailRecuperoPassword(Utente u) {

		String to = u.getEmail();
		String subject = "Leggermente - Recupero Dati "; //OGGETTO DELLA MAIL
		String msg ="<body>"
				+ " Questa email è assegnata a " + u.getUsername()
				+ ""
				+ "<br><a href=\"http://localhost:8080/LeggerMente/ModificaPassword?id="+u.getIdUtente()+"\">clicca qui</a> per recuperare la tua password</body>";
		String from ="leggermente.roma@gmail.com";
		String password ="Letteralmente";


		Properties props = new Properties();  
		props.setProperty("mail.transport.protocol", "smtp");     
		props.setProperty("mail.host", "smtp.gmail.com");  
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port", "465");  
		props.put("mail.debug", "true");  
		props.put("mail.smtp.socketFactory.port", "465");  
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
		props.put("mail.smtp.socketFactory.fallback", "false");  
		Session session = Session.getDefaultInstance(props,  
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {  
				return new PasswordAuthentication(from,password);  
			}  
		});  

		//session.setDebug(true);  
		try {
			Transport transport = session.getTransport();  
			InternetAddress addressFrom = new InternetAddress(from);  

			MimeMessage message = new MimeMessage(session);  
			message.setSender(addressFrom);  
			message.setSubject(subject);  
			message.setContent(msg, "text/html; charset=utf-8");  //SE METTIAMO HTML-message.setContent(someHtmlMessage, "text/html; charset=utf-8");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  

			transport.connect();  
			Transport.send(message);  
			transport.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}




