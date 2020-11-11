package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the libro database table.
 * 
 */
@Entity
@NamedQuery(name="Libro.findAll", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	private String autore;

	@Column(name="casa_editrice")
	private String casaEditrice;

	private String genere;

	@Column(name="is_usato")
	private boolean isUsato;

	private double prezzo;

	private int quantita;

	private String titolo;

	private String trama;
	
	private String immagine_path;

	
	public String getImmagine_path() {
		return immagine_path;
	}

	public void setImmagine_path(String immagine_path) {
		this.immagine_path = immagine_path;
	}

	@OneToOne(mappedBy="lib")
	public Noleggio nol;
	
	@OneToOne(mappedBy="lib")
	public Prenotazione pren;

	public Libro() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutore() {
		return this.autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getCasaEditrice() {
		return this.casaEditrice;
	}

	public void setCasaEditrice(String casaEditrice) {
		this.casaEditrice = casaEditrice;
	}

	public String getGenere() {
		return this.genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public boolean getIsUsato() {
		return this.isUsato;
	}

	public void setIsUsato(boolean isUsato) {
		this.isUsato = isUsato;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getTitolo() {
		return this.titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTrama() {
		return this.trama;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public Noleggio getNol() {
		return nol;
	}

	public void setNol(Noleggio nol) {
		this.nol = nol;
	}

	public Prenotazione getPren() {
		return pren;
	}

	public void setPren(Prenotazione pren) {
		this.pren = pren;
	}

	public void setUsato(boolean isUsato) {
		this.isUsato = isUsato;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Libro) {
			Libro l = (Libro) o;
			if(l.getAutore().toLowerCase().equals(this.autore.toLowerCase()) || l.getTitolo().toLowerCase().equals(this.titolo.toLowerCase()) || l.getIsbn().equals(this.isbn)) {
				return true;
			}else return false;
		}else return false;
	}
}