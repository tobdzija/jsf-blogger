package rs.cubes.FullWebApp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		else if(UserQueries.emailExists(em, u.getEmail())) {throw new AppException(ErrorMessage.emailExists());}
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
	public String logIn(String un,String pw) {
		System.out.println("Username je: " + un);
		System.out.println("Password je: " + pw);
		String nick = "";
		String q = "select u from User u where u.username = :un and u.password = :pw";
		TypedQuery<User> query = em.createQuery(q,User.class);
		query.setParameter("un", un);
		query.setParameter("pw", pw);
		
		List<User> u = query.getResultList();
		if(u.size()!=0) {
			nick = u.get(0).getNickname();
		}
		System.out.println("Nik je :" + nick);
		return nick;
	}
	
	public List<User> searchUser(String nn) {
		System.out.println("vrednost nn: " + nn);
		String q = "select u from User u where u.nickname like concat('%',:nn ,'%')";
		TypedQuery<User> query= em.createQuery(q,User.class);
		query.setParameter("nn",nn);
		List<User> users = query.getResultList();
		return users;
	}
}
