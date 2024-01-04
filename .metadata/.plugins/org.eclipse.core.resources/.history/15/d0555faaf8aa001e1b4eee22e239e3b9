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


public class UserModel {
	
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
	
	public Boolean login(User user)  {
		
		Boolean check = false;;
		connection=DbConnection.getConnection();
		try {
			
			rs = DQSQuery("SELECT * FROM user WHERE name = ? AND email = ? AND password= ? ;",user).executeQuery();
			if(rs.next()) {
				check=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return check;
	}
	
	public Boolean register(User user) {
		
		Boolean isCreated=false;
		connection = DbConnection.getConnection();
		try {
			int row=DQSQuery("INSERT INTO user (name,email,password) VALUES (?,?,?)",user).executeUpdate();
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
	
     public Boolean createUser(User user) {
		
		Boolean isCreated=false;
		connection = DbConnection.getConnection();
		try {
			pstmt= connection.prepareStatement("INSERT INTO user (name,email,password) VALUES (?,?,?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getRole());
			
			int row =pstmt.executeUpdate();
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
	
     public List<User> showAllUser()  {
		
        List<User> users = new ArrayList<User>();
		connection=DbConnection.getConnection();
		
		
			try {
				stmt=connection.createStatement();
				rs = stmt.executeQuery("SELECT * fROM user");
				while(rs.next()) {
					users.add(new User(
								
							rs.getLong("id"),
							rs.getString("name"),
							rs.getString("email"),
							rs.getString("password"),
							rs.getString("role")
					));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				closeConnection();
			}
		
		
		return users;
	 }
     
    public Boolean delete(Long id) {
    	Boolean isDelete = false;
		connection = DbConnection.getConnection();
		try {
			pstmt= connection.prepareStatement("DELETE FROM user WHERE id=(?)");
			pstmt.setLong(1, id);
			Integer row = pstmt.executeUpdate();
			if(row > 0) {
				isDelete=true;
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
    
    public Boolean update(User user) {
    	Boolean isUpdated=false;
		connection = DbConnection.getConnection();
		try {
			pstmt = connection.prepareStatement("UPDATE user SET name=(?) , email=(?) , password=(?) , role =(?) WHERE id=(?)");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
		   	pstmt.setString(4, user.getRole());
		   	pstmt.setLong(5, user.getIt());
			
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
    
    public User getUserById(Long id) {
    		User user = null;
    		connection=DbConnection.getConnection();
    		try {
    			pstmt= connection.prepareStatement("SELECT id,role FROM user WHERE id = (?)");
    			pstmt.setLong(1, id);
    			rs = pstmt.executeQuery();
    			if(rs.next()) {
    				
    				user = new User(
    						rs.getLong("id"),
    						rs.getString("name"),
    						rs.getString("email"),
    						rs.getString("password"),
    						rs.getString("role")
    					);
    			}
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		finally {
    			closeConnection();
    		}
    		
    		return user;
    	
    }
	
	public void getUserInfo(User user) {
		connection=DbConnection.getConnection();
		try {
			pstmt= connection.prepareStatement("SELECT id,role FROM user WHERE email = (?)");
			pstmt.setString(1, user.getEmail());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				CurrentUserSession.setId(rs.getLong("id"));
				CurrentUserSession.setRole(rs.getString("role"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		
	}
	
	
	
	//utility
	
	private PreparedStatement DQSQuery(String query,User user) throws SQLException {
		pstmt= connection.prepareStatement(query);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getPassword());
		
		return pstmt;
	}
	
	
}
