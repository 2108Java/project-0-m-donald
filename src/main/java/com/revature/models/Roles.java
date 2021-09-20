package com.revature.models;

public class Roles extends User{
	
	
	// VARIABLES 
	
	public boolean admin_role;
	
	public boolean view_role;

	
	// CONSTRUCTORS
	
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int user_id, String fname, String lname) {
		super(user_id, fname, lname);
		// TODO Auto-generated constructor stub
	}
	
	public Roles(int user_id, String username, String password, boolean isEmployee) {
		super(user_id, username, password, isEmployee);
		// TODO Auto-generated constructor stub
	}
	
	public Roles(int user_id, String username, String password, boolean isEmployee, boolean admin_role, boolean view_role) {
		super(user_id, username, password, isEmployee);
		// TODO Auto-generated constructor stub
		this.admin_role = admin_role;
		this.view_role = view_role;
	}

	public Roles(int user_id, String fname, String lname, String username, String password, boolean isEmployee, boolean admin_role, boolean view_role) {
		super(user_id, fname, lname, username, password, isEmployee);
		// TODO Auto-generated constructor stub
		this.admin_role = admin_role;
		this.view_role = view_role;
	}

	public Roles(boolean admin_role, boolean view_role) {
		super();
		this.admin_role = admin_role;
		this.view_role = view_role;
	}
	
	
	// GETTERS
	

	public boolean isAdmin_role() {
		return admin_role;
	}

	public boolean isView_role() {
		return view_role;
	}

	
	// SETTERS
	
	
	public void setAdmin_role(boolean admin_role) {
		this.admin_role = admin_role;
	}

	public void setView_role(boolean view_role) {
		this.view_role = view_role;
	}

	

	
	
	
	

}
