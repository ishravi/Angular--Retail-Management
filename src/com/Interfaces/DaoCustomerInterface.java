package com.interfaces;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.Customer;
import com.bean.CustomerStatus;
import com.exception.CustomerIDNotFoundException;
import com.exception.CustomerNotFoundException;
import com.exception.CustomerSSNIDAlreadyExistsException;
import com.exception.CustomerSSNIDNotFoundException;

public interface DaoCustomerInterface {


		
		public abstract boolean checkSSNID(String ssn_id) throws CustomerSSNIDNotFoundException;
		public abstract boolean checkcusID(int cusid) throws CustomerIDNotFoundException;
		
		public abstract int getcusid();
		public abstract int createCustomer(String ssn_id,int cusid,String name,int age,long mobile,String email,String address,String city,String state) throws CustomerSSNIDAlreadyExistsException;


		
		public abstract ArrayList<Customer> viewAllCustomer();
		public abstract ArrayList<CustomerStatus> viewAllCustomerStatus();
		public abstract Customer viewCustomerbySSnIDorCusId(String ssn_id,String cusid) throws CustomerNotFoundException;
		
		
		public abstract int updateCustomer(String ssn_id,String name,int age,long mobile,String email,String address,String city,String state);
		public abstract int updateCustomerStatus(String ssn_id,String message,Timestamp lastupdated);
		
		
		public abstract int getCustomerIDbySSNId(String ssnid) throws CustomerSSNIDNotFoundException;
		
		
		public abstract int checkAccountCount(int Cusid);
		public abstract int checkInactiveAccountCount(int Cusid);

		public abstract int deleteCustomer(String ssn_id);
		

}
