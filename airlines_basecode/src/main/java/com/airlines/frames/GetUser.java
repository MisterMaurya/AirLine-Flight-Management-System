package com.airlines.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.airlines.controller.Register;
import com.airlines.dao.impl.UserDAOImpl;
import com.airlines.entity.User;

public class GetUser {

	public static JFrame frame;
	static Font f = new Font("SansSerif", Font.BOLD, 30);
	public static JLabel label;
	static UserDAOImpl getUser = null;
	static User user = null;
	static int getCommand = 0;

	public static void getUserDialogFrame() {
		frame = new JFrame();
		JLabel heading;

		heading = new JLabel("Search Airline Member ", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 700, 50);
		heading.setOpaque(true);
		heading.setBackground(new Color(9, 195, 218));
		heading.setForeground(Color.WHITE);
		heading.setFont(f);

		label = new JLabel("", SwingConstants.CENTER);
		label.setForeground(new Color(149, 146, 146));
		label.setFont(new Font("Courier", Font.PLAIN, 25));
		label.setBounds(0, 70, 700, 50);

		final JLabel errorL = new JLabel("", SwingConstants.CENTER);
		errorL.setVerticalAlignment(SwingConstants.CENTER);
		errorL.setFont(new Font("sansSerif", Font.PLAIN, 20));
		errorL.setForeground(new Color(216, 0, 12));
		errorL.setBounds(100, 270, 500, 25);
		errorL.setVisible(false);

		final JLabel footer;

		footer = new JLabel("Airline", SwingConstants.CENTER);
		footer.setVerticalAlignment(SwingConstants.CENTER);
		footer.setBounds(0, 270, 700, 40);
		footer.setOpaque(true);
		footer.setBackground(Color.white);
		footer.setForeground(new Color(160, 160, 160));
		footer.setFont(new Font("Courier", Font.BOLD, 20));

		final JTextField txt = new JTextField();
		txt.setBounds(100, 130, 500, 50);
		txt.setFont(new Font("Verdana", Font.PLAIN, 20));
		txt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txt.setText(null);
				errorL.setVisible(false);
				footer.setVisible(true);
			}
		});

		Border border = BorderFactory.createLineBorder(Color.white);
		JButton get = new JButton("Get Member");
		get.setSize(200, 50);
		get.setLocation(250, 200);
		get.setBackground(new Color(9, 195, 218));
		get.setForeground(Color.WHITE);
		get.setFont(new Font("Courier", Font.BOLD, 25));
		get.setBorder(border);
		get.setFocusPainted(false);

		get.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getCommand == 1) {

					if (Register.isValidEmailPattern(txt.getText())) {
						try {
							if (Register.isEmailExists(txt.getText())) {
								getUser = new UserDAOImpl();
								user = getUser.getUserByEmail(txt.getText());
								frame.dispose();
								AdminService.serviceFrameToGetUser(user);

							} else {
								errorL.setText("Invaild email address. Please try again!");
								errorL.setVisible(true);
								footer.setVisible(false);

							}
						} catch (SQLException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}
					} else {
						errorL.setText("Invaild email address. Please try again!");
						errorL.setVisible(true);
						footer.setVisible(false);
					}
				} else {
					if (Register.isValidUserName(txt.getText())) {
						try {
							if (Register.isUserNameExists(txt.getText())) {
								getUser = new UserDAOImpl();
								user = getUser.getUserByUserName(txt.getText());
								frame.dispose();
								AdminService.serviceFrameToGetUser(user);

							} else {
								errorL.setText("Invaild username. Please try again!");
								errorL.setVisible(true);
								footer.setVisible(false);

							}
						} catch (SQLException e1) {

							e1.printStackTrace();
						} catch (IOException e1) {

							e1.printStackTrace();
						}

					} else {
						errorL.setText("Invaild username. Please try again!");
						errorL.setVisible(true);
						footer.setVisible(false);
					}
				}

			}
		});

		frame.addWindowFocusListener(new WindowFocusListener() {

			public void windowLostFocus(WindowEvent e) {
				frame.dispose();
			}

			public void windowGainedFocus(WindowEvent e) {
			}
		});

		frame.setLayout(null);
		frame.add(get);
		frame.add(heading);
		frame.add(txt);
		frame.add(footer);
		frame.add(errorL);
		frame.add(label);
		frame.setSize(700, 350);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);

	}

}
