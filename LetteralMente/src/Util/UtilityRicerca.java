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
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.email =:ricerca",ricerca);
		case "username":
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.username =:ricerca",ricerca);
		case "nome":
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.nome =:ricerca",ricerca);
		case "cognome":
			return ricercaUtenteGenerica("Select u FROM Utente u WHERE u.cognome =:ricerca",ricerca);

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
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.idprenotazione =:ricerca",ricerca);
		case "username":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.u.username =:ricerca",ricerca);
		case "isbn":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.lib.isbn =:ricerca",ricerca);
		case "titolo":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.lib.titolo =:ricerca",ricerca);
		case "cognome":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.u.cognome =:ricerca",ricerca);
		case "email":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.u.email =:ricerca",ricerca);
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
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.id_noleggio =:ricerca",ricerca);
		case "username":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.u.username =:ricerca",ricerca);
		case "isbn":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.lib.isbn =:ricerca",ricerca);
		case "titolo":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.lib.titolo =:ricerca",ricerca);
		case "cognome":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.u.cognome =:ricerca",ricerca);
		case "email":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.u.email =:ricerca",ricerca);
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
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.autore =:ricerca",ricerca);
		case "genere":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.genere =:ricerca",ricerca);
		case "isbn":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.isbn =:ricerca",ricerca);
		case "titolo":
			return ricercaLibroGenerica("Select l FROM Libro l WHERE l.titolo =:ricerca",ricerca);
		default:
			return new ArrayList<Libro>();
		}
	}
	
	private static List<Libro> ricercaLibroGenerica(String query, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
		Query q=em.createQuery(query);
		q.setParameter("ricerca", "%"+ricerca+"%");
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
}




