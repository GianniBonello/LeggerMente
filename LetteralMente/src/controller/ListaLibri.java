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
			Libro lib = new Libro();
			lib.setAutore(request.getParameter("ricerca"));
			lib.setTitolo(request.getParameter("ricerca"));
			lib.setIsbn(request.getParameter("ricerca"));

			if(listaLibri.contains(lib)){

				lib = listaLibri.get(listaLibri.indexOf(lib));
				listaLibri.clear();
				listaLibri.add(lib);
			}else {
				for (Libro l : listaLibri) {
					int cont=0;
					if(request.getParameter("titolo")!=null) { 
						for(String s : UtilityRicerca.spezzaStringhe(l.getTitolo())) {
							for(String v : UtilityRicerca.spezzaStringhe(request.getParameter("ricerca"))) {
								if(!s.equals(v)) {
									cont++; 		//incremento numero parole non corrispondenti
								} 
							}
						}
						if (cont == UtilityRicerca.spezzaStringhe(l.getTitolo()).length * UtilityRicerca.spezzaStringhe(request.getParameter("ricerca")).length) {
							listaLibri.remove(l);
						}else if(cont == (UtilityRicerca.spezzaStringhe(l.getTitolo()).length-1)*(UtilityRicerca.spezzaStringhe(request.getParameter("ricerca")).length)) {  // se cont == 0
							listaLibri.clear();
							listaLibri.add(l);
						}

						//se ho trovato tutte parole differenti allora elimina l
						if (cont == UtilityRicerca.spezzaStringhe(l.getTitolo()).length) {
							listaLibri.remove(l);
						}

					}else if(request.getParameter("autore")!=null) { //se filtra=autore
						for(String s : UtilityRicerca.spezzaStringhe(l.getAutore())) {
							for(String v : UtilityRicerca.spezzaStringhe(request.getParameter("ricerca"))) {
								if(!s.equals(v)) {
									cont++; 		//incremento numero parole non corrispondenti
								} 
							}
						}
						if (cont == UtilityRicerca.spezzaStringhe(l.getAutore()).length * UtilityRicerca.spezzaStringhe(request.getParameter("ricerca")).length) {
							listaLibri.remove(l);
						}else if(cont == 0) {
							listaLibri.clear();
							listaLibri.add(l);
						}

					}else if (request.getParameter("isbn")!=null && !request.getParameter("ricerca").equals(l.getIsbn())) {
						listaLibri.remove(l);
					}
				} 
				
			}
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
