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
import at.fhv.persistencejava.entities.Genre;

public class GenreRepository implements BaseRepository<Genre> {

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#loadAll(javax.persistence.EntityManager)
	 */
	public List<Genre> loadAll(EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Genre> query = builder.createQuery(Genre.class);
		Root<Genre> root = query.from(Genre.class);

		CriteriaQuery<Genre> selectQuery = query.select(root);
		TypedQuery<Genre> typedQuery = entityManager.createQuery(selectQuery);
		return typedQuery.getResultList();
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#load(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public Genre load(EntityManager entityManager, Integer id) {
		return entityManager.find(Genre.class, id);
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#delete(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public void delete(EntityManager entityManager, Integer id) {
		Genre emp = load(entityManager, id);
	    if (emp != null) {
	    	entityManager.remove(emp);
	    }
	}
}
