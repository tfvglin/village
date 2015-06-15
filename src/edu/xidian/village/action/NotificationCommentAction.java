package edu.xidian.village.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;

import edu.xidian.village.service.NotificationCommentService;
import edu.xidian.village.util.Fetch;
import edu.xidian.village.vo.NotificationComment;

@Controller("notificationCommentAction")
public class NotificationCommentAction extends SuperAction{

	private NotificationCommentService notificationCommentServiceImpl;
	private Fetch fetch;
	private String sign;
	private InputStream inputStream;
	private List<NotificationComment> nclist;
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public List<NotificationComment> getNclist() {
		return nclist;
	}
	public void setNclist(List<NotificationComment> nclist) {
		this.nclist = nclist;
	}
	public List<NotificationComment> getNcList() {
		return nclist;
	}
	public void setNcList(List<NotificationComment> ncList) {
		this.nclist = ncList;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public Fetch getFetch() {
		return fetch;
	}
	@Resource
	public void setFetch(Fetch fetch) {
		this.fetch = fetch;
	}

	public NotificationCommentService getNotificationCommentServiceImpl() {
		return notificationCommentServiceImpl;
	}

	@Resource
	public void setNotificationCommentServiceImpl(
			NotificationCommentService notificationCommentServiceImpl) {
		this.notificationCommentServiceImpl = notificationCommentServiceImpl;
	}
	
	public String addNotificationComment()
	{
		NotificationComment nc = new NotificationComment();
		try {
			String jsonStr =Fetch.fetchInputStream(request.getInputStream());
			System.out.println(jsonStr);
			JSONObject jsonObject ;
			jsonObject = new JSONObject(jsonStr);
			nc.setContent(jsonObject.getString("content"));
			nc.setDatetime(Long.parseLong(jsonObject.getString("date")));
			int nid=Integer.parseInt(jsonObject.getString("nid"));
			int uid=Integer.parseInt(jsonObject.getString("uid"));
		
			
			sign=notificationCommentServiceImpl.addNotificationComment(nc, nid,uid)?"ok":"error";	
				
		
		} catch (Exception e) {
			sign="error";
			e.printStackTrace();
		} 
		inputStream = new ByteArrayInputStream(sign.getBytes());
		return SUCCESS;
	}
	
	public String notificationCommentList()
	{
		try{
			int nid = Integer.parseInt(request.getParameter("nid"));
			nclist = notificationCommentServiceImpl.getNotificationCommentList(nid);
		
			if(nclist.isEmpty())
				sign="empty";
			else
				sign="ok";
		}
		catch(Exception e)
		{
			sign="error";
			e.printStackTrace();
		}
	
			return SUCCESS;
	}
	
}
