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
import model.Libro;
import model.Utente;

@WebServlet("/ListaLibri")
public class ListaLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaLibri() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Libro> listaLibri = Utility.leggiLibro();
		//FILTRO PER TITOLO AUTORE ISBN

		if(request.getParameter("ricerca") != null && !request.getParameter("ricerca").equals("")) {
			Libro l = new Libro();
			l.setAutore(request.getParameter("ricerca"));
			l.setTitolo(request.getParameter("ricerca"));
			l.setIsbn(request.getParameter("ricerca"));
			
			if(request.getParameter("autore") != null && listaLibri.contains(l)) {
				listaLibri.clear();
				listaLibri.add(l);
			}else if(request.getParameter("titolo")!=null && listaLibri.contains(l)) {
				listaLibri.clear();
				listaLibri.add(l);
			}else if(request.getParameter("isbn")!=null && listaLibri.contains(l)) {
				listaLibri.clear();
				listaLibri.add(l);
			}
			/*-------------------------------------------------------------------------*/
			/*for (Libro l : listaLibri) {
				int cont=0;
				if(request.getParameter("titolo")!=null) { //se filtra=titolo
					for(String s : UtilityRicerca.spezzaStringhe(l.getTitolo())) {
						if(!s.equals(request.getParameter("ricerca").toLowerCase())) {	
							cont++;
						}
					}
					//se ho trovato tutte parole differenti allora elimina l
					if (cont == UtilityRicerca.spezzaStringhe(l.getTitolo()).length) {
						listaLibri.remove(l);
					}

				}else if(request.getParameter("autore")!=null) { //se filtra=autore
					for(String s : UtilityRicerca.spezzaStringhe(l.getAutore())) {
						if(!s.equals(request.getParameter("ricerca").toLowerCase())) {
							cont++;
						}
					}
					//se ho trovato tutte parole differenti allora elimina l
					if (cont == UtilityRicerca.spezzaStringhe(l.getAutore()).length) {
						listaLibri.remove(l);
					}

				}else if (request.getParameter("isbn")!=null && !request.getParameter("ricerca").equals(l.getIsbn())) {
					listaLibri.remove(l);
					//CONTROLLARE SULL' HTML CHE L'UTENTE INSERISCA I "-" DOPO TOT NUMERI

				}
			} */
		}

		request.setAttribute("listaLibri", listaLibri);

		if (((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff()) {
			request.getRequestDispatcher("/ListaLibriStaff.jsp").forward(request, response);
		}else request.getRequestDispatcher("/ListaLibri.jsp").forward(request, response);


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
