package com.revature.views;

import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repo.CustomerDAO;
import com.revature.service.AuthenticateUser;
import com.revature.service.BankService;

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

//	private void prettyDisplayOfInfo() {
//		
////		for(int i = 0; i < userArray.length; i++) { // add User[] userArray arg
////			
////			if(userArray[i] != null) {
////				System.out.println("Name: " + userArray[i].getName());
////				System.out.println("Account balance: " + userArray[i].getBalance());
////				System.out.println("Employee status: " +userArray[i].isEmployee());
////				System.out.println("");
////			}
////		}
//				System.out.println("Name: " + user.getFname() + " " + user.getLname());
//				System.out.println("Account balance: " + account.getBalance());
//				System.out.println("Employee status: " +user.isEmployee());
//				System.out.println(" ");	
//	}
	
	public void userLoginMenu() {
		System.out.println("Welcome to the Bank!");
		System.out.println("");
		System.out.println("1) Login");
		System.out.println("2) Create Account");
		System.out.println("3) Exit");
		
		Scanner sc = new Scanner(System.in);
		
		String decision = sc.nextLine();
		
		switch(decision) {
		
			case "1":
				System.out.println("Hello! Customers press 1. Employees press 2. ");
				
				int entry = sc.nextInt();
				
				switch(entry) {
				case 1:
//					System.out.println("Welcome back customer! Please enter your credentials: ");
//					System.out.println("");
//					System.out.println("Username: ");
//					String username = sc.nextLine();
//					System.out.println("Password");
//					String password = sc.nextLine();
//					
//					auth.authenticate(username, password);
					
					boolean isAuthenticated = false;
					for(int i=0;i<=3 || !isAuthenticated; i++) {
						isAuthenticated = this.display();
					}
					
					custMenu.displayCustomerMenu();
					
					break;
				case 2:
					
					boolean isAuthenticated2 = false;
					for(int i=0;i<=3 || !isAuthenticated2; i++) {
						isAuthenticated2 = this.display();
					}
				
					empMenu.displayEmployeeMenu();
					
					break;
				default:
					System.out.println("Invalid entry! Please try again!");
					display();
				}
				
				break;
			case "2":
				custDao.createNewApplication();
				break;
			case "3":
				System.out.println("Good-bye!");
				break;
			default:
				break;
		}
		
		
	}
	
	
	public boolean display() {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
//		boolean running = true;
		
		System.out.println("Welcome back! Please enter your credentials: ");
		System.out.println("");
		System.out.println("Username: ");
		String username = sc.nextLine();
		System.out.println("Password");
		String password = sc.nextLine();
		
		return auth.authenticate(username, password);

		
		
	}
}

































