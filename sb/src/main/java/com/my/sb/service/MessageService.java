package com.my.sb.service;

import java.util.List;

import com.my.sb.domain.Message;

public interface MessageService {

	List<Message> getMessageList();
	
	void insertMessage(Message message);
	
}
