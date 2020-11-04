package test;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.annotations.Properties;
import org.eclipse.persistence.jpa.config.Property;

import model.Libro;
import model.Noleggio;
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
        emf = Persistence.createEntityManagerFactory("LetteralMente");
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
		u.setNome("cidao");
		u.setCognome("ooddod");
		u.setCf("fgssjkds");
		u.setCap("vfbrddn");
		u.setDataDiNascita(Date.valueOf("2015-10-20"));
		u.setComune("cados");
		u.setEmail("gfsssjdka");
		u.setIndirizzo("bcrnexdjm");
		u.setIsStaff(false);
		u.setPassword("vgrbdhde");
		u.setUsername("vssdcd");
		
		//aggiungi(u);
		
		Noleggio n = new Noleggio();
		n.setDataInizio(Date.valueOf("2015-10-20"));
		n.setDataFine(Date.valueOf("2015-10-21"));
		//n.setInCorso((byte)0);
		
		aggiungi(n);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void aggiungi(Noleggio l) {
		em.getTransaction().begin();
		l.setLib(em.find(Libro.class, "123-456"));
		l.setU(em.find(Utente.class, 1));
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
