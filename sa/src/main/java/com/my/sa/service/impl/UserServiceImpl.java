package com.my.sa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sa.domain.User;
import com.my.sa.repository.UserRepository;
import com.my.sa.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(User user) {
		userRepository.createUser(user);		
	}

	@Override
	public User getUserByAccount(String account) {
		return userRepository.getUserByAccount(account);
	}

}
