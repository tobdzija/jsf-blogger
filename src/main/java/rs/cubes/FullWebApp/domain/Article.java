package rs.cubes.FullWebApp.domain;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Article {

	private long id;
	private String title, content, shortContent;
	private int ratingCounter;
	private double averageRating; 
	private Date date;
	private ArrayList<String> keywords;
	
	public Article() {}
	
	public Article(String title, String content, String shortContent, double averageRating,
			Date date, ArrayList<String> keywords) {
		super();
		this.title = title;
		this.content = content;
		this.shortContent = shortContent;
		this.averageRating = averageRating;
		this.date = date;
		this.keywords = keywords;
	}

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
	
	
}
