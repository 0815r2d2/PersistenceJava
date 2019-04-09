/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 27.03.2019
 */
package at.fhv.team5.sportsfreund.persistencejava.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer _id;
	
	@Column(name="name")
	private String _name;
	
	@OneToMany(mappedBy="_language")
	private Collection<Film> _films = new ArrayList<Film>();
	
	protected Language() {
		
	}
	
	public Language(String name) {
		_name = name;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Integer getId() {
		return _id;
	}

	public Collection<Film> getFilms() {
		return _films;
	}

	public void setFilms(Collection<Film> films) {
		_films = films;
	}

}
