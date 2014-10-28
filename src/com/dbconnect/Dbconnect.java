package com.dbconnect;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; 
public class Dbconnect 
{ 
	private Connection con = null;
	private Statement st = null;  
	public Statement dbconnect() throws ClassNotFoundException, SQLException 
	 {   
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      //con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=BBC_PROD;selectMethod=cursor","bicyclebuys", "bicyclebuys");
		//con =DriverManager.getConnection("jdbc:sqlserver://75.99.49.198:1433;databaseName=;selectMethod=cursor","bicyclebuys","bicyclebuys" );
		/*working*/    //con =DriverManager.getConnection("jdbc:sqlserver://10.0.0.66:1433;databaseName=BBC_PROD3;selectMethod=cursor","bicyclebuys","bicyclebuys" );
		 con =DriverManager.getConnection("jdbc:sqlserver://10.0.0.66:1433;databaseName=BBC_PROD;selectMethod=cursor","bicyclebuys","bicyclebuys" );
	    //con=DriverManager.getConnection("jdbc:sqlserver://182.50.129.94:1433;databaseName=BBC_PROD;selectMethod=cursor","tambbc","Tamagna@2014" );
	    st = con.createStatement();
		return st;
	 } 
	public void close() 
	 {
		try
		 { 
			if (st != null)
			{
				st.close();
			}
			if (con != null) 
			{
				con.close();
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
 }

