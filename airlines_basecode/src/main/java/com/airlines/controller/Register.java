package com.airlines.controller;

import java.awt.Color;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airlines.dao.impl.UserDAOImpl;
import com.airlines.entity.User;
import com.airlines.frames.Registration;
import com.airlines.util.DBConnect;

public class Register {
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static final Font f = new Font("sans-serif", Font.BOLD, 20);
	static public String email = null;

	public static boolean userServices() throws Exception {
		if (isValidName() == false) {
			Registration.errorL.setText("Please enter a valid name");
		
		} else if (isValidUserName(Registration.userNameTF.getText()) == false) {
			Registration.errorL.setText("Please enter a valid Username name");

		} else if (isUserNameExists(Registration.userNameTF.getText()) == true) {
			Registration.errorL.setText("The username '" + Registration.userNameTF.getText()
					+ "' already exists. Please use a different username!");
		} else if (isValidEmailPattern(Registration.emailTF.getText()) == false) {
			Registration.errorL.setText("Please enter a valid email");
		} else if (isEmailExists(Registration.emailTF.getText()) == true) {
			Registration.errorL.setText("The Email Addresss'" + Registration.emailTF.getText()
					+ "' already exists. Please use a different Email!");
		} else if (isValidPassword() == false) {
			Registration.errorL.setText("Password should be greater than 6 digit");
		} else if (isDOBEnter() == true) {
			Registration.errorL.setText("Enter date of birth");
		} else if (isValidContact(Registration.contactTF.getText()) == false) {
			Registration.errorL.setText("Please enter a valid contact ");
		} else if (isContactExists() == true) {
			Registration.errorL.setText("The Contact '" + Registration.contactTF.getText()
					+ "' already exists. Please use a different Contact!");
		} else if (isValidAddress() == false) {
			Registration.errorL.setText("Please enter a valid address ");
		}

		else {

			User user = new User();
			UserDAOImpl register = new UserDAOImpl();
			String pass=new String(Registration.passwordF.getPassword());
			email = Registration.emailTF.getText();
			user.setFullName(Registration.fullNameTF.getText());
			user.setUserName(Registration.userNameTF.getText());
			user.setEmail(Registration.emailTF.getText());
			user.setPassword(Encryption.encrptPass(pass));
			user.setDob(Registration.dobDP.getJFormattedTextField().getText());
			user.setGender(Registration.group.getSelection().getActionCommand());
			user.setContact(Registration.contactTF.getText());
			user.setAddress(Registration.addressTF.getText());
			user.setUserRole("ROLE_USER");
			user.setStatus("N");
			String otp = generateOTP();
			OTP.mailAPI(Registration.emailTF.getText(),
					msg(otp, Registration.fullNameTF.getText()));
			user.setOtp(otp);
			user.setOtpTime(currentDateTime());
			boolean b = register.saveUser(user);
			Registration.errorL.setForeground(Color.white);
			Registration.fullNameTF.setText(null);
			Registration.userNameTF.setText(null);
			Registration.emailTF.setText(null);
			Registration.passwordF.setText(null);
			Registration.dobDP.getJFormattedTextField().setText(null);
			Registration.group.getSelection();
			Registration.addressTF.setText(null);
			Registration.contactTF.setText(null);
			return b;
		}
		return false;
	}

	// Validate FullName
	private static boolean isValidName() {
		if (Registration.fullNameTF.getText().length() >= 2) {
			Pattern p = Pattern.compile("[a-zA-z][a-zA-Z\\s]*");
			Matcher m = p.matcher(Registration.fullNameTF.getText());
			return m.matches();
		}
		return false;
	}

	// Validate Username
	public static boolean isValidUserName(String userName) {
		Pattern p = Pattern.compile("[a-zA-z][a-zA-Z0-9]*");
		Matcher m = p.matcher(userName);
		return m.matches();
	}

	// Validate Username already exists or not
	public static boolean isUserNameExists(String userName) throws SQLException {
		String query = "select * from user where userName='" + userName + "'";
		return DBConnect.preparedStatement(query).executeQuery().next();
	}

	// Validate Email Pattern
	public static boolean isValidEmailPattern(String email) {
		
			Pattern p = Pattern.compile("[a-zA-z][a-zA-z0-9._]*@[a-zA-z]+([.][a-zA-z]+)+");
			
			Matcher m = p.matcher(email);
			return m.matches();
		
	}

	// Validate Email already exists or not
	public static boolean isEmailExists(String email) throws SQLException {
		String query = "select * from user where email='" + email + "'";
		return DBConnect.preparedStatement(query).executeQuery().next();

	}

	// Validate Password
	private static boolean isValidPassword() {
		return Registration.passwordF.getPassword().length > 6;
	}

	// Validate Date of Birth
	private static boolean isDOBEnter() {
		if (Registration.dobDP.getJFormattedTextField().getText().length() > 0) {
			return false;
		}
		return true;
	}

	// Validate Contact
	private static boolean isValidContact(String contact) {
		Pattern p = Pattern.compile("(0|91)?[789][0-9]{9}");
		Matcher m = p.matcher(contact);
		return m.matches();
	}

	// Validate Contact already exists or not
	private static boolean isContactExists() throws SQLException {
		String query = "select * from user where contact='" + Registration.contactTF.getText() + "'";
		return DBConnect.preparedStatement(query).executeQuery().next();
	}

	// Validate Address
	private static boolean isValidAddress() {
		if (Registration.addressTF.getText().length() >= 12) {
			Pattern p = Pattern.compile("[a-zA-Z][a-zA-Z0-9\\s-/]*");
			Matcher m = p.matcher(Registration.addressTF.getText());
			return m.matches();
		}
		return false;
	}

	public static String msg(String otp, String name) {
		return "Hey " + name + ","
				+ "You registered for Airlines.\nYou may be asked to enter this OTP(One Time Passcode) code : " + otp;
	}

	public static String msgReset(String otp,String email) {
		return "Dear Airline User,\nWe recevied a request to access your Airline Account "+email+" through your email address.\nYour Ailrine verification code is : " + otp;
	}

	
	
	
	public static String generateOTP() {
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		Random rnd = new Random();
		String generate = "";
		for (int i = 0; i < 6; i++) {
			generate = generate + chars[rnd.nextInt(chars.length)];
		}
		return generate;
	}

	public static String currentDateTime() {
		Date otpTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		return sdf.format(otpTime);
	}

	public static boolean timeDateDifference(String start) throws Exception {
		Date d1 = null;
		Date d2 = null;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		d1 = format.parse(start);
		d2 = format.parse(currentDateTime());
		long diff = d2.getTime() - d1.getTime();

		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.println(diffMinutes);
		if (diffHours == 0 && diffDays == 0 && diffMinutes < 2) {
			return true;
		}
		return false;

	}
}
