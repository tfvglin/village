package edu.xidian.village.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name="";
	private String password="";
	private String realName="";
	private String email="";
	private String phone="";
	private String nearName="";
	
	@OneToMany(mappedBy="user")
	private List<NotificationComment> notificationComment = new ArrayList<NotificationComment>();
	
	public User()
	{
		
	}
	public User(String realName,String nearName)
	{
		this.realName=realName;
		this.nearName=nearName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getNearName() {
		return nearName;
	}
	public void setNearName(String nearName) {
		this.nearName = nearName;
	}
	
	
	public List<NotificationComment> getNotificationComment() {
		return notificationComment;
	}
	public void setNotificationComment(List<NotificationComment> notificationComment) {
		this.notificationComment = notificationComment;
	}
	@Override
	public String toString()
	{
		return name+","+realName+","+email+","+id;
	}
}
