package rs.cubes.FullWebApp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;
	private String username, nickname, surname, name, password, email;
	
	// atributi za mapiranje veza izmedju entiteta
	//@XmlTransient  ova anotacija mozda treba da stoji nad nekim drugim atributom !!
	@OneToMany(mappedBy="author")
	private Set<Article> articles;
	
	@OneToMany(mappedBy="user")
	private Set<Rating> raitings;
	
	@OneToMany(mappedBy="author")
	private Set<Comment> comments;
	
	public User() {}
	
	public User(String username, String nickname, String surname, String name, String password, String email) {
		this.username = username;
		this.nickname = nickname;
		this.surname = surname;
		this.name = name;
		this.password = password;
		this.email = email;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
