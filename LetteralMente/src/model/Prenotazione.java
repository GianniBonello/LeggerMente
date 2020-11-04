package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the prenotazione database table.
 * 
 */
@Entity
@NamedQuery(name="Prenotazione.findAll", query="SELECT p FROM Prenotazione p")
public class Prenotazione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idprenotazione;

	@Temporal(TemporalType.DATE)
	private Date data;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_utente")
	private Utente u;

	private boolean inCorso;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="isbn_libro")
	private Libro lib;

	public Prenotazione() {
	}

	public int getIdprenotazione() {
		return this.idprenotazione;
	}

	public void setIdprenotazione(int idprenotazione) {
		this.idprenotazione = idprenotazione;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public boolean getInCorso() {
		return this.inCorso;
	}

	public void setInCorso(boolean inCorso) {
		this.inCorso = inCorso;
	}

}