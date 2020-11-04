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
	private byte isUsato;

	private double prezzo;

	private int quantita;

	private String titolo;

	private String trama;

	private byte vm18;
	
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

	public byte getIsUsato() {
		return this.isUsato;
	}

	public void setIsUsato(byte isUsato) {
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

	public byte getVm18() {
		return this.vm18;
	}

	public void setVm18(byte vm18) {
		this.vm18 = vm18;
	}

}