package com.my.sa.service;

import com.my.sa.domain.User;

public interface UserService {
	
	void createUser(User user);
	
	User getUserByAccount(String account);

}
