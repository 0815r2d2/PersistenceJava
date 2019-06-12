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

public class ActorRepository implements BaseRepository<Actor> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#loadAll
	 * (javax.persistence.EntityManager)
	 */
	public List<Actor> loadAll(EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> query = builder.createQuery(Actor.class);
		Root<Actor> root = query.from(Actor.class);

		CriteriaQuery<Actor> selectQuery = query.select(root);
		TypedQuery<Actor> typedQuery = entityManager.createQuery(selectQuery);
		return typedQuery.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#load(
	 * javax.persistence.EntityManager, java.lang.Integer)
	 */
	public Actor load(EntityManager entityManager, Integer id) {
		return entityManager.find(Actor.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#delete(
	 * javax.persistence.EntityManager, java.lang.Integer)
	 */
	public void delete(EntityManager entityManager, Integer id) {
		Actor emp = load(entityManager, id);
		if (emp != null) {
			entityManager.remove(emp);
		}
	}

}
