package com.taylan.service.impl;

import com.taylan.dao.MessageDao;
import com.taylan.model.Message;
import com.taylan.model.People;
import com.taylan.service.MessageService;

public class MessageServiceImpl implements MessageService {
	
	MessageDao messageDao;
	
	@Override
	public Message getMessage(People people) {
		
		return getMessageDao().getMessage(people);
	}

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

}
