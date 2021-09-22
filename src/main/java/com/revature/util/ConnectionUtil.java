package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	private static final String URL = "localhost:5432";
	// database-1.ccxgyhzlbz4s.us-east-2.rds.amazonaws.com/postgres
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "miaduuh1";
	private String dbLocation = "localhost:5432";
	private String username = "postgres";
	private String password = "miaduuh1";
	private String url = "jdbc:postgresql://" + dbLocation + "/postgres";

	public Connection getConnection() throws SQLException {
		
	//	Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
		
		
	}
	
}
