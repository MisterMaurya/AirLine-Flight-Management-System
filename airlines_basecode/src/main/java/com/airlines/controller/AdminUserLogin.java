package com.airlines.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airlines.frames.AdminWelcome;
import com.airlines.frames.Login;
import com.airlines.frames.UserWelcome;
import com.airlines.frames.ValidateOTP;
import com.airlines.util.DBConnect;

public class AdminUserLogin {

	static PreparedStatement ps = null;
	static boolean check = false;

	public static void loginEmailServices(String email) throws Exception {
		System.out.println(Login.passwordF.getPassword());
		String name = null;
		String pass = new String(Login.passwordF.getPassword());
		String getStautsAndRole[] = getStatus(email);
		ps = DBConnect.preparedStatement("select password,fullName from user where email='" + email + "'");
		try {
			check = matchPassword(ResultSet(ps)[0], Encryption.encrptPass(pass));

			name = ResultSet(ps)[1];
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (check) {
			if (getStautsAndRole[1].equals("ROLE_ADMIN")) {
				if (getStautsAndRole[0].equals("Y")) {
					AdminWelcome.assistant();
					Login.frame.dispose();
				} else {
				}
			} else {
				if (getStautsAndRole[0].equals("Y")) {
					UserWelcome.welcomeFrame(email);
					Login.frame.dispose();
				} else {
					System.out.println(Login.userTF.getText() + "*");
					Login.passwordF.setText("");
					Login.userTF.setText("");
					Login.errorL.setText("");
					String otp = Register.generateOTP();
					ps = null;
					ps = DBConnect.preparedStatement("UPDATE USER SET OTP=?,OTPTime=? WHERE email='" + email + "'");
					ps.setString(1, otp);
					ps.setString(2, Register.currentDateTime());
					ps.executeUpdate();

					OTP.mailAPI(email, Register.msg(otp, name));

					ValidateOTP.otpFrame(email);
				}
			}
		} else {
			Login.errorL.setForeground(new Color(216, 0, 12));

			Login.frame.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {

					Login.errorL.setForeground(Color.white);

				}
			});

			Login.passwordF.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {
					Login.passwordF.setText(null);
					Login.errorL.setForeground(Color.white);

				}
			});
		}
	}

	public static void loginUserNameServices(String userName) throws Exception {
		String email = null;
		String name = null;
		String pass = new String(Login.passwordF.getPassword());
		email = getEmail(userName);
		String getStautsAndRole[] = getStatus(email);
		ps = DBConnect.preparedStatement("select password,fullName from user where userName='" + userName + "'");
		try {
			check = matchPassword(ResultSet(ps)[0], Encryption.encrptPass(pass));
			name = ResultSet(ps)[1];
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (check) {
			if (getStautsAndRole[1].equals("ROLE_ADMIN")) {
				if (getStautsAndRole[0].equals("Y")) {
					AdminWelcome.assistant();
					Login.frame.dispose();
				} else {
				}
			} else {
				if (getStautsAndRole[0].equals("Y")) {
					UserWelcome.welcomeFrame(email);
					Login.frame.dispose();
				} else {
					Login.passwordF.setText("");
					Login.userTF.setText("");
					Login.errorL.setText("");
					String otp = Register.generateOTP();
					ps = null;
					ps = DBConnect.preparedStatement("UPDATE USER SET OTP=?,OTPTime=? WHERE email='" + email + "'");
					ps.setString(1, otp);
					ps.setString(2, Register.currentDateTime());
					ps.executeUpdate();
					System.out.println(Register.currentDateTime());
					OTP.mailAPI(email, Register.msg(otp, name));
					ValidateOTP.otpFrame(email);
				}
			}
		} else {
			Login.errorL.setForeground(new Color(216, 0, 12));
			Login.passwordF.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					Login.errorL.setForeground(Color.white);

				}
			});

			Login.frame.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {

					Login.errorL.setForeground(Color.white);

				}
			});
		}

	}

	private static String getEmail(String userName) throws SQLException {
		ps = DBConnect.preparedStatement("select email from user where userName='" + userName + "'");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getString("email");
		}
		return null;
	}

	private static String[] ResultSet(PreparedStatement ps) throws SQLException {
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new String[] { rs.getString("password"), rs.getString("fullName") };
		}
		return null;
	}

	private static boolean matchPassword(String password, String passwordF) {
		if (password.equals(passwordF)) {
			return true;
		} else
			return false;
	}

	private static String[] getStatus(String email) throws Exception {
		ps = DBConnect.preparedStatement("select status,role from user where email='" + email + "'");
		ResultSet rs = null;

		rs = ps.executeQuery();
		if (rs.next()) {
			return new String[] { rs.getString("status"), rs.getString("role") };
		}
		return null;
	}

}
