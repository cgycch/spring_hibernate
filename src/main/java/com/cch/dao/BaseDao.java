package com.cch.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
	void save(T entity);
	void update(T entity);
	void deleteById(Serializable id);
	T findById(Serializable id);
	List<T> findAll();
}
