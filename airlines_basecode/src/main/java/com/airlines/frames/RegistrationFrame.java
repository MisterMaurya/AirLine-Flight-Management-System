package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationFrame {

	static String male = "MALE";
	static String female = "FEMALE";

	public static void registrationFrame() {
		final JFrame frame = new JFrame("REGISTRATION");
		frame.setLayout(null);
		JLabel heading = new JLabel("REGISTER FOR AN ACCOUNT");
		JButton b1 = new JButton("REGISTER");
		JLabel userLabel = new JLabel("EMAIL");
		JLabel gender = new JLabel("GENDER");
		JLabel pwdlLabel = new JLabel("PASSWORD");
		JLabel uNameLabel = new JLabel("USERNAME");
		JLabel cpwdlLabel = new JLabel("CONFIRM PASSWORD");
		JLabel rLabel = new JLabel("Already have an account? Sign in");
		JTextField user = new JTextField();
		JTextField password = new JTextField();
		JTextField name = new JTextField();
		JTextField cpassword = new JTextField();
		ButtonGroup group = new ButtonGroup();
		JRadioButton maleButton = new JRadioButton(male);
		JRadioButton femaleButton = new JRadioButton(female);

		group.add(maleButton);
		group.add(femaleButton);

		heading.setLocation(80, 20);
		heading.setSize(505, 40);
		heading.setFont(new Font("serif", Font.BOLD, 25));
		heading.setForeground(Color.WHITE);

		uNameLabel.setForeground(Color.WHITE);
		uNameLabel.setFont(new Font("Courier", Font.BOLD, 20));
		uNameLabel.setLocation(20, 110);
		uNameLabel.setSize(440, 40);

		name.setSize(450, 40);
		name.setBackground(Color.LIGHT_GRAY);
		name.setForeground(Color.white);
		name.setLocation(20, 150);

		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("Courier", Font.BOLD, 20));
		userLabel.setLocation(20, 190);
		userLabel.setSize(440, 40);

		user.setSize(450, 40);
		user.setBackground(Color.LIGHT_GRAY);
		user.setForeground(Color.white);
		user.setLocation(20, 230);

		pwdlLabel.setFont(new Font("Courier", Font.BOLD, 20));
		pwdlLabel.setForeground(Color.WHITE);
		pwdlLabel.setLocation(20, 270);
		pwdlLabel.setSize(440, 40);

		password.setBackground(Color.LIGHT_GRAY);
		password.setLocation(20, 310);
		password.setSize(450, 40);

		cpwdlLabel.setForeground(Color.WHITE);
		cpwdlLabel.setFont(new Font("Courier", Font.BOLD, 20));
		cpwdlLabel.setLocation(20, 350);
		cpwdlLabel.setSize(440, 40);

		cpassword.setSize(450, 40);
		cpassword.setBackground(Color.LIGHT_GRAY);
		cpassword.setForeground(Color.white);
		cpassword.setLocation(20, 390);

		gender.setForeground(Color.WHITE);
		gender.setFont(new Font("Courier", Font.BOLD, 20));
		gender.setLocation(20, 430);
		gender.setSize(440, 40);

		maleButton.setLocation(20, 460);
		maleButton.setBackground(Color.GRAY);
		maleButton.setForeground(Color.WHITE);
		maleButton.setFont(new Font("Courier", Font.BOLD, 20));
		maleButton.setSize(80, 40);
		maleButton.setActionCommand(male);
		maleButton.setSelected(true);

		femaleButton.setLocation(100, 460);
		femaleButton.setFont(new Font("Courier", Font.BOLD, 20));
		femaleButton.setForeground(Color.WHITE);
		femaleButton.setSize(100, 40);
		femaleButton.setBackground(Color.GRAY);
		femaleButton.setActionCommand(female);

		b1.setSize(120, 40);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setFont(new Font("serif", Font.BOLD, 16));
		b1.setLocation(190, 525);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		rLabel.setLocation(170, 575);
		rLabel.setSize(400, 40);
		rLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rLabel.setFont(new Font("Courier", Font.BOLD, 16));
		rLabel.setForeground(Color.LIGHT_GRAY);
		rLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFrame.loginFrame();
				frame.setVisible(false);

			}

		});

		frame.add(gender);
		frame.add(b1);
		frame.add(maleButton);
		frame.add(femaleButton);
		frame.add(heading);
		frame.add(userLabel);
		frame.add(user);
		frame.add(pwdlLabel);
		frame.add(password);
		frame.add(uNameLabel);
		frame.add(name);
		frame.add(cpwdlLabel);
		frame.add(cpassword);
		frame.add(rLabel);
		frame.pack();
		frame.setSize(505, 650);
		/* frame.setUndecorated(true); */
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
