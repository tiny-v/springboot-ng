package com.my.sb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.sb.domain.Message;
import com.my.sb.service.MessageService;

@Controller
@RequestMapping(value="/message")
public class MessageCtrl {
	
	@Autowired
	private MessageService messageService;
	
	@ResponseBody
	@RequestMapping(value="/getMessageList",method=RequestMethod.GET)
	public List<Message> getMessageList(){
        return messageService.getMessageList();
	}
	
	@ResponseBody
	@RequestMapping(value="/insertMessage",method=RequestMethod.GET)
	public void insertMessage(){
		Message message = new Message();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		message.setMsgId(String.valueOf((int)(Math.random()*1000)));
        message.setMsgCat("testCat");
        message.setMsgContent("hello transaction");
        message.setMsgTitle("go go go,basketball");
        message.setMsgType("test");
        message.setCreateBy("may");
        message.setCreateTime(format.format(new Date()));
        message.setUpdateBy("may");
        message.setUpdateTime(format.format(new Date()));
        messageService.insertMessage(message);
	}

}
