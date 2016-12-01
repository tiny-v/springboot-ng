package com.my.sa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.sa.core.exception.OrtException;
import com.my.sa.core.util.DateUtils;
import com.my.sa.core.util.SessionUtils;
import com.my.sa.core.util.IdUtil.IdUtil;
import com.my.sa.domain.User;
import com.my.sa.dto.LoginUser;
import com.my.sa.service.UserService;

@RestController
@RequestMapping(value="/login")
public class loginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public LoginUser checkLogin(@RequestBody User user,HttpServletRequest request){
		User user2 = userService.getUserByAccount(user.getAccount());
		if(null!=user2){
			if(user.getPassword().equals(user2.getPassword())){
				HttpSession session = request.getSession();
				LoginUser loginUser = new LoginUser();
				loginUser.setUserId(user2.getUserId());
				loginUser.setUserName(user2.getUserName());
				loginUser.setAccount(user2.getAccount());
				loginUser.setRole(user2.getRole());
				String token = SessionUtils.getToken(request);
				loginUser.setToken(token);
				session.setAttribute(SessionUtils.SIGN_IN_USER, user2);
				return loginUser;
			}else{
				//账号密码不匹配
				throw new OrtException(400,"账号密码不匹配");
			}
		}else{
			//没有此账号
			throw new OrtException(400,"没有此账号");
		}
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
