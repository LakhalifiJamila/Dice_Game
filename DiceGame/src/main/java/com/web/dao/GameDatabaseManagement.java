package com.web.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bo.User;
import com.web.helpers.IGameDataManagement;

public class GameDatabaseManagement implements IGameDataManagement{

	private static GameDatabaseManagement instance;
	
	private String connexionString= "jdbc:mariadb://localhost:3306/dicesgamedb?user=root&password=";
	
	private GameDatabaseManagement() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	synchronized public static final GameDatabaseManagement getInstance() {
		if(instance==null) {
			instance= new GameDatabaseManagement();
		}
		return instance;
	}

	@Override
	public List<User> getAllUsers() {
		
		Connection con= null;
		List<User> list= new ArrayList<>();
		
		try {
			con= DriverManager.getConnection(connexionString);
			
			try {
				Statement st= con.createStatement();
				
				ResultSet rs= st.executeQuery("select * from Users");
				
				while(rs.next()) {
					User user= new User(rs.getString("firstName"), rs.getString("lastName"), rs.getString("login"), rs.getString("password"), rs.getInt("actualScore"), rs.getInt("bestScore"));
					list.add(user);
				}
			}finally {
				if(con != null) {
					con.close();
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return list;
	}

	@Override
	public void updateBestScore(User user) {
		Connection con= null;
		
		try {
			con= DriverManager.getConnection(connexionString);
			
			try {
				PreparedStatement pstmt= con.prepareStatement("Update Users set bestScore= ? where login= ? ");
				pstmt.setInt(1, user.getBestScore());
				pstmt.setString(2, user.getLogin());
				
				pstmt.executeUpdate();
			}finally {
				if(con!=null) {
					con.close();
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void insertUser(User user) {
		Connection con= null;
		try {
			con= DriverManager.getConnection(connexionString);
			try {
				PreparedStatement pstmt= con.prepareStatement("insert into Users(firstName, lastName, login, password, actualScore, bestScore) values(?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, user.getFirstName());
				pstmt.setString(2, user.getLastName());
				pstmt.setString(3, user.getLogin());
				pstmt.setString(4, user.getPassword());
				pstmt.setInt(5, user.getActualScore());
				pstmt.setInt(6, user.getBestScore());
				
				pstmt.executeUpdate();
			}finally {
				if(con != null) {
					con.close();
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public User getUserByLogin(String login) {
		Connection con= null;
		User user= null;
		try {
			con= DriverManager.getConnection(connexionString);
			try {
				PreparedStatement pstmt= con.prepareStatement("select * from Users where login= ?");
				pstmt.setString(1, login);
				
				ResultSet rs= pstmt.executeQuery();
				
				while(rs.next()) {
					User u= new User(rs.getString("firstName"), rs.getString("lastName"), rs.getString("login"), rs.getString("password"), rs.getInt("actualScore"), rs.getInt("bestScore"));
					user= u;
				}
			}finally {
				if(con!=null) {
					con.close();
				}
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return user;
	}
}
