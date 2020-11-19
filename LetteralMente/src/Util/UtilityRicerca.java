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
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	
	
	
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
		System.out.println(d.getClass());
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
		/*-------------------------------------------------------------------------------------------*/
		String msg ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n" + 
				" <head> \r\n" + 
				"  <meta charset=\"UTF-8\"> \r\n" + 
				"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \r\n" + 
				"  <meta name=\"x-apple-disable-message-reformatting\"> \r\n" + 
				"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \r\n" + 
				"  <meta content=\"telephone=no\" name=\"format-detection\"> \r\n" + 
				"  <title>LibreriaLeggerMente</title> \r\n" + 
				"  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,700i\" rel=\"stylesheet\"> \r\n" + 
				"  <style type=\"text/css\">\r\n" + 
				"#outlook a {\r\n" + 
				"	padding:0;\r\n" + 
				"}\r\n" + 
				".ExternalClass {\r\n" + 
				"	width:100%;\r\n" + 
				"}\r\n" + 
				".ExternalClass,\r\n" + 
				".ExternalClass p,\r\n" + 
				".ExternalClass span,\r\n" + 
				".ExternalClass font,\r\n" + 
				".ExternalClass td,\r\n" + 
				".ExternalClass div {\r\n" + 
				"	line-height:100%;\r\n" + 
				"}\r\n" + 
				".es-button {\r\n" + 
				"	mso-style-priority:100!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"}\r\n" + 
				"a[x-apple-data-detectors] {\r\n" + 
				"	color:inherit!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"	font-size:inherit!important;\r\n" + 
				"	font-family:inherit!important;\r\n" + 
				"	font-weight:inherit!important;\r\n" + 
				"	line-height:inherit!important;\r\n" + 
				"}\r\n" + 
				".es-desk-hidden {\r\n" + 
				"	display:none;\r\n" + 
				"	float:left;\r\n" + 
				"	overflow:hidden;\r\n" + 
				"	width:0;\r\n" + 
				"	max-height:0;\r\n" + 
				"	line-height:0;\r\n" + 
				"	mso-hide:all;\r\n" + 
				"}\r\n" + 
				".es-button-border:hover {\r\n" + 
				"	border-color:#f63656 #f63656 #f63656 #f63656!important;\r\n" + 
				"	background:#f63656!important;\r\n" + 
				"}\r\n" + 
				"@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:16px!important; line-height:150%!important } h1 { font-size:30px!important; text-align:center; line-height:120% } h2 { font-size:26px!important; text-align:center; line-height:120% } h3 { font-size:20px!important; text-align:center; line-height:120% } h1 a { font-size:30px!important } h2 a { font-size:26px!important } h3 a { font-size:20px!important } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:14px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; border-left-width:0px!important; border-right-width:0px!important } }\r\n" + 
				"</style> \r\n" + 
				" </head> \r\n" + 
				" <body style=\"width:100%;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \r\n" + 
				"  <div class=\"es-wrapper-color\" style=\"background-color:#F9F9F9\"> \r\n" + 
				"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"> \r\n" + 
				"     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"      <td valign=\"top\" style=\"padding:0;Margin:0\"> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" style=\"padding:0;Margin:0\"> \r\n" + 
				"           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://nhkhto.stripocdn.email/content/guids/a74331ad-a3d9-46c0-bef8-63fc221c9ac1/images/83391605728629586.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                     	<!--SCRITTA CONFERMA-->\r\n" + 
				"                      <td align=\"center\" style=\"padding:20px;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:30px;\r\n" + 
				"                      font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:45px;color:#C80258\"><strong>PRENOTAZIONE CONFERMATA</strong></p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr class=\"es-mobile-hidden\" style=\"border-collapse:collapse\"> \r\n" + 
				"                     	<!--testo email--------------------------------------------------------------------------------------------------------------------------------------------------->\r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0\"><h1 style=\"Margin:0;line-height:23px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:15px;font-style:normal;font-weight:normal;color:#1C1C1C\">Gentile&nbsp;<b>"+p.getU().getNome()+" "+p.getU().getCognome()+"</b><br>Con la seguente email le confermiamo il successo della prenotazione del Libro di <b>"+p.getLib().getTitolo()+"</b> di <b>"+p.getLib().getAutore()+"</b> <br>Potrà recarsi nella nostra libreria e mostrare il seguente codice:<br>\r\n<br>" + 
				"                      <b style=\"font-size:26pt\">"+p.getIdprenotazione()+"</b><br>\r\n" + 
				"                      alla cassa per poter ritirare il suo libro entro la data:&nbsp; "+LocalDate.parse(UtilityRicerca.dataString(p.getData())).plusDays(7).format(formatter)+"</h1></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:20px;Margin:0;font-size:0\"> \r\n" + 
				"                       <table border=\"0\" width=\"10%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;display:inline-table;width:10% !important\" role=\"presentation\"> \r\n" + 
				"                         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                          <td style=\"padding:0;Margin:0;border-bottom:5px solid #C80258;background:none;height:1px;width:100%;margin:0px\"></td> \r\n" + 
				"                         </tr> \r\n" + 
				"                       </table></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" style=\"padding:0;Margin:0\"> \r\n" + 
				"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" bgcolor=\"#1C1C1C\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px;background-color:#1C1C1C\"> \r\n" + 
				"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:center top\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"> \r\n" + 
				"                       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:15px\"><a target=\"_blank\" href=\"https://www.facebook.com/LeggerMente-104221868164792/?modal=suggested_action&notif_id=1605606672416756&notif_t=page_user_activity&ref=notif\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;font-size:16px;text-decoration:none;color:#FFFFFF\"><img src=\"https://nhkhto.stripocdn.email/content/assets/img/social-icons/logo-white/facebook-logo-white.png\" alt=\"Fb\" title=\"Facebook\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0\"><a target=\"_blank\" href=\"https://www.instagram.com/leggermente.libreria/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;font-size:16px;text-decoration:none;color:#FFFFFF\"><img src=\"https://nhkhto.stripocdn.email/content/assets/img/social-icons/logo-white/instagram-logo-white.png\" alt=\"Ig\" title=\"Instagram\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                         </tr> \r\n" + 
				"                       </table></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr class=\"es-mobile-hidden\" style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;line-height:18px;color:#FFFFFF\">Via Sandro Sandri, 81, 00159 Roma RM<br>06-3214587001</p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table></td> \r\n" + 
				"     </tr> \r\n" + 
				"   </table> \r\n" + 
				"  </div>  \r\n" + 
				" </body>\r\n" + 
				"</html>";
		
		
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
		String msg ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n" + 
				" <head> \r\n" + 
				"  <meta charset=\"UTF-8\"> \r\n" + 
				"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \r\n" + 
				"  <meta name=\"x-apple-disable-message-reformatting\"> \r\n" + 
				"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \r\n" + 
				"  <meta content=\"telephone=no\" name=\"format-detection\"> \r\n" + 
				"  <title>LibreriaLeggerMente</title> \r\n" + 
				"  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,700i\" rel=\"stylesheet\"> \r\n" + 
				"  <style type=\"text/css\">\r\n" + 
				"#outlook a {\r\n" + 
				"	padding:0;\r\n" + 
				"}\r\n" + 
				".ExternalClass {\r\n" + 
				"	width:100%;\r\n" + 
				"}\r\n" + 
				".ExternalClass,\r\n" + 
				".ExternalClass p,\r\n" + 
				".ExternalClass span,\r\n" + 
				".ExternalClass font,\r\n" + 
				".ExternalClass td,\r\n" + 
				".ExternalClass div {\r\n" + 
				"	line-height:100%;\r\n" + 
				"}\r\n" + 
				".es-button {\r\n" + 
				"	mso-style-priority:100!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"}\r\n" + 
				"a[x-apple-data-detectors] {\r\n" + 
				"	color:inherit!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"	font-size:inherit!important;\r\n" + 
				"	font-family:inherit!important;\r\n" + 
				"	font-weight:inherit!important;\r\n" + 
				"	line-height:inherit!important;\r\n" + 
				"}\r\n" + 
				".es-desk-hidden {\r\n" + 
				"	display:none;\r\n" + 
				"	float:left;\r\n" + 
				"	overflow:hidden;\r\n" + 
				"	width:0;\r\n" + 
				"	max-height:0;\r\n" + 
				"	line-height:0;\r\n" + 
				"	mso-hide:all;\r\n" + 
				"}\r\n" + 
				".es-button-border:hover {\r\n" + 
				"	border-color:#f63656 #f63656 #f63656 #f63656!important;\r\n" + 
				"	background:#f63656!important;\r\n" + 
				"}\r\n" + 
				"@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:16px!important; line-height:150%!important } h1 { font-size:30px!important; text-align:center; line-height:120% } h2 { font-size:26px!important; text-align:center; line-height:120% } h3 { font-size:20px!important; text-align:center; line-height:120% } h1 a { font-size:30px!important } h2 a { font-size:26px!important } h3 a { font-size:20px!important } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:14px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; border-left-width:0px!important; border-right-width:0px!important } }\r\n" + 
				"</style> \r\n" + 
				" </head> \r\n" + 
				" <body style=\"width:100%;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \r\n" + 
				"  <div class=\"es-wrapper-color\" style=\"background-color:#F9F9F9\"> \r\n" + 
				"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"> \r\n" + 
				"     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"      <td valign=\"top\" style=\"padding:0;Margin:0\"> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" style=\"padding:0;Margin:0\"> \r\n" + 
				"           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://nhkhto.stripocdn.email/content/guids/a74331ad-a3d9-46c0-bef8-63fc221c9ac1/images/83391605728629586.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                     	<!--SCRITTA CONFERMA-->\r\n" + 
				"                      <td align=\"center\" style=\"padding:20px;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:30px;\r\n" + 
				"                      font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:45px;color:#C80258\"><strong>NOLEGGIO CONFERMATO</strong></p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr class=\"es-mobile-hidden\" style=\"border-collapse:collapse\"> \r\n" + 
				"                     	<!--testo email--------------------------------------------------------------------------------------------------------------------------------------------------->\r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0\"><h1 style=\"Margin:0;line-height:23px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:15px;font-style:normal;font-weight:normal;color:#1C1C1C\">Gentile&nbsp;<b>"+p.getU().getNome()+" "+p.getU().getCognome()+"</b><br>Con la seguente email le confermiamo il successo del noleggio del Libro di <b>"+p.getLib().getTitolo()+"</b> di <b>"+p.getLib().getAutore()+"</b> <br>Potrà recarsi nella nostra libreria e mostrare il seguente codice:<br>\r\n<br>" + 
				"                      <b style=\"font-size:26pt\">"+p.getIdNoleggio()+"</b><br>\r\n" + 
				"                      alla cassa per poter ritirare il suo libro entro la data:&nbsp; <b>"+LocalDate.parse(UtilityRicerca.dataString(p.getDataInizio())).plusDays(7).format(formatter)+"</b> <br>si ricordi di riconsegnare il libro entro la data : <b>"+LocalDate.parse(UtilityRicerca.dataString(p.getDataInizio())).format(formatter)+"</b></h1></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:20px;Margin:0;font-size:0\"> \r\n" + 
				"                       <table border=\"0\" width=\"10%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;display:inline-table;width:10% !important\" role=\"presentation\"> \r\n" + 
				"                         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                          <td style=\"padding:0;Margin:0;border-bottom:5px solid #C80258;background:none;height:1px;width:100%;margin:0px\"></td> \r\n" + 
				"                         </tr> \r\n" + 
				"                       </table></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" style=\"padding:0;Margin:0\"> \r\n" + 
				"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" bgcolor=\"#1C1C1C\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px;background-color:#1C1C1C\"> \r\n" + 
				"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:center top\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"> \r\n" + 
				"                       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:15px\"><a target=\"_blank\" href=\"https://www.facebook.com/LeggerMente-104221868164792/?modal=suggested_action&notif_id=1605606672416756&notif_t=page_user_activity&ref=notif\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;font-size:16px;text-decoration:none;color:#FFFFFF\"><img src=\"https://nhkhto.stripocdn.email/content/assets/img/social-icons/logo-white/facebook-logo-white.png\" alt=\"Fb\" title=\"Facebook\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0\"><a target=\"_blank\" href=\"https://www.instagram.com/leggermente.libreria/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;font-size:16px;text-decoration:none;color:#FFFFFF\"><img src=\"https://nhkhto.stripocdn.email/content/assets/img/social-icons/logo-white/instagram-logo-white.png\" alt=\"Ig\" title=\"Instagram\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                         </tr> \r\n" + 
				"                       </table></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr class=\"es-mobile-hidden\" style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;line-height:18px;color:#FFFFFF\">Via Sandro Sandri, 81, 00159 Roma RM<br>06-3214587001</p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table></td> \r\n" + 
				"     </tr> \r\n" + 
				"   </table> \r\n" + 
				"  </div>  \r\n" + 
				" </body>\r\n" + 
				"</html>";
				
				
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
		String msg ="<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"width:100%;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\r\n" + 
				" <head> \r\n" + 
				"  <meta charset=\"UTF-8\"> \r\n" + 
				"  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \r\n" + 
				"  <meta name=\"x-apple-disable-message-reformatting\"> \r\n" + 
				"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \r\n" + 
				"  <meta content=\"telephone=no\" name=\"format-detection\"> \r\n" + 
				"  <title>LibreriaLeggerMente</title> \r\n" + 
				"  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700,700i\" rel=\"stylesheet\"> \r\n" + 
				"  <style type=\"text/css\">\r\n" + 
				"#outlook a {\r\n" + 
				"	padding:0;\r\n" + 
				"}\r\n" + 
				".ExternalClass {\r\n" + 
				"	width:100%;\r\n" + 
				"}\r\n" + 
				".ExternalClass,\r\n" + 
				".ExternalClass p,\r\n" + 
				".ExternalClass span,\r\n" + 
				".ExternalClass font,\r\n" + 
				".ExternalClass td,\r\n" + 
				".ExternalClass div {\r\n" + 
				"	line-height:100%;\r\n" + 
				"}\r\n" + 
				".es-button {\r\n" + 
				"	mso-style-priority:100!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"}\r\n" + 
				"a[x-apple-data-detectors] {\r\n" + 
				"	color:inherit!important;\r\n" + 
				"	text-decoration:none!important;\r\n" + 
				"	font-size:inherit!important;\r\n" + 
				"	font-family:inherit!important;\r\n" + 
				"	font-weight:inherit!important;\r\n" + 
				"	line-height:inherit!important;\r\n" + 
				"}\r\n" + 
				".es-desk-hidden {\r\n" + 
				"	display:none;\r\n" + 
				"	float:left;\r\n" + 
				"	overflow:hidden;\r\n" + 
				"	width:0;\r\n" + 
				"	max-height:0;\r\n" + 
				"	line-height:0;\r\n" + 
				"	mso-hide:all;\r\n" + 
				"}\r\n" + 
				".es-button-border:hover {\r\n" + 
				"	border-color:#f63656 #f63656 #f63656 #f63656!important;\r\n" + 
				"	background:#f63656!important;\r\n" + 
				"}\r\n" + 
				"@media only screen and (max-width:600px) {p, ul li, ol li, a { font-size:16px!important; line-height:150%!important } h1 { font-size:30px!important; text-align:center; line-height:120% } h2 { font-size:26px!important; text-align:center; line-height:120% } h3 { font-size:20px!important; text-align:center; line-height:120% } h1 a { font-size:30px!important } h2 a { font-size:26px!important } h3 a { font-size:20px!important } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:14px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:14px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:block!important } .es-btn-fw { border-width:10px 0px!important; text-align:center!important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } a.es-button, button.es-button { font-size:20px!important; display:block!important; border-left-width:0px!important; border-right-width:0px!important } }\r\n" + 
				"</style> \r\n" + 
				" </head> \r\n" + 
				" <body style=\"width:100%;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\"> \r\n" + 
				"  <div class=\"es-wrapper-color\" style=\"background-color:#F9F9F9\"> \r\n" + 
				"   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top\"> \r\n" + 
				"     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"      <td valign=\"top\" style=\"padding:0;Margin:0\"> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" style=\"padding:0;Margin:0\"> \r\n" + 
				"           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://nhkhto.stripocdn.email/content/guids/a74331ad-a3d9-46c0-bef8-63fc221c9ac1/images/83391605728629586.png\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                     	<!--SCRITTA CONFERMA-->\r\n" + 
				"                      <td align=\"center\" style=\"padding:20px;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:30px;\r\n" + 
				"                      font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;line-height:45px;color:#C80258\"><strong>RECUPERO PASSWORD</strong></p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\"> \r\n" + 
				"               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                     <tr class=\"es-mobile-hidden\" style=\"border-collapse:collapse\"> \r\n" + 
				"                     	<!--testo email--------------------------------------------------------------------------------------------------------------------------------------------------->\r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0\"><h1 style=\"Margin:0;line-height:23px;mso-line-height-rule:exactly;font-family:'open sans', 'helvetica neue', helvetica, arial, sans-serif;font-size:15px;font-style:normal;font-weight:normal;color:#1C1C1C\">Gentile&nbsp;<b>"+u.getNome()+" "+u.getCognome()+"</b><br>come da lei richiesto, troverà qui sotto il suo username<br>le basterà cliccare sul bottone <b>\"CLICCA QUI\"</b> per poter modificare la sua password.</p>\r\n" + 
						"	            <p><b>USERNAME:</b> "+u.getUsername()+"</p>\r\n" + 
						"				 <a href=\"http://localhost:8080/LeggerMente/view/modificapassword.jsp?id="+u.getIdUtente()+"\">\r\n" + 
						"				<button type=\"submit\" class=\"p-3 mr-3 col-xl-3 col-xs-4 text-white shadow\"><b>CLICCA QUI</b></button></a>\r\n" + 
						"				<br><br>\r\n" + 
						"				 <p>La ringraziamo,<br>\r\n" + 
						"				 Il team di <b>Legger</b>Mente.\r\n</h1></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:20px;Margin:0;font-size:0\"> \r\n" + 
				"                       <table border=\"0\" width=\"10%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;display:inline-table;width:10% !important\" role=\"presentation\"> \r\n" + 
				"                         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                          <td style=\"padding:0;Margin:0;border-bottom:5px solid #C80258;background:none;height:1px;width:100%;margin:0px\"></td> \r\n" + 
				"                         </tr> \r\n" + 
				"                       </table></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table> \r\n" + 
				"       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\"> \r\n" + 
				"         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"          <td align=\"center\" style=\"padding:0;Margin:0\"> \r\n" + 
				"           <table class=\"es-content-body\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;width:600px\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\"> \r\n" + 
				"             <tr style=\"border-collapse:collapse\"> \r\n" + 
				"              <td align=\"left\" bgcolor=\"#1C1C1C\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:30px;background-color:#1C1C1C\"> \r\n" + 
				"               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                 <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                  <td align=\"left\" style=\"padding:0;Margin:0;width:560px\"> \r\n" + 
				"                   <table style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-position:center top\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\"> \r\n" + 
				"                     <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0\"> \r\n" + 
				"                       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-table-not-adapt es-social\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\"> \r\n" + 
				"                         <tr style=\"border-collapse:collapse\"> \r\n" + 
				"                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;padding-right:15px\"><a target=\"_blank\" href=\"https://www.facebook.com/LeggerMente-104221868164792/?modal=suggested_action&notif_id=1605606672416756&notif_t=page_user_activity&ref=notif\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;font-size:16px;text-decoration:none;color:#FFFFFF\"><img src=\"https://nhkhto.stripocdn.email/content/assets/img/social-icons/logo-white/facebook-logo-white.png\" alt=\"Fb\" title=\"Facebook\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                          <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0\"><a target=\"_blank\" href=\"https://www.instagram.com/leggermente.libreria/\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;font-size:16px;text-decoration:none;color:#FFFFFF\"><img src=\"https://nhkhto.stripocdn.email/content/assets/img/social-icons/logo-white/instagram-logo-white.png\" alt=\"Ig\" title=\"Instagram\" width=\"32\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\"></a></td> \r\n" + 
				"                         </tr> \r\n" + 
				"                       </table></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                     <tr class=\"es-mobile-hidden\" style=\"border-collapse:collapse\"> \r\n" + 
				"                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:12px;font-family:'trebuchet ms', 'lucida grande', 'lucida sans unicode', 'lucida sans', tahoma, sans-serif;line-height:18px;color:#FFFFFF\">Via Sandro Sandri, 81, 00159 Roma RM<br>06-3214587001</p></td> \r\n" + 
				"                     </tr> \r\n" + 
				"                   </table></td> \r\n" + 
				"                 </tr> \r\n" + 
				"               </table></td> \r\n" + 
				"             </tr> \r\n" + 
				"           </table></td> \r\n" + 
				"         </tr> \r\n" + 
				"       </table></td> \r\n" + 
				"     </tr> \r\n" + 
				"   </table> \r\n" + 
				"  </div>  \r\n" + 
				" </body>\r\n" + 
				"</html>";
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




