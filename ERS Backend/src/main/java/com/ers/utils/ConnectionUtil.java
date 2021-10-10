package com.ers.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//to manage and establish our database connection
public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		
		//register PostgreSQL driver
		try {
			Class.forName("org.postgresql.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); 
			System.out.println("problem occurred locating driver");
		}
		
		//use database credentials to establish a database connection
		String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=ers";
		String username = "postgres";
		String password = "password";
		
		//returns the actual database Connection object
		return DriverManager.getConnection(url, username, password);
	}

}
