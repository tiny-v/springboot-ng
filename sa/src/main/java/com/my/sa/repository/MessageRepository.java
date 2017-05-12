package com.my.sa.repository;

import java.util.List;

import com.my.sa.domain.Message;

public interface MessageRepository {

    List<Message> getMessageList();
	
	public void createMessage(Message message);
	
}
