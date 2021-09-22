package com.revature.repo;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Transaction;
import com.revature.models.User;

public interface EmployeeDAO {
	

	public boolean updateAccount(Account account, boolean isApproved); // As an employee, I can approve or reject an account registration by a user.
	
	public boolean viewAllBalances(Account account); // As an employee, I can view a customer's bank account balance
	
	public boolean selectAllTransactions(Transaction transaction); // An employee, I can view a log of all transactions.
	
	public boolean selectCustomerAccount(Account account); // As an employee, I can view a customer's bank accounts.
	
	public boolean selectUserByUserID(User u);

	public Employee selectEmployeeById(int userId);

}
