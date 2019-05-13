package rs.cubes.FullWebApp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import rs.cubes.FullWebApp.domain.Article;

@Stateless
public class ArticleService {
	@PersistenceContext
	private EntityManager em;
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
