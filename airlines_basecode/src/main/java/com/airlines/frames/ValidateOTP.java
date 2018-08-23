package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.airlines.dao.impl.UserDAOImpl;

public class ValidateOTP {
	public static JFrame frame;
	public static JLabel errorL1;
	public static JLabel errorL2;
	public static JTextField txtF;

	public static void otpFrame(final String email) {
		frame = new JFrame();

		StyleContext context = new StyleContext();
		StyledDocument document = new DefaultStyledDocument(context);
		Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
		StyleConstants.setAlignment(style, StyleConstants.ALIGN_LEFT);
		StyleConstants.setForeground(style, new Color(155, 150, 150));
		StyleConstants.setFontFamily(style, "verdana");
		StyleConstants.setFontSize(style, 20);
		StyleConstants.setSpaceAbove(style, 4);
		StyleConstants.setSpaceBelow(style, 4);

		// Insert content
		try {
			String message = "Please enter the OTP below to verify your Email Address. If you cannot see the email from 'Airline' in your inbox, make sure to check your SPAM folder.";
			document.insertString(document.getLength(), message, style);
		} catch (BadLocationException badLocationException) {
			System.err.println("Oops");
		}

		frame.setLayout(null);
		JLabel heading = new JLabel("    Validate OTP(One Time Passcode)", SwingConstants.LEFT);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 700, 40);
		heading.setOpaque(true);
		heading.setBackground(Color.white);
		heading.setForeground(new Color(82, 77, 77));
		heading.setFont(new Font("sans-Serif", Font.BOLD, 22));

		JLabel line = new JLabel();
		line.setBackground(new Color(161, 159, 155));
		line.setBounds(18, 50, 650, 1);
		line.setOpaque(true);

		JLabel msg1 = new JLabel("OTP has been sent to " +email);
		msg1.setVerticalAlignment(SwingConstants.CENTER);
		msg1.setBounds(20, 70, 660, 40);
		msg1.setOpaque(true);
		msg1.setBackground(Color.white);
		msg1.setForeground(new Color(102, 100, 107));
		msg1.setFont(new Font("verdana", Font.PLAIN, 20));

		JTextPane textPane = new JTextPane(document);
		textPane.setEditable(false);
		textPane.setBounds(20, 120, 660, 100);
		textPane.setBackground(Color.white);

		txtF = new JTextField();
		txtF.setBounds(20, 220, 640, 50);
		txtF.setFont(new Font("verdana", Font.PLAIN, 22));
		txtF.setForeground(new Color(82, 77, 77));

		Border border = BorderFactory.createLineBorder(Color.white);
		
		JButton valid = new JButton("Validate OTP");
		valid.setFont(new Font("sansserif", Font.BOLD, 19));
		valid.setForeground(Color.white);
		valid.setBounds(20, 310, 150, 50);
		valid.setBackground(new Color(0, 160, 210));
		valid.setBorder(border);
		valid.setCursor(new Cursor(Cursor.HAND_CURSOR));

		valid.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				UserDAOImpl validation = new UserDAOImpl();
				boolean res = false;
				try {
					res = validation.validateOTP(email, txtF.getText());
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(res);

			}
		});

		errorL1 = new JLabel("Invalid OTP. Please try again", SwingConstants.CENTER);
		errorL1.setVerticalAlignment(SwingConstants.CENTER);
		errorL1.setFont(new Font("sansSerif", Font.PLAIN, 18));
		errorL1.setForeground(Color.white);
		errorL1.setBounds(100, 305, 500, 20);

		errorL2 = new JLabel("OTP entered is expired. Please generate a new OTP and try again", SwingConstants.CENTER);
		errorL2.setVerticalAlignment(SwingConstants.CENTER);
		errorL2.setFont(new Font("sansSerif", Font.PLAIN, 18));
		errorL2.setForeground(Color.white);
		errorL2.setBounds(60, 280, 550, 20);

		JLabel resend = new JLabel("Resend OTP");
		resend.setFont(new Font("sansserif", Font.PLAIN, 20));
		resend.setForeground(new Color(155, 150, 150));
		resend.setBounds(550, 310, 150, 50);
		resend.setCursor(new Cursor(Cursor.HAND_CURSOR));

		resend.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				
			}
		});

		frame.add(heading);
		frame.add(msg1);
		frame.add(textPane);
		frame.add(line);
		frame.add(valid);
		frame.add(txtF);
		frame.add(resend);
		frame.add(errorL1);
		frame.add(errorL2);
		frame.pack();
		frame.setSize(700, 420);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
	}

}
