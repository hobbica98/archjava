package entities;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
    name = "Transactions"
)
public class Transaction {
	
	@Id
	private int id;
	
	@Id
	private User username;
	
	@Basic
	private Date data;
	
	@Basic
	private float valore;
	
	@Basic
	private String causale;

	public Transaction(int id, User username, Date data, float valore, String causale) {
		super();
		this.id = id;
		this.username = username;
		this.data = data;
		this.valore = valore;
		this.causale = causale;
	}
	public Transaction() {
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUsername() {
		return username;
	}

	public void setUsername(User username) {
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
