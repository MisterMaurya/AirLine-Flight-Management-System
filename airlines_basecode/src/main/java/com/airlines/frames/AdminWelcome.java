package com.airlines.frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminWelcome {
	static JFrame frame = new JFrame("Assistant");
	static JPanel frontpanel;

	public static void assistant() throws Exception {
		frame.setLayout(null);
		JLabel heading = new JLabel("Airlines Adminstrator", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setOpaque(true);
		heading.setFont(new Font("SansSerif", Font.BOLD, 40));
		heading.setForeground(Color.WHITE);
		heading.setLocation(0, 0);
		heading.setSize(1200, 100);
		heading.setBackground(new Color(9, 195, 218));
		frontpanel = FirstPanel.firstPanel();
		frontpanel.setVisible(true);
		frame.add(frontpanel);
		frame.add(heading);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.pack();
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
