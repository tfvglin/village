package edu.xidian.village.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.xidian.village.dao.UserDao;
import edu.xidian.village.template.VillageHibernateTemplate;
import edu.xidian.village.vo.User;

@Repository("userDAOImpl")
public class UserDaoImpl extends VillageHibernateTemplate implements UserDao{

	
	@Override
	@SuppressWarnings("unchecked")
	public  List<User> find(String name) {
		String hql = "from User where name = ?";
		return getHibernateTemplate().find(hql, name);
	}

	
	@Override
	public Serializable add(User user) {
		return	getHibernateTemplate().save(user);
	}

	
	@Override
	public List<User> get(User user){
		String hql = "from User where name=? and password = ?";
		return getHibernateTemplate().find(hql, user.getName(),user.getPassword());
	}


	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}


	@Override
	public User get(Class<? extends User> c, int uid) {
		return getHibernateTemplate().get(User.class, uid);
		
	}


	
	

}
