package com.revature.stacklite.dl;

import java.util.List;

/**
 * This is a generic interface for our DAOs
 * @author MarielleNolasco
 *
 * @param <T> type of object we're creating a DAO for
 * @param <K> data type of the id of the object
 */
public interface DAO<T,K> {
	T findById(K id);
	List<T> findAll();
	void add(T newObject);
	void update(T newObject);
}
