package Util;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

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
	
	public static List<Libro> leggiLibroHome(){
		EntityManager em = getManager();
		Query q = em.createQuery("SELECT l FROM Libro l ORDER BY l.id_libro DESC");
		q.setMaxResults(6);
		return (List<Libro>)q.getResultList();
    	 
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
	public static void inserisciNoleggio(Noleggio n, int idLibro, int idUtente) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	n.setLib(em.find(Libro.class, idLibro));
    	n.setU(em.find(Utente.class, idUtente));
    	em.persist(n);
    	et.commit();
    	UtilityRicerca.mailNoleggi(trovaNoleggio(idUtente, idLibro));
	}
	public static void inserisciPrenotazione(Prenotazione p, int idLibro, int idUtente) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	p.setLib(em.find(Libro.class, idLibro));
    	p.setU(em.find(Utente.class, idUtente));
    	em.persist(p);
    	et.commit();
    	UtilityRicerca.mailPrenotazioni(trovaPrenotazione(idUtente, idLibro));
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
    	UtilityRicerca.mailPrenotazioni(p);
	}
	public static void modificaNoleggio(Noleggio n) {
		EntityManager em = getManager();
    	EntityTransaction et = em.getTransaction();
    	et.begin();
    	em.merge(n);
    	et.commit();
	}
	/*-----------------------------------------------------------------------------TROVA-----------------------------*/
	public static Libro trovaLibro(int id) {
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
	
	public static Utente trovaUtente(String use, String pass){
		String passCod = Base64.getEncoder().encodeToString((pass).getBytes());
		EntityManager em = getManager();
		Query q = em.createQuery("SELECT u FROM Utente u WHERE u.username =:user AND u.password =:pass");
		q.setParameter("user", use);
		q.setParameter("pass", passCod);
		try {
			return (Utente)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
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
	
	public static Prenotazione trovaPrenotazione(int u, int l) {
		EntityManager em = getManager();
		Query q= em.createQuery("SELECT p FROM Prenotazione p WHERE p.u.idUtente =:utente AND p.lib.id_libro =:libro ORDER BY p.idprenotazione DESC");
		q.setParameter("utente", u);
		q.setParameter("libro", l);
		q.setMaxResults(1);
		try {
			return (Prenotazione)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
	
	//torna lista di prenotazioni in coda
	public static List<Prenotazione> trovaPrenotazione(Libro l){
		EntityManager em = getManager();
		Query q = em.createQuery("SELECT p FROM Prenotazione p WHERE p.data is NULL AND p.lib.id_libro =:libro");
		q.setParameter("libro", l.getId_libro());
		return q.getResultList();
	}
	
	public static Noleggio trovaNoleggio(int u, int l) {
		EntityManager em = getManager();
		Query q= em.createQuery("SELECT p FROM Noleggio p WHERE p.u.idUtente =:utente AND p.lib.id_libro =:libro ORDER BY p.idNoleggio DESC");
		q.setParameter("utente", u);
		q.setParameter("libro", l);
		q.setMaxResults(1);
		try {
			return (Noleggio)q.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
	
	public static List<Noleggio> trovaNoleggio(Utente u){
		EntityManager em = getManager();
		Query q = em.createQuery("SELECT p FROM Noleggio p WHERE p.u.idUtente =:utente");
		q.setParameter("utente", u.getIdUtente());
		return q.getResultList();
	}
	
	public static List<Prenotazione> trovaPrenotazione(Utente u){
		EntityManager em = getManager();
		Query q = em.createQuery("SELECT p FROM Prenotazione p WHERE p.u.idUtente =:utente");
		q.setParameter("utente", u.getIdUtente());
		return q.getResultList();
	}
	
}
