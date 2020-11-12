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
	@Column(name="idprenotazione")
	private int idprenotazione;

	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date data;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_utente")
	private Utente u;
	
	@Column(name="inCorso")
	private boolean inCorso;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="isbn_libro")
	private Libro lib;

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

	public Utente getU() {
		return u;
	}

	public void setU(Utente u) {
		this.u = u;
	}

	public Libro getLib() {
		return lib;
	}

	public void setLib(Libro lib) {
		this.lib = lib;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o!=null && o instanceof Prenotazione) {
			Prenotazione p = (Prenotazione)o;
			if(p.getIdprenotazione()== this.idprenotazione) {
				return true;
			}else return false;
		}else return false;
	}

}