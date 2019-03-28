/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 27.03.2019
 */
package at.fhv.team5.sportsfreund.persistencejava.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Film implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer _id;
	
	@Column(name="title")
	private String _title;
	
	@Column(name="releaseYear")
	private Integer _releaseYear;
	
	@ManyToOne(optional = false)
	@JoinColumn(name ="languageId")
	private Language _language;
	
	@ManyToOne(optional = false)
	@JoinColumn(name ="genreId")
	private Genre _genre;
	
	@ManyToMany
	@JoinTable(
			name="filmActor",
			joinColumns = @JoinColumn(name ="filmId"),
			inverseJoinColumns = @JoinColumn(name ="actorId")
	)
	private List<Actor> _actors = new ArrayList<Actor>();
	
	protected Film() {
		
	}
	
	public Film(String title, Language language, Genre genre) {
		_title = title;
		_language = language;
		_genre = genre;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Integer getReleaseYear() {
		return _releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		_releaseYear = releaseYear;
	}

	public Integer getId() {
		return _id;
	}

	public Language getLanguage() {
		return _language;
	}

	public void setLanguage(Language language) {
		_language = language;
	}

	public Genre getGenre() {
		return _genre;
	}

	public void setGenre(Genre genre) {
		_genre = genre;
	}

	public List<Actor> getActors() {
		return _actors;
	}

	public void setActors(List<Actor> actors) {
		_actors = actors;
	}

}
