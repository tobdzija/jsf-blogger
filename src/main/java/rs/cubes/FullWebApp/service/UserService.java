package rs.cubes.FullWebApp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rs.cubes.FullWebApp.domain.Article;
import rs.cubes.FullWebApp.domain.User;
import rs.cubes.FullWebApp.domain.UserQueries;
import rs.cubes.FullWebApp.rest.ErrorMessage;
import rs.cubes.FullWebApp.utils.EmailRegex;

@Stateless
public class UserService {
	@PersistenceContext
	private EntityManager em;
	
	public User createUser(User u) {
		if(u.getUsername().length()>20) {
			throw new AppException(ErrorMessage.usernameTooLong());
		}else if(u.getNickname().length()>20) {throw new AppException(ErrorMessage.nicknameTooLong());}
		else if(u.getSurname().length()>50) {throw new AppException(ErrorMessage.surnameTooLong());}
		else if(u.getName().length()>20) {throw new AppException(ErrorMessage.nameTooLong());}
		else if(!EmailRegex.validate(u.getEmail())) {throw new AppException(ErrorMessage.emailFormatError());}
		else if(UserQueries.usernameExists(em, u.getUsername())) {throw new AppException(ErrorMessage.usernameExists());}
		em.persist(u);
		return u;
	}
	
	public List<User> getAllUsers(){
		
		String q = "select u from User u";
		TypedQuery<User> query = em.createQuery(q,User.class);
		
		return query.getResultList();
	}
	public void deleteAll() {
		em.clear();
	}
	
}
