package com.revature.repo;

import com.revature.models.User;

public interface UserDAO {
	
	public User registerNewAccount(String username, String password); // As a user, I can register for a customer account (checking or savings or both!).
	
	public boolean applyForJointAccount();  // (Stretch goal) As a user, I can apply for a joint account
	
	public User loginToAccount(); // As a user, I can login.
	
//	public boolean insertUser(User u);
	
}
