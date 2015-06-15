package edu.xidian.village.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import edu.xidian.village.service.NotificationService;
import edu.xidian.village.vo.Notification;

@Controller("notificationAction")
@Scope("prototype") 
public class NotificationAction extends SuperAction {

	private String sign;

	private Notification notification;
	
	private NotificationService<Notification> notificationServiceImple;
	
	private List<Notification> nlist = new ArrayList<Notification>();
	private InputStream inputStream ;

	
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	
	public NotificationService<Notification> getNotificationServiceImple() {
		return notificationServiceImple;
	}
	@Resource
	public void setNotificationServiceImple(
			NotificationService<Notification> notificationServiceImple) {
		this.notificationServiceImple = notificationServiceImple;
	}
	public List<Notification> getNlist() {
		return nlist;
	}
	public void setNlist(List<Notification> nlist) {
		this.nlist = nlist;
	}
	public String notificationList()
	{
		
	
		try {
			int notificationcount =Integer.parseInt(request.getParameter("count")); 
			int offset =Integer.parseInt(request.getParameter("offset")); 
			nlist = notificationServiceImple.getNotificationList(notificationcount,offset);
			
			if(nlist.isEmpty())
				sign="error";
			else
				sign="ok";
		} catch (Exception e) {
			
			e.printStackTrace();
			sign="error";
		}
		
		return SUCCESS;
	}
	

	public String notificationIssue()
	{
		notification.setDatetime(new Date().getTime());		
		if(notificationServiceImple.addNotification(notification))
			
			sign="发布成功";
		else
			sign="发布失败";
		inputStream = new ByteArrayInputStream(sign.getBytes());
		return SUCCESS;
	}
	

	
	
	

}
