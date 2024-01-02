package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import asset.CurrentUserSession;
import database.DbConnection;

public class PostModel {
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private final CurrentUserSession currentUserSession = new CurrentUserSession();
	
	public Boolean createPost(Post post) {
		
		Boolean isCreated=false;
		connection = DbConnection.getConnection();
		try {
			pstmt = connection.prepareStatement("INSERT INTO post (user_id,title,image,description) VALUES (?,?,?,?)");
		
			pstmt.setLong(1, currentUserSession.getId());
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getImage());
			pstmt.setString(4, post.getDescription());
			
			
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
}
