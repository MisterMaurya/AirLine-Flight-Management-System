package com.airlines.frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.airlines.controller.Register;
import com.airlines.controller.ResetPassword;

public class ForgotPassword {
	static JFrame frame;

	public static void forgotWindow() {
		frame = new JFrame();
		frame.setLayout(null);
		final JLabel heading = new JLabel("Forgot your password? Let's get you a new one.", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 700, 60);
		heading.setOpaque(true);
		heading.setBackground(Color.white);
		heading.setForeground(new Color(82, 77, 77));
		heading.setFont(new Font("sans-Serif", Font.BOLD, 25));

		final JLabel heading2 = new JLabel("Airline will send a verification code to your Email!",
				SwingConstants.CENTER);
		heading2.setVerticalAlignment(SwingConstants.CENTER);
		heading2.setBounds(0, 0, 700, 60);
		heading2.setOpaque(true);
		heading2.setBackground(Color.white);
		heading2.setForeground(new Color(82, 77, 77));
		heading2.setFont(new Font("sans-Serif", Font.BOLD, 25));
		heading2.setVisible(false);

		final JLabel heading3 = new JLabel("All done!", SwingConstants.CENTER);
		heading3.setVerticalAlignment(SwingConstants.CENTER);
		heading3.setBounds(0, 0, 700, 60);
		heading3.setOpaque(true);
		heading3.setBackground(Color.white);
		heading3.setForeground(new Color(87,87,87));
		heading3.setFont(new Font("sans-Serif", Font.BOLD, 30));
		heading3.setVisible(false);
		
		final JLabel line = new JLabel();
		line.setBackground(new Color(161, 159, 155));
		line.setBounds(50, 70, 600, 1);
		line.setOpaque(true);

		// panel1

		final JPanel panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 90, 700, 300);
		panel1.setOpaque(true);
		panel1.setBackground(Color.white);

		final JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 90, 700, 300);
		panel2.setOpaque(true);
		panel2.setBackground(Color.white);

		final JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(0, 90, 700, 300);
		panel3.setOpaque(true);
		panel3.setBackground(Color.white);
		panel3.setVisible(false);

		Border txtBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(108, 201, 217));

		final JLabel errorL = new JLabel("Invalid E-mail Address", SwingConstants.CENTER);
		errorL.setVerticalAlignment(SwingConstants.CENTER);
		errorL.setFont(new Font("Courier", Font.BOLD, 20));
		errorL.setForeground(Color.white);
		errorL.setBounds(0, 220, 700, 20);

		JLabel label1 = new JLabel("Your E-mail Address:");
		label1.setBounds(150, 10, 400, 50);
		label1.setForeground(new Color(149, 146, 146));
		label1.setFont(new Font("Courier", Font.PLAIN, 22));

		final JTextField txtF = new JTextField();

		txtF.setBounds(150, 60, 400, 50);
		txtF.setFont(new Font("verdana", Font.PLAIN, 22));
		txtF.setForeground(Color.BLACK);
		txtF.setBorder(txtBorder);
		txtF.setBackground(Color.white);

		txtF.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				errorL.setForeground(Color.white);
				txtF.setText(null);

			}
		});

		Border border = BorderFactory.createLineBorder(Color.white);
		JButton rb = new JButton("Reset Your Password");
		rb.setBounds(150, 130, 400, 60);

		rb.setBackground(new Color(108, 201, 217));
		rb.setForeground(Color.WHITE);
		rb.setFont(new Font("Courier", Font.BOLD, 20));
		rb.setBorder(border);
		rb.setFocusPainted(false);
		rb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if (Register.isEmailExists(txtF.getText())) {
						ResetPassword.sendCode(txtF.getText());
						panel1.setVisible(false);
						heading.setVisible(false);
						panel2.setVisible(true);
						heading2.setVisible(true);

					} else {
						errorL.setForeground(new Color(216, 0, 12));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		panel1.add(label1);
		panel1.add(errorL);
		panel1.add(txtF);
		panel1.add(rb);

		// panel2

		JLabel label2 = new JLabel("Confirmation Verfication Code:");
		label2.setBounds(150, 0, 400, 25);
		label2.setForeground(new Color(149, 146, 146));
		label2.setFont(new Font("Courier", Font.PLAIN, 22));

		final JTextField otpF = new JTextField("");
		otpF.setBounds(150, 30, 400, 50);
		otpF.setFont(new Font("verdana", Font.PLAIN, 22));
		otpF.setBorder(txtBorder);
		otpF.setBackground(Color.white);

		JLabel label3 = new JLabel("New Password:");
		label3.setBounds(150, 90, 400, 25);
		label3.setForeground(new Color(149, 146, 146));
		label3.setFont(new Font("Courier", Font.PLAIN, 22));

		final JTextField pass = new JTextField();

		pass.setBounds(150, 120, 400, 50);
		pass.setFont(new Font("verdana", Font.PLAIN, 22));
		pass.setBorder(txtBorder);
		pass.setBackground(Color.white);

		final JLabel errorL2 = new JLabel("Invalid confirmation code, Try again.", SwingConstants.CENTER);
		errorL2.setVerticalAlignment(SwingConstants.CENTER);
		errorL2.setFont(new Font("Courier", Font.BOLD, 20));
		errorL2.setForeground(new Color(216, 0, 12));
		errorL2.setBounds(0, 250, 700, 30);
		errorL2.setVisible(false);

		

		JButton valid = new JButton("Submit");
		valid.setBounds(150, 180, 400, 60);

		valid.setBackground(new Color(108, 201, 217));
		valid.setForeground(Color.WHITE);
		valid.setFont(new Font("Courier", Font.BOLD, 20));
		valid.setBorder(border);
		valid.setFocusPainted(false);

		valid.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					boolean b = false;
					try {

						b = ResetPassword.resetPass(otpF.getText(), pass.getText());
						

					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (b) {
						panel2.setVisible(false);
						panel3.setVisible(true);
						heading3.setVisible(true);
						line.setVisible(false);
						
					
					} else {
					
						errorL2.setVisible(true);
						otpF.setText(null);
						pass.setText(null);
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		// panel3

		JLabel label4 = new JLabel("Password Reset Successfully!");
		label4.setBounds(180, 45, 400, 50);
		label4.setForeground(new Color(0, 210, 220));
		label4.setBackground(Color.white);
		label4.setOpaque(true);
		label4.setFont(new Font("Courier", Font.BOLD, 25));

		ImageIcon icon = new ImageIcon("src/main/java/com/airlines/images/suc.png");
		JLabel label5 = new JLabel(icon);
		label5.setBounds(30, 10, 128, 128);

		JLabel label6 = new JLabel("Your Password successfully updated! Please Log in", SwingConstants.CENTER);
		label6.setVerticalAlignment(SwingConstants.CENTER);
		label6.setBounds(25, 95, 700, 50);
		label6.setForeground(new Color(142, 142, 142));
		label6.setBackground(Color.white);
		label6.setOpaque(true);
		label6.setFont(new Font("Courier", Font.PLAIN, 20));

		JButton dis = new JButton("OK");
		dis.setBounds(280, 180, 120, 50);
		dis.setBackground(new Color(140, 212, 245));
		dis.setForeground(Color.WHITE);
		dis.setFont(new Font("Courier", Font.PLAIN, 25));
		dis.setFocusable(false);
		dis.setBorder(BorderFactory.createLineBorder(Color.white));
		dis.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		panel3.add(label4);
		panel3.add(label5);
		panel3.add(label6);
		panel3.add(dis);

		frame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				errorL2.setVisible(false);
				
			}
		});
		frame.add(panel3);
		frame.add(heading3);
		frame.add(heading2);
		panel2.add(label2);
		panel2.add(label3);
		
		panel2.add(errorL2);
		panel2.add(otpF);
		panel2.add(pass);
		panel2.add(valid);
		panel2.setVisible(false);
		frame.add(heading);
		frame.add(panel1);
		frame.add(panel2);
		frame.add(line);
		frame.pack();
		frame.setSize(700, 420);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
	}

}
