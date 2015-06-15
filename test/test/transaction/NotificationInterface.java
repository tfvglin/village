package test.transaction;

import edu.xidian.village.vo.Notification;

public interface NotificationInterface {

	public void add(Notification n);
	
	public Notification get(int n,int offset)throws Exception;
}
