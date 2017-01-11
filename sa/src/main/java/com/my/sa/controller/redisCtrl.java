package com.my.sa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.sa.domain.Message;

@RestController
@RequestMapping(value="/redis")
public class redisCtrl {
	
	/*@RequestMapping(value="/testPost",method=RequestMethod.POST)
	public String testPost(@RequestBody String json){
		System.out.println("json:"+json);
		return "key:value";
	}*/
	
	@RequestMapping(value="/testPost",method=RequestMethod.POST)
	public String testPost(@RequestBody String json){
		System.out.println("json:"+json);
		return "key:value";
	}
	
	@RequestMapping(value="/testGet",method=RequestMethod.GET)
	@ResponseBody
	public List<Message> testGet(String key,String value){
		Message m1 = new Message();
		m1.setMsgTitle("this is message1");
		Message m2 = new Message();
		m2.setMsgTitle("this is message2");
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	

}
