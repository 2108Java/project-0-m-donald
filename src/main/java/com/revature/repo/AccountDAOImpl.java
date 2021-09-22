package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO{

	Account account;
	
	ConnectionUtil connectionUtil = new ConnectionUtil();
	
	public Account selectAccountData(int cust_id, String accountType) {
		// TODO Auto-generated method stub
		
		Account acc = new Account();
		
		try
		{
			Connection connection = connectionUtil.getConnection();
			
			String sql = "SELECT * FROM account_table WHERE foreign_primary_custID = ? AND acc_type = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setInt(1, cust_id);
			ps.setString(2, accountType);
			
			ps.execute();	
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				
				acc.setAcc_id(rs.getInt("account_id"));
				acc.setAccount_num(rs.getInt("acc_num"));
				acc.setAccountType(rs.getString("acc_type"));
				acc.setBalance(rs.getInt("balance"));
				acc.setApproved(rs.getBoolean("isApproved"));
	
			
//			 custInfo.setCust_id(rs.getInt("primary_custId"));
//			 custInfo.setFname(rs.getString("cust_fname"));
//			 custInfo.setLname(rs.getString("cust_lname"));
//			 custInfo.setPhoneNum(rs.getString("cust_phoneNum"));
//			 custInfo.setDob(rs.getString("dob"));
//			 custInfo.setAddress(rs.getString("address"));
//			 custInfo.setCity(rs.getString("city"));
//			 custInfo.setState(rs.getString("state"));
//			 custInfo.setZipCode(rs.getString("zipCode"));
//			 custInfo.setPrimaryCustomer(rs.getBoolean("isPrimaryCustomer"));
			
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acc;
		
	}

	@Override
	public boolean rejectInvalidTransaction() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	@Override
//	public double withdrawMoney(double wthdrwAmount) {
//		// TODO Auto-generated method stub
//		
//		double balance = account.getBalance() - wthdrwAmount;
//		
//		if(balance < 0 || wthdrwAmount == 0) {
//			System.out.println("Insufficient funds! ");
//			
//			custMenu.displayCustomerMenu(0);
//			
//		}
//		
//		return balance;
//	}

	@Override
	public double depositMoney(int cust_id, double depositAmount) {
		// TODO Auto-generated method stub
		
		double balance = 0;
		
		if(depositAmount <= 0) {
			
		}else {
			
//			selectAccountData(cust_id);
			
			// GET ACCUNT BALANCE
			balance = account.getBalance();
			
			// INSERT TRANSACTION INTO TRANS TABLE 
	//		insertTransaction();
			
			// ADD DEPOSITED AMOUNT TO BALANCE AND UPDATE ACCOUNT table
			
	//		account.updateBalance();
			
			balance += depositAmount;
			
		}

		return balance;
	}

	@Override
	public double withdrawMoney(double wthdrwAmount) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean updateBalance(int acct_id, double balance) {
		// TODO ADD SQL TO UPDATE ACCOUNT BALANCE
		
		boolean success = false;
		
		

		try
		{
			Connection connection = connectionUtil.getConnection();
			
			String sql = "UPDATE account_table SET balance = ? WHERE account_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setDouble(1, balance);
			ps.setInt(2, acct_id);
			
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
	public Account createAccount(String acctType, Customer customer) {
		// TODO Auto-generated method stub
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		 
		account = new Account();
		
		boolean success = false;
		//1. Connect to database!
		try{
			
			
			Connection connection = connectionUtil.getConnection();
//			
			String sql = "INSERT INTO account_table (foreign_primary_custid, foreign_user_id, acc_type, balance, isapproved) "
					+ "VALUES ((SELECT primary_custID FROM customer_table WHERE primary_custID = ?),(SELECT user_id FROM user_table WHERE user_id = ?),?,?,?)";
//			
			PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			
			
			ps.setInt(1, customer.getCust_id());
			ps.setInt(2, customer.getUser_id());
			ps.setString(3, acctType);
			ps.setDouble(4, customer.getStartingBalance());
			ps.setBoolean(5, false);
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next()) {
				account.setAcc_id(rs.getInt(1));
				account.setAccount_num(rs.getInt(4));
				account.setAccountType(rs.getString(5));
				account.setUser_id(rs.getInt(3));	
				account.setApproved(rs.getBoolean(7));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}

}
