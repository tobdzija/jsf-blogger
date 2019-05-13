package rs.cubes.FullWebApp.domain;

import javax.persistence.Entity;

@Entity
public class Rating {

	private long id;
	private int[] rating = {1,2,3,4,5};
	
	public Rating() {}

	public Rating(long id, int[] rating) {
		super();
		this.id = id;
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int[] getRating() {
		return rating;
	}

	public void setRating(int[] rating) {
		this.rating = rating;
	}
	
	
}
