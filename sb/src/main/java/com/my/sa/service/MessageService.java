package com.my.sa.service;

import java.util.List;

import com.my.sa.domain.Message;

public interface MessageService {

	List<Message> getMessageList();
	
	void insertMessage(Message message);
	
}
