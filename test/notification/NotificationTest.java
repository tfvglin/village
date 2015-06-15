package notification;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import edu.xidian.village.template.VillageHibernateTemplate;
import edu.xidian.village.vo.Notification;
import edu.xidian.village.vo.NotificationComment;
//@Transactional
@Component("notificationTest")
public class NotificationTest  extends TestCase {
	
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	public void testNotificationComment()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		NotificationTest notificationTest = (NotificationTest) ctx.getBean("notificationTest");
		HibernateTemplate ht = new HibernateTemplate(notificationTest.getSessionFactory());
		//Session session = notificationTest.getSessionFactory().getCurrentSession();
		VillageHibernateTemplate vht = new VillageHibernateTemplate();
		Notification no = new Notification();
		Notification no1 = new Notification();
		NotificationComment notificationComment = new NotificationComment();
	
		
		//no1.setMessage("ppppppppppppp");
		//session.save(no1);
		//throw new RuntimeException("aaa");
		no.setId(27);
		
		notificationComment.setContent("评论14```````````````````````");
		notificationComment.setNotification(no);
		ht.save(notificationComment);
		
		//no.setId(27);
		//no.setMessage("通知<<<<<<<<<<<<<<<<<<");
		//no.setTitle("通知13");
		//no.setNotificationComment(notificationComment);
		//no.getNotificationComment().add(notificationComment);
		/*List<Notification> list =ht.findByExample(no);
		
		Iterator<NotificationComment> it =list.get(0).getNotificationComment().iterator();
		while(it.hasNext())
			System.out.println(it.next().getContent());*/
		//int i=ht.get(Notification.class, 27).getNotificationComment().size();
		//Notification no1 = (Notification) ht.get(Notification.class, 27);
		//System.out.println(i);
		/*Iterator<NotificationComment> it =no1.getNotificationComment().iterator();
		while(it.hasNext())
			System.out.println(it.next().getContent());*/
	}
	
/*	public void testNotification()
	{
		Session session = Hibernate
	}*/

}
