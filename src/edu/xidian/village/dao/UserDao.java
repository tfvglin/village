package edu.xidian.village.dao;

import java.io.Serializable;
import java.util.List;

import edu.xidian.village.vo.User;

public interface UserDao {
	
	
	public List<User> find(String name);
	
	public Serializable add(User user);
	
	public List<User> get(User user);
	
	public void update(User user);

	public User get(Class<? extends User> c,int uid);
}
