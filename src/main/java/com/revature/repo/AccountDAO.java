package com.revature.repo;

import com.revature.models.Account;
import com.revature.models.Customer;

public interface AccountDAO {
	
	public boolean rejectInvalidTransaction(); // Cant withdraw and result in a negative balance
											   // Cant deposit or withdraw negative money

	public Account selectAccountData(int cust_id, String accountType);

	double withdrawMoney(double wthdrwAmount);

	double depositMoney(int cust_id, double depositAmount);

	public boolean updateBalance(int acct_id, double balance);

	public Account createAccount(String accountType, Customer customer);

}
