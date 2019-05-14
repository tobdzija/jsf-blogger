package rs.cubes.FullWebApp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	@Id
	@GeneratedValue
	private long id;
	private String value;
	
	// atributi za mapiranje veza
	@ManyToMany
	private Set<Article> articles;
	
	public Tag() {}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
