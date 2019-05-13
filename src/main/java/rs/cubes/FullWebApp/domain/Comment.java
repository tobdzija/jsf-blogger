package rs.cubes.FullWebApp.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private long id;
	private Date creationDateTime;
	private String text;
	private int upVote, downVote;
	
	public Comment() {}

	public Comment(Date creationDateTime, String text, int upVote, int downVote) {
		super();
		this.creationDateTime = creationDateTime;
		this.text = text;
		this.upVote = upVote;
		this.downVote = downVote;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUpVote() {
		return upVote;
	}

	public void setUpVote(int upVote) {
		this.upVote = upVote;
	}

	public int getDownVote() {
		return downVote;
	}

	public void setDownVote(int downVote) {
		this.downVote = downVote;
	}
}
