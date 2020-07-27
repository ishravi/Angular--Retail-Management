package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mappings.LogIn;
import com.util.DBUtil;

public class LoginDao {

	public int validateUser(LogIn loginObj) throws SQLException {
		String pwd=null;
		
		Connection conn = DBUtil.getConnection();
		PreparedStatement psValidate = conn.prepareStatement("select password from account_executive where login_id=?");
		psValidate.setString(1, loginObj.getUsername());
		ResultSet rs = psValidate.executeQuery();
		if(rs.next())
		{
			 pwd = rs.getString(1);
			 
		}
		
		
		if(pwd!=null && pwd!=""){
			if(pwd.equals(loginObj.getPassword())){
				
				PreparedStatement psLog = conn.prepareStatement("insert into userstore_a values(?,?,?)");
				psLog.setString(1, loginObj.getUsername());
				psLog.setString(2, loginObj.getPassword());
				
				Calendar calendar = Calendar.getInstance();
				java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
				 
				psLog.setTimestamp(3, ourJavaTimestampObject);
				
				psLog.executeUpdate();
				
				DBUtil.closeConnection(conn);
				
				return 1;
			}
			else{
				DBUtil.closeConnection(conn);
				return 0;	
			}
		}
		else{
			DBUtil.closeConnection(conn);
			return -1;
		}		
	}

	public boolean resetPassword(double mobile, String secretKey, String newPassword) throws SQLException {
		
		Connection conn = DBUtil.getConnection();		
		PreparedStatement ps = conn.prepareStatement("update table account_executive set password=? where mobile=? and secret_answer=? ");
		ps.setString(1, newPassword);
		ps.setDouble(2, mobile);
		ps.setString(3, secretKey);
		int flag = ps.executeUpdate();
		if(flag==1){
			return true;
		}		
		return false;
	}
}
