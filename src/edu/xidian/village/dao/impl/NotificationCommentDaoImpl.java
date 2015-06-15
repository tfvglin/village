package edu.xidian.village.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.xidian.village.dao.NotificationCommentDao;
import edu.xidian.village.template.VillageHibernateTemplate;
import edu.xidian.village.vo.NotificationComment;
@Repository("notificationCommentDaoImpl")
public class NotificationCommentDaoImpl extends VillageHibernateTemplate implements NotificationCommentDao{

	@Override
	public void add(NotificationComment nc)throws Exception {
		getHibernateTemplate().save(nc);
		
	}

	@Override
	public List<NotificationComment> get(int nid) throws Exception {
	return	getHibernateTemplate().find("select content,datetime,user.nearName,user.name from NotificationComment where notification_id =? order by datetime desc",nid);
		//from NotificationComment where notification_id =? order by datetime desc
	}

	
	
}
