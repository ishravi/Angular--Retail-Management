package com.service;

import java.sql.SQLException;

import com.dao.LoginDao;
import com.mappings.LogIn;

public class LoginService {

	public LoginService() {
	
	}

	public int validateUser(LogIn loginObj) throws SQLException {
		
		LoginDao loginDao = new LoginDao();
		
		int status = loginDao.validateUser(loginObj);
		return status;		
	}

	public boolean resetPassword(double mobile, String secretKey, String newPassword) throws SQLException {
		
		LoginDao loginDao = new LoginDao();
		
		
		return loginDao.resetPassword(mobile,secretKey,newPassword);
	}



}
