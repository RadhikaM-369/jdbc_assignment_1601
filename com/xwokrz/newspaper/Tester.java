package com.xwokrz.newspaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {
	static String url="jdbc:mysql://localhost:3306/jdbc";
	static String userName="root";
	static String password="SQL123456789";
	static String sqlStatement="insert into jdbc.newspaper values(1,'kannada','vijaykarntaka', 16, 18),"
			+"(2,'kannada','KannadaPrabha', 18, 20),"
			+ "(3,'English','Times of India',20,22),"
			+ "(4,'english','The indian express',20,22),(5,'kannada','prajaVani',20,22),"
			+ "(6,'english','The economics times',18,25)";
		
	static String updateStatement="update jdbc.newspaper set Nname='Business standards' where newsId=6";
	
	static String deleteStatement="delete from jdbc.newspaper where newsId=3";
	
	public static void main(String[] args) throws Exception {
		Connection connection=null;
		
		 try {
			 connection=DriverManager.getConnection(url, userName, password);	
			 System.out.println(connection+url);
			 
			 Statement statement=connection.createStatement(); 
			
		//	 statement.executeUpdate(sqlStatement);
			// statement.executeUpdate(updateStatement);
		   statement.executeUpdate(deleteStatement);
			 System.out.println("Query executed");
		 }
		 
	catch(SQLException e) {
		System.out.println("Query is not executed"+e.getMessage());
	}
		 
	finally {
		try {
				if(connection!=null) {
				connection.close();
			}	else {
				System.out.println("Connection is not created");
			}
		}
		catch(SQLException e) {
			
		}
	
}
}
}