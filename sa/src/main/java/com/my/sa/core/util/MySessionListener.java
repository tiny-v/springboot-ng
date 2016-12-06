package com.my.sa.core.util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import com.my.sa.core.global.Constants;

@WebListener
public class MySessionListener implements HttpSessionListener{


	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//HttpSession session=se.getSession();
		//String id=session.getId()+session.getCreationTime();
		//SummerConstant.UserMap.put(id,Boolean.TRUE);//添加用户
        Constants.onlineNum++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		Constants.onlineNum--;
	}

}
