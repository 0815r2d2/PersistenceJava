/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 28.03.2019
 */
package at.fhv.team5.sportsfreund.persistencejava.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import at.fhv.team5.sportsfreund.persistencejava.entities.Actor;
import at.fhv.team5.sportsfreund.persistencejava.entities.Film;
import at.fhv.team5.sportsfreund.persistencejava.entities.Genre;
import at.fhv.team5.sportsfreund.persistencejava.entities.IEntity;
import at.fhv.team5.sportsfreund.persistencejava.entities.Language;
import at.fhv.team5.sportsfreund.persistencejava.repositories.ActorRepository;
import at.fhv.team5.sportsfreund.persistencejava.repositories.FilmRepository;
import at.fhv.team5.sportsfreund.persistencejava.repositories.GenreRepository;
import at.fhv.team5.sportsfreund.persistencejava.repositories.LanguageRespository;


public class Facade {

	private EntityManagerFactory factory;
	private EntityManager entityManager;

	public Facade() {
		try {
			factory = Persistence.createEntityManagerFactory("PersistenceUnit");
			entityManager = factory.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void saveEntity(IEntity entity) {
		EntityTransaction transaction = entityManager.getTransaction();
	    try {
	        transaction.begin();
	        entityManager.persist(entity);
	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction.isActive()) {
	            transaction.rollback();
	        }
	    }
	}
	
	public Actor loadActor(Integer id) {
		ActorRepository rep = new ActorRepository();
		return rep.load(entityManager, id);
	}
	
	public Genre loadGenre(Integer id) {
		GenreRepository rep = new GenreRepository();
		return rep.load(entityManager, id);
	}
	
	public Language loadLanguage(Integer id) {
		LanguageRespository rep = new LanguageRespository();
		return rep.load(entityManager, id);
	}
	
	public Film loadFilm(Integer id) {
		FilmRepository rep = new FilmRepository();
		return rep.load(entityManager, id);
	}
	
	public void removeActor(Integer id) {
		ActorRepository rep = new ActorRepository();
		rep.delete(entityManager, id);
	}
	
	public void removeGenre(Integer id) {
		GenreRepository rep = new GenreRepository();
		rep.delete(entityManager, id);
	}
	
	public void removeLanguage(Integer id) {
		LanguageRespository rep = new LanguageRespository();
		rep.delete(entityManager, id);
	}
	
	public void removeFilm(Integer id) {
		FilmRepository rep = new FilmRepository();
		rep.delete(entityManager, id);
	}
	
	public List<Actor> loadAllActors(){
		ActorRepository rep = new ActorRepository();
		return rep.loadAll(entityManager);
	}
	
	public List<Genre> loadAllGenres(){
		GenreRepository rep = new GenreRepository();
		return rep.loadAll(entityManager);
	}
	
	public List<Language> loadAllLanguages(){
		LanguageRespository rep = new LanguageRespository();
		return rep.loadAll(entityManager);
	}
	
	public List<Film> loadAllFilms(){
		FilmRepository rep = new FilmRepository();
		return rep.loadAll(entityManager);
	}
}
