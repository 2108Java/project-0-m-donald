package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Transaction;
import com.revature.models.User;
import com.revature.service.BankService;
import com.revature.views.EmployeeMenu;
import com.revature.views.LoginMenu;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	User user = new User();
	Employee emp = new Employee();
	LoginMenu mainMenu = new LoginMenu();
	EmployeeMenu empMenu = new EmployeeMenu();
	BankService service;
	Account account = new Account();
	
	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "miaduuh1";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";

//	@Override
//	public boolean approveAccount(Account account, boolean isApproved) {
//		// TODO Auto-generated method stub
//		
//		
//		
//		return false;
//	}

	@Override
	public boolean updateAccount(Account account, boolean isApproved) {
		// TODO Auto-generated method stub
		
		boolean success = false;
		
		

		try(Connection connection = DriverManager.getConnection(url, username, password))
		{
			
			String sql = "UPDATE account_table SET isApproved = ? WHERE foreign_user_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setBoolean(1, isApproved);
			ps.setInt(2, user.getUser_id());
			ps.execute();		
			success = true;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public boolean viewAllBalances(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectAllTransactions(Transaction transaction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean selectCustomerAccount(Account account) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	@Override
	public boolean selectUserByUserID(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
