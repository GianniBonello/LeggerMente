package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the noleggio database table.
 * 
 */
@Entity
@NamedQuery(name="Noleggio.findAll", query="SELECT n FROM Noleggio n")
public class Noleggio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_noleggio")
	private int idNoleggio;

	@Temporal(TemporalType.DATE)
	@Column(name="data_fine")
	private Date dataFine;

	@Temporal(TemporalType.DATE)
	@Column(name="data_inizio")
	private Date dataInizio;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_utente")
	private Utente u;

	@Column(name="in_corso")
	private byte inCorso;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="isbn_libro")
	private Libro lib;


	public Noleggio() {
	}

	public int getIdNoleggio() {
		return this.idNoleggio;
	}

	public void setIdNoleggio(int idNoleggio) {
		this.idNoleggio = idNoleggio;
	}

	public Date getDataFine() {
		return this.dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	public Date getDataInizio() {
		return this.dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public byte getInCorso() {
		return this.inCorso;
	}

	public void setInCorso(byte inCorso) {
		this.inCorso = inCorso;
	}

}