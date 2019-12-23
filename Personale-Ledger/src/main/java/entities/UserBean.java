package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Users")
public class UserBean {
	@Id
	@Column(name="username", length = 16, nullable = false)
	private String username;
	
	@Column(name="password", length = 20, nullable = false)
	private String password;
	
	public UserBean(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserBean() {
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
