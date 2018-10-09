package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SecondPanel {

	public static JPanel secondPanel() throws Exception {

		final JPanel secondPanel = Panel.panel();
		secondPanel.setBackground(new Color(247, 249, 249));

		JLabel home = new JLabel("Home");
		home.setLocation(7, 620);
		home.setSize(90, 30);
		home.setForeground(new Color(204, 204, 204));
		home.setBackground(new Color(247, 249, 249));
		home.setOpaque(true);
		home.setFont(new Font("sans-serif", Font.PLAIN, 20));
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AdminWelcome.assistant();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				secondPanel.setVisible(false);
				AdminManagement.frame.dispose();
			}

		});

		JLabel label1 = new JLabel(
				"<html><center>AIRCRAFT MANAGE</center><br><h2>Aircraft management is streamline flight<br>operations and maximize your aircraft's <br>potential</h2></html>",
				SwingConstants.CENTER);
		label1.setFont(new Font("courier", Font.PLAIN, 30));
		label1.setVerticalAlignment(SwingConstants.CENTER);
		label1.setForeground(new Color(255, 255, 255));
		label1.setBounds(0, 0, 400, 400);

		final JPanel box1 = Panel.panel();
		box1.setBounds(0, 100, 400, 400);
		box1.setBackground(new Color(108, 201, 217));
		box1.add(label1);
		box1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		box1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				AircraftManagement.aircraftManagemntView();
				secondPanel.setVisible(false);
				AdminManagement.frame.dispose();
			}
		});

		JLabel label2 = new JLabel(
				"<html><center>FLIGHT MANAGE</center><br><h2>FMS is a specialized computer system <br>that automates a wide variety of in<br>flight tasks</h2></html>",
				SwingConstants.CENTER);
		label2.setFont(new Font("courier", Font.PLAIN, 30));
		label2.setVerticalAlignment(SwingConstants.CENTER);
		label2.setForeground(new Color(95, 97, 98));
		label2.setBounds(0, 0, 400, 400);

		final JPanel box2 = Panel.panel();
		box2.setBounds(400, 100, 400, 400);
		box2.setBackground(new Color(255, 255, 255));
		box2.add(label2);
		box2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		box2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					FlightManagement.flightManagemntView();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				AdminManagement.frame.dispose();
				secondPanel.setVisible(false);
			}
		});

		JLabel label3 = new JLabel(
				"<html><center>ALL TIME STATISTICS</center><br><h2>Total Flights :<br>Total Passenger :<br>Total Pilots</h2></html>",
				SwingConstants.CENTER);
		label3.setVerticalAlignment(SwingConstants.CENTER);
		label3.setBounds(0, 0, 400, 400);
		label3.setForeground(new Color(255, 255, 255));
		label3.setFont(new Font("courier", Font.PLAIN, 30));

		JPanel box3 = Panel.panel();
		box3.setBounds(800, 100, 400, 400);
		box3.setBackground(new Color(108, 201, 217));
		box3.add(label3);
		box3.setCursor(new Cursor(Cursor.HAND_CURSOR));

		secondPanel.add(home);
		secondPanel.add(box1);
		secondPanel.add(box2);
		secondPanel.add(box3);
		secondPanel.setOpaque(true);
		return secondPanel;

	}

}
