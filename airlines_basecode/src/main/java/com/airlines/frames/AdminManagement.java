package com.airlines.frames;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminManagement {
	static JFrame frame = new JFrame("Assistant");

	public static void management() throws Exception {
		JPanel panel = SecondPanel.secondPanel();
		
		frame.setLayout(null);
		JLabel heading = new JLabel("Airlines Adminstrator", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setOpaque(true);
		heading.setFont(new Font("SansSerif", Font.BOLD, 40));
		heading.setForeground(Color.WHITE);
		heading.setLocation(0, 0);
		heading.setSize(1200, 100);
		heading.setBackground(new Color(9, 195, 218));
		frame.add(heading);
		frame.add(panel);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.pack();
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
