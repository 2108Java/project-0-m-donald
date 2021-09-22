package com.revature.repo;

import com.revature.models.Account;
import com.revature.models.Customer;
import com.revature.models.Transaction;

public interface TransactionDAO {

	boolean insertTxn(Customer cust, Account account, double depositAmount, String txnType);

}
