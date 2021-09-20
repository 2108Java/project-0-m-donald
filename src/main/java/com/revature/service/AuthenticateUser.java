package com.revature.service;

import com.revature.models.User;

public interface AuthenticateUser {
	
	boolean authenticate(String username, String password);

	User getUser(String username);

}
