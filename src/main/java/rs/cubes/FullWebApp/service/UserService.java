package rs.cubes.FullWebApp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rs.cubes.FullWebApp.domain.Article;
import rs.cubes.FullWebApp.domain.User;

@Stateless
public class UserService {
	@PersistenceContext
	private EntityManager em;
	
	public User createUser(User u) {
		em.persist(u);
		return u;
	}
	
	public List<User> getAllUsers(){
		
		String q = "select u from User u";
		TypedQuery<User> query = em.createQuery(q,User.class);
		
		return query.getResultList();
	}
	
	public Article createArticle(Article a) {
		em.persist(a);
		return a;
	}
	
	public List<Article> getAllArticles(){
		
		String q = "select a from Article a";
		TypedQuery<Article> query = em.createQuery(q,Article.class);
		
		return query.getResultList();
	}
}
