package rs.cubes.FullWebApp.jsf;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rs.cubes.FullWebApp.domain.Article;
import rs.cubes.FullWebApp.domain.User;
import rs.cubes.FullWebApp.service.ArticleService;

@Named
@SessionScoped
public class ArticleBean implements Serializable {
	@Inject
	private ArticleService as;

	private long id;
	private String title, content, shortContent;
	private int ratingCounter;
	private double averageRating; 
	private Date date = new Date();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getShortContent() {
		return shortContent;
	}
	public void setShortContent(String content) {
		shortContent = content;
	}
	public int getRatingCounter() {
		return ratingCounter;
	}
	public void setRatingCounter(int ratingCounter) {
		this.ratingCounter = ratingCounter;
	}
	public double getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	private void reset() {
		title="";
		content="";		
	}
	
	public String createArticle() {
		System.out.println("title: " + title);
		as.createArticle(new Article(title, content, shortContent, averageRating, date));
		reset();
		return "createArticle?faces-redirect=true";
	}
}