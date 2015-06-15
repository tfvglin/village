package edu.xidian.village.service;

import java.util.List;

import edu.xidian.village.vo.NotificationComment;

public interface NotificationCommentService {

	public boolean addNotificationComment(NotificationComment nc,int noid,int uid);
	
	public List<NotificationComment> getNotificationCommentList(int nid)throws Exception;
}
