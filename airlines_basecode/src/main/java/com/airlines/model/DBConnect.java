package com.airlines.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	final private static String USR = "root";
	final private static String PWD = "1000";
	final private static String URL = "jdbc:mysql//localhost:3306/airlinedatebase";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, USR, PWD);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static Statement getStatement() {
		Statement st = DBConnect.getStatement();
		return st;

	}

	public static PreparedStatement preparedStatement(String query) {
		PreparedStatement ps = DBConnect.preparedStatement(query);
		return ps;

	}
}
