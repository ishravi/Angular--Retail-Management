package com.interfaces;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.AccountStatus;
import com.exception.CustomerSSNIDNotFoundException;

public interface DaoAccountInterface {

	public abstract int getaccid();
	public abstract int createAccount(int accountId, int  cusId,String type,double balance) ;
	


	public abstract ArrayList<Account> viewAllAccountForCustomer(int cusid);
	public abstract ArrayList<AccountStatus> viewAllAccountStatus();
	
	
	public abstract double getAccountbalance(long accountid);
	public abstract int deleteAccountbalance(long accountid);
	

}
