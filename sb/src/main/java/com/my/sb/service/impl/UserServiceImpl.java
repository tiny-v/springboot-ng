package com.my.sb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.dao.UserDao;
import com.my.sb.domain.User;
import com.my.sb.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public void createUser(User user) {
		userDao.createUser(user);		
	}

}
