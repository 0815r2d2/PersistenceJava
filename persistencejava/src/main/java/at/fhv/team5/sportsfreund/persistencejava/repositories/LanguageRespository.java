/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 28.03.2019
 */
package at.fhv.team5.sportsfreund.persistencejava.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import at.fhv.team5.sportsfreund.persistencejava.entities.Actor;
import at.fhv.team5.sportsfreund.persistencejava.entities.Language;

public class LanguageRespository implements BaseRepository<Language> {

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#loadAll(javax.persistence.EntityManager)
	 */
	public List<Language> loadAll(EntityManager entityManager) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Language> query = builder.createQuery(Language.class);
		Root<Language> root = query.from(Language.class);

		CriteriaQuery<Language> selectQuery = query.select(root);
		TypedQuery<Language> typedQuery = entityManager.createQuery(selectQuery);
		return typedQuery.getResultList();
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#load(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public Language load(EntityManager entityManager, Integer id) {
		return entityManager.find(Language.class, id);
	}

	/* (non-Javadoc)
	 * @see at.fhv.team5.sportsfreund.persistencejava.repositories.BaseRepository#delete(javax.persistence.EntityManager, java.lang.Integer)
	 */
	public void delete(EntityManager entityManager, Integer id) {
		Language emp = load(entityManager, id);
	    if (emp != null) {
	    	entityManager.remove(emp);
	    }
	}
	
	

	
}
