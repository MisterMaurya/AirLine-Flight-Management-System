package com.airlines.frames;

import java.awt.Color;

import javax.swing.JFrame;

public class WelcomeFrame {

	public static void welcomeFrame() {
		JFrame frame = new JFrame("Welcome Buddy");
		frame.setLayout(null);
		frame.pack();
		frame.setSize(505, 650);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
