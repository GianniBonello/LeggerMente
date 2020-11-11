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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LeggerMente");
        EntityManager em = emf.createEntityManager();
        return em;
	}
	
	/*-----------------------------------------------------------------------------LEGGI LISTE------------------------------*/
	public  static List<Libro> leggiLibro() {
		EntityManager em = getManager();
    	return em.createNamedQuery("Libro.findAll").getResultList();
	}
	public static List<Prenotazione> leggiPrenotazione() {
		EntityManager em = getManager();
    	return em.createNamedQuery("Prenotazione.findAll").getResultList();
	}
	public static List<Noleggio> leggiNoleggio() {
		EntityManager em = getManager();
    	return em.createNamedQuery("Noleggio.findAll").getResultList();
	}
	public static List<Utente> leggiUtente() {
		EntityManager em = getManager();
    	return em.createNamedQuery("Utente.findAll").getResultList();
	}
	
	/*COSA GENNIALEEEEE MF--------------------------------------------------------------------------------FILTRI---------------------------
	@SuppressWarnings("unchecked")
	public static List<Libro> filtraLibri(String filtro){
		return (List<Libro>)getManager().createQuery("SELECT * FROM libro ORDER BY " + filtro + ";");
	}
	*/
	
	/*--------------------------------------------------------------------------------INSERISCI---------------------------*/
	public static void inserisciLibro(Libro l) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(l);
    	et.commit();
	}
	public static void inserisciUtente(Utente u) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.persist(u);
    	et.commit();
	}
	public static void inserisciNoleggio(Noleggio n, String idLibro, int idUtente) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	n.setLib(em.find(Libro.class, idLibro));
    	n.setU(em.find(Utente.class, idUtente));
    	em.persist(n);
    	et.commit();
	}
	public static void inserisciPrenotazione(Prenotazione p, String idLibro, int idUtente) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	p.setLib(em.find(Libro.class, idLibro));
    	p.setU(em.find(Utente.class, idUtente));
    	em.persist(p);
    	et.commit();
	}
	
	/*---------------------------------------------------------------------------------ELIMINA-------------------------------*/
	public static void eliminaLibro(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.remove(em.find(Libro.class, id));
    	et.commit();
	}
	public static void eliminaUtente(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.remove(em.find(Utente.class, id));
    	et.commit();
	}
	public static void eliminaPrenotazione(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.remove(em.find(Prenotazione.class, id));
    	et.commit();
	}
	public static void eliminaNoleggio(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.remove(em.find(Noleggio.class, id));
    	et.commit();
	}
	/*-----------------------------------------------------------------------------MODIFICA-----------------------------------*/
	public static void modificaLibro(Libro l) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.merge(l);
    	et.commit();
	}
	public static void modificaUtente(Utente u) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.merge(u);
    	et.commit();
	}
	public static void modificaPrenotazione(Prenotazione p) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.merge(p);
    	et.commit();
	}
	public static void modificaNoleggio(Noleggio n) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.merge(n);
    	et.commit();
	}
	/*-----------------------------------------------------------------------------TROVA-----------------------------*/
	public static Libro trovaLibro(String id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	Libro l = em.find(Libro.class, id);
    	et.commit();
    	return l;
	}
	public static Utente trovaUtente(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	Utente u = em.find(Utente.class, id);
    	et.commit();
    	return u;
	}
	
	public static Utente trovaUtentePerUser(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	Utente u = em.find(Utente.class, id);
    	et.commit();
    	return u;
	}
	
	public static Prenotazione trovaPrenotazione(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	Prenotazione p = em.find(Prenotazione.class, id);
    	et.commit();
    	return p;
	}
	public static Noleggio trovaNoleggio(int id) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	Noleggio n = em.find(Noleggio.class, id);
    	et.commit();
    	return n;
	}
	
}
