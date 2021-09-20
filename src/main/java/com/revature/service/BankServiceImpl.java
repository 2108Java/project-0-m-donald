package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;

public class BankServiceImpl implements BankService {

	private String dbLocation = "localhost";
	private String username = "postgres";
	private String password = "miaduuh1";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";	
	
	User user = new User();
	Customer cust = new Customer();
	Employee emp = new Employee();
	
//	@Override
//	public Account[] getAllAccounts() {
//		// TODO Auto-generated method stub
//		
//		User[] userArray = new User[30];
//		
//		//Establish a connection 
//		
//		try(Connection connection = DriverManager.getConnection(url, username, password)){
//			
//			String sql = "SELECT * FROM customer_table";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			//ResultSet is the information we receive from the DB, based on our Select query
//			//We do a "executeQuery" when we expect something back. 
//			ResultSet rs = ps.executeQuery();
//			
//			int i = 0;
//			
//			while(rs.next()) { //rs.next() returns true or false depending on whether there is another row available
//				
//				//looping through all the rows until there are no rows!
//				
//				customerArray[i] = new Customer(rs.getInt("user_id"),
//									rs.getString("name"),
//									rs.getBoolean("isEmployee"));
//				i++;
//				
//			}
//			
//			
//			
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return null;
//	}

//	@Override
//	public User[] getAllUsers() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean viewBalance(double balance) {
//		// TODO Auto-generated method stub
//		return false;
//	}

//	@Override
//	public boolean isEmployee(boolean isEmployee) {
//		/
//		return false;
//	}

//	@Override
//	public boolean applyForApplication(User newUser) {
//		// TODO Auto-generated method stub
//		
//		boolean success = false;
//		//1. Connect to database!
//		try(Connection connection = DriverManager.getConnection(url,username,password)){
//			
////			//2. Write a SQL statement String
////			
//			String sql = "INSERT INTO customer_table (cust_name, cust_phoneNum, isEmployee, cust_username, cust_password, isApproved) VALUES (?,?,?,?,?,?)";
////			
//			PreparedStatement ps = connection.prepareStatement(sql);
////			
//			ps.setString(1, newUser.getName());
//			ps.setString(2, newUser.getPhoneNum());
//			ps.setBoolean(3, newUser.isEmployee);
//			ps.setString(4, newUser.getUsername());
//			ps.setString(5, newUser.getPassword());
//			ps.setBoolean(6, newUser.isApproved);
//			
//			ps.execute();
//			
//			success = true;
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
//		
//		return success;
//	}

//	@Override
//	public boolean loginToAccount(String username, String password) {
//		// TODO Auto-generated method stub
//		
//		return false;
//	}

//	@Override
//	public boolean verifyEmployment(String emp_uName, boolean isEmployee) {
//		// TODO Auto-generated method stud
//		
//		boolean success = false;
//		
//		try(Connection connection = DriverManager.getConnection(url, username, password))
//		{
//			
//			String sql = "SELECT * FROM employee_table  WHERE emp_username = ? ";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			
//				if(rs.next() == true) {
//					success = true;	
//				}else {
//					System.out.println("Sorry, invalid employee credentials! Please try again!");
//				}	
//
//		} 
//		catch (SQLException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return success;
//	}
//
//	@Override
//	public boolean updateApplicationStatus(int accountNum, String cust_username) {
//		// TODO Auto-generated method stub
//		
//		boolean success = false;
//		
//		try(Connection connection = DriverManager.getConnection(url, username, password))
//		{
//			
//			String sql = "UPDATE customer_table SET isApproved = ? WHERE cust_username = ?";
//			
//			PreparedStatement ps = connection.prepareStatement(sql);
//			
//			ps.setBoolean(1, true);
//			ps.execute();		
//			success = true;
//		} 
//		catch (SQLException e) 
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return success;
//	}

//	@Override
//	public boolean withdrawMoney(int custID, int amt, double balance) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean depositMoney(int custID, int amt, double balance) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
