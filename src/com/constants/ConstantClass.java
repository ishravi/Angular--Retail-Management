package com.constants;

public class ConstantClass {
	
	public static final String AUTO_ACCID="select account_seq_a.nextval from dual";
    public static final String INSERT_ACCOUNT_IN_ACCOUNT_QUERY = "insert into account_a values(?,?,?,?,?,?,?)";
		
	public static final String UPDATE__ACCOUNT_STATUS_QUERY = "update account_a set message=?,last_updated=? where account_id=?";
	 
	
	public static final String CHECK_ACCOUNT_STATUS_QUERY="select account_status from account_a where account_id=?";
	public static final String CHECK_ACCOUNT_BALANCE_QUERY="select balance from account_a where account_id=?";
	public static final String DELETE_ACCOUNT_QUERY="update account_a set account_status=? ,message=?, last_updated=? where account_id=?";

	
	public static final String VIEW_ACCOUNT_BY_CUSTOMERID_QUERY ="select * from account_a where customer_id= ? or account_id = ?";	
	public static final String VIEW_ALL_ACCOUNTSTATUS_QUERY="select  * from account_a";

	public static final String COUNTOFSAVINGS_ACCOUNTS= "select count(*) from account_a where account_type='Savings'  and customer_id=?" ;
	public static final String COUNTOFCURRENT_ACCOUNTS= "select count(*) from account_a where account_type='Current' and customer_id=?" ;

	public static final String COUNTOFALL_ACCOUNTS= "select count(*) from account_a where customer_id=?" ;
	public static final String COUNTOF_INACTIVE_ACCOUNTS="select count(*) from account_a where customer_id=? and account_status= ?";


}
