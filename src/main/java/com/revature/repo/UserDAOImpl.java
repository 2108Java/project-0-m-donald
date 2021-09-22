package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.models.Customer;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	ConnectionUtil connectionUtil = new ConnectionUtil();

	@Override
	public User selectUserByUsername(String username) {
		// TODO Auto-generated method stub
		
		User user = new User();
		try
		{
			Connection connection = connectionUtil.getConnection();
			
			String sql = "SELECT * FROM user_table WHERE username = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, username);
			
		//	ps.executeQuery();	
			
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
			
			 user.setUser_id(rs.getInt("user_id"));
			 user.setPassword(rs.getString("passwrd"));
			 user.setUsername(rs.getString("username"));
			
			}
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public int createUser(User user) {
		
		boolean success = false;
		int userID = 0;
		
		try {
		Connection connection = connectionUtil.getConnection();
//		
		String sql = "INSERT INTO user_table (username, passwrd) VALUES (?,?)";
//		
		PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//		
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		
		ps.executeUpdate();
		
		ResultSet rs = ps.getGeneratedKeys();

		if(rs.next()) {
			userID = rs.getInt(1);
		
		}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return userID;
		
	}




}
