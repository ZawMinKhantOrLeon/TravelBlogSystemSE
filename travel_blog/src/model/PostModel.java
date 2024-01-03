package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import asset.CurrentUserSession;
import database.DbConnection;

public class PostModel {
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Boolean createPost(Post post) {
		
		Boolean isCreated=false;
		connection = DbConnection.getConnection();
		try {
			pstmt = connection.prepareStatement("INSERT INTO post (user_id,title,image,description) VALUES (?,?,?,?)");
		
			pstmt.setLong(1, CurrentUserSession.getId());
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
	
	
	public List<Post> showAllPost(){
		
		List<Post>  postList = new ArrayList<Post>();
		connection = DbConnection.getConnection();
		
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM POST");
			while(rs.next()) {
				postList.add(new Post(
						
						rs.getLong("id"),
						rs.getString("title"),
						rs.getString("image"),
						rs.getString("description"),
						rs.getDate("date").toLocalDate()
					));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postList;
	}
	
	public Boolean delete(Long id) {
		Boolean isDelete = false;
		connection = DbConnection.getConnection();
		try {
			pstmt= connection.prepareStatement("DELETE FROM post WHERE id=(?)");
			pstmt.setLong(1, id);
			Integer row = pstmt.executeUpdate();
			if(row > 0) {
				isDelete=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isDelete;
	}
}
