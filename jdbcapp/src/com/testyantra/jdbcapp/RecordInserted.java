package com.testyantra.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RecordInserted {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt  = null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String dburl = "jdbc:mysql://localhost:3306/info_employee_db";
			conn = DriverManager.getConnection(dburl, "root", "root");
			String query = " insert into employee_info values(103,'arjun',23,'123',1000,'arjun@gmail.com',1234123412)";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(query);
			

			System.out.println("count"+count);


		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(conn !=null) {
					conn.close();
				}
				if(stmt !=null) {
					stmt.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
