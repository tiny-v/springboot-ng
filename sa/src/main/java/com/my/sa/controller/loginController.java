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

/**
 * The Class loginController.
 * 登录Ctrl
 */
@RestController
@RequestMapping(value="/login")
public class loginController {

	@Autowired
	private UserService userService;
	@Autowired
	private visitRecordDao vrDao;

	/**
	 * Check login. 登录方法
	 *
	 * @param user the user
	 * @param request the request
	 * @return the login user
	 */
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	public LoginUser checkLogin(@RequestBody User requestUser,HttpServletRequest request){
		User user = userService.getUserByAccount(requestUser.getAccount());
		if(null!=user){//判断根据登录账号判断是否有该用户
			if(requestUser.getPassword().equals(user.getPassword())){//判断用户账号和密码是否匹配
				//将该用户信息，存到session中
				HttpSession session = request.getSession();
				session.setAttribute(SessionUtils.SIGN_IN_USER, user);
				session.setMaxInactiveInterval(10*60);
                //根据 agent获取一些登录信息
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
				visitRecord vr = null;
				try {
					String ip = NetworkUtil.getIpAddress(request); //获取请求IP
					//如果不是本地登录，则将请求数据存至mongo中
					if(null!=ip &&  !("").equals(ip) && !("0:0:0:0:0:0:0:1").equals(ip) ){
						vr = new visitRecord();
						vr.setAccount(user.getAccount());
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
				//将前端需要的用户数据返回
				LoginUser loginUser = new LoginUser();
				loginUser.setUserId(user.getUserId());
				loginUser.setUserName(user.getUserName());
				loginUser.setAccount(user.getAccount());
				loginUser.setRole(user.getRole());
				String token = SessionUtils.getToken(request);
				loginUser.setToken(token);
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

	/**
	 * Register.
	 * 注册
	 * @param user the user
	 * @return the map< string, string>
	 */
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
