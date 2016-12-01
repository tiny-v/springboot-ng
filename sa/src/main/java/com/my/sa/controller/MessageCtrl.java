package com.my.sa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.sa.core.security.anotation.Security;
import com.my.sa.core.util.IdUtil.IdUtil;
import com.my.sa.domain.Message;
import com.my.sa.service.MessageService;

@Controller
@RequestMapping(value="/message")
public class MessageCtrl {
	
	@Autowired
	private MessageService messageService;
	
	@Security
	@ResponseBody
	@RequestMapping(value="/getMessageList",method=RequestMethod.GET)
	public List<Message> getMessageList(){
        return messageService.getMessageList();
	}
	
	@ResponseBody
	@RequestMapping(value="/insertMessage",method=RequestMethod.GET)
	public void insertMessage(@RequestBody Message message,HttpServletRequest request){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		message.setMsgId(IdUtil.getId());
        message.setMsgType("test");
        message.setCreateBy("may");
        message.setCreateTime(format.format(new Date()));
        message.setUpdateBy("may");
        message.setUpdateTime(format.format(new Date()));
        messageService.insertMessage(message);
	}

}
