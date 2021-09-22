package com.revature.service;

import com.revature.models.User;

public interface AuthenticateUser {
	
	int authenticate(String username, String password);

	User getUser(String username);

}
