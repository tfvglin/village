package test.transaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import edu.xidian.village.dao.NotificationDao;
import edu.xidian.village.vo.Notification;

public class NotificationImpl implements NotificationInterface{

	
	private NotificationDao notificationDaoImpl ;
	
	
	
	public NotificationDao getNotificationDaoImpl() {
		return notificationDaoImpl;
	}


	@Resource
	public void setNotificationDaoImpl(NotificationDao notificationDaoImpl) {
		this.notificationDaoImpl = notificationDaoImpl;
	}



	//@Transactional
	@Override
	public void add(Notification n) {
		notificationDaoImpl.add(n);
		throw new RuntimeException("aaaaa");
	}

	@Transactional
	@Override
	public Notification get(int n,int offset) throws Exception {
		List list =notificationDaoImpl.get(n, offset);
		return (Notification) list.get(0);
	}

}
