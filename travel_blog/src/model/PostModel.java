package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import database.DbConnection;
import session.CurrentUserSession;

public class PostModel {
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Boolean createPost(Post post) {
		
		Boolean isCreated=false;
		connection = DbConnection.getConnection();
		try {
			pstmt = connection.prepareStatement("INSERT INTO post (user_id,title,image,description,author) VALUES (?,?,?,?,?)");
		
			pstmt.setLong(1, CurrentUserSession.getId());
			pstmt.setString(2, post.getTitle());
			pstmt.setString(3, post.getImage());
			pstmt.setString(4, post.getDescription());
			pstmt.setString(5, CurrentUserSession.getName());
			
			
			int row=pstmt.executeUpdate();
			if(row >0) {
				isCreated=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
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
							rs.getString("author"),
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
			finally {
				closeConnection();
			}
		
		
		
		return postList;
	}
	
public Optional<Post> showPostById(Long id){
		
		
		connection = DbConnection.getConnection();
		
		Optional<Post> optionalPost= Optional.empty();
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery("SELECT * FROM POST WHERE id = '"+ id+"';");
				while(rs.next()) {
					 optionalPost= Optional.of(new Post(
								
								rs.getLong("id"),
								rs.getLong("user_id"),
								rs.getString("author"),
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
			
		
		
		
		return optionalPost;
		
          }
	
	public Boolean delete(Long id) {
		Boolean isDelete = false;
		connection = DbConnection.getConnection();
		Optional<Post> optionalPost = showPostById(id);
		try {
			
			if(optionalPost.isPresent()) {
				Post post = optionalPost.get();
				if(post.getUser_id() == CurrentUserSession.getId()) {
					pstmt= connection.prepareStatement("DELETE FROM post WHERE id=(?)");
					pstmt.setLong(1, id);
					Integer row = pstmt.executeUpdate();
					if(row > 0) {
						isDelete=true;
					}
				}else {
					System.out.println("\033[1;31m This is not your post , therefore you cannot delete this post \033[0m");
					return isDelete;
				}
			}
			else {
				System.out.println("\033[1;31m There is no such post \033[0m");
				return isDelete;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return isDelete;
	}
	
	
	public Boolean update(Post post) {
			
		Boolean isUpdated=false;
		connection = DbConnection.getConnection();
		try {
			pstmt = connection.prepareStatement("UPDATE POST SET title=(?) , image=(?) , description=(?) WHERE id=(?)");
		
			pstmt.setString(1, post.getTitle());
			pstmt.setString(2, post.getImage());
			pstmt.setString(3, post.getDescription());
		   	pstmt.setLong(4, post.getId());
			
			int row=pstmt.executeUpdate();
			if(row >0) {
				isUpdated=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return isUpdated;
	}
	
}
