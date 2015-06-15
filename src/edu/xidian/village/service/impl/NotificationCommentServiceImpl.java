package edu.xidian.village.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



import edu.xidian.village.dao.NotificationCommentDao;
import edu.xidian.village.dao.NotificationDao;
import edu.xidian.village.dao.UserDao;
import edu.xidian.village.service.NotificationCommentService;
import edu.xidian.village.vo.Notification;
import edu.xidian.village.vo.NotificationComment;
import edu.xidian.village.vo.User;
@Transactional
@Component("notificationCommentServiceImpl")
public class NotificationCommentServiceImpl implements NotificationCommentService {

	private NotificationCommentDao notificationCommentDaoImpl;
	private NotificationDao notificationDaoImpl;
	private UserDao userDaoImpl;
	
	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}
	@Resource
	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}
	public NotificationCommentDao getNotificationCommentDaoImpl() {
		return notificationCommentDaoImpl;
	}
	@Resource
	public void setNotificationCommentDaoImpl(
			NotificationCommentDao notificationCommentDaoImpl) {
		this.notificationCommentDaoImpl = notificationCommentDaoImpl;
	}
	public NotificationDao getNotificationDaoImpl() {
		return notificationDaoImpl;
	}
	@Resource
	public void setNotificationDaoImpl(NotificationDao notificationDaoImpl) {
		this.notificationDaoImpl = notificationDaoImpl;
	}

	@Override
	public boolean addNotificationComment(NotificationComment nc, int noid,int uid) {
		try
		{
			Notification no = notificationDaoImpl.get(Notification.class, noid);
			User user = userDaoImpl.get(User.class, uid);
			nc.setNotification(no);
			nc.setUser(user);
			notificationCommentDaoImpl.add(nc);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public List<NotificationComment> getNotificationCommentList(int nid) throws Exception {
		
		return notificationCommentDaoImpl.get(nid);
	}

}
