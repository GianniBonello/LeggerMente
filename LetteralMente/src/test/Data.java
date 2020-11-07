package test;

import java.io.IOException;
import java.util.Calendar;
//import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.sql.*;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.annotations.Properties;
import org.eclipse.persistence.jpa.config.Property;

import Util.Utility;
import model.Libro;
import model.Noleggio;
import model.Prenotazione;
import model.Utente;

/**
 * Servlet implementation class Data
 */
@WebServlet(name="data", urlPatterns={"/Data"})
public class Data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private EntityManagerFactory emf;
    private EntityManager em;
    public Data() {
        super();
        // TODO Auto-generated constructor stub
        emf = Persistence.createEntityManagerFactory("LeggerMente");
        em = emf.createEntityManager();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro l = new Libro();
		l.setTitolo("cpso");
		l.setAutore("coso");
		l.setCasaEditrice("coso");
		l.setGenere("coso");
		l.setIsbn("123-657");
		l.setQuantita(10);
		l.setPrezzo(10);
		l.setTrama("coso");
		
		LocalDate data = LocalDate.parse("2020/11/12");
		//aggiungi(l);
		Utente u = new Utente();
		u.setNome("Mario");
		u.setCognome("Rossi");
		u.setCf("cppdhedscrive");  							//univoco
		u.setCap("00146");
		u.setDataDiNascita(Date.valueOf(LocalDate.parse("2020-11-23")));
		u.setComune("Roma");
		u.setEmail("linlllsasa@hotmail.it");					//univoco
		u.setIndirizzo("via crucis");
		//u.setIsStaff(false); Questo non ce serve oooh!!!
		u.setPassword("root");
		u.setUsername("Malini");
		//u.setIdUtente(20);//univoco
		
		
		try {
			Utility.inserisciUtente(u);
		} catch (RollbackException e) {
			System.out.println("vedemo se entra qua va");
		}
		/*try {
			elimina(9);
		}catch(IllegalArgumentException e) {
			System.out.println("l'utente non esiste");
		}*/
    	
		
		Noleggio n = new Noleggio();
		//n.setDataInizio(Date.valueOf("2015-10-20"));
		//n.setDataFine(Date.valueOf("2015-10-21"));
		//n.setInCorso((byte)0);
		
		Prenotazione p = new Prenotazione();
		//p.setData(Date.valueOf("2015-10-20"));
		p.setInCorso(false);
		
		//aggiungi(p);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void aggiungi(Utente l) {
		em.getTransaction().begin();
		//l.setLib(em.find(Libro.class, "123-456"));
		//l.setU(em.find(Utente.class, 1));
		em.persist(l);
		em.getTransaction().commit();
	}
	
	public void elimina(int id) {
		em.getTransaction().begin();
		em.remove(em.find(Utente.class, id));
		em.getTransaction().commit();
	}
	
	public void modifica(Libro l) {
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
	}

}
