package it.jac.java;

import java.util.Date;


// Rappresentazione di una singola transazione all'interno del database
public class Transaction {
	
	// ID univoco transazione
	private int id; 
	// Username utente che ha effettuato la transazione
	private String username;
	// Data in cui è avvenuta la transazione
	private Date data;
	// Ammontare della transazione (positivo = risparmio | negativo = spesa)
	private float valore;
	// Descrizione opzionale per la transazione
	private String causale;
	
	
	
	// Costruttore
	public Transaction(int id, String username, Date data, float valore, String causale) {
		super();
		this.id = id;
		this.username = username;
		this.data = data;
		this.valore = valore;
		this.causale = causale;
	}
	
	// Costruttore senza casuale
	public Transaction(int id, String username, Date data, float valore) {
		super();
		this.id = id;
		this.username = username;
		this.data = data;
		this.valore = valore;
	}
	
	
	// GETTERS & SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getValore() {
		return valore;
	}
	public void setValore(float valore) {
		this.valore = valore;
	}
	public String getCausale() {
		return causale;
	}
	public void setCausale(String causale) {
		this.causale = causale;
	}
}
