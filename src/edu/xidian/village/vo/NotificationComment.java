package edu.xidian.village.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class NotificationComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	private String content;
	private Long datetime;
	@ManyToOne
	@JoinColumn(name="notification_id")
	private Notification notification;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public NotificationComment()
	{
		
	}
	public NotificationComment(Integer id,String content,Long datetime)
	{
		this.id=id;
		this.content=content;
		this.datetime=datetime;
	}
	public NotificationComment(Integer id,String content,Long datetime,User user)
	{
		this.id=id;
		this.content=content;
		this.datetime=datetime;
		
		this.user=user;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Long getDatetime() {
		return datetime;
	}
	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}
	public Notification getNotification() {
		return notification;
	}
	
	
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
