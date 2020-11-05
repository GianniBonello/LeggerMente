package Util;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Libro;
import model.Noleggio;
import model.Prenotazione;
import model.Utente;

public class Utility {
	
	/*-----------------------------METODO CHE RITONA L'ENTITY MANAGER---------------------------------*/
	
	private static EntityManager getManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoFinaleJRM18");
        EntityManager em = emf.createEntityManager();
        return em;
	}
	
	/*-----------------------------------------------------------------------------LEGGI LISTE------------------------------*/
	public List<Libro> leggiLibro() {
    	return (List<Libro>)getManager().createNamedQuery("Libro.findAll");
	}
	public List<Prenotazione> leggiPrenotazione() {
    	return (List<Prenotazione>)getManager().createNamedQuery("Prenotazione.findAll");
	}
	public List<Noleggio> leggiNoleggio() {
    	return (List<Noleggio>)getManager().createNamedQuery("Noleggio.findAll");
	}
	public List<Utente> leggiUtente() {
    	return (List<Utente>)getManager().createNamedQuery("Utente.findAll");
	}
	
	/*--------------------------------------------------------------------------------INSERISCI---------------------------*/
	public void inserisciLibro(Libro l) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().persist(l);
    	et.commit();
	}
	public void inserisciUtente(Utente u) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().persist(u);
    	et.commit();
	}
	public void inserisciNoleggio(Noleggio n, int idLibro, int idUtente) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	n.setLib(getManager().find(Libro.class, idLibro));
    	n.setU(getManager().find(Utente.class, idUtente));
    	getManager().persist(n);
    	et.commit();
	}
	public void inserisciPrenotazione(Prenotazione p, int idLibro, int idUtente) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	p.setLib(getManager().find(Libro.class, idLibro));
    	p.setU(getManager().find(Utente.class, idUtente));
    	getManager().persist(p);
    	et.commit();
	}
	
	/*---------------------------------------------------------------------------------ELIMINA-------------------------------*/
	public void eliminaLibro(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().remove(getManager().find(Libro.class, id));
    	et.commit();
	}
	public void eliminaUtente(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().remove(getManager().find(Utente.class, id));
    	et.commit();
	}
	public void eliminaPrenotazione(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().remove(getManager().find(Prenotazione.class, id));
    	et.commit();
	}
	public void eliminaNoleggio(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().remove(getManager().find(Noleggio.class, id));
    	et.commit();
	}
	/*-----------------------------------------------------------------------------MODIFICA-----------------------------------*/
	public void modificaLibro(Libro l) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().merge(l);
    	et.commit();
	}
	public void modificaUtente(Utente u) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().merge(u);
    	et.commit();
	}
	public void modificaPrenotazione(Prenotazione p) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().merge(p);
    	et.commit();
	}
	public void modificaNoleggio(Noleggio n) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	getManager().merge(n);
    	et.commit();
	}
	/*-----------------------------------------------------------------------------TROVA-----------------------------*/
	public Libro trovaLibro(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	Libro l = getManager().find(Libro.class, id);
    	et.commit();
    	return l;
	}
	public Utente trovaUtente(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	Utente u = getManager().find(Utente.class, id);
    	et.commit();
    	return u;
	}
	public Prenotazione trovaPrenotazione(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	Prenotazione p = getManager().find(Prenotazione.class, id);
    	et.commit();
    	return p;
	}
	public Noleggio trovaNoleggio(int id) {
    	EntityTransaction et = getManager().getTransaction();
    	et.begin();
    	Noleggio n = getManager().find(Noleggio.class, id);
    	et.commit();
    	return n;
	}
}
