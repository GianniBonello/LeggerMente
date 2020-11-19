package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Util.Utility;
import Util.UtilityRicerca;
import model.Libro;
import model.Utente;

@WebServlet("/GestioneLibri")
@MultipartConfig
public class GestioneLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GestioneLibri() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente)request.getSession().getAttribute("utenteLoggato");
		if(u!=null && u.getIsStaff()) {
		if(request.getParameter("campo") != null && request.getParameter("ricerca") != null) {
			request.setAttribute("listaLibri", UtilityRicerca.ricercaLibro(request.getParameter("campo"), request.getParameter("ricerca")));
			request.getRequestDispatcher("/view/gestioneprenotazioni.jsp").include(request, response);
		}else request.setAttribute("listaLibri", Utility.leggiLibro());

		request.getRequestDispatcher("/view/gestionelibri.jsp").include(request, response);
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//devo controllare se la quantita di prima è cambiata rispetto ad ora

		Utente u = (Utente)request.getSession().getAttribute("utenteLoggato");
		if( u!= null && u.getIsStaff() && request.getParameter("idLibro") != null) {
			Libro l = Utility.trovaLibro(Integer.parseInt(request.getParameter("idLibro")));
			//mi salvo la quantità che aveva prima il libro
			int quantita = l.getQuantita();
			l.setIsbn(request.getParameter("isbn"));
			l.setAutore(request.getParameter("autore"));
			l.setCasaEditrice(request.getParameter("casaeditrice"));
			l.setGenere(request.getParameter("genere"));
			l.setQuantita(Integer.parseInt(request.getParameter("quantita")));
			l.setTitolo(request.getParameter("titolo"));
			l.setTrama(request.getParameter("trama"));
			l.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));


			final String PATH = "C:\\Users\\utente\\Desktop\\UploadIMG"; 
			final Part FILEPART= request.getPart("immagine");
			final String FILENAME=getFileName(FILEPART);
			try( 	//questa è la condizione del Try-Catch		  
					OutputStream out=new FileOutputStream(new File(PATH+File.separator+FILENAME));
					//vado a prendermi il content dentro al part
					InputStream fileContent = FILEPART.getInputStream();) 
			{	
				int read = 0;
				final byte [] bytes=new byte[1024];
				while ((read=fileContent.read(bytes))!=-1) {
					out.write(bytes, 0, read);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			l.setImmagine_path("http://127.0.0.1:8887/"+FILENAME); //<--------PRIMA PARTE PATH WEB SERVLET
			
			
			try {
				Utility.modificaLibro(l);
			} catch (RollbackException e) {			
			}
			request.setAttribute("modifica", "successo");
			//dopo aver modificato il libro controllo se la quantita di prima era 0 e se ora è maggiore da 0
			if(quantita == 0 && Integer.parseInt(request.getParameter("quantita")) > 0) {
				request.setAttribute("libro", l);
				request.getRequestDispatcher("PrenotazioniAutomatiche").include(request, response);
			}
		}else if(u!= null && u.getIsStaff()){
			Libro lib = new Libro();
			lib.setIsbn(request.getParameter("isbn"));
			lib.setAutore(request.getParameter("autore"));
			lib.setCasaEditrice(request.getParameter("casaeditrice"));
			lib.setGenere(request.getParameter("genere"));
			lib.setQuantita(Integer.parseInt(request.getParameter("quantita")));
			lib.setTitolo(request.getParameter("titolo"));
			lib.setTrama(request.getParameter("trama"));
			lib.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
			if(request.getParameter("isUsato") != null && request.getParameter("isUsato").equals("on")) {
				lib.setIsUsato(true);
			}else lib.setIsUsato(false);

			final String PATH = "C:\\Users\\giuli\\OneDrive\\Desktop\\immaginiProgetto"; 
			final Part FILEPART= request.getPart("immagine");
			final String FILENAME=getFileName(FILEPART);
			try( 	//questa è la condizione del Try-Catch		  
					OutputStream out=new FileOutputStream(new File(PATH+File.separator+FILENAME));
					//vado a prendermi il content dentro al part
					InputStream fileContent = FILEPART.getInputStream();) 
			{	
				int read = 0;
				final byte [] bytes=new byte[1024];
				while ((read=fileContent.read(bytes))!=-1) {
					out.write(bytes, 0, read);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println(FILENAME);

			lib.setImmagine_path("http://127.0.0.1:8887/"+FILENAME); //<--------PRIMA PARTE PATH WEB SERVLET
			
			try {
				Utility.inserisciLibro(lib);
				request.setAttribute("libroInserito", "successo");
			} catch (RollbackException e) {
				request.setAttribute("libroInserito", "errore");
			}
			//request.getRequestDispatcher("/listaLibri.jsp");
		}else request.getRequestDispatcher("ControlloIniziale").forward(request, response);
		
		doGet(request, response);
	}



	private String getFileName(final Part part) {		
		for(String content : part.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(
						content.indexOf('=')+1).trim().replace("\"", "");
			}
		}
		return null;
	}
}

