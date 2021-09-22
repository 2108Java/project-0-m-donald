package com.revature.repo;

import com.revature.models.User;

public interface UserDAO {
	
//	public boolean applyForJointAccount();  // (Stretch goal) As a user, I can apply for a joint account
	
	public User  selectUserByUsername(String username);  // Selects a user by username 

	public int createUser(User user);
	
}
