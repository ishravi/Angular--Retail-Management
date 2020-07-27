package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.Account;
import com.bean.AccountStatus;
import com.mappings.Accountdet;
import com.constants.ConstantClass;
import com.exception.CustomerIDNotFoundException;
import com.util.DBUtil;

public class AccountDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;

	public AccountDao() {
		
	}

	public int getaccid() {
		con=DBUtil.getConnection();
		int accid=0;
		try {
			ps=con.prepareStatement(ConstantClass.AUTO_ACCID);
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				accid= rs.getInt(1);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return accid;
	}

public long createAccount(Accountdet acc) throws SQLException, CustomerIDNotFoundException
	 {

	con=DBUtil.getConnection();
	String status1 = "active";
	PreparedStatement ps1= con.prepareStatement("select cust_id from customer_a where cust_id=? and customer_status=?");
	ps1.setInt(1, acc.getCustomerId());
	ps1.setString(2, status1);
	ResultSet rs1=ps1.executeQuery();
	if(rs1.next()){
		long id = getaccid();
		String message = "Created";
		String status = "active";
		Timestamp ts= new Timestamp(System.currentTimeMillis());
		System.out.println("in dao acc"+acc);
		System.out.println("in dao"+acc.getAccountBalance());
		try {
			ps=con.prepareStatement(ConstantClass.INSERT_ACCOUNT_IN_ACCOUNT_QUERY);
			ps.setLong(1, id);
			ps.setString(2,acc.getAccountType());
			ps.setDouble(3,acc.getAccountBalance());
			ps.setInt(4,acc.getCustomerId());
			ps.setString(5,status);
			ps.setString(6,message);
			ps.setTimestamp(7, ts);
			
			int rowCount= ps.executeUpdate();
		
			return id;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return -4;
	}
	else
		throw new CustomerIDNotFoundException();

}

	public ArrayList<Account> viewAllAccountForCustomer(int cusid,long accid) {

		ArrayList<Account> accList= new ArrayList<Account>();
		con=DBUtil.getConnection();

			try {
				ps=con.prepareStatement(ConstantClass.VIEW_ACCOUNT_BY_CUSTOMERID_QUERY);
				ps.setInt(1, cusid);
				ps.setLong(2, accid);
				rs=ps.executeQuery();
				while(rs.next())
				{
					AccountStatus as=new AccountStatus(rs.getLong(1),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
//					Account a=new Account(rs.getLong(1),rs.getString(2),rs.getDouble(3),rs.getInt(4));
					Account acc = new Account();
					acc.setAccountBalance(rs.getDouble(3));
					acc.setAccountId(rs.getLong(1));
					acc.setAccountStatusObj(as);
					acc.setAccountType(rs.getString(2));
					acc.setCusid(rs.getInt("customer_id"));
//					a.setAccountStatusObj(as);
					accList.add(acc);
			
						}
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
		return accList;

		
		
	}

	public int checkAccountCount(int Cusid) {
		con=DBUtil.getConnection();
		int count = 0;
			try {
				ps=con.prepareStatement(ConstantClass.COUNTOFALL_ACCOUNTS);
				ps.setInt(1, Cusid);
				rs=ps.executeQuery();
				while(rs.next())
				{
					count=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return count;
	}

	public int checkSavingsAccountCount(int Cusid) {
		con=DBUtil.getConnection();
		int count = 0;
			try {
				ps=con.prepareStatement(ConstantClass.COUNTOFSAVINGS_ACCOUNTS);
				ps.setInt(1, Cusid);
				rs=ps.executeQuery();
				while(rs.next())
				{
					count=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return count;
	
	}
	
		public int checkCurrentAccountCount(int Cusid) {
			con=DBUtil.getConnection();
			int count = 0;
				try {
					ps=con.prepareStatement(ConstantClass.COUNTOFCURRENT_ACCOUNTS);
					ps.setInt(1, Cusid);
					rs=ps.executeQuery();
					while(rs.next())
					{
						count=rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return count;
		
		}
	
	
	
		public ArrayList<Account> viewAllAccountStatus() {
			ArrayList<Account> statList= new ArrayList<Account>();
			con=DBUtil.getConnection();

					try {
						ps=con.prepareStatement(ConstantClass.VIEW_ALL_ACCOUNTSTATUS_QUERY);
						
						rs=ps.executeQuery();
						while(rs.next())
						{
							AccountStatus cs= new AccountStatus(rs.getLong(1),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
							Account acc = new Account();
							acc.setAccountBalance(rs.getDouble(3));
							acc.setAccountId(rs.getLong(1));
							acc.setAccountStatusObj(cs);
							acc.setAccountType(rs.getString(2));
							acc.setCusid(rs.getInt("customer_id"));
//							Account acc = new Account(rs.getLong(1),rs.getString(2),rs.getDouble(3),rs.getInt("customer_id"));
//							
						
//							acc.setAccountStatusObj(cs);
							System.out.println("qqqqqq"+acc.getCusid());
						
	                         statList.add(acc);
						}				} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			return statList;
		}

		
		public long deleteAccount(long accountid) {
			con=DBUtil.getConnection();

			String message = "Deleted";
		    Timestamp ts= new Timestamp(System.currentTimeMillis());
			String status="inactive";
			try {
				ps=con.prepareStatement(ConstantClass.DELETE_ACCOUNT_QUERY);
				ps.setString(1,status);
				ps.setString(2, message);
				ps.setTimestamp(3, ts);
				ps.setLong(4, accountid);
		
				int count=ps.executeUpdate();
				
				return accountid;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		
		public double getAccountbalance(long accountid) {
			con=DBUtil.getConnection();
			double balance=0.0;
			try {
				ps=con.prepareStatement(ConstantClass.CHECK_ACCOUNT_BALANCE_QUERY);
				ps.setLong(1, accountid);
				rs=ps.executeQuery();
				while(rs.next()){
					balance=rs.getDouble(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return balance;
		}

		public String getAccountStatus(long accountid) {
			con=DBUtil.getConnection();
			String res =null;
			try {
				ps=con.prepareStatement(ConstantClass.CHECK_ACCOUNT_STATUS_QUERY);
				ps.setLong(1, accountid);
				rs=ps.executeQuery();
				while(rs.next()){
					res = rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return res;
		}




}
