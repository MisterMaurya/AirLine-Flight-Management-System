package com.airlines.controller;

import java.sql.SQLException;

import com.airlines.util.DBConnect;
import com.mysql.jdbc.PreparedStatement;


public class ResetPassword {
	private static String otp = null;
	static PreparedStatement ps = null;
	private static String getEmail=null;
	
	public static void sendCode(String email) throws SQLException {
		otp = Register.generateOTP();
		getEmail=email;
		ps = (PreparedStatement) DBConnect.preparedStatement("Update User set Otp=?,otptime=? where email=?");
		ps.setString(1, otp);
		ps.setString(2, Register.currentDateTime());
		ps.setString(3, email);
		ps.executeUpdate();
		String msg = Register.msgReset(otp, email);
		OTP.mailAPI(email, msg);
}

	public static boolean resetPass(String otpTF, String pass) throws Exception {
		if (otp.equals(otpTF)) {
			ps=null;
			ps = (PreparedStatement) DBConnect.preparedStatement("Update User set password=? where email=?");
			ps.setString(1, Encryption.encrptPass(pass));
			ps.setString(2, getEmail);
			ps.executeUpdate();
			return true;
		}

		return false;
	}
}
