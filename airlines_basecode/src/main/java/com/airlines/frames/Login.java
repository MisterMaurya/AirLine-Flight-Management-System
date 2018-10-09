package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.airlines.controller.AdminUserLogin;
import com.airlines.controller.Register;

public class Login {

	public static JPasswordField passwordF;
	public static JTextField userTF;
	public static JLabel errorL;
	public static JFrame frame;

	public static void loginFrame() throws Exception {

		frame = new JFrame();
		frame.setLayout(null);
		Font f = new Font("SansSerif", Font.BOLD, 40);

		JLabel heading;
		JLabel loginL;
		heading = new JLabel("Airline", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 1200, 100);
		heading.setOpaque(true);
		heading.setBackground(new Color(9, 195, 218));
		heading.setForeground(Color.WHITE);
		heading.setFont(f);

		loginL = new JLabel("Member Login", SwingConstants.CENTER);
		loginL.setVerticalAlignment(SwingConstants.CENTER);
		loginL.setBounds(0, 120, 1200, 100);
		loginL.setOpaque(true);
		loginL.setBackground(Color.white);
		loginL.setForeground(Color.BLACK);
		loginL.setFont(new Font("SansSerif", Font.BOLD, 50));

		JLabel userLabel = new JLabel("Email or Username");
		userLabel.setForeground(new Color(149, 146, 146));
		userLabel.setFont(new Font("Courier", Font.PLAIN, 25));
		userLabel.setBounds(400, 240, 400, 50);

		Border txtBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(9, 195, 218));
		userTF = new JTextField();
		userTF.setBounds(400, 290, 400, 50);
		userTF.setFont(new Font("Verdana", Font.PLAIN, 20));
		userTF.setBorder(txtBorder);

		JLabel pwdlLabel = new JLabel("Password");
		pwdlLabel.setForeground(new Color(149, 146, 146));
		pwdlLabel.setFont(new Font("Courier", Font.PLAIN, 25));
		pwdlLabel.setBounds(400, 340, 400, 50);

		passwordF = new JPasswordField();
		passwordF.setBounds(400, 390, 400, 50);
		passwordF.setFont(new Font("Verdana", Font.PLAIN, 20));
		passwordF.setBorder(txtBorder);

		errorL = new JLabel("Invalid Username/Email or Password", SwingConstants.CENTER);

		errorL.setVerticalAlignment(SwingConstants.CENTER);
		errorL.setFont(new Font("Courier", Font.BOLD, 20));
		errorL.setForeground(Color.WHITE);
		errorL.setBounds(0, 620, 1200, 20);

		Border border = BorderFactory.createLineBorder(Color.white);
		JButton loginB = new JButton("Login");
		loginB.setBounds(400, 460, 400, 60);
		loginB.setBackground(new Color(9, 195, 218));
		loginB.setForeground(Color.WHITE);
		loginB.setFont(new Font("Courier", Font.BOLD, 25));
		loginB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginB.setBorder(border);
		loginB.setFocusPainted(false);
		loginB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Register.isValidUserName(userTF.getText()) || Register.isValidEmailPattern(userTF.getText())) {
					try {
						if (Register.isUserNameExists(userTF.getText()) || Register.isEmailExists(userTF.getText())) {

							if (Register.isValidEmailPattern(userTF.getText())) {
								AdminUserLogin.loginEmailServices(userTF.getText());
							} else {
								AdminUserLogin.loginUserNameServices(userTF.getText());

							}

						} else {
							errorL.setForeground(new Color(216, 0, 12));
							userTF.addMouseListener(new MouseAdapter() {

								public void mouseClicked(MouseEvent e) {
									userTF.setText(null);
									errorL.setForeground(Color.white);
								}
							});
							Login.frame.addMouseListener(new MouseAdapter() {

								public void mouseClicked(MouseEvent e) {
									userTF.setText(null);
									Login.errorL.setForeground(Color.white);

								}
							});
						}
					} catch (SQLException e1) {
					} catch (Exception e1) {
						e1.printStackTrace();
					}

				} else {
					errorL.setForeground(new Color(216, 0, 12));
					userTF.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent e) {
							userTF.setText(null);
							errorL.setForeground(Color.white);
						}
					});
					Login.frame.addMouseListener(new MouseAdapter() {

						public void mouseClicked(MouseEvent e) {
							userTF.setText(null);
							Login.errorL.setForeground(Color.white);

						}
					});
				}

			}
		});

		JButton forgotB = new JButton("Forgot your password?");
		forgotB.setBounds(400, 540, 400, 60);
		forgotB.setBackground(new Color(242, 242, 242));
		forgotB.setForeground(new Color(160, 160, 160));
		forgotB.setFont(new Font("Courier", Font.BOLD, 20));
		forgotB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		forgotB.setBorder(border);
		forgotB.setFocusPainted(false);
		forgotB.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ForgotPassword.forgotWindow();

			}
		});

		final JLabel rLabel = new JLabel("Not Registered? Create an account");
		rLabel.setBounds(440, 710, 340, 30);
		rLabel.setFont(new Font("Courier", Font.BOLD, 20));
		rLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Registration.registrationFrame();
				frame.dispose();
			}
		});

		frame.add(heading);
		frame.add(loginL);
		frame.add(userLabel);
		frame.add(userTF);
		frame.add(pwdlLabel);
		frame.add(passwordF);
		frame.add(loginB);
		frame.add(forgotB);
		frame.add(rLabel);
		frame.add(errorL);

		frame.pack();

		frame.setSize(1200, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
