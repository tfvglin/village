package edu.xidian.village.vo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String title;
	private String message;
	private Long datetime;
	private String picture;
	
	@OneToMany(mappedBy="notification")
	private List<NotificationComment> notificationComment = new ArrayList<NotificationComment>();
	
	public Notification()
	{
		
	}
	public Notification(Integer id,String message,Long datetime,String picture,String title)
	{
		this.id=id;
		this.message=message;
		this.datetime=datetime;
		this.picture=picture;
		this.title=title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getDatetime() {
		return datetime;
	}
	public void setDatetime(Long datetime) {
		this.datetime = datetime;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public List<NotificationComment> getNotificationComment() {
		return notificationComment;
	}
	public void setNotificationComment(List<NotificationComment> notificationComment) {
		this.notificationComment = notificationComment;
	}
	

	
	
}
