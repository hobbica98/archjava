package it.jac.ledger.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class TransactionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2440628960312964544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "causale", length = 255)
	private String causale;

	@Column(name = "data")
	private Date data;

	@Column(name = "valore")
	private double valore;

	@ManyToOne
	@JoinColumn(name = "username")
	private UserBean username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserBean getUsername() {
		return username;
	}

	public void setUsername(UserBean username) {
		this.username = username;
	}

	// Set username tramite stringa user e password
	public void setUsername(String username, String password) {
		UserBean bean = new UserBean();
		bean.setUsername(username);
		bean.setPassword(password);
		this.username = bean;
	}

	// Set username tramite stringa user e default password
	public void setUsername(String username) {
		UserBean bean = new UserBean();
		bean.setUsername(username);
		bean.setPassword("defaultpw");
		this.username = bean;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(double valore) {
		this.valore = valore;
	}

	public String getCausale() {
		return causale;
	}

	public void setCausale(String causale) {
		this.causale = causale;
	}

	@Override
	public String toString() {
		return "Transazione [id = " + id + ", Username = " + username + ", Data = " + data.toString() + ", Valore = "
				+ valore + ", Causale = " + causale + "]";
	}

}
