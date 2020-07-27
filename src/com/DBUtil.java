package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	private static final String URL="jdbc:oracle:thin:@intvmoradb04:1521:orajavadb";
	private static final String USERNAME="TVM1819_TVM62_TJA311_DEV";
	private static final String PASSWORD="tcstvm62";
	
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		try {
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public static void closeConnection(Connection connection)
	{
		if(connection!=null)
		{
			try {
				connection.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	}
	


}
