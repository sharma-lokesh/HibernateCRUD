/**
 * 
 */
package com.lokesh.sharma.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Lokesh
 *
 */
public class TestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		try {
			System.out.println("Connecting to DB " + jdbcUrl);
			//Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection Successfull !!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
