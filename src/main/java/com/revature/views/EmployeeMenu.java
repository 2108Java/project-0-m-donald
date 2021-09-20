package com.revature.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.service.BankService;
import com.revature.util.ConnectionUtil;

public class EmployeeMenu extends Employee {
	
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	User user;
	Employee emp;
	LoginMenu mainMenu;
	BankService service;
	Account account;
	Customer cust;
	
	public void prettyDisplayOfInfo() {
		
	}
	
	public void displayEmployeeMenu() {
		// Employee menu explaining all options available to the employee
			System.out.println("Welcome back " + user.getFname() + " " + user.getLname() + "!");
			System.out.println(" ");
			System.out.println(" 1) Approve an Application");
			System.out.println(" 2) Deny an Application");
			System.out.println(" 3) View Customer Account");
			System.out.println(" 4) Exit");
			
			// Checks chosen option
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: // Approve a customer account
				System.out.println("Please enter the customer ID for the account you want to approve:");
				System.out.println("Customer ID #: ");
				
				int idEntry = sc.nextInt();
				Customer customer = selectCustomer(idEntry);
				
				
				selectCustomerAccount();
				updateAccount(account, true);
				
				break;
			case 2: // Denies a customer account
				int idEntry2 = sc.nextInt();
				
				Customer customer2 = selectCustomer(idEntry2);
				
				selectCustomerAccount();
				updateAccount(account, false);
				break;
			case 3: // Selects customer account and views account info

				
				int idEntry3 = sc.nextInt();
				
				Customer customer3 = selectCustomer(idEntry3);
								
				System.out.println(selectCustomerAccount());
				
				break;
			case 4: //Exits to main menu
				System.out.println("Thank you! Come again!");
				mainMenu.userLoginMenu();
				break;
			}
	}

	private boolean selectCustomerAccount() {
		// TODO Auto-generated method stub
		
		boolean success = false;
		
		try
		{
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "SELECT * FROM account_table WHERE foreign_cust_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, cust.getCust_id());
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

	private boolean updateAccount(Account account, boolean isApproved) {
		// TODO Auto-generated method stub
		
		boolean success = false;
	
		try
		{
			Connection connection = connectionUtil.getConnection();
			
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
	
	public Customer selectCustomer(int idEntry) {
		
		Customer custInfo = new Customer();
		
		try
		{
			Connection connection = connectionUtil.getConnection();
			
			String sql = "SELECT * FROM customer_table WHERE primary_custID = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, idEntry);
			
			ps.execute();	
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
			
			 custInfo.setCust_id(rs.getInt("primary_custId"));
			 custInfo.setFname(rs.getString("cust_fname"));
			 custInfo.setLname(rs.getString("cust_lname"));
			 custInfo.setPhoneNum(rs.getString("cust_phoneNum"));
			 custInfo.setDob(rs.getString("dob"));
			 custInfo.setAddress(rs.getString("address"));
			 custInfo.setCity(rs.getString("city"));
			 custInfo.setState(rs.getString("state"));
			 custInfo.setZipCode(rs.getString("zipCode"));
			 custInfo.setPrimaryCustomer(rs.getBoolean("isPrimaryCustomer"));
			
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return custInfo;
	}

//	public void depositMoney() {
//		
//	}
//	
//	public void withdrawMoney() {
//		
//	}
//	
//	public void transferMoney() {
//		
//	}
//	
//	public void verifyApplication() {
//		
//	}
//	
//	public void viewAllBalances() {
//		
//	}
}
