package edu.xidian.village.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import edu.xidian.village.dao.NotificationDao;
import edu.xidian.village.template.VillageHibernateTemplate;
import edu.xidian.village.util.PageUtil;
import edu.xidian.village.vo.Notification;

@Repository("notificationDaoImpl")
public class NotificationDaoImpl<T> extends VillageHibernateTemplate implements NotificationDao<T> {

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> get(final int n,final int offset)throws Exception {
		
		final String hql = "select new Notification(id,message,datetime,picture,title) from Notification order by datetime desc";
		
		
		return  getHibernateTemplate().execute(new HibernateCallback<List<Notification>>()
		{
			 @Override
			public List<Notification> doInHibernate(Session session)throws HibernateException, SQLException 
			 {
				 List<Notification> list2 = PageUtil.getList(session,hql,offset,n);
		        return list2;
			 }
		});
	
	}

	@Override
	public Serializable add(T t) {
		
		return getHibernateTemplate().save(t);
	}

	@Override
	public List<Notification> get(int n) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notification get(Class c,int id) {
		return getHibernateTemplate().get(c, id);
		
	}

}
