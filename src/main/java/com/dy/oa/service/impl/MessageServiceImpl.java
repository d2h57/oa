package com.dy.oa.service.impl;

import com.dy.oa.model.Message;
import com.dy.oa.service.MessageService;
import com.dy.oa.util.PushAppMessageUtil;

public class MessageServiceImpl implements MessageService {

	@Override
	public void addMessage(Message message) throws Exception {
		PushAppMessageUtil.sendPush(message.getAudience(), message.getMsgContent(), msgType, appId);
	}

}
