package edu.xidian.village.dao;

import java.util.List;

import edu.xidian.village.vo.NotificationComment;

public interface NotificationCommentDao {

	public void add(NotificationComment nc)throws Exception;
	
	public List<NotificationComment> get(int nid)throws Exception;
}
