package com.revature.repo;

public interface AccountDAO {
	
	public boolean rejectInvalidTransaction(); // Cant withdraw and result in a negative balance
											   // Cant deposit or withdraw negative money
	

}
