package com.my.sa.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.sa.core.util.DateUtils;
import com.my.sa.core.util.IdUtil.IdUtil;
import com.my.sa.domain.User;
import com.my.sa.service.UserService;

@RestController
@RequestMapping(value="/login")
public class loginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public boolean checkLogin(@RequestBody User user){
		return ("admin").equals(user.getAccount()) && ("admin").equals(user.getPassword());
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> register(@RequestBody User user){
		Map<String,String> map = new HashMap<String,String>();
		user.setUserId(IdUtil.getId());
		user.setRole("user");
		user.setCreateTime(DateUtils.curDateTimeStr());
		user.setUpdateTime(DateUtils.curDateTimeStr());
		userService.createUser(user);
		map.put("message", "success");
		return map;
	}
	
}
