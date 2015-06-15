package edu.xidian.village.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



import edu.xidian.village.dao.UserDao;
import edu.xidian.village.service.UserService;
import edu.xidian.village.vo.User;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	private UserDao userDaoImpl;
	
	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	@Resource
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	
	@Override
	public boolean addUser(User user) {
		
		if(userDaoImpl.add(user)!=null)
			return true;
		else
			return false;
	}

	
	@Override
	public boolean checkPassword(User user) {
		// TODO Auto-generated method stub
		if( userDaoImpl.get(user).isEmpty())
			return false;
		else
			return true;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postTopic() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User find(User user) {
		List<User> t =userDaoImpl.find(user.getName());
		if(t.isEmpty())
				return null;
		else
			return t.get(0);
			
	
	}
	@Override
	public User getUser(String name) {
		// TODO Auto-generated method stub
		return userDaoImpl.find(name).get(0);
	}
	@Override
	public boolean saveUserInfo(User user) {
		try{
		userDaoImpl.update(user);
		return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	@Override
	public boolean checkToken(String name,String token) {
		try{
			User u = userDaoImpl.find(name).get(0);
			if(u.getId().toString().equals(token))
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}



}
