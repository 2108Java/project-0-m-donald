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
import com.revature.util.ConnectionUtil;

public class BankServiceImpl implements BankService {

	
	
	User user = new User();
	Customer cust = new Customer();
	Employee emp = new Employee();
	
	ConnectionUtil connectionUtil = new ConnectionUtil();

}
