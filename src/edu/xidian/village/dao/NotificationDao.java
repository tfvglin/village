package edu.xidian.village.dao;

import java.io.Serializable;
import java.util.List;

import edu.xidian.village.vo.Notification;

public interface NotificationDao<T> {
	
	List<Notification> get(int n) throws Exception;
	
	Serializable add(T t);

	List<Notification> get(int n, int offset) throws Exception;
	
	Notification get(Class c,int id);

}
