package com.my.sa.repository;

import com.my.sa.domain.User;

public interface UserRepository {

    void createUser(User user);
	
	User getUserByAccount(String account);
	
}
