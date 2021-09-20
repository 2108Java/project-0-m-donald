package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;
import com.revature.views.CustomerMenu;

public class CustomerDAOImpl implements CustomerDAO {
	
	Account account;
	Customer cust;
	CustomerMenu custMenu;
	
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	@Override
	public boolean createNewApplication() {
		// TODO Auto-generated method stub
		
		boolean success = false;
		//1. Connect to database!
		try{
			
			System.out.println("Please enter the following information: ");
			System.out.println(" ");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("First Name: ");
			String fname = sc.nextLine();
			System.out.println("Last Name: ");
			String lname = sc.nextLine();
			System.out.println("Phone Number (No / or - ): ");
			String telephone = sc.nextLine();
			System.out.println("Date of Birth  (MM/DD/YYYY) : ");
			String dob = sc.nextLine();
			System.out.println("Street Address: ");
			String streetaddress = sc.nextLine();
			System.out.println("City: ");
			String city = sc.nextLine();
			System.out.println("State: ");
			String state = sc.nextLine();
			System.out.println("zipCode: ");
			String zip = sc.nextLine();
			System.out.println("Starting Balance: ");
			double startingBalance = sc.nextDouble();
			System.out.println("Are you the primary customer on the account? ( true / false ): ");
			boolean input = sc.nextBoolean();
			
			
			Connection connection = connectionUtil.getConnection();
//			
			String sql = "INSERT INTO customer_table (cust_fname, cust_lname, cust_phoneNum, dob, address"
					+ "city, state, zipCode, startingBalance, isPrimaryCustomer, VALUES (?,?,?,?,?,?,?,?,?,?)";
//			
			PreparedStatement ps = connection.prepareStatement(sql);
//			
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, telephone);
			ps.setString(4, dob);
			ps.setString(5, streetaddress);
			ps.setString(6, city);
			ps.setString(7, state);
			ps.setString(8, zip);
			ps.setDouble(9, startingBalance);
			ps.setBoolean(10, true);
			
			ps.execute();
			
			success = true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thank you for creating an account! Someone will approve or deny your account within 24 hours!");
		
		return false;
	}

	@Override
	public boolean viewMyBalance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double withdrawMoney(double wthdrwAmount) {
		// TODO Auto-generated method stub
		
		double balance = account.getBalance() - wthdrwAmount;
		
		if(balance < 0 || wthdrwAmount == 0) {
			System.out.println("Insufficient funds! ");
			
			custMenu.displayCustomerMenu();
			
		}
		
		return balance;
	}

	@Override
	public double depositMoney(double depositAmount) {
		// TODO Auto-generated method stub
		
		double balance = 0;
		
		if(depositAmount <= 0) {
			
		}else {
			balance = account.getBalance() + depositAmount;
		}

		return balance;
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
	public Customer selectCustomerById(Customer cust_id) {
		// TODO Auto-generated method stub
		
		Customer custInfo = new Customer();
		
		try
		{
			Connection connection = connectionUtil.getConnection();
			
			String sql = "SELECT * FROM customer_table WHERE primary_custID = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, cust.getCust_id());
			
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
		
		return null;
	}

}