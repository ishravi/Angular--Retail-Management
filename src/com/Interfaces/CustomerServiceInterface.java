package com.interfaces;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.Customer;
import com.bean.CustomerStatus;
import com.exception.CustomerCanNotbeDeleted;
import com.exception.CustomerIDNotFoundException;
import com.exception.CustomerNotFoundException;
import com.exception.CustomerSSNIDAlreadyExistsException;
import com.exception.CustomerSSNIDNotFoundException;

public interface CustomerServiceInterface {
	

	
	
	

	public abstract int createCustomer(String ssn_id,String name,int age,long mobile,String email,String address,String city,String state) throws CustomerSSNIDAlreadyExistsException;


	public abstract ArrayList<Customer> viewAllCustomer();
	public abstract ArrayList<CustomerStatus> viewAllCustomerStatus();
	public abstract Customer viewCustomerbySSnIDorCusId(String ssn_id,String cusid) throws CustomerNotFoundException;
	
	
	public abstract int updateCustomer(String ssn_id,String name,int age,long mobile,String email,String address,String city,String state);
	
	
	
	public abstract int deleteCustomer(String ssn_id) throws CustomerCanNotbeDeleted;

}
