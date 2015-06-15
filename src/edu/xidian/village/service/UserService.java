package edu.xidian.village.service;

import edu.xidian.village.vo.User;

public interface UserService {
	
	public boolean addUser(User user);
	
	public boolean checkPassword(User user);
	
	public boolean logout();
	
	public void postTopic();

	public User find(User user);
	
	public User getUser(String name);
	
	public boolean saveUserInfo(User user);


	public boolean checkToken(String name,String token);

}
