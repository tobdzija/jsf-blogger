package rs.cubes.FullWebApp.jsf;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rs.cubes.FullWebApp.domain.User;
import rs.cubes.FullWebApp.service.UserService;

@Named
@ApplicationScoped
public class UserBean implements Serializable{
	@Inject
	private UserService us;
	
	private long id;
	private String username, nickname, surname, name, password, email;
	
	
	public UserService getUs() {
		return us;
	}
	public void setUs(UserService us) {
		this.us = us;
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
	
	public void confirmButton() {
		us.createUser(new User(username, nickname, surname, name, password, email));
		username="";
		password="";
		name="";
		nickname="";
		surname="";
		email="";
		
	}
	
	//promeni povratni tip !
	public String logIn(String un,String pw) {
		if(us.logIn(un, pw)!="") {
			setNickname(us.logIn(un, pw));
			setLamp(false);
			System.out.println("bio sam ovde");
			return "createArticle?faces-redirect=true";
		}
		return "indexNew?faces-redirect=true";
	}
	
	public String logOut() {
			lamp = true;
			return "indexNew?faces-redirect=true";
	}
	
	private boolean lamp=true;
	public boolean isLamp() {
		return lamp;
	}
	public void setLamp(boolean lamp) {
		this.lamp = lamp;
	}
	
	public List<User> completeNames(String nickname){
		return us.searchUser(nickname);
	}
	
	public String fullName() {
		System.out.println("Name: " + name);
		System.out.println("Surname: " + surname);
		return this.name + " " + this.surname;
	}
}
