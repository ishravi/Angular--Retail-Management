package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.AccountStatus;
import com.mappings.Accountdet;
import com.bean.Customer;
import com.dao.AccountDao;
import com.dao.CustomerDao;
import com.exception.AccountCountExceeded;
import com.exception.CurrentAccountCountExceeded;
import com.exception.CustomerIDNotFoundException;
import com.exception.SavingsAccountCountExceeded;

public class AccountService{
	AccountDao Dao = new AccountDao();
public long createAccount(Accountdet acc) throws SQLException, SavingsAccountCountExceeded, CurrentAccountCountExceeded, AccountCountExceeded, CustomerIDNotFoundException {
		
	   int b= Dao.checkAccountCount(acc.getCustomerId());
	   System.out.println("first id is"+b);
	   if(b<2)
	   {
		   if(acc.getAccountType().equalsIgnoreCase("savings"))
		   {
			 
			 int c= Dao.checkSavingsAccountCount(acc.getCustomerId());
			  System.out.println("qqqqq"+c);
			 System.out.println("");
				 if(c==0)
				 {
					 return Dao.createAccount(acc);
					
				 }
				 
				 else
				 {
					 System.out.println("Savings Account Count Exceeded");
					 return -1;
				 }
					
			 }
		   
		   else if(acc.getAccountType().equalsIgnoreCase("current"))
		   {
			   int d= Dao.checkCurrentAccountCount(acc.getCustomerId());
			   System.out.println("wwwww"+d);
			   if(d==0)
			   {
				   return Dao.createAccount(acc);
			
			   }
			   else
			   {
				   System.out.println("Current Account Count Exceeded");
					 return -2;
			   }
			 
		   }
		  
			
	   }
	return -3;
	   
	   
		 

	}

public ArrayList<Account> viewAllAccountForCustomer(int cusid,long accid) {
	return Dao.viewAllAccountForCustomer(cusid, accid);
	
}

public ArrayList<Account> viewAllAccountStatus(){
	return Dao.viewAllAccountStatus();
}

public long deleteAccount(long accountid)
{
	
double balance = Dao.getAccountbalance(accountid);
if(balance==0)
{
	String status = Dao.getAccountStatus(accountid);
	if(status.equalsIgnoreCase("active"))
	{
		return Dao.deleteAccount(accountid);
	}
	else 
		return -2;

}
	return -1;
	
}



}
