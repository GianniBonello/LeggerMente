package test;

import java.io.IOException;
import java.sql.Date;

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
		l.setVm18((byte)0);
		l.setPrezzo(10);
		l.setTrama("coso");
		
		//aggiungi(l);
		Utente u = new Utente();
		u.setNome("Mario");
		u.setCognome("Rossi");
		u.setCf("chedevoscrive");  							//univoco
		u.setCap("00146");
		u.setDataDiNascita(Date.valueOf("2015-10-20"));
		u.setComune("Roma");
		u.setEmail("linomusso@hotmail.it");					//univoco
		u.setIndirizzo("via crucis");
		//u.setIsStaff(false); Questo non ce serve oooh!!!
		u.setPassword("root");
		u.setUsername("MarioLini");							//univoco
		
		
		try {
			aggiungi(u);
		} catch (RollbackException e) {
			System.out.println("vedemo se entra qua va");
		}
		
		
		Noleggio n = new Noleggio();
		n.setDataInizio(Date.valueOf("2015-10-20"));
		n.setDataFine(Date.valueOf("2015-10-21"));
		//n.setInCorso((byte)0);
		
		Prenotazione p = new Prenotazione();
		p.setData(Date.valueOf("2015-10-20"));
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
	
	public void elimina(Libro l) {
		em.getTransaction().begin();
		em.remove(l);
		em.getTransaction().commit();
	}
	
	public void modifica(Libro l) {
		em.getTransaction().begin();
		em.merge(l);
		em.getTransaction().commit();
	}

}
