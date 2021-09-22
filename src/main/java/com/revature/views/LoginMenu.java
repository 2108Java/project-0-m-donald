package com.revature.views;

import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repo.CustomerDAO;
import com.revature.service.AuthenticateUser;
import com.revature.service.BankService;
import com.revature.util.ConnectionUtil;



public class LoginMenu implements Menu {
	
	BankService service;
	User user;
	Account account;
	EmployeeMenu empMenu;
	CustomerMenu custMenu;
	CustomerDAO custDao;
	AuthenticateUser auth;
	
	public LoginMenu(BankService service, AuthenticateUser auth, EmployeeMenu empMenu, CustomerMenu custMenu) {
		this.auth = auth;
		this.service = service;
		this.empMenu= empMenu;
		this.custMenu = custMenu;
	}
	
	public LoginMenu() {
	}
	
	public void userLoginMenu() {
		System.out.println("Welcome to the Bank!");
		System.out.println("");
		System.out.println("1) Login");
		System.out.println("2) Create User Account");
		System.out.println("3) Exit");
		
		Scanner sc = new Scanner(System.in);
		
		String decision = sc.nextLine();
		
		switch(decision) {
		
		
		
			case "1":
				int userId = display();
				if(userId != 0) 
				{
					for(int i=1;i<=2 || userId == 0; i++)
					{
						if(userId == 0) {
							userId = this.display();
						}else {
							i = 3;
						}
					}
				}
				
				System.out.println("Hello! Customers press 1. Employees press 2. ");
				
				int entry = sc.nextInt();

				
				switch(entry) {
				case 1:
					custMenu.displayCustomerMenu(userId);
					userLoginMenu();
					break;
				case 2:
					empMenu.displayEmployeeMenu(userId);
					break;
				default:
					System.out.println("Invalid entry! Please try again!");
					display();
				}
				break;
			case "2":
				System.out.println("\n Hello!");
				custMenu.createUserAccount();
				userLoginMenu();
				break;
			case "3":
				System.out.println("Good-bye!");
				break;
			default:
				break;
		}
		
		
	}
	
	
	public boolean createNewApplication() {
		// TODO Auto-generated method stub
		
		ConnectionUtil connectionUtil = new ConnectionUtil();
		User user = new User();
		
		boolean success = false;
		//1. Connect to database!
		try{
			
			System.out.println("Please enter the following information: ");
			System.out.println(" ");

			Scanner sc = new Scanner(System.in);
			
			System.out.println("Username: ");
			String usrname = sc.nextLine();
			System.out.println("Password: ");
			String passwrd = sc.nextLine();
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
		
		System.out.println("Thank you for creating an account! Someone will approve or deny your application within 24 hours!");
		
		return success;
	}

	public int display() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
//		boolean running = true;
		
		System.out.println("Welcome! Please enter your credentials: ");
		System.out.println("");
		System.out.println("Username: ");
		String username = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		
		return auth.authenticate(username, password);

		
		
	}
}

































