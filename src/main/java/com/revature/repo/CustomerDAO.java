package com.revature.repo;

import com.revature.models.Customer;
import com.revature.models.User;

public interface CustomerDAO {
	
	public boolean createNewApplication(); // As a customer, I can apply for a new bank account with a starting balance.
	
	public boolean viewMyBalance(); // As a customer, I can view the balance of a specific account (that belongs to me).
	
	public double  withdrawMoney(double wthdrwAmount);  // As a customer, I can make a withdraw from my account
	
	public double depositMoney(double depositAmount); // As a customer, I can make a deposit to a specific account (that belongs to me).
	
	public double postMoneyTransferToAnotherAccount(); // As a customer, I can post a money transfer to another account.
	
	public double acceptMoneyTransferFromAnotherAccount(double postAmount); // As a customer, I can accept a money transfer from another account.
	
	public Customer selectCustomerById(int user_id);

	public boolean createUserAccount();

	public Customer createCustomer(int userID, Customer customer);
}
