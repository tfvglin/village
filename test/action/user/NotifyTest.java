package action.user;

import java.util.Date;

import junit.framework.TestCase;
import edu.xidian.village.service.impl.NotificationServiceImpl;
import edu.xidian.village.vo.Notification;

public class NotifyTest extends TestCase{

	
	/*private NotificationService<Notification> notificationServiceImpl;

	public NotificationService<Notification> getNotificationServiceImpl() {
		return notificationServiceImpl;
	}

	@Resource
	public void setNotificationServiceImpl(NotificationService<Notification> notificationServiceImpl) {
		this.notificationServiceImpl = notificationServiceImpl;
	}*/


	private Notification n = new Notification();
	
	public void test1()
	{
		NotificationServiceImpl<Notification> notificationServiceImpl = new NotificationServiceImpl<Notification>();
		n.setMessage("aaaaaaa");
		n.setDatetime(new Date().getTime());
	
		notificationServiceImpl.addNotification(n);
	}
	
	
	
}
