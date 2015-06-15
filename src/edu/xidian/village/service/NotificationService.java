package edu.xidian.village.service;

import java.util.List;

import edu.xidian.village.vo.Notification;



public interface NotificationService<T> {
	
	public List<Notification> getNotificationList(int n,int offset) throws Exception;
	
	public boolean addNotification(T t);

	
}
