package rs.cubes.FullWebApp.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rs.cubes.FullWebApp.domain.User;

@Named
@SessionScoped
public class SearchArticle implements Serializable {

	//@Inject
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<User> completeNames(String query) {
		ArrayList<User> allUsers = new ArrayList<User>();
		
		//Create users and add them to the collection.
		User robert = new User();
		robert.setName("Robert");
		allUsers.add(robert);
		
		return allUsers;
	}
}