package com.my.sb.dao;

import java.util.List;

import com.my.sb.domain.Message;

public interface MessageDao {

	List<Message> getMessageList();
	
	public void insertMessage(Message message);
	
}
