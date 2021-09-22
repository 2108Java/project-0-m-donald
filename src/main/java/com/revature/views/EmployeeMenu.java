package com.revature.views;

import java.sql.Connection;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.repo.AccountDAO;
import com.revature.repo.CustomerDAO;
import com.revature.repo.EmployeeDAO;
import com.revature.repo.TransactionDAO;
import com.revature.repo.UserDAO;
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
	Menu menu;

	CustomerDAO custDao;

	UserDAO userDao;

	TransactionDAO txnDao;

	AccountDAO accDao;

	EmployeeDAO empDao;
	
	private static final Logger loggy = Logger.getLogger(EmployeeMenu.class);
	
	public EmployeeMenu(CustomerDAO custDao, UserDAO userDao, AccountDAO accDao, TransactionDAO txnDao, EmployeeDAO empDao) {
		this.custDao = custDao;
		this.userDao = userDao;
		this.accDao = accDao;
		this.txnDao = txnDao;
		this.empDao = empDao;

	}
	
	public void displayEmployeeMenu(int userId) {
		
		loggy.setLevel(Level.ALL);
		
		// Employee menu explaining all options available to the employee
		emp = empDao.selectEmployeeById(userId);
		
			System.out.println("Welcome back employee!");
			System.out.println(" ");
			System.out.println(" 1) Approve an Application");
			System.out.println(" 2) Deny an Application");
			System.out.println(" 3) View Customer Account");
			System.out.println(" 4) Exit");
			
			// Checks chosen option
			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			loggy.setLevel(Level.WARN);
			
			switch(choice) {
			case 1: // Approve a customer account
				loggy.info("User selected 1");
				
				System.out.println("Please enter the customer ID for the account you want to approve:");
				System.out.println("Customer ID #: ");
				
				int idEntry = sc.nextInt();
				Customer customer = selectCustomer(idEntry);
				
				
				selectCustomerAccount(customer.getCust_id());
				updateAccount(account, true, userId);
				
				System.out.println("You have approved the application for Customer ID#: " + idEntry + "\n\n");
				loggy.info("You have approved the application for Customer ID#: " + idEntry);
				displayEmployeeMenu(userId);
				break;
			case 2: // Denies a customer account
				loggy.info("User selected 2");
				System.out.println("Please enter the customer ID for the account you want to approve:");
				System.out.println("Customer ID #: ");
				
				int idEntry2 = sc.nextInt();
				
				Customer customer2 = selectCustomer(idEntry2);
				
				selectCustomerAccount(customer2.getCust_id());
				updateAccount(account, false, userId);
				
				System.out.println("You have denied the application for Customer ID#: " + idEntry2 + "\n\n");
				loggy.info("You have denied the application for Customer ID#: " + idEntry2);
				displayEmployeeMenu(userId);
				break;
			case 3: // Selects customer account and views account info
				loggy.info("User selected 3");
				
				System.out.println("Which account?");
				System.out.println(" ");
				System.out.println(" 1) Checking");
				System.out.println(" 2) Savings");
//				System.out.println(" 3) Joint");

				// Checks chosen option
				sc = new Scanner(System.in);

				int viewAcctType = sc.nextInt();
				
				String viewAcct;
				
				if (viewAcctType == 1) {
					viewAcct = "checking";
				} else {
					viewAcct = "savings";
				}
				
				Customer customer3 = custDao.selectCustomerById(userId);
								
				account = accDao.selectAccountData(viewAcctType, viewAcct);
				
				if (account.getAcc_id() > 0) {
					loggy.info("Customer Info Printed");
					System.out.println("Customer Name: " + customer3.getFname() + " " + customer3.getLname());
					System.out.println("Account Number: " + account.getAccount_num());
					System.out.println("Account Type: " + account.getAccountType());
					System.out.println("Balance: " + account.getBalance()+"\n\n");
				} else {
					System.out.println("Account does not exist.\n\n");
					loggy.warn("Account does not exist");
				}
				displayEmployeeMenu(userId);
				break;
			case 4: //Exits to main menu
				System.out.println("Thank you! Come again!");
				loggy.info("User has exited the employee menu");
//				menu.display();
				break;
			}
	}

	public Account selectCustomerAccount(int cust_id) {
		// TODO Auto-generated method stub
		
		boolean success = false;
		
		account = new Account();
		
		try
		{
			
			Connection connection = connectionUtil.getConnection();
			
			String sql = "SELECT * FROM account_table WHERE foreign_primary_custID = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, cust_id);		

			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
			
			 account.setAcc_id(rs.getInt(1));
//			 account.setFname(rs.getString("cust_fname"));
//			 account.setLname(rs.getString("cust_lname"));
//			 account.setPhoneNum(rs.getString("cust_phoneNum"));
//			 account.setDob(rs.getString("dob"));
			
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
		
	}

	private boolean updateAccount(Account account, boolean isApproved, int user_id) {
		// TODO Auto-generated method stub
		
		boolean success = false;
	
		try
		{
			Connection connection = connectionUtil.getConnection();
			
			String sql = "UPDATE account_table SET isApproved = ? WHERE foreign_user_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setBoolean(1, isApproved);
			ps.setInt(2, user_id);
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


}
