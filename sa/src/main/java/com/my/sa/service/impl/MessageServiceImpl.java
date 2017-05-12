package com.my.sa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sa.domain.Message;
import com.my.sa.repository.MessageRepository;
import com.my.sa.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	/*
	 *  Java变量的初始化顺序为：静态变量或静态语句块–>实例变量或初始化语句块–>构造方法
	 * */
	
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<Message> getMessageList() {
		return messageRepository.getMessageList();
	}

	@Override
	public void insertMessage(Message message) {
		messageRepository.createMessage(message);
	}

}
