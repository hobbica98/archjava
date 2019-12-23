package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Basic;
@Entity
@Table(
    name = "Users"
)
public class User {
	@Id
	private String username;
	@Basic
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User() {
		
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
