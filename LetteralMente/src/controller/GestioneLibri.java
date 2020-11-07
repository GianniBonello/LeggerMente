package controller;

import java.io.IOException;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.Utility;
import model.Libro;
import model.Utente;

@WebServlet("/GestioneLibri")
public class GestioneLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GestioneLibri() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff() && request.getParameter("idLibro") == null){
			Libro lib = new Libro();
			lib.setIsbn(request.getParameter("isbn"));
			lib.setAutore(request.getParameter("autore"));
			lib.setCasaEditrice(request.getParameter("casaEditrice"));
			lib.setGenere(request.getParameter("genere"));
			lib.setQuantita(Integer.parseInt(request.getParameter("quantita")));
			lib.setTitolo(request.getParameter("titolo"));
			lib.setTrama(request.getParameter("trama"));
			lib.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
			lib.setIsUsato(Boolean.parseBoolean(request.getParameter("isUsato")));
			try {
				Utility.inserisciLibro(lib);
				request.setAttribute("libroInserito", "successo");
			} catch (RollbackException e) {
				request.setAttribute("libroInserito", "errore");
			}
			request.getRequestDispatcher("/listaLibri.jsp");
		}else if(((Utente)request.getSession().getAttribute("utenteLoggato")).getIsStaff() && request.getParameter("idLibro") != null) {
			Libro l = Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro")));
			l.setIsbn(request.getParameter("isbn"));
			l.setAutore(request.getParameter("autore"));
			l.setCasaEditrice(request.getParameter("casaEditrice"));
			l.setGenere(request.getParameter("genere"));
			l.setQuantita(Integer.parseInt(request.getParameter("quantita")));
			l.setTitolo(request.getParameter("titolo"));
			l.setTrama(request.getParameter("trama"));
			l.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
			l.setIsUsato(Boolean.parseBoolean(request.getParameter("isUsato")));
			
			Utility.modificaLibro(l);
		request.setAttribute("modifica", "successo");
		}
	}
}
