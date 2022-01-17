package com.xwokrz.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {
	static String url="jdbc:mysql://localhost:3306/jdbc";
	static String userName="root";
	static String password="SQL123456789";
	static String sqlStatement="insert into jdbc.company values(1,'TCS','Pune','CGR2',true,200000,280,1654.12),"
			+ "(2,'Wipro','Hyderabad','CGR3',true,1506252,385,1325.11),(4,'TechMahindra','Chennai','CGR2',true,154211,200,1123.54),"
			+ "(3,'TATA','Mumbai','CGR2',true,3654211,400,1523.54),(5,'Accenture','Bangalore','CGR3',true,254211,180,1223.74)";
		
	static String updateStatement="update jdbc.company set companyName='Capgemini' where Id=2";
	
	static String deleteStatement="delete from jdbc.company where Id=3";
	
	public static void main(String[] args) throws Exception {
		Connection connection=null;
		
		 try {
			 connection=DriverManager.getConnection(url, userName, password);	
			 System.out.println(connection+url);
			 
			 Statement statement=connection.createStatement(); 
			
			// statement.executeUpdate(sqlStatement);
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