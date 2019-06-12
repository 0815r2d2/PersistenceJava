/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 28.03.2019
 */
package at.fhv.persistencejava.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import at.fhv.persistencejava.entities.Actor;
import at.fhv.persistencejava.entities.Film;
import at.fhv.persistencejava.entities.Genre;
import at.fhv.persistencejava.entities.IEntity;
import at.fhv.persistencejava.entities.Language;
import at.fhv.persistencejava.repositories.ActorRepository;
import at.fhv.persistencejava.repositories.FilmRepository;
import at.fhv.persistencejava.repositories.GenreRepository;
import at.fhv.persistencejava.repositories.LanguageRespository;


public class Facade {

	private EntityManager _entityManager;

	public Facade() {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");
			_entityManager = factory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void saveEntity(IEntity entity) {
		EntityTransaction transaction = _entityManager.getTransaction();
	    try {
	        transaction.begin();
	        _entityManager.persist(entity);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	    }
	}
	
	public Actor loadActor(Integer id) {
		ActorRepository rep = new ActorRepository();
		return rep.load(_entityManager, id);
	}
	
	public Genre loadGenre(Integer id) {
		GenreRepository rep = new GenreRepository();
		return rep.load(_entityManager, id);
	}
	
	public Language loadLanguage(Integer id) {
		LanguageRespository rep = new LanguageRespository();
		return rep.load(_entityManager, id);
	}
	
	public Film loadFilm(Integer id) {
		FilmRepository rep = new FilmRepository();
		return rep.load(_entityManager, id);
	}
	
	public void removeActor(Integer id) {
		ActorRepository rep = new ActorRepository();
		rep.delete(_entityManager, id);
	}
	
	public void removeGenre(Integer id) {
		GenreRepository rep = new GenreRepository();
		rep.delete(_entityManager, id);
	}
	
	public void removeLanguage(Integer id) {
		LanguageRespository rep = new LanguageRespository();
		rep.delete(_entityManager, id);
	}
	
	public void removeFilm(Integer id) {
		FilmRepository rep = new FilmRepository();
		rep.delete(_entityManager, id);
	}
	
	public List<Actor> loadAllActors(){
		ActorRepository rep = new ActorRepository();
		return rep.loadAll(_entityManager);
	}
	
	public List<Genre> loadAllGenres(){
		GenreRepository rep = new GenreRepository();
		return rep.loadAll(_entityManager);
	}
	
	public List<Language> loadAllLanguages(){
		LanguageRespository rep = new LanguageRespository();
		return rep.loadAll(_entityManager);
	}
	
	public List<Film> loadAllFilms(){
		FilmRepository rep = new FilmRepository();
		return rep.loadAll(_entityManager);
	}
}
