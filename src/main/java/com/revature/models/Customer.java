package com.revature.models;

public class Customer extends User{

	public int cust_id;
	public String phoneNum;
	public String dob;
	public String address;
	public String city;
	public String state;
	public String zipCode;
	public double startingBalance;
	public boolean isPrimaryCustomer;
	
	
	public Customer(int cust_id, String phoneNum, String dob, String address, String city, String state, String zipCode,
			double startingBalance, boolean isPrimaryCustomer) {
		super();
		this.cust_id = cust_id;
		this.phoneNum = phoneNum;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.startingBalance = startingBalance;
		this.isPrimaryCustomer = isPrimaryCustomer;
	}


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(int user_id, String username, String password, boolean isEmployee) {
		super(user_id, username, password, isEmployee);
		// TODO Auto-generated constructor stub
	}


	public Customer(int user_id, int cust_id, String fname, String lname, String username, String password, boolean isEmployee,
			String phoneNum, String dob, String address, String city, String state, String zipCode,
			double startingBalance, boolean isPrimaryCustomer) {
		super(user_id, fname, lname, username, password, isEmployee);
		// TODO Auto-generated constructor stub
		this.cust_id = cust_id;
		this.phoneNum = phoneNum;
		this.dob = dob;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.startingBalance = startingBalance;
		this.isPrimaryCustomer = isPrimaryCustomer;
	}


	public Customer(int user_id, int cust_id, String fname, String lname) {
		super(user_id, fname, lname);
		// TODO Auto-generated constructor stub
		this.cust_id = cust_id;
	}
	
	
	// GETTERS


	public int getCust_id() {
		return cust_id;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public String getDob() {
		return dob;
	}


	public String getAddress() {
		return address;
	}


	public String getCity() {
		return city;
	}


	public String getState() {
		return state;
	}


	public String getZipCode() {
		return zipCode;
	}


	public double getStartingBalance() {
		return startingBalance;
	}


	public boolean isPrimaryCustomer() {
		return isPrimaryCustomer;
	}
	
	
	
	// SETTERS


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setState(String state) {
		this.state = state;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public void setStartingBalance(double startingBalance) {
		this.startingBalance = startingBalance;
	}


	public void setPrimaryCustomer(boolean isPrimaryCustomer) {
		this.isPrimaryCustomer = isPrimaryCustomer;
	}
	
	
	
	// toSTRING
	
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", phoneNum=" + phoneNum + ", dob=" + dob + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", startingBalance="
				+ startingBalance + ", isPrimaryCustomer=" + isPrimaryCustomer + ", user_id=" + user_id + ", fname="
				+ fname + ", lname=" + lname + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
