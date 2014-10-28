package com.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreConnection {
	private Connection con = null;
	private Statement st = null;
  
	public Connection Predbconnect() throws ClassNotFoundException, SQLException 
	{
		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BBC_PROD;selectMethod=cursor","sa", "sa@123");
		 // con =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BBC_PROD;selectMethod=cursor","bicyclebuys","bicyclebuys" );
		//con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BBC_PROD;selectMethod=cursor","tambbc",
		//"Tamagna@2014" );
		 
		 return con;
	}
	
	public void close() 
	{
		try {
			if (st != null) {
				st.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
