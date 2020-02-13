package com.testyantra.jdbcapp;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MyFirstJDBC {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt  = null;
		ResultSet  rs = null;
		try {
			FileInputStream input =	new FileInputStream("db.properties");
			Properties pro =new Properties();
			pro.load(input);
			
					
			Class.forName(pro.getProperty("driver")).newInstance();

			//2.establishing the connection via driver
			
			conn = DriverManager.getConnection(pro.getProperty("dburl"), pro);



			//3.Issue the sql query via connection

			String query="select * from employee_info";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			//4.process the result returned sql query
			while (rs.next()) {
				int employeeId = rs.getInt("empid");
				String name = rs.getString("ename");
				int age = rs.getInt("age");
				String password = rs.getString("password");
				String email = rs.getString("email");
				int salary = rs.getInt("salary");
				long mobile = rs.getLong("mobile");
				System.out.println("employeeId "+employeeId);
				System.out.println("name "+name);
				System.out.println("age "+age);
				System.out.println("password "+password);
				System.out.println("email "+email);
				System.out.println("salary "+salary);
				System.out.println("mobile "+mobile);
				System.out.println("*************");
			}

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
				if(rs !=null) {
					rs.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}


	}
}
