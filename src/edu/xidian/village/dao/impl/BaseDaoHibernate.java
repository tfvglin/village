package edu.xidian.village.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.xidian.village.dao.BaseDao;

public class BaseDaoHibernate<T> extends HibernateDaoSupport implements BaseDao<T> {

	@Override
	public T get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
