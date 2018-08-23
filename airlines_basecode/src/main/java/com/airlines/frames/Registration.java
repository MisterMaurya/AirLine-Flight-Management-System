package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.airlines.controller.Register;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class Registration {

	final static String MALE = "Male";
	final static String FEMALE = "Female";
	public static JFrame frame;
	public static JTextField fullNameTF;
	public static JTextField userNameTF;
	public static JTextField emailTF;
	public static JPasswordField passwordF;
	public static JRadioButton maleButton;
	public static JRadioButton femaleButton;
	public static ButtonGroup group;
	public static JTextField contactTF;
	public static JDatePickerImpl dobDP;
	public static JTextField addressTF;
	public static JLabel errorL;

	static Font f = new Font("SansSerif", Font.BOLD, 40);

	public static void registrationFrame() {
		frame = new JFrame();
		frame.setLayout(null);

		JLabel heading;

		JLabel line = new JLabel();
		maleButton = new JRadioButton(MALE);
		femaleButton = new JRadioButton(FEMALE);
		group = new ButtonGroup();

		UtilDateModel model = new UtilDateModel();

		JDatePanelImpl datePanel = new JDatePanelImpl(model);

		datePanel.setPreferredSize(new Dimension(400, 150));
		datePanel.setBackground(Color.white);
		datePanel.setFont(new Font("Courier", Font.PLAIN, 25));
		dobDP = new JDatePickerImpl(datePanel);
		JFormattedTextField textField = dobDP.getJFormattedTextField();
		textField.setBackground(Color.white);
		textField.setFont(new Font("Verdana", Font.PLAIN, 20));

		line.setBounds(599, 220, 2, 370);
		line.setOpaque(true);
		line.setBackground(new Color(9, 195, 218));

		heading = new JLabel("Airline World", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 1200, 100);
		heading.setOpaque(true);
		heading.setBackground(new Color(9, 195, 218));
		heading.setForeground(Color.WHITE);
		heading.setFont(f);

		JLabel fullNameL = new JLabel("Full Name");
		fullNameL.setForeground(new Color(149, 146, 146));
		fullNameL.setFont(new Font("Courier", Font.PLAIN, 25));
		fullNameL.setBounds(350, 120, 160, 50);

		fullNameTF = new JTextField();
		fullNameTF.setBounds(510, 120, 340, 50);
		fullNameTF.setFont(new Font("Verdana", Font.PLAIN, 20));

		JLabel userNameL = new JLabel("Username");
		userNameL.setForeground(new Color(149, 146, 146));
		userNameL.setFont(new Font("Courier", Font.PLAIN, 25));
		userNameL.setBounds(350, 180, 160, 50);

		userNameTF = new JTextField();
		userNameTF.setBounds(510, 180, 340, 50);
		userNameTF.setFont(new Font("Verdana", Font.PLAIN, 20));

		JLabel emailL = new JLabel("Email");
		emailL.setForeground(new Color(149, 146, 146));
		emailL.setFont(new Font("Courier", Font.PLAIN, 25));
		emailL.setBounds(350, 240, 160, 50);

		emailTF = new JTextField();
		emailTF.setBounds(510, 240, 340, 50);
		emailTF.setFont(new Font("Verdana", Font.PLAIN, 20));

		JLabel passwordL = new JLabel("Password");
		passwordL.setForeground(new Color(149, 146, 146));
		passwordL.setFont(new Font("Courier", Font.PLAIN, 25));
		passwordL.setBounds(350, 300, 160, 50);

		passwordF = new JPasswordField();
		passwordF.setBounds(510, 300, 340, 50);
		passwordF.setFont(new Font("Verdana", Font.PLAIN, 20));

		JLabel genderL = new JLabel("Gender");
		genderL.setForeground(new Color(149, 146, 146));
		genderL.setFont(new Font("Courier", Font.PLAIN, 25));
		genderL.setBounds(350, 360, 160, 50);

		group.add(maleButton);
		group.add(femaleButton);

		maleButton.setBounds(510, 360, 120, 50);
		maleButton.setForeground(new Color(149, 146, 146));
		maleButton.setFont(new Font("Courier", Font.PLAIN, 25));
		maleButton.setBackground(Color.white);
		maleButton.setActionCommand(MALE);
		maleButton.setSelected(true);

		femaleButton.setBounds(630, 360, 140, 50);
		femaleButton.setFont(new Font("Courier", Font.PLAIN, 25));
		femaleButton.setForeground(new Color(149, 146, 146));
		femaleButton.setBackground(new Color(38, 38, 38));
		femaleButton.setActionCommand("F");
		femaleButton.setBackground(Color.white);

		JLabel dobL = new JLabel("Date Of Birth");
		dobL.setForeground(new Color(149, 146, 146));
		dobL.setFont(new Font("Courier", Font.PLAIN, 25));
		dobL.setBounds(350, 420, 160, 50);

		dobDP.setBounds(510, 420, 340, 50);
		dobDP.setBackground(Color.white);

		JLabel contactL = new JLabel("Contact");
		contactL.setForeground(new Color(149, 146, 146));
		contactL.setFont(new Font("Courier", Font.PLAIN, 25));
		contactL.setBounds(350, 480, 160, 50);

		contactTF = new JTextField(10);
		contactTF = new JTextField();
		contactTF.setBounds(510, 480, 340, 50);
		contactTF.setFont(new Font("Verdana", Font.PLAIN, 20));

		JLabel addressL = new JLabel("Address");
		addressL.setForeground(new Color(149, 146, 146));
		addressL.setFont(new Font("Courier", Font.PLAIN, 25));
		addressL.setBounds(350, 540, 160, 50);

		addressTF = new JTextField();
		addressTF.setBounds(510, 540, 340, 50);
		addressTF.setFont(new Font("Verdana", Font.PLAIN, 20));
		
		errorL = new JLabel("", SwingConstants.CENTER);
		errorL.setVerticalAlignment(SwingConstants.CENTER);
		errorL.setFont(new Font("Courier", Font.BOLD, 20));
		errorL.setForeground(new Color(216, 0, 12));
		errorL.setBounds(0, 605, 1200, 20);

		Border border = BorderFactory.createLineBorder(Color.white);
		JButton registerB = new JButton("Register");
		registerB.setBounds(400, 650, 400, 60);
		registerB.setBackground(new Color(9, 195, 218));
		registerB.setForeground(Color.WHITE);
		registerB.setFont(new Font("Courier", Font.BOLD, 25));
		registerB.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerB.setBorder(border);
		registerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean b = Register.userServices();
					if (b) {
						ValidateOTP.otpFrame(Register.email);
					}
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});

		JLabel lLabel = new JLabel("Already have an account? Sign in");
		lLabel.setBounds(443, 720, 340, 30);

		lLabel.setFont(new Font("Courier", Font.BOLD, 20));
		lLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				try {
					Login.loginFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				frame.dispose();

			}
		});

		frame.add(heading);

		frame.add(fullNameL);
		frame.add(fullNameTF);

		frame.add(userNameL);
		frame.add(userNameTF);
		frame.add(emailL);
		frame.add(emailTF);
		frame.add(passwordL);
		frame.add(passwordF);
		frame.add(genderL);
		frame.add(maleButton);
		frame.add(femaleButton);

		frame.add(dobL);
		frame.add(dobDP);
		frame.add(contactL);
		frame.add(contactTF);
		frame.add(addressL);
		frame.add(addressTF);
		frame.add(errorL);
		frame.add(registerB);
		frame.add(lLabel);
		frame.pack();
		frame.setSize(1200, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}
