package com.revature.models;

public class Employee extends User {
	
	public int emp_id;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int user_id, String username, String password, boolean isEmployee) {
		super(user_id, username, password, isEmployee);
		// TODO Auto-generated constructor stub
	}

	public Employee(int user_id, String fname, String lname, String username, String password, boolean isEmployee) {
		super(user_id, fname, lname, username, password, isEmployee);
		// TODO Auto-generated constructor stub
	}

	public Employee(int user_id, String fname, String lname) {
		super(user_id, fname, lname);
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id) {
		super();
		this.emp_id = emp_id;
	}
	
	public Employee(int user_id, int emp_id, String fname, String lname, String username, String password, boolean isEmployee) {
		super(user_id, fname, lname, username, password, isEmployee);
		// TODO Auto-generated constructor stub
		this.emp_id = emp_id;
		
	}
	
	
	// GETTERS

	public int getEmp_id() {
		return emp_id;
	}

	
	// SETTERS 
	
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	
	


	
}
