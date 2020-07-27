package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.bean.Customer;
import com.mappings.CustomerDetail;
import com.mappings.SearchCustomer;
import com.util.DBUtil;

public class CustomerDao {

	public CustomerDao() {
		//constructor
		
	}

	public int createCustomer(Customer customer) throws SQLException {
		
		Connection conn = DBUtil.getConnection();		
		PreparedStatement ps = conn.prepareStatement("insert into customer_a values(cust_seq_a.nextval,?,?,?,?,?,?,?,?,?,?,?)");		
		ps.setString(1, customer.getCustomerName());
		ps.setInt(2, customer.getCustomerAge());
		ps.setDouble(3, customer.getMobileNo());
		ps.setString(4, customer.getEmail());
		ps.setString(5, customer.getAddress());
		ps.setString(6, customer.getCity());
		ps.setString(7, customer.getState());
		ps.setString(8, customer.getCustomerStatus());
		ps.setString(9, customer.getMessage());
        Calendar calendar = Calendar.getInstance();		
		java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		ps.setTimestamp(10, ourJavaTimestampObject);
		ps.setString(11, customer.getCustomerSsnId());		
		int test = ps.executeUpdate();	
		if(test>=1){
			PreparedStatement ps1 = conn.prepareStatement("select cust_id from customer_a where ssn_id=?");
			ps1.setString(1, customer.getCustomerSsnId());
			ResultSet rs1 = ps1.executeQuery();
						
			if(rs1.next()){
				int test1 = rs1.getInt(1);
				DBUtil.closeConnection(conn);
				return test1;
			}
		}
		return -1;
	}
	
	public ArrayList<CustomerDetail> getAllCustomer() throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		ArrayList<CustomerDetail> alist = new ArrayList<CustomerDetail>();
		
		PreparedStatement ps = conn.prepareStatement("select * from customer_a");
	    ResultSet res = ps.executeQuery();
	    
	    while(res.next())
	    {
	    	CustomerDetail c = new CustomerDetail();
	    	c.setCustomerSsnId(res.getString("ssn_id"));
	    	c.setCustomerName(res.getString("customer_name"));
	    	c.setCustomerAge(res.getInt("age"));
	    	c.setEmail(res.getString("email"));
	    	c.setAddress(res.getString("address"));
	    	c.setCity(res.getString("city"));
	    	c.setCustomerStatus(res.getString("customer_status"));
	    	c.setMessage(res.getString("message"));
	    	c.setMobileNo(res.getLong("mobile"));
	    	c.setState(res.getString("state"));
	    	c.setLast_update(res.getTimestamp("last_updated"));
	    	c.setCust_id(res.getInt("cust_id"));
	    	
	    	alist.add(c);
	    	
	    }
	    DBUtil.closeConnection(conn);
	    return alist;
		
		
	}
	
	public ArrayList<CustomerDetail> searchCustomer(SearchCustomer custObj) throws SQLException
	{
		ArrayList<CustomerDetail> alist = new ArrayList<CustomerDetail>();
		Connection conn = DBUtil.getConnection();
		CustomerDetail c = new CustomerDetail();
		
		
		String sid = custObj.getSsnId();
		System.out.println("ssn is"+" "+ sid);
		
		if(sid!=null && !sid.equals(""))
		{
			System.out.println("ssnId");
			PreparedStatement ps = conn.prepareStatement("select * from customer_a where ssn_id=?");
			ps.setString(1, custObj.getSsnId());
		    ResultSet res = ps.executeQuery();
		    
		    while(res.next())
		    {
		    	c.setCustomerSsnId(res.getString("ssn_id"));
		    	c.setCustomerName(res.getString("customer_name"));
		    	c.setCustomerAge(res.getInt("age"));
		    	c.setEmail(res.getString("email"));
		    	c.setAddress(res.getString("address"));
		    	c.setCity(res.getString("city"));
		    	c.setCustomerStatus(res.getString("customer_status"));
		    	c.setMessage(res.getString("message"));
		    	c.setMobileNo(res.getLong("mobile"));
		    	c.setState(res.getString("state"));
		    	c.setLast_update(res.getTimestamp("last_updated"));
		    	c.setCust_id(res.getInt("cust_id"));
		    	alist.add(c);
		    }
		    ps.close();
		    DBUtil.closeConnection(conn);
		    return alist;
		}
		else 
		{
			System.out.println("custId is "+custObj.getCustId());
			
			PreparedStatement ps = conn.prepareStatement("select * from customer_a where cust_id=?");
			ps.setInt(1,custObj.getCustId());
		    ResultSet res = ps.executeQuery();
		    
		    while(res.next())
		    {
		    	c.setCustomerSsnId(res.getString("ssn_id"));
		    	c.setCustomerName(res.getString("customer_name"));
		    	c.setCustomerAge(res.getInt("age"));
		    	c.setEmail(res.getString("email"));
		    	c.setAddress(res.getString("address"));
		    	c.setCity(res.getString("city"));
		    	c.setCustomerStatus(res.getString("customer_status"));
		    	c.setMessage(res.getString("message"));
		    	c.setMobileNo(res.getLong("mobile"));
		    	c.setState(res.getString("state"));
		    	c.setLast_update(res.getTimestamp("last_updated"));
		    	c.setCust_id(res.getInt("cust_id"));
		    	alist.add(c);
		    }
		    ps.close();
		    DBUtil.closeConnection(conn);
		    return alist;
		}
	  
	}

	public int deleteCustomer(int customerId) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		String name=null;
		int balance = 0;
		System.out.println("id is"+customerId);
		
		PreparedStatement ps0 = conn.prepareStatement("select balance from customer_a c inner join account_a a on c.cust_id=a.customer_id where c.cust_id=?");
		ps0.setInt(1, customerId);
		
		ResultSet res0 = ps0.executeQuery();
		
		while(res0.next())
		{
			
			int val = res0.getInt("balance");
			balance = balance+val;
		}
		
		if(balance==0)
		{
			PreparedStatement ps = conn.prepareStatement("select customer_status from customer_a where cust_id=?");
			ps.setInt(1, customerId);
			
			ResultSet res = ps.executeQuery();
			
			if(res.next())
			{
				name = res.getString("customer_status");
				if(name.equalsIgnoreCase("active"))
				{
					PreparedStatement ps1 = conn.prepareStatement("update customer_a set customer_status=? where cust_id=?");
					ps1.setString(1,"inactive");
					ps1.setInt(2, customerId);
					
					int res1 = ps1.executeUpdate();
					
					if(res1>0)
					{
						return 1;
					}
					else
						return 2;
				}
				else
				{
					return 0;
				}
			}
		}
		
		
		return -1;
	}
	
//	public boolean deleteCustomer(String ssnId) throws SQLException
//	{
//		Connection conn = DBUtil.getConnection();
//		PreparedStatement ps = conn.prepareStatement("delete from customer_a where ssn_id=?");
//		ps.setString(1, ssnId);
//		
//		int res = ps.executeUpdate();
//		
//		if(res>0)
//		{
//			 DBUtil.closeConnection(conn);
//			return true;
//		}
//		else
//			 DBUtil.closeConnection(conn);
//			return false;
//		
//	}
//	
	public boolean updateCustomer(CustomerDetail customerDetail) throws SQLException
	{
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement("update customer_a set customer_name=?,age=?,mobile=?,email=?,address=?,city=?,state=?,message=?,last_updated=?,customer_status=? where ssn_id=?");
		ps.setString(1, customerDetail.getCustomerName());
		ps.setInt(2, customerDetail.getCustomerAge());
		ps.setLong(3, customerDetail.getMobileNo());
		ps.setString(4, customerDetail.getEmail());
		ps.setString(5, customerDetail.getAddress());
		ps.setString(6, customerDetail.getCity());
		ps.setString(7, customerDetail.getState());
		ps.setString(8, customerDetail.getMessage());
		ps.setString(10, customerDetail.getCustomerStatus());
		
		
		 Calendar calendar = Calendar.getInstance();		
			java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
			ps.setTimestamp(9, ourJavaTimestampObject);
			ps.setString(11, customerDetail.getCustomerSsnId());	
		
		int res = ps.executeUpdate();
		
		if(res>0)
		{
			DBUtil.closeConnection(conn);
			return true;
		}
		
		else
			DBUtil.closeConnection(conn);
			return false;
	}

}
