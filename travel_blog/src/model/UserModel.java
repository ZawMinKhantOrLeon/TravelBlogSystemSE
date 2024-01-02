package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import asset.CurrentUserSession;
import database.DbConnection;


public class UserModel {
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Boolean login(User user)  {
		
		Boolean check = false;;
		connection=DbConnection.getConnection();
		try {
			pstmt= connection.prepareStatement("SELECT email FROM user WHERE email = (?)");
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}
	
	public Boolean register(User user) {
		
		Boolean isCreated=false;
		connection = DbConnection.getConnection();
		try {
			pstmt = connection.prepareStatement("INSERT INTO user (name,email,password) VALUES (?,?,?)");
			System.out.println(user.getName());
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			
			int row=pstmt.executeUpdate();
			if(row >0) {
				isCreated=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isCreated;
	}
	
	public Long getUserInfo(User user) {
		Long id = null;
		connection=DbConnection.getConnection();
		try {
			pstmt= connection.prepareStatement("SELECT id FROM user WHERE email = (?)");
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id=rs.getLong("id");
				CurrentUserSession.setId(id);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	
}
