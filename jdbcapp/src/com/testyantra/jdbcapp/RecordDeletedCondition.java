package com.testyantra.jdbcapp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class RecordDeletedCondition {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt  = null;
		
		try {
			FileInputStream input =	new FileInputStream("db.properties");
			Properties pro =new Properties();
			pro.load(input);
			
			Class.forName(pro.getProperty("driver")).newInstance();
			conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);
			String query = " delete from employee_info where empid=103 and age=20";
			stmt = conn.createStatement();
			int count = stmt.executeUpdate(query);
			if(count > 0) {
				System.out.println("count deleted"+count);
			}else {
				System.out.println("not deleted");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
