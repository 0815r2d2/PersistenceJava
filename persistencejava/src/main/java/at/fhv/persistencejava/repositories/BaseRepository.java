/**
 * @author: Bianca Koinegg
 * Version 1.0
 * 28.03.2019
 */
package at.fhv.persistencejava.repositories;

import java.util.List;

import javax.persistence.EntityManager;

public interface BaseRepository<T> {
	
	public T load(EntityManager entityManager, Integer id);
	public List<T> loadAll(EntityManager entityManager);
	public void delete(EntityManager entityManager, Integer id);
	
}
