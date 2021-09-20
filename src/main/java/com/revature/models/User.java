package com.revature.models;

public class User {

	
	// VARIABLES
	
	public int user_id;
	public String fname;
	public String lname;
	public String username;
	public String password;
	public boolean isEmployee;
	
	
	// CONSTRUCTORS
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int user_id) {
		super();
		// TODO Auto-generated constructor stub
		this.user_id = user_id;
	}
	
	public User(int user_id, String fname, String lname) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
	}
	
	public User(int user_id, String username, String password, boolean isEmployee) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
	}
	
	public User(int user_id, String fname, String lname, String username, String password, boolean isEmployee) {
		super();
		this.user_id = user_id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
	}
	
	
	// GETTERS
	

	public int getUser_id() {
		return user_id;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isEmployee() {
		return isEmployee;
	}
	
	
	// SETTERS
	

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}
	
	
	
	

	
	
	
	
}
