package rs.cubes.FullWebApp.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import rs.cubes.FullWebApp.domain.Article;
import rs.cubes.FullWebApp.service.ArticleService;
import rs.cubes.FullWebApp.service.UserService;

@Named
@RequestScoped
public class ArticleBean implements Serializable {
	@Inject
	private ArticleService as;

	private long id;
	private String title, content, shortContent;
	private int ratingCounter;
	private double averageRating; 
	private Date date;
	private ArrayList<String> keywords;
	
	
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
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
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
	public ArrayList<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(ArrayList<String> keywords) {
		this.keywords = keywords;
	}
	
	public void createButton() {
		as.createArticle(new Article(title, content, shortContent, averageRating, date, keywords));
	}
	
}
