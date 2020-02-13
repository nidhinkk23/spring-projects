package com.testyantra.jdbcapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class PreparedStatementsUpdate {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		
		try {
			//1.Load the Driver
					
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			//2.establishing the connection via driver
		 
			String dburl = "jdbc:mysql://localhost:3306/info_employee_db";
			conn = DriverManager.getConnection(dburl, "root", "root");



			//3.Issue the sql query via connection

			String query="update employee_info set ename=?"
					+ "where empid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, args[0]);
			pstmt.setInt(2,Integer.parseInt(args[1]));
			int count=pstmt.executeUpdate();
			//4.process the result returned sql query
			if(count>0) {
				System.out.println("Updated");
			}else {
				System.out.println("Not Updated");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn !=null) {
					conn.close();
				}
				if(pstmt !=null) {
					pstmt.close();
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

}
