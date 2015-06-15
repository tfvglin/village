package test.transaction;



import java.util.Date;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.xidian.village.dao.impl.NotificationCommentDaoImpl;
import edu.xidian.village.vo.NotificationComment;

public class NotificationTest extends TestCase{

	
	public void testTransaction() throws Exception
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*NotificationInterface notificationimpl = (NotificationInterface) ctx.getBean("notificationI");
		Notification no = new Notification();*/
		//no.setMessage("bbbbbbbbbbbbbbbbbbbbb");
		//notificationimpl.add(no);
		
		//NotificationDaoImpl nodaoimpl = (NotificationDaoImpl) ctx.getBean("notificationDaoImpl");
		//List list =nodaoimpl.get(1, 11);
		//no=notificationimpl.get(1, 11);
		//System.out.print(no.getNotificationComment().size());
		NotificationCommentDaoImpl ncdaoimpl = (NotificationCommentDaoImpl) ctx.getBean("notificationCommentDaoImpl");
		NotificationComment nc = new NotificationComment();
		nc.setContent("alalalala");
		nc.setDatetime(new Date().getTime());
		ncdaoimpl.add(nc);
	}
}
