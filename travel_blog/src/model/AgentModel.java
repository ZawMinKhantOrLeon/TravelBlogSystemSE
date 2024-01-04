package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DbConnection;

public class AgentModel {
		
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pstmt ;
	private ResultSet rs;
	
	private void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public Boolean createAgent(Agent agent) {
			
			Boolean isCreated=false;
			connection = DbConnection.getConnection();
			try {
				pstmt= connection.prepareStatement("INSERT INTO agent (name,phone,email,active) VALUES (?,?,?,?)");
				pstmt.setString(1, agent.getName());
				pstmt.setString(2, agent.getPhone());
				pstmt.setString(3, agent.getEmail());
				pstmt.setBoolean(4, agent.getActive());
				
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
	 
	 public List<Agent> showAllAgent()  {
			
	        List<Agent> agents = new ArrayList<Agent>();
			connection=DbConnection.getConnection();
			
			
				try {
					stmt=connection.createStatement();
					rs = stmt.executeQuery("SELECT * fROM agent");
					while(rs.next()) {
						agents.add(new Agent(
									
								rs.getLong("id"),
								rs.getString("name"),
								rs.getString("phone"),
								rs.getString("email"),
								rs.getBoolean("active")
						));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					closeConnection();
				}
			
			
			return agents;
		 }
	 
	 public Boolean delete(Long id) {
	    	Boolean isDelete = false;
			connection = DbConnection.getConnection();
			try {
				pstmt= connection.prepareStatement("DELETE FROM agent WHERE id=(?)");
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
	 
	 public Boolean update(Agent agent) {
	    	Boolean isUpdated=false;
			connection = DbConnection.getConnection();
			try {
				pstmt = connection.prepareStatement("UPDATE agent SET name=(?) , phone=(?) , email=(?) , active =(?) WHERE id=(?)");
				pstmt.setString(1, agent.getName());
				pstmt.setString(2, agent.getPhone());
				pstmt.setString(3, agent.getEmail());
			   	pstmt.setBoolean(4, agent.getActive());
			   	pstmt.setLong(5, agent.getId());
				
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
	 
	 public Agent getAgentById(Long id) {
 		Agent agent = null;
 		connection=DbConnection.getConnection();
 		try {
 			pstmt= connection.prepareStatement("SELECT * FROM agent WHERE id = (?)");
 			pstmt.setLong(1, id);
 			rs = pstmt.executeQuery();
 			if(rs.next()) {
 				
 				agent = new Agent(
 						rs.getLong("id"),
 						rs.getString("name"),
 						rs.getString("phone"),
 						rs.getString("email"),
 						rs.getBoolean("active")
 					);
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		finally {
 			closeConnection();
 		}
 		
 		return agent;
 	
 }
	     
		
}
