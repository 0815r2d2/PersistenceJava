/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 28.03.2019
 */
package at.fhv.persistencejava.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import at.fhv.persistencejava.entities.Actor;
import at.fhv.persistencejava.entities.Film;

public class FilmRepository implements BaseRepository<Film> {

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#loadAll(javax.persistence.EntityManager)
	 */
	public List<Film> loadAll(EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Film> query = builder.createQuery(Film.class);
		Root<Film> root = query.from(Film.class);

		CriteriaQuery<Film> selectQuery = query.select(root);
		TypedQuery<Film> typedQuery = entityManager.createQuery(selectQuery);
		return typedQuery.getResultList();
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#load(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public Film load(EntityManager entityManager, Integer id) {
		return entityManager.find(Film.class, id);
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#delete(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public void delete(EntityManager entityManager, Integer id) {
		Film emp = load(entityManager, id);
	    if (emp != null) {
	    	entityManager.remove(emp);
	    }
		
	}

	

}
