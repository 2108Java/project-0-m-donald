package com.revature.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;
import com.revature.views.CustomerMenu;

public class CustomerDAOImpl implements CustomerDAO {
	
	Account account;
	Customer custInfo;
	CustomerMenu custMenu;
	
	ConnectionUtil connectionUtil = new ConnectionUtil();

	@Override
	public boolean viewMyBalance() {
		// TODO Auto-generated method stub
		return false;
	}

	private void insertTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double postMoneyTransferToAnotherAccount() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How much could you like to transfer?: ");
		double postAmount = sc.nextDouble();
		
		double balance = account.getBalance() - postAmount;
		
		System.out.println("You have just transerred $" + postAmount + " !");
		System.out.println(" ");
		System.out.println("New Balance: " + balance);
		
		return balance;
	}

	@Override
	public double acceptMoneyTransferFromAnotherAccount(double acceptedTransfer) {
		// TODO Auto-generated method stub
		
		
		
		double balance = account.getBalance() + acceptedTransfer;
		
		System.out.println("You have just accepted $" + acceptedTransfer + " !");
		System.out.println(" ");
		System.out.println("New Balance: " + balance);
		
		return balance;
	}

	@Override
	public Customer selectCustomerById(int user_id) {
		// TODO Auto-generated method stub
		
		Customer custInfo = new Customer();
		
		try
		{
			Connection connection = connectionUtil.getConnection();
			
			String sql = "SELECT * FROM customer_table WHERE foreign_user_id = (SELECT user_id FROM user_table WHERE user_id = ?)";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, user_id);
			
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

	@Override
	public boolean createUserAccount() {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		User user = new User();
		
		boolean success = false;
		//1. Connect to database!
		try{
			
			System.out.println("Please enter the following information: ");
			System.out.println(" ");

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Username: ");
			String usrname = sc.nextLine();
			System.out.println("Password: ");
			String passwrd = sc.nextLine();
			
			Connection connection = connectionUtil.getConnection();
//			
			String sql = "INSERT INTO user_table (username, password) VALUES (?,?)";
//			
			PreparedStatement ps = connection.prepareStatement(sql);
//			
			ps.setString(1, usrname);
			ps.setString(2, passwrd);
			
			ps.execute();
			
			success = true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thank you for creating an account!");
		
		return success;
			
			
	}
	@Override
	public boolean createNewApplication() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double withdrawMoney(double wthdrwAmount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double depositMoney(double depositAmount) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Customer selectCustomer(int idEntry) {

		Customer custInfo = new Customer();

		try {
			Connection connection = connectionUtil.getConnection();

			String sql = "SELECT * FROM customer_table WHERE primary_custID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setInt(1, idEntry);

			ps.execute();

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return custInfo;
	}

	private boolean selectCustomerAccount() {
		// TODO Auto-generated method stub

		boolean success = false;

		try {

			Connection connection = connectionUtil.getConnection();

			String sql = "SELECT * FROM account_table WHERE foreign_primary_custID = ?";

			PreparedStatement ps = connection.prepareStatement(sql);

		//	ps.setInt(1, cust.getCust_id());
			ps.execute();
			success = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return success;

	}

	@Override
	public Customer createCustomer(int userID, Customer customer) {
		// TODO Auto-generated method stub
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		
		
		boolean success = false;
		//1. Connect to database!
		try{
			
			Connection connection = connectionUtil.getConnection();
//			
			String sql = "INSERT INTO customer_table (cust_fname, cust_lname, cust_phonenum, dob, address, city, state, zipcode, startingbalance, foreign_user_id, isprimarycustomer) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,(SELECT user_id FROM user_table WHERE user_id = ?),?)";
//			
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			
			ps.setString(1, customer.getFname());
			ps.setString(2, customer.getLname());
			ps.setString(3, customer.getPhoneNum());
			ps.setString(4, customer.getDob());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getCity());
			ps.setString(7, customer.getState());
			ps.setString(8, customer.getZipCode());
			ps.setDouble(9, customer.getStartingBalance());
			ps.setInt(10, userID);
			ps.setBoolean(11, customer.isPrimaryCustomer);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next()) {
				customer.setCust_id(rs.getInt(1));
			
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

}
