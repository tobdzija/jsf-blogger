package rs.cubes.FullWebApp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rs.cubes.FullWebApp.domain.Article;
import rs.cubes.FullWebApp.domain.User;
import rs.cubes.FullWebApp.rest.ErrorMessage;

@Stateless
public class UserService {
	@PersistenceContext
	private EntityManager em;
	
	public User createUser(User u) {
		if(u.getUsername().length()>20) {
			throw new AppException(ErrorMessage.usernameTooLong());
		}
		em.persist(u);
		return u;
	}
	
	public List<User> getAllUsers(){
		
		String q = "select u from User u";
		TypedQuery<User> query = em.createQuery(q,User.class);
		
		return query.getResultList();
	}
	
	
}
