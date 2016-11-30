package com.my.sa.dao;

import java.util.List;

import com.my.sa.domain.Message;

public interface MessageDao {

	List<Message> getMessageList();
	
	public void insertMessage(Message message);
	
}
