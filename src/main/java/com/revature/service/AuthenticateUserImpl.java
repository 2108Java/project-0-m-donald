package com.revature.service;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.repo.CustomerDAO;
import com.revature.repo.EmployeeDAO;
import com.revature.repo.UserDAO;

public class AuthenticateUserImpl implements AuthenticateUser {
	
	private UserDAO userDao;
	private CustomerDAO custDao;
	private EmployeeDAO empDao;
	
	

	public AuthenticateUserImpl(UserDAO uDao, CustomerDAO cDao, EmployeeDAO eDao) {
		super();
		// TODO Auto-generated constructor stub
			
			this.userDao = uDao;
			this.custDao = cDao;
			this.empDao = eDao;
	}

	@Override
	public boolean authenticate(String username, String password) {
		// TODO Auto-generated method stub
		
		User user = getUser(username); 
		
		boolean authenticated = false;
		
		if(user != null) {
			if(user.getPassword() != null && user.getPassword().equals(password)) {
				
				authenticated = true;
			}
			
		}
		
		return authenticated;
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		
		User user = userDao.selectUserByUsername(username);
		
		return user;
	}

}
