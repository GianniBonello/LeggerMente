package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the utente database table.
 * 
 */
@Entity
@NamedQuery(name="Utente.findAll", query="SELECT u FROM Utente u")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_utente")
	private int idUtente;

	private String cap;

	private String cf;

	private String cognome;

	private String comune;

	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;

	private String email;

	private String indirizzo;

	@Column(name="is_staff")
	private boolean isStaff;

	private String nome;

	private String password;

	private String username;
	
	@OneToMany(mappedBy ="u")
	public List<Noleggio> listaNoleggi;
	
	@OneToMany(mappedBy="u")
	public List<Prenotazione> listaPrenotazioni;

	public Utente() {
	}

	public int getIdUtente() {
		return this.idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

	public String getCap() {
		return this.cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCf() {
		return this.cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getComune() {
		return this.comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public Date getDataDiNascita() {
		return this.dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public boolean getIsStaff() {
		return this.isStaff;
	}

	public void setIsStaff(boolean isStaff) {
		this.isStaff = isStaff;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}