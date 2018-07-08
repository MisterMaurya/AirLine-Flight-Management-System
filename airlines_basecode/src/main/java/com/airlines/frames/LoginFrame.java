package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.airlines.main.Main;

import javafx.scene.image.Image;

public class LoginFrame {

	public static void loginFrame() {
		
		final JFrame frame = new JFrame("LOGIN");

		frame.setLayout(null);

		JLabel label = new JLabel(new ImageIcon("src//main/java/com/airlines/images/p.jpg"));
		JLabel userLabel = new JLabel("EMAIL");
		JLabel pwdlLabel = new JLabel("PASSWORD");
		JTextField user = new JTextField();
		JTextField password = new JTextField();
		JButton b1 = new JButton("SIGN IN");
		JButton b2 = new JButton("CANCEL");
		JLabel rLabel = new JLabel("Not Registered? Create an account");

		label.setSize(505, 250);
		label.setLocation(0, 0);

		userLabel.setForeground(Color.WHITE);
		userLabel.setFont(new Font("Courier", Font.BOLD, 20));
		userLabel.setLocation(20, 270);
		userLabel.setSize(440, 40);

		user.setSize(450, 40);
		user.setBackground(Color.LIGHT_GRAY);
		user.setForeground(Color.white);
		user.setLocation(20, 310);

		pwdlLabel.setFont(new Font("Courier", Font.BOLD, 20));
		pwdlLabel.setForeground(Color.WHITE);
		pwdlLabel.setLocation(20, 350);
		pwdlLabel.setSize(440, 40);
		password.setBackground(Color.LIGHT_GRAY);
		password.setLocation(20, 390);
		password.setSize(450, 40);

		b1.setSize(120, 40);
		b1.setBackground(Color.LIGHT_GRAY);
		b1.setFont(new Font("serif", Font.BOLD, 16));
		b1.setLocation(130, 450);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				WelcomeFrame.welcomeFrame();
			}
		});

		b2.setSize(120, 40);
		b2.setBackground(Color.LIGHT_GRAY);
		b2.setFont(new Font("serif", Font.BOLD, 16));
		b2.setLocation(250, 450);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));

		rLabel.setLocation(170, 526);
		rLabel.setSize(400, 40);
		rLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rLabel.setFont(new Font("Courier", Font.BOLD, 16));
		rLabel.setForeground(Color.LIGHT_GRAY);
		rLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationFrame.registrationFrame();
				frame.setVisible(false);

			}

		});

		frame.add(label);
		frame.add(userLabel);
		frame.add(user);
		frame.add(pwdlLabel);
		frame.add(password);
		frame.add(b1);
		frame.add(b2);
		frame.add(rLabel);
		frame.pack();

		frame.setSize(505, 600);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
