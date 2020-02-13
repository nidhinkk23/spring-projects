package com.testyantra.jdbcapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class PreparedStatementsInsert {
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

			String query="insert into employee_info "
					+ "values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2,args[1]);
			pstmt.setInt(3, Integer.parseInt(args[2]));
			pstmt.setString(4, args[3]);
			pstmt.setInt(5, Integer.parseInt(args[4]));
			pstmt.setString(6, args[5]);
			pstmt.setLong(7, Long.parseLong(args[6]));
			
			int count=pstmt.executeUpdate();
			//4.process the result returned sql query
			if(count>0) {
				System.out.println("Inserted");
			}else {
				System.out.println("Not Inserted");
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
