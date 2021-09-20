package com.revature.models;

public class Account extends User {
	
	// VARIABLES
	
	public int acc_id;
	
	public int account_num;
	
	public String accountType;
	
	public double balance;
	
	public boolean isApproved;
	
	public boolean isDenied;
	
	
	// STORING ACCOUNT TYPES
	enum AccountType{
		CHECKING,
		SAVINGS,
		JOINT
	}

	
	// CONSTRUCTORS
	

	public Account(int acc_id, int account_num, String accountType, double balance, boolean isApproved,
			boolean isDenied) {
		super();
		this.acc_id = acc_id;
		this.account_num = account_num;
		this.accountType = accountType;
		this.balance = balance;
		this.isApproved = isApproved;
		this.isDenied = isDenied;
	}


	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(int user_id, int acc_id, int account_num) {
		// TODO Auto-generated constructor stub
		super(user_id);
		this.acc_id = acc_id;
		this.account_num = account_num;
	}


	public Account(int user_id, String username, String password, boolean isEmployee) {
		super(user_id, username, password, isEmployee);
		// TODO Auto-generated constructor stub
	}


	public Account(int user_id, String fname, String lname, String username, String password, boolean isEmployee) {
		super(user_id, fname, lname, username, password, isEmployee);
		// TODO Auto-generated constructor stub
	}


	public Account(int user_id, String fname, String lname) {
		super(user_id, fname, lname);
		// TODO Auto-generated constructor stub
	}

	
	public Account(int user_id, String fname, String lname, int acc_id, int account_num, String accountType, double balance, boolean isApproved,
			boolean isDenied) {
		super(user_id, fname, lname);
		// TODO Auto-generated constructor stub
		this.acc_id = acc_id;
		this.account_num = account_num;
		this.accountType = accountType;
		this.balance = balance;
		this.isApproved = isApproved;
		this.isDenied = isDenied;
	}
	
	
	
	// GETTERS


	public int getAcc_id() {
		return acc_id;
	}


	public int getAccount_num() {
		return account_num;
	}


	public String getAccountType() {
		return accountType;
	}


	public double getBalance() {
		return balance;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public boolean isDenied() {
		return isDenied;
	}
	
	
	// SETTERS
	


	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}


	public void setAccount_num(int account_num) {
		this.account_num = account_num;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	public void setDenied(boolean isDenied) {
		this.isDenied = isDenied;
	}
	
	
	
	

}
