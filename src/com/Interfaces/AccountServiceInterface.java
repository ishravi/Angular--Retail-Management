package com.interfaces;

import java.util.ArrayList;

import com.bean.Account;
import com.bean.AccountStatus;
import com.exception.AccountCountExceeded;
import com.exception.CurrentAccountCountExceeded;
import com.exception.CustomerSSNIDNotFoundException;
import com.exception.SavingsAccountCountExceeded;

public interface AccountServiceInterface {
		

	public int createAccount(int accountId, int cusId, String type, double balance) throws SavingsAccountCountExceeded, CurrentAccountCountExceeded, AccountCountExceeded;
	public abstract ArrayList<Account> viewAllAccountForCustomer(int cusid);
	public abstract ArrayList<AccountStatus> viewAllAccountStatus();
	public abstract int deleteAccountbalance(long accountid);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
