package entities;

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
@Table(
    name = "Transactions"
)
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
	private float valore;
	
	@ManyToOne
    @JoinColumn(name="username")
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
	
	@Override
	public String toString() {
		return "Transazione [id = "+id+", Username = "+username+", Data = "+ data.toString()+", Valore = "+valore+", Causale = "+causale+"]";
	}
	
}
