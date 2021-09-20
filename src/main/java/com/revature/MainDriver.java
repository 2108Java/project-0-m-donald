package com.revature;

import com.revature.views.CustomerMenu;
import com.revature.views.EmployeeMenu;
import com.revature.views.LoginMenu;
import com.revature.views.Menu;
import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.repo.CustomerDAO;
import com.revature.repo.CustomerDAOImpl;
import com.revature.repo.EmployeeDAO;
import com.revature.repo.EmployeeDAOImpl;
import com.revature.repo.UserDAO;
import com.revature.repo.UserDAOImpl;
import com.revature.service.AuthenticateUser;
import com.revature.service.AuthenticateUserImpl;
import com.revature.service.BankService;
import com.revature.service.BankServiceImpl;

public class MainDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDAO database = new UserDAOImpl();
		CustomerDAO custDao = new CustomerDAOImpl();
		EmployeeDAO empDao = new EmployeeDAOImpl();
		
		BankService service = new BankServiceImpl();
		
		AuthenticateUserImpl auth = new AuthenticateUserImpl(database, custDao, empDao);
		
		EmployeeMenu empMenu = new EmployeeMenu();
		
		CustomerMenu custMenu = new CustomerMenu();

		LoginMenu loginMenu = new LoginMenu(service, auth, empMenu, custMenu);
		
		loginMenu.userLoginMenu();
	}

}
