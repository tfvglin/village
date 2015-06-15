package edu.xidian.village.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import edu.xidian.village.dao.NotificationDao;
import edu.xidian.village.service.NotificationService;
import edu.xidian.village.vo.Notification;

//@Transactional
@Service("notificationServiceImpl")
public class NotificationServiceImpl<T> implements NotificationService<T> {

	private NotificationDao<T> notificationDaoImpl;
	
	




	public NotificationDao<T> getNotificationDaoImpl() {
		return notificationDaoImpl;
	}
	@Resource
	public void setNotificationDaoImpl(NotificationDao<T> notificationDaoImpl) {
		this.notificationDaoImpl = notificationDaoImpl;
	}

	@Override
	public List<Notification> getNotificationList(int n,int offset) throws Exception {
		return notificationDaoImpl.get(n,offset);
		
	}

	
	@Override
	public boolean addNotification(T t) {
		
			if(notificationDaoImpl.add(t)!=null)
			{
				//throw new RuntimeException("aa");
				return true;
				
			}
			else
				return false;
		
	}

}
