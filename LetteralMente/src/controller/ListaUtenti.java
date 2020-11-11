package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import Util.UtilityRicerca;
import model.Utente;


@WebServlet("/ListaUtenti")
public class ListaUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ListaUtenti() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Utente> listaUtenti = Utility.leggiUtente();
		//se ricerca!=null && filtro==nome
		//se ricerca!=null && filtro==cognome ecc..
		//FARE CONTROLLO TOLOWERCASE
		if(request.getParameter("ricerca")!=null && !request.getParameter("ricerca").equals("")) {
			for (Utente u : listaUtenti) {
				int cont=0;
				if(request.getParameter("nome")!=null) { //se filtra=nome
			
					for(String s : UtilityRicerca.spezzaStringhe(u.getNome())) { //basta che una stringa dell'array è uguale a scelta per non eliminare l'utente
						if(!s.equals(request.getParameter("ricerca").toLowerCase())) {							
							cont++; //incremento numero parole non corrispondenti
						}
					}
					//se ho trovato tutte parole differenti allora elimina u
					if (cont == UtilityRicerca.spezzaStringhe(u.getNome()).length) {
						listaUtenti.remove(u);
					}
					
				
				}else if(request.getParameter("cognome")!=null) { //se filtra=nome
					for(String s : UtilityRicerca.spezzaStringhe(u.getCognome())) {
						if(!s.equals(request.getParameter("ricerca").toLowerCase())) {
							cont++;
						}
					}
					//se ho trovato tutte parole differenti allora elimina u
					if (cont == UtilityRicerca.spezzaStringhe(u.getCognome()).length) {
						listaUtenti.remove(u);
					}

				}else if (request.getParameter("username")!=null && !request.getParameter("ricerca").equals(u.getUsername())) {
					listaUtenti.remove(u);

				}else if  (request.getParameter("email")!=null && !request.getParameter("ricerca").toLowerCase().equals(u.getEmail().toLowerCase())) {
					listaUtenti.remove(u);
				}
			}
		}

		request.setAttribute("listaUtenti", listaUtenti);
		//request.setAttribute("listaUtenti", Utility.leggiUtente());
		request.getRequestDispatcher("/listaUtenti.jsp").forward(request, response);

	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
