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


@Entity
public class Genre implements IEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer _id;
	
	@Column(name="name")
	private String _name;
	
	@OneToMany(mappedBy="_genre")
	private Collection<Film> _films = new ArrayList<Film>();
	
	protected Genre() {
		
	}
	
	public Genre(String name) {
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
