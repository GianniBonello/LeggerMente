package Util;



import java.io.IOException;
import java.time.LocalDate;
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
	
	public static List<Libro> ricercaLibro(String campo, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
    	return em.createQuery("Libro l FROM Libro l WHERE "+campo+" LIKE '%"+ricerca+"%';").getResultList();
	}
	
	public static List<Utente> ricercaUtente(String campo, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
    	return em.createQuery("Libro u FROM Utente u WHERE "+campo+" LIKE '%"+ricerca+"%';").getResultList();
	}
	
	public static List<Prenotazione> ricercaPrenotazione(String campo, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
    	return em.createQuery("Libro p FROM Prenotazione p WHERE "+campo+" LIKE '%"+ricerca+"%';").getResultList();
	}
	
	public static List<Noleggio> ricercaNoleggio(String campo, String ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
    	return em.createQuery("Libro n FROM Noleggio n WHERE "+campo+" LIKE '%"+ricerca+"%';").getResultList();
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




