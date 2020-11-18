package Util;



import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
	
	
	
	//ECCOLO QUI IL TUO AMATO METODO NELLA TUA AMATA CLASSE CARA GIULIA!!!
	public static String dataString(Date data){
		String stringaData;
		/*String anno=data.getYear()+"";
		String mese=data.getMonth()+"";
		String giorno=data.getDay()+"";
		stringaData=Integer.parseInt(anno)>2?"19"+anno+"-":"20"+anno+"-";
		stringaData=mese.length()>1?stringaData+mese+"-":stringaData+"0"+mese+"-";
		stringaData=giorno.length()>1?stringaData+giorno:stringaData+"0"+giorno;*/
		LocalDate d=convertDate(data);
		stringaData=d.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return stringaData;	
	}
	
	private static LocalDate convertDate(Date d) {
		return d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

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
		int ric=0;
		if(campo!=null && campo.equals("idprenotazione")) {
			try {
				 ric = Integer.parseInt(ricerca);
				}catch(NumberFormatException e) {
					return Utility.leggiPrenotazione();
				}
		}

		switch (campo.trim().toLowerCase()) {
		case "idprenotazione":
			return ricercaPrenotazioneGenerica("Select p FROM Prenotazione p WHERE p.idprenotazione =:ricerca",ric);
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
	private static List<Prenotazione> ricercaPrenotazioneGenerica(String query, int ricerca){
		System.out.println("sono nella ricerca");
		EntityManager em = getManager();
		//rimarra nella storia
		Query q=em.createQuery(query);
		q.setParameter("ricerca", ricerca);
		return q.getResultList();
	}


	public static List<Noleggio> ricercaNoleggio(String campo, String ricerca){
		int ric = 0;
		if(campo != null && campo.equals("id_noleggio")) {
			try {
				 ric = Integer.parseInt(ricerca);
				}catch(NumberFormatException e) {
					return Utility.leggiNoleggio();
				}

		}
		switch (campo.trim().toLowerCase()) {
		case "id_noleggio":
			return ricercaNoleggioGenerica("Select d FROM Noleggio d WHERE d.idNoleggio =:ricerca",ric);
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
	
	private static List<Noleggio> ricercaNoleggioGenerica(String query, int ricerca){
		EntityManager em = getManager();
		//rimarra nella storia
		Query q=em.createQuery(query);
		q.setParameter("ricerca", ricerca);
		return q.getResultList();
	}
	
 static List<Noleggio> ricercaNoleggioGenerica(String query, String ricerca){
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
		
		String msg ="<head>"
				+ "<style>"
				+ " .mailtitle{\r\n"
				+ "	font-size: 26pt;\r\n"
				+ "	color: #C80258;\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ ".mailbord{\r\n"
				+ "	border-left: 2px !important;\r\n"
				+ "	border-color: #818181 !important;\r\n"
				+ "	border-left-style: solid !important;\r\n"
				+ "\r\n"
				+ "} "
				+ "</style>"
				+ "</head>"
				+ "<div class=\"container\">\r\n"
				+ "        <div class=\"row mt-5 mb-5 mail\">\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-xl-2 offset-xl-0 col-md-2 col-sm-10 offset-sm-2 mr-2\">\r\n"
				+ "            <img src=\"res/logo-nero.png\" class=\"pt-5 mb-5\" style=\"margin-top: 20px;\"><br>\r\n"
				+ "            </div>\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-xl-8 offset-xl-0 col-md-8 col-sm-10 sm-text-center mailbord\">\r\n"
				+ "            <h1 class=\"mailtitle\"><b>CONFERMA PRENOTAZIONE</b></h1>\r\n"
				+ "            <hr>\r\n"
				+ "            <p>Gentile <b>"+p.getU().getCognome()+ " " + p.getU().getNome() + "</b>,</p>\r\n"
				+ "            <p>con la seguente email le confermiamo il successo della prenotazione del libro <b>" +p.getLib().getTitolo() + "</b>di <b>" + p.getLib().getAutore() +"</b>.<br>\r\n"
				+ "            Potrà recarsi nella nostra libreria e mostrare il seguente codice: <b>"+p.getIdprenotazione()+"</b> alla cassa per poter ritirare il suo libro.</p>\r\n"
				+ "            \r\n"
				+ "            <p>La ringraziamo,<br>\r\n"
				+ "            Il team di <b>Legger</b>Mente.</p>\r\n"
				+ "            \r\n"
				+ "            \r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>";
		
		
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
			message.setContent(msg, "text/html; charset=utf-8");  //SE METTIAMO HTML
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
		String msg ="<head>"
				+ "<style>"
				+ " .mailtitle{\r\n"
				+ "	font-size: 26pt;\r\n"
				+ "	color: #C80258;\r\n"
				+ "}"
				+ "</style>"
				+ "</head>"
				+ "<div class=\"container\">\r\n"
				+ "        <div class=\"row mt-5 mb-5 mail\">\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-xl-2 offset-xl-0 col-md-2 col-sm-10 offset-sm-2 mr-2\">\r\n"

				+ "            </div>\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-xl-8 offset-xl-0 col-md-8 col-sm-10 sm-text-center mailbord\">\r\n"
				+ "            <h1 class=\"mailtitle\"><b>CONFERMA NOLEGGIO</b></h1>\r\n"
				+ "            <hr>\r\n"
				+ "            <p>Gentile <b>"+p.getU().getCognome()+" " + p.getU().getNome()+"</b>,</p>\r\n"
				+ "            <p>con la seguente email le confermiamo il successo del noleggio del libro <b>" +p.getLib().getTitolo() + "</b> di <b>" + p.getLib().getAutore() +"</b>.<br>\r\n"
				+ "            Potrà recarsi nella nostra libreria e mostrare il seguente codice: <b>"+p.getIdNoleggio()+"</b> alla cassa per poter ritirare il libro.</p>\r\n"
				+ "            \r\n"
				+ "            <p>La ringraziamo,<br>\r\n"
				+ "            Il team di <b>Legger</b>Mente.</p>\r\n"
				+ "            \r\n"
				+ "            \r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>";
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
			message.setContent(msg, "text/html; charset=utf-8");  //SE METTIAMO HTML
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
		String msg ="<head>"
				+ "<style>"
				+ " .mailtitle{\r\n"
				+ "	font-size: 26pt;\r\n"
				+ "	color: #C80258;\r\n"
				+ "}"
				+ "p{\r\n"
				+ "color:#000000;\r\n"
				+ "}\r\n"
				+ ""
				+ "</style>"
				+ "</head>"
				+ "    <div class=\"container\">\r\n"
				+ "        <div class=\"row mt-5 mb-5 mail\">\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-xl-2  mr-2\">\r\n"		
				+ "            </div>\r\n"
				+ "    \r\n"
				+ "            <div class=\"col-xl-8 mailbord\">\r\n"
				+ "            <h1 class=\"mailtitle\"><b>RECUPERO CREDENZIALI</b></h1>\r\n"
				+ "            <hr>\r\n"
				+ "            <p>Gentile <b>"+u.getCognome()+" " + u.getNome()+"</b>,</p>\r\n"
				+ "            <p>come da lei richiesto, troverà qui sotto il suo username<br>le basterà cliccare sul bottone <b>\"CLICCA QUI\"</b> per poter modificare la sua password.</p>\r\n"
				+ "            <p><b>USERNAME:</b> "+u.getUsername()+"</p>\r\n"
				+ "           <a href=\"http://localhost:8080/LeggerMente/view/modificapassword.jsp?id="+u.getIdUtente()+"\">\r\n"
				+ "<button type=\"submit\" class=\"p-3 mr-3 col-xl-3 col-xs-4 text-white shadow\"><b>CLICCA QUI</b></button></a>\r\n"
				+ "<br><br>\r\n"
				+ "            <p>La ringraziamo,<br>\r\n"
				+ "            Il team di <b>Legger</b>Mente.</p>\r\n"
				+ "            \r\n"
				+ "            \r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    \r\n"
				+ "        \r\n"
				+ "    </div>";
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




