package com.revature.views;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.Account;
import com.revature.models.Employee;
import com.revature.models.Transaction;
import com.revature.models.User;
import com.revature.repo.CustomerDAO;
import com.revature.service.BankService;
import com.revature.util.ConnectionUtil;

public class CustomerMenu {

	User user;
	Customer cust;
	Account account;
	LoginMenu mainMenu;
	CustomerDAO custDao;
	
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	public void displayCustomerMenu() {
		// Check credentials
			System.out.println("Welcome back " + user.getFname() + " " + user.getLname() + "!");
			System.out.println(" ");
			System.out.println(" 1) Withdraw");
			System.out.println(" 2) Deposit");
			System.out.println(" 3) Post Money Transfer");
			System.out.println(" 4) View Account Balance");
			System.out.println(" 5) Exit");
			
			// Checks chosen option
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1: // Withdraw
				
				System.out.println("How much would you like to withdraw?");
				double wthdrwAmount = sc.nextDouble();
				
				selectCustomerAccount();
				
				
				custDao.withdrawMoney(wthdrwAmount);
				
//				wthdrwAmount = account.getBalance();
				
				System.out.println("Total Balance: " + wthdrwAmount);
				
				break;
				
			case 2: // Deposit
				
				System.out.println("How much would you like to deposit?");
				double depositAmount = sc.nextDouble();
				
				selectCustomerAccount();
				custDao.withdrawMoney(depositAmount);

				
				System.out.println("Total Balance: " + depositAmount);
				break;
				
			case 3:  // Post money transfer

				selectCustomerAccount();
				
				custDao.postMoneyTransferToAnotherAccount();
				
				
				break;
			case 4: // Show's the customer their balance.
				
				prettyDisplayOfInfo();
				
				break;
			case 5: // Exits to main menu
				System.out.println("Thank you! Come again!");
				mainMenu.userLoginMenu();
				break;
			}
	}
	
	private void prettyDisplayOfInfo() {
		// TODO Auto-generated method stub
		
		System.out.println(cust.getFname());
		System.out.println(" ");
		System.out.println("Customer ID: " + cust.getCust_id());
		System.out.println(" ");
		System.out.println("Balance: " + account.getBalance());
		System.out.println("Thank you! Come again!");
		
		displayCustomerMenu();
//		mainMenu.userLoginMenu();
		
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
	
	
}
