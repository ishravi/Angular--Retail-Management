package com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.mappings.CustomerDetail;
import com.mappings.SearchCustomer;

public class CustomerService {

	public CustomerService() {
		
		
		
	}

	public int createCustomer(Customer customer) throws SQLException {
		
		CustomerDao csDao = new CustomerDao();
		return csDao.createCustomer(customer);
	}

	
	public ArrayList<CustomerDetail> getAllCustomer() throws SQLException
	{
		CustomerDao csDao = new CustomerDao();
		return csDao.getAllCustomer();
	}
	
	
	
	public ArrayList<CustomerDetail> searchCustomer(SearchCustomer custObj) throws SQLException
	{
		ArrayList<CustomerDetail> alist = new ArrayList<CustomerDetail>();
		CustomerDao csDao = new CustomerDao();
		alist= csDao.searchCustomer(custObj);
		return alist;
	}
	
	
	
	public boolean updateCustomer(CustomerDetail customerDetail) throws SQLException
	{
		CustomerDao csDao = new CustomerDao();
		if(csDao.updateCustomer(customerDetail))
		{
			return true;
		}
		else
			return false;
	}
	
	public int deleteCustomer(int customerId) throws SQLException
	{
		CustomerDao csDao = new CustomerDao();
		
		return csDao.deleteCustomer(customerId);
	}
}
