package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Utente;


@WebServlet("/ModificaUtenti")
public class ModificaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificaUtenti() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*se è admin
		 * sia eliminare tutti che modificare tutti
		 * else se non è admin puo modificare solo se l utente da mod non è staff 
		 * puo eliminare solo se l utente non è staff*/
		Utente utenteLog = (Utente)request.getSession().getAttribute("utenteLoggato");
		Utente gener = Utility.trovaUtente(Integer.parseInt(request.getParameter("idUtente")));

		if(utenteLog.getUsername().equals("Admin")) {//se sei admin
			if(request.getParameter("nome")!=null && !request.getParameter("nome").equals("")&&//se hai tutti i paramentri
					request.getParameter("cognome")!=null && !request.getParameter("cognome").equals("")&&
					request.getParameter("dataDiNascita")!=null && !request.getParameter("dataDiNascita").equals("")&&
					request.getParameter("cf")!=null && !request.getParameter("cf").equals("")&&
					request.getParameter("email")!=null && !request.getParameter("email").equals("")&&
					request.getParameter("username")!=null && !request.getParameter("username").equals("")&&
					request.getParameter("password")!=null && !request.getParameter("password").equals("")&&
					request.getParameter("comune")!=null && !request.getParameter("comune").equals("")&&
					request.getParameter("indirizzo")!=null && !request.getParameter("indirizzo").equals("")&&
					request.getParameter("cap")!=null && !request.getParameter("cap").equals("")) {

				gener.setNome(request.getParameter("nome"));
				gener.setCognome(request.getParameter("cognome"));
				gener.setDataDiNascita(Date.valueOf(request.getParameter("dataDiNascita")));
				gener.setCf(request.getParameter("cf"));
				gener.setEmail(request.getParameter("email"));
				gener.setPassword(request.getParameter("password"));
				gener.setUsername(request.getParameter("username"));
				gener.setComune(request.getParameter("comune"));
				gener.setCap(request.getParameter("cap"));
				gener.setIndirizzo(request.getParameter("indirizzo"));			
				Utility.modificaUtente(gener);
				request.setAttribute("utenteModificato", "utente modificato con successo");
			
			}else if(request.getParameter("idUtente")!=null){
				//elimina
				try {
					Utility.eliminaUtente(Integer.parseInt(request.getParameter("idUtente")));
				request.setAttribute("utenteEliminato", "utente eliminato con successo");
				} catch (IllegalArgumentException e) {
					// TODO: handle exception
				}				
			}
		}else if(utenteLog.getIsStaff()  && !gener.getIsStaff()) {//se non è admin
			if(request.getParameter("nome")!=null && !request.getParameter("nome").equals("")&&//se hai tutti i paramentri
					request.getParameter("cognome")!=null && !request.getParameter("cognome").equals("")&&
					request.getParameter("dataDiNascita")!=null && !request.getParameter("dataDiNascita").equals("")&&
					request.getParameter("cf")!=null && !request.getParameter("cf").equals("")&&
					request.getParameter("email")!=null && !request.getParameter("email").equals("")&&
					request.getParameter("username")!=null && !request.getParameter("username").equals("")&&
					request.getParameter("password")!=null && !request.getParameter("password").equals("")&&
					request.getParameter("comune")!=null && !request.getParameter("comune").equals("")&&
					request.getParameter("indirizzo")!=null && !request.getParameter("indirizzo").equals("")&&
					request.getParameter("cap")!=null && !request.getParameter("cap").equals("")) {

				gener.setNome(request.getParameter("nome"));
				gener.setCognome(request.getParameter("cognome"));
				gener.setDataDiNascita(Date.valueOf(request.getParameter("dataDiNascita")));
				gener.setCf(request.getParameter("cf"));
				gener.setEmail(request.getParameter("email"));
				gener.setPassword(request.getParameter("password"));
				gener.setUsername(request.getParameter("username"));
				gener.setComune(request.getParameter("comune"));
				gener.setCap(request.getParameter("cap"));
				gener.setIndirizzo(request.getParameter("indirizzo"));			
				Utility.modificaUtente(gener);
				request.setAttribute("utenteModificato", "utente modificato con successo");

			}else if(request.getParameter("idUtente")!=null){
				//elimina
				try {
					Utility.eliminaUtente(Integer.parseInt(request.getParameter("idUtente")));
				request.setAttribute("utenteEliminato", "utente eliminato con successo");
				} catch (IllegalArgumentException e) {
					// TODO: handle exception
				}
			}
			request.setAttribute("operazioneNonRiuscita", "operazione non riuscita");
		}
	}
}
