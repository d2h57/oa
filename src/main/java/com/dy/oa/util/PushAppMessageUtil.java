package com.dy.oa.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.ClientConfig;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;


public final class PushAppMessageUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PushAppMessageUtil.class);
	private static final String APP_KEY[] = new String[]{"30d839c2f91a0e083277b938","14b60266c85162d1d4293625"};
	private static final String MASTER_SECRET[] = new String[]{"b599a2a6fd99d17891e37ff9","f30101569432dc0f58bb4c05"};
	private static final int MAX_RETRY_TIMES = 3;
	private static final int NOTIFICATION_TYPE = 0;
	private static final int MESSAGE_TYPE = 1;
	
	public static void sendPush(String alias,String msgContent,int msgType,int appId) throws Exception {
		ClientConfig.getInstance().setMaxRetryTimes(MAX_RETRY_TIMES);
		JPushClient jpushClient = new JPushClient(MASTER_SECRET[appId], APP_KEY[appId]);
	
		PushPayload payload = null;
        // For push, all you need do is to build PushPayload object.
		if(NOTIFICATION_TYPE == msgType){
			payload = buildPushObject_all_alias_alert(alias,msgContent);
		}else {
			payload = buildPushObject_all_alias_message(alias,msgContent);
		}
        
        PushResult result = jpushClient.sendPush(payload);
        LOGGER.debug("send push result:{}",result);
	}
	
    /**
     * 构造消息
     * @param alias 接收消息的账号
     * @param msgContent 消息内容
     * @return
     */
    private static PushPayload buildPushObject_all_alias_message(String alias,String msgContent) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder().setMsgContent(msgContent).build())
                .build();
    }
    
    /**
     * 构造alert
     * 
     * @param alias
     * @param device
     * @param title
     * @param MSG_CONTENT
     * @return
     */
    public static PushPayload buildPushObject_all_alias_alert(String alias,String msgContent) {//通知提醒
        return PushPayload.newBuilder()
        		.setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.newBuilder()
                        .setAlert(msgContent)
                		.addPlatformNotification(AndroidNotification.newBuilder()
                				.build())
                		.addPlatformNotification(IosNotification.newBuilder()
                				.incrBadge(1)
                				.build())
                		.build())
                .build();
    } 
}
