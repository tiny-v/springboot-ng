package com.my.sa.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.my.sa.core.util.AddressUtils;
import com.my.sa.core.util.BaiduIpAddressUtils;
import com.my.sa.core.util.DateUtils;
import com.my.sa.core.util.NetworkUtil;
import com.my.sa.core.util.SessionUtils;
import com.my.sa.core.util.IdUtil.IdUtil;
import com.my.sa.dao.visitRecordDao;
import com.my.sa.domain.User;
import com.my.sa.domain.visitRecord;
import com.my.sa.dto.LoginUser;
import com.my.sa.service.UserService;

import net.sf.json.JSONObject;

@RestController
@RequestMapping(value="/login")
public class loginController {

	@Autowired
	private UserService userService;
	@Autowired
	private visitRecordDao vrDao;

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
				session.setMaxInactiveInterval(10*60);

				String agent = request.getHeader("user-agent");
				System.out.println("agent:"+agent);
				if(agent.contains("Android")) {
					System.out.println("Android移动客户端");
				} else if(agent.contains("iPhone")) {
					System.out.println("iPhone移动客户端");
				}  else if(agent.contains("iPad")) {
					System.out.println("iPad客户端");
				}  else {
					System.out.println("其他客户端");
				}

				//将登陆信息存到mongodb
				visitRecord vr = new visitRecord();
				String ip = "";
				try {
					ip = NetworkUtil.getIpAddress(request);
					if(!("0:0:0:0:0:0:0:1").equals(ip) && null!=ip && !("").equals(ip)){
						vr.setAccount(user2.getAccount());
						vr.setVisitTime(DateUtils.curDateTimeStr());
						vr.setIp(ip);
						vr.setArea(new AddressUtils().getAddresses("ip="+ip, "utf-8"));
						JSONObject json = BaiduIpAddressUtils.post(ip);
						if(null!=json.get("content")){
				        	 String address = JSONObject.fromObject(json.get("content")).get("formatted_address").toString();
				        	 String confidence = JSONObject.fromObject(json.get("content")).get("confidence").toString();
				        	 String radius = JSONObject.fromObject(json.get("content")).get("radius").toString();
				             vr.setAddressDetail(address);
				             vr.setConfidence(confidence);
				             vr.setRadius(radius);
						}
						vrDao.saveVisitRecord(vr);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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

	/**
	 * Log out.注销
	 *
	 * @param request the request
	 */
	@RequestMapping(value="/logOut",method=RequestMethod.GET)
	public void logOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.invalidate();
	}


}
