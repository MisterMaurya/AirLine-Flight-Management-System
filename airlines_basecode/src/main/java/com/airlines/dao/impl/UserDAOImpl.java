package com.airlines.dao.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.airlines.controller.Encryption;
import com.airlines.controller.Register;
import com.airlines.dao.api.UserDAO;
import com.airlines.entity.User;
import com.airlines.frames.ValidateOTP;
import com.airlines.util.DBConnect;

public class UserDAOImpl implements UserDAO {
	private static ResultSet rs = null;

	public boolean saveUser(User user) {
		PreparedStatement ps;
		ps = DBConnect.preparedStatement(
				"insert into user(userName,email,password,fullName,dob,address,contact,gender,role,status,OTP,OTPTime) values(?,?,?,?,?,?,?,?,?,?,?,?)");

		try {
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFullName());
			ps.setString(5, user.getDob());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getContact());
			ps.setString(8, user.getGender());
			ps.setString(9, user.getUserRole());
			ps.setString(10, user.getStatus());
			ps.setString(11, user.getOtp());
			ps.setString(12, user.getOtpTime());

			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			System.out.println("Exception : " + e);
			return false;
		}

	}

	public boolean deleteUser(User user) {

		return false;
	}

	public List<User> getAllUser() {
		List<User> list = new ArrayList<User>();
		PreparedStatement ps = DBConnect.preparedStatement("SELECT * FROM USER");
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setFullName(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setContact(rs.getString(8));
				user.setGender(rs.getString(9));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public User getUserByUserName(String userName) {
		PreparedStatement ps = DBConnect.preparedStatement("SELECT *FROM USER WHERE USERNAME ='" + userName + "'");
		User user = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				user = new User();
				user.setUserName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setFullName(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setContact(rs.getString(8));
				user.setGender(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return user;
	}

	public User getUserByEmail(String email) {
		PreparedStatement ps = DBConnect.preparedStatement("SELECT *FROM USER WHERE EMAIL ='" + email + "'");
		User user = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs.next()) {
				user = new User();
				user.setUserName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setFullName(rs.getString(5));
				user.setDob(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setContact(rs.getString(8));
				user.setGender(rs.getString(9));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}

		return user;
	}

	public boolean updateUser(User user) throws Exception {
		int i = 0;

		PreparedStatement ps = DBConnect.preparedStatement(
				"Update user set userName=?,email=?,password=?,fullName=?,dob=?,address=?,contact=?,gender=? where email=?");
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getEmail());
		ps.setString(3, Encryption.encrptPass(user.getPassword()));
		ps.setString(4, user.getFullName());
		ps.setString(5, user.getDob());
		ps.setString(6, user.getAddress());
		ps.setString(7, user.getContact());
		ps.setString(8, user.getGender());
		ps.setString(9, user.getEmail());

		i = ps.executeUpdate();
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean validateOTP(String email, String code) throws Exception {
		ImageIcon icon = null;
		UIManager.put("OptionPane.background", Color.white);
		UIManager.put("Panel.background", Color.white);
		UIManager.put("OptionPane.minimumSize", new Dimension(700, 200));
		User user = new User();
		user.setStatus("Y");
		String name = null;
		String getOTP = null;
		String getOTPTime = null;
		String gender = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ps = DBConnect.preparedStatement("SELECT OTP,OTPTime,gender,fullName FROM USER WHERE email='" + email + "'");

		rs = ps.executeQuery();
		if (rs.next()) {
			getOTP = rs.getString("OTP");
			getOTPTime = rs.getString("OTPTime");
			gender = rs.getString("gender");
			name = rs.getString("fullName");
		}

		if (getOTP.equals(code)) {
			if (Register.timeDateDifference(getOTPTime)) {
				ps = DBConnect.preparedStatement("UPDATE USER SET STATUS=? WHERE email='" + email + "'");
				ps.setString(1, user.getStatus());
				ps.executeUpdate();
				ValidateOTP.frame.dispose();
				if (gender.equals("Male")) {
					icon = new ImageIcon("src/main/java/com/airlines/images/Bo.png");
				} else {
					icon = new ImageIcon("src/main/java/com/airlines/images/gi.png");
				}
				JLabel rLabel = new JLabel("Hello " + name + ", You have successfully registered");

				rLabel.setFont(new Font("sans-serif", Font.BOLD, 20));
				JOptionPane.showMessageDialog(null, rLabel, "Message from Airlines", JOptionPane.PLAIN_MESSAGE, icon);

			} else {

				ValidateOTP.errorL2.setForeground(Color.red);
				ValidateOTP.txtF.addMouseListener(new MouseListener() {

					public void mouseReleased(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
					}

					public void mouseEntered(MouseEvent e) {
					}

					public void mouseClicked(MouseEvent e) {
						ValidateOTP.txtF.setText(null);
						ValidateOTP.errorL2.setForeground(Color.white);
					}
				});
				return false;
			}
		} else {
			ValidateOTP.errorL1.setForeground(Color.red);

			ValidateOTP.txtF.addMouseListener(new MouseListener() {

				public void mouseReleased(MouseEvent e) {
				}

				public void mousePressed(MouseEvent e) {
				}

				public void mouseExited(MouseEvent e) {
				}

				public void mouseEntered(MouseEvent e) {
				}

				public void mouseClicked(MouseEvent e) {
					ValidateOTP.txtF.setText(null);
					ValidateOTP.errorL1.setForeground(Color.white);
				}
			});
			return false;
		}

		return true;
	}
}
