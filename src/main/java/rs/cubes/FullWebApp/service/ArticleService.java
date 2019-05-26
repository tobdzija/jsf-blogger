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
public class ArticleService {
	@PersistenceContext
	private EntityManager em;
	
	public Article createArticle(Article a) {
		if(a.getTitle().length()>50) {throw new AppException(ErrorMessage.titleTooLong());}
		else if(a.getContent().length()>5000) {throw new AppException(ErrorMessage.contentTooLong());}
		em.persist(a);
		return a;
	}
	
	public List<Article> getAllArticles(){
		
		String q = "select a from Article a";
		TypedQuery<Article> query = em.createQuery(q,Article.class);
		
		return query.getResultList();
	}
	
	public List<User> searchArticle(String title) {
		System.out.println("vrednost nn: " + title);
		String q = "select a from Article a where a.title like concat('%',:article ,'%')";
		TypedQuery<User> query= em.createQuery(q,User.class);
		query.setParameter("article",title);
		List<User> articles = query.getResultList();
		return articles;
	}
}
