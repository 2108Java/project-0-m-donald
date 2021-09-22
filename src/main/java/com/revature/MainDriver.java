package com.revature;

import com.revature.views.CustomerMenu;
import com.revature.views.EmployeeMenu;
import com.revature.views.LoginMenu;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.revature.models.Account;
import com.revature.repo.AccountDAO;
import com.revature.repo.AccountDAOImpl;
import com.revature.repo.CustomerDAO;
import com.revature.repo.CustomerDAOImpl;
import com.revature.repo.EmployeeDAO;
import com.revature.repo.EmployeeDAOImpl;
import com.revature.repo.TransactionDAO;
import com.revature.repo.TransactionDAOImpl;
import com.revature.repo.UserDAO;
import com.revature.repo.UserDAOImpl;
import com.revature.service.AuthenticateUserImpl;
import com.revature.service.BankService;
import com.revature.service.BankServiceImpl;

public class MainDriver {
	
	public final static Logger loggy = Logger.getLogger(MainDriver.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loggy.setLevel(Level.INFO);
		loggy.info("Starting the application!");
		
		UserDAO database = new UserDAOImpl();
		CustomerDAO custDao = new CustomerDAOImpl();
		EmployeeDAO empDao = new EmployeeDAOImpl();
		AccountDAO accDao = new AccountDAOImpl();
		TransactionDAO txnDao = new TransactionDAOImpl();
		
		
		BankService service = new BankServiceImpl();
		
		AuthenticateUserImpl auth = new AuthenticateUserImpl(database, custDao, empDao);
		
		EmployeeMenu empMenu = new EmployeeMenu(custDao, database, accDao, txnDao, empDao);
		Account account = new Account();
		
		
		CustomerMenu custMenu = new CustomerMenu(custDao, database, accDao, txnDao);

		LoginMenu loginMenu = new LoginMenu(service, auth, empMenu, custMenu);
		
		loginMenu.userLoginMenu();
	}

}
