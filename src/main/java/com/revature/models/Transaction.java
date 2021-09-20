package com.revature.models;

public class Transaction extends Account {
	
	public String transactionType;
	
	public String transactionDate;
	
	public double transactionAmount;

	public Transaction(int acc_id, int account_num, String accountType, double balance, boolean isApproved,
			boolean isDenied, String transactionType, String transactionDate, double transactionAmount) {
		super(acc_id, account_num, accountType, balance, isApproved, isDenied);
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int user_id, int acc_id, int account_num) {
		super(user_id, acc_id, account_num);
		// TODO Auto-generated constructor stub
		
	}
	
	public Transaction(int user_id, int acc_id, int account_num, String transactionType, String transactionDate, double transactionAmount) {
		super(user_id, acc_id, account_num);
		// TODO Auto-generated constructor stub
		this.transactionType = transactionType;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
	}

	public Transaction(int acc_id, int account_num, String accountType, double balance, boolean isApproved,
			boolean isDenied) {
		super(acc_id, account_num, accountType, balance, isApproved, isDenied);
		// TODO Auto-generated constructor stub
	}

//	public Transaction(int user_id, String username, String password, boolean isEmployee) {
//		super(user_id, username, password, isEmployee);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Transaction(int user_id, String fname, String lname, int acc_id, int account_num, String accountType,
//			double balance, boolean isApproved, boolean isDenied) {
//		super(user_id, fname, lname, acc_id, account_num, accountType, balance, isApproved, isDenied);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Transaction(int user_id, String fname, String lname, String username, String password, boolean isEmployee) {
//		super(user_id, fname, lname, username, password, isEmployee);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Transaction(int user_id, String fname, String lname) {
//		super(user_id, fname, lname);
//		// TODO Auto-generated constructor stub
//	}
	
	
	
	

}
