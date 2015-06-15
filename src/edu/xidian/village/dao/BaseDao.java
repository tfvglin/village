package edu.xidian.village.dao;

public interface BaseDao<T> {

	public  T get();
	
	public void save(T t);

	
}
