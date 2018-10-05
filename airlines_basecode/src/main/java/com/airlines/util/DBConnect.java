package com.airlines.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	final private static String USR = "root";
	final private static String PWD = "mysql";
	final private static String URL = "jdbc:mysql://localhost:3306/airlines?useSSL=false";

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USR, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return con;
	}

	public static Statement getStatement() {
		Statement st;
		try {
			st = getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return st;
	}

	public static PreparedStatement preparedStatement(String query) {
		PreparedStatement ps;
		try {
			ps = getConnection().prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ps;
	}
}
