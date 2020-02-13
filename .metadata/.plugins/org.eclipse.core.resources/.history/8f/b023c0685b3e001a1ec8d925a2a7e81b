package com.testyantra.jdbcapp;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class PreparedStatements {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt  = null;
		ResultSet  rs = null;
		try {
			//1.Load the Driver
					
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			//2.establishing the connection via driver
		 
			String dburl = "jdbc:mysql://localhost:3306/info_employee_db";
			conn = DriverManager.getConnection(dburl, "root", "root");



			//3.Issue the sql query via connection

			String query="select * from employee_info "
					+ "where empid=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(args[0]));
			rs=pstmt.executeQuery();
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
				if(pstmt !=null) {
					pstmt.close();
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
