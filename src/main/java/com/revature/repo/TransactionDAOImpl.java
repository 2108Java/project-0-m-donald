package com.revature.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Transaction;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public boolean insertTxn(Customer cust, Account account, double depositAmount, String txnType) {
		// TODO ADD SQL TO INSERT ROW ON TXN TABLE
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		
		
		boolean success = false;
		//1. Connect to database!
		try{
			
			Connection connection = connectionUtil.getConnection();
//			
			String sql = "INSERT INTO transaction_table (acc_id, txn_date, txn_type, txn_amt, txn_acc) "
					+ "VALUES ((SELECT account_id FROM account_table WHERE acc_num = ?),?,?,?,?)";
//			
			PreparedStatement ps = connection.prepareStatement(sql);
			Date txndate = new Date(new java.util.Date().getTime());
			
			ps.setInt(1, account.getAccount_num());
			ps.setDate(2, txndate);
			ps.setString(3, txnType);
			ps.setDouble(4, depositAmount);
			ps.setString(5, account.getAccountType());
			
			ps.execute();
			
			success = true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return success;
	}

}
