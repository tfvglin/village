package edu.xidian.village.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


@Controller("messageAction")
@Scope("prototype")
public class MessageAction extends SuperAction{
	
	
	
	
	/*public void push()
	{
		
		JPushClient jpushClient = new JPushClient("d4922580c99ecf1c0c8501f7", "63919c284bf299bb559def92");

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_android_tag_alertWithTitle();

        try {
        	
            PushResult result = jpushClient.sendPush(payload);
            
            LOG.info("Got result - " + result);
            
            

        } catch (APIConnectionException e) {
            // Connection error, should retry later
            LOG.error("Connection error, should retry later", e);
           

        } catch (APIRequestException e) {
            // Should review the error, and fix the request
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
           
        }
       
        
	}
	  public static PushPayload buildPushObject_android_tag_alertWithTitle() {
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android())
	                .setAudience(Audience.tag("tag1"))
	                .setNotification(Notification.android("ALERT", "TITLE", null))
	                .build();
	    }
	public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.alertAll("ALERT");
    }*/
}
