package test;

import java.sql.Connection;

import database.DbConnection;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = DbConnection.getConnection();
		
		if(connection != null) {
			System.out.println("Connection Successfully Created");
		}
		else {
			System.out.println("Connection Fail");
		}
	}

}
