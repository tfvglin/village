package edu.xidian.village.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
/**
 *����������Ҫ����ʵ�ַ�ҳ
 */
public class PageUtil {
/**
     * @param <T>
 * @param             session :һ���Ự
     * @param            hql:����Ҫִ�е�hql��䣬
     * @param            offset ���ÿ�ʼλ��
     * @param              length:��ȡ��¼����
     * return             ���ؽ����List<?>��ʾһ�����͵�List
     */
    public static <T> List<T> getList( Session session , String hql , int offset, int length){
       Query q = session.createQuery(hql);
       q.setFirstResult(offset);
       q.setMaxResults(length);
      
       List<T> list = q.list();
      
       return list;
    }
}