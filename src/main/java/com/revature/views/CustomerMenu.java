package com.revature.views;

import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.models.User;
import com.revature.repo.AccountDAO;
import com.revature.repo.CustomerDAO;
import com.revature.repo.TransactionDAO;
import com.revature.repo.UserDAO;
import com.revature.util.ConnectionUtil;

public class CustomerMenu {

	User user;
	Customer cust;
	Account account;
	LoginMenu mainMenu;
	CustomerDAO custDao;
	UserDAO userDao;
	AccountDAO accDao;
	TransactionDAO txnDao;
	Transaction txn;

	public CustomerMenu(CustomerDAO custDao, UserDAO userDao, AccountDAO accDao, TransactionDAO txnDao) {
		this.custDao = custDao;
		this.userDao = userDao;
		this.accDao = accDao;
		this.txnDao = txnDao;

	}

	ConnectionUtil connectionUtil = new ConnectionUtil();

	public void displayCustomerMenu(int userId) {

		cust = custDao.selectCustomerById(userId);

		// Check credentials
		System.out.println("Welcome back " + cust.getFname() + " " + cust.getLname() + "!");
		System.out.println(" ");
		System.out.println(" 1) Withdraw");
		System.out.println(" 2) Deposit");
		System.out.println(" 3) Post Money Transfer");
		System.out.println(" 4) View Account Balance");
		System.out.println(" 5) Exit");

		// Checks chosen option
		Scanner sc = new Scanner(System.in);

		int choice = sc.nextInt();

		switch (choice) {
		case 1: // Withdraw

//			System.out.println("Which account?");
//			System.out.println(" ");
//			System.out.println(" 1) Checking");
//			System.out.println(" 2) Savings");
////			System.out.println(" 3) Joint");
//
//			// Checks chosen option
//				sc = new Scanner(System.in);

			int acctChoice = chooseAccount(); // sc.nextInt();

			String acctType;

			if (acctChoice == 1) {
				acctType = "checking";
			} else {
				acctType = "savings";
			}

			System.out.println("How much would you like to withdraw?");
			double wthdrwAmount = sc.nextDouble();

			wthdrwAmount = wthdrwAmount * -1;

			account = accDao.selectAccountData(cust.getCust_id(), acctType);

			boolean wtxnAdded = txnDao.insertTxn(cust, account, wthdrwAmount, "WITHDRAWAL");

			if (wtxnAdded) {
				double updatedBalance = account.getBalance() + wthdrwAmount;

				accDao.updateBalance(account.getAcc_id(), updatedBalance);

				System.out.println("Updated Balance: " + updatedBalance);
			} else {
				System.out.println("Error: Withdrawal not accepted! ");
			}
			displayCustomerMenu(userId);

			break;

		case 2: // Deposit

			int acctChoice2 = chooseAccount();

			String acctType2;

			if (acctChoice2 == 1) {
				acctType2 = "checking";
			} else {
				acctType2 = "savings";
			}

			System.out.println("How much would you like to deposit?");
			double depositAmount = sc.nextDouble();

			account = accDao.selectAccountData(cust.getCust_id(), acctType2);

			boolean txnAdded = txnDao.insertTxn(cust, account, depositAmount, "DEPOSIT");

			if (txnAdded) {
				double newBalance = account.getBalance() + depositAmount;

				accDao.updateBalance(account.getAcc_id(), newBalance);

				System.out.println("Updated Balance: " + newBalance);
			} else {
				System.out.println("Error: Deposit not accepted! ");
			}

			displayCustomerMenu(userId);
			break;

		case 3: // Post money transfer
			Scanner scan = new Scanner(System.in);

			System.out.println("Choose account to transfer from: \n");
			System.out.println(" 1) Checking");
			System.out.println(" 2) Savings");
			int transferFrom = scan.nextInt();
			System.out.println("Choose account to transfer to: \n");
			if (transferFrom == 1) {
				System.out.println(" 2) Savings");

			} else {
				System.out.println(" 1) Checking");
			}
			int transferto = scan.nextInt();

			String fromAcctType;
			String toAcctType;

			if (transferFrom == 1) {
				fromAcctType = "checking";
				toAcctType = "savings";
			} else {
				fromAcctType = "savings";
				toAcctType = "checking";
			}

			System.out.println("How much would you like to transfer?");
			double transferAmount = sc.nextDouble();

			// Transfer From
			account = accDao.selectAccountData(cust.getCust_id(), fromAcctType);

			double transferFromAmount = transferAmount * -1;
			double transferToAmount = transferAmount;

			boolean transferFrom1 = txnDao.insertTxn(cust, account, transferFromAmount, "TRANSFER");

			double afterTransferBalance = 0;

			if (transferFrom1) {
				afterTransferBalance = account.getBalance() + transferFromAmount;

				accDao.updateBalance(account.getAcc_id(), afterTransferBalance);
			} else {
				System.out.println("Error: Transfer not accepted! ");
			}

			// Transfer To
			account = accDao.selectAccountData(cust.getCust_id(), toAcctType);

			boolean transferTo2 = txnDao.insertTxn(cust, account, transferToAmount, "TRANSFER");

			double recipientTransferBalance = 0;

			if (transferTo2) {
				recipientTransferBalance = account.getBalance() + transferToAmount;
				accDao.updateBalance(account.getAcc_id(), recipientTransferBalance);
			} else {
				System.out.println("Error: Transfer not accepted! ");
			}

			System.out.println(fromAcctType.toUpperCase() + " BALANCE: " + afterTransferBalance);
			System.out.println(toAcctType.toUpperCase() + " BALANCE: " + recipientTransferBalance + "/n/n");

			displayCustomerMenu(userId);

			break;
		case 4: // Show's the customer their balance.
//
//			System.out.println("Which account?");
//			System.out.println(" ");
//			System.out.println(" 1) Checking");
//			System.out.println(" 2) Savings");
////			System.out.println(" 3) Joint");
//
//			// Checks chosen option
//			sc = new Scanner(System.in);

			int viewChoice = chooseAccount(); //sc.nextInt();

			String viewAcct;

			if (viewChoice == 1) {
				viewAcct = "checking";
			} else {
				viewAcct = "savings";
			}

			account = accDao.selectAccountData(cust.getCust_id(), viewAcct);

			double viewBalance = account.getBalance();

			System.out.println(viewAcct.toUpperCase() + " BALANCE : " + viewBalance + "\n\n");

			displayCustomerMenu(userId);

			break;
		case 5: // Exits to main menu
			System.out.println("Thank you! Come again! \n\n");
			break;
		}
	}

	private int chooseAccount() {
		System.out.println("Which account?");
		System.out.println(" ");
		System.out.println(" 1) Checking");
		System.out.println(" 2) Savings");
//		System.out.println(" 3) Joint");

		// Checks chosen option
		Scanner sc = new Scanner(System.in);

		return sc.nextInt();
	}

	public void createUserAccount() {
		
		// TODO MENU TO ENTER APPL/CUST DATA
		
		Customer customer = createApplication();
		
		// TODO INSERT NEW USER IN USER TABLE
		
		int userID = userDao.createUser(user);
		
		// TODO INSERT CUSTOMER DATA IN CUSTOMER TABLE USING USER_ID
		Customer newCust = custDao.createCustomer(userID, customer);
		// TODO MENU TO APPLY FOR CHECKING, SAVINGS ACCT WITH OR W/O STARTING BALANCE
		int accountTypeChoice = chooseAccount();
		
		String acctType;

		if (accountTypeChoice == 1) {
			acctType = "checking";
		} else {
			acctType = "savings";
		}
		
		// Return an account object
		
		account = accDao.createAccount(acctType, newCust);
		
		System.out.println("Congratulations on creating your " + acctType + "account! ");
		
		
		// TODO DISPLAY SOMETHING TO CONSOLE
		
		
		
	}

	private Customer createApplication() {
		// TODO Auto-generated method stub
		
		cust = new Customer();
		user = new User();
		
		System.out.println("Please enter the following information: ");
		System.out.println(" ");

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Username: ");
		user.setUsername(sc.nextLine());
		System.out.println("Password: ");
		user.setPassword(sc.nextLine());
		System.out.println("First Name: ");
		cust.setFname(sc.nextLine());
		System.out.println("Last Name: ");
		cust.setLname(sc.nextLine());
		System.out.println("Phone Number (No / or - ): ");
		cust.setPhoneNum(sc.nextLine());
		System.out.println("Date of Birth  (MM/DD/YYYY) : ");
		cust.setDob(sc.nextLine());
		System.out.println("Street Address: ");
		cust.setAddress(sc.nextLine());
		System.out.println("City: ");
		cust.setCity(sc.nextLine());
		System.out.println("State: ");
		cust.setState(sc.nextLine());
		System.out.println("zipCode: ");
		cust.setZipCode(sc.nextLine());
		System.out.println("Starting Balance: ");
		cust.setStartingBalance(sc.nextDouble());
		System.out.println("Are you the primary customer on the account? ( true / false ): ");
		cust.setPrimaryCustomer(sc.nextBoolean());
		
		
		
		return cust;
		
	}

}
