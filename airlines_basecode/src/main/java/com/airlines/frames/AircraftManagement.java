package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.airlines.controller.Craft;
import com.airlines.dao.impl.AircarftDAOImpl;
import com.airlines.entity.Aircraft;

public class AircraftManagement {
	static JFrame frame = new JFrame("Assistant");

	public static void aircraftManagemntView() {

		frame.setLayout(null);
		JLabel heading = new JLabel("Airlines Adminstrator", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setOpaque(true);
		heading.setFont(new Font("SansSerif", Font.BOLD, 40));
		heading.setForeground(Color.WHITE);
		heading.setLocation(0, 0);
		heading.setSize(1200, 100);
		heading.setBackground(new Color(9, 195, 218));

		final JPanel panel = Panel.panel();
		panel.setBackground(new Color(251, 251, 251));
		Font font = new Font("courier", Font.PLAIN, 23);
		final Color fg = new Color(35, 20, 21);

		JPanel panelL = Panel.panel();
		panelL.setBounds(200, 50, 800, 560);
		panelL.setBackground(new Color(255, 255, 255));
		Border bor = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(9, 195, 218));

		JLabel leftHeader = new JLabel("<html><h1>&Nbsp&Nbsp&Nbsp MANAGE AIRCRAFT<h1>", SwingConstants.LEFT);
		leftHeader.setVerticalAlignment(SwingConstants.CENTER);
		leftHeader.setBounds(0, 0, 800, 100);
		leftHeader.setFont(new Font("courier", Font.PLAIN, 25));
		leftHeader.setForeground(new Color(255, 255, 255));
		leftHeader.setBackground(new Color(108, 201, 217));
		leftHeader.setOpaque(true);
		panelL.add(leftHeader);

		JLabel labelName = new JLabel("<html>Aircarft Name<font color=red>*</font><html>");
		labelName.setBounds(50, 130, 250, 50);
		labelName.setForeground(new Color(71, 73, 73));
		labelName.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(labelName);

		final JTextField aircraftName = new JTextField();
		aircraftName.setBounds(350, 130, 350, 50);
		aircraftName.setFont(font);
		aircraftName.setForeground(fg);
		aircraftName.setBackground(Color.white);
		aircraftName.setOpaque(true);
		aircraftName.setBorder(bor);
		panelL.add(aircraftName);

		JLabel fcs = new JLabel("<html>First class seats<font color=red>*</font><html>");
		fcs.setBounds(50, 190, 250, 50);
		fcs.setForeground(new Color(71, 73, 73));
		fcs.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(fcs);

		final JTextField seatInFirstClass = new JTextField();
		seatInFirstClass.setBorder(bor);
		seatInFirstClass.setBounds(350, 190, 350, 50);
		seatInFirstClass.setFont(font);
		seatInFirstClass.setForeground(fg);
		panelL.add(seatInFirstClass);

		JLabel bcs = new JLabel("<html>Business class seats<font color=red>*</font><html>");
		bcs.setBounds(50, 250, 250, 50);
		bcs.setForeground(new Color(71, 73, 73));
		bcs.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(bcs);

		final JTextField seatInBusinessClass = new JTextField();
		seatInBusinessClass.setBorder(bor);
		seatInBusinessClass.setBounds(350, 250, 350, 50);
		seatInBusinessClass.setFont(font);
		seatInBusinessClass.setForeground(fg);
		panelL.add(seatInBusinessClass);

		JLabel ecs = new JLabel("<html>Economy class seats<font color=red>*</font><html>");
		ecs.setBounds(50, 310, 250, 50);
		ecs.setForeground(new Color(71, 73, 73));
		ecs.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(ecs);

		final JTextField seatInEconomyClass = new JTextField();
		seatInEconomyClass.setBorder(bor);
		seatInEconomyClass.setBounds(350, 310, 350, 50);
		seatInEconomyClass.setFont(font);
		seatInEconomyClass.setForeground(fg);
		panelL.add(seatInEconomyClass);

		JLabel pecs = new JLabel("<html>Premium Economy class seats<font color=red>*</font><html>");
		pecs.setBounds(50, 380, 250, 60);
		pecs.setForeground(new Color(71, 73, 73));
		pecs.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(pecs);

		final JTextField seatInPremiumEconomyClass = new JTextField();
		seatInPremiumEconomyClass.setBorder(bor);
		seatInPremiumEconomyClass.setBounds(350, 380, 350, 50);
		seatInPremiumEconomyClass.setFont(font);
		seatInPremiumEconomyClass.setForeground(fg);
		panelL.add(seatInPremiumEconomyClass);

		JLabel plus = new JLabel(new ImageIcon("src/main/java/com/airlines/images/plus.png"));
		plus.setBounds(390, 470, 32, 32);
		plus.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelL.add(plus);

		JLabel update = new JLabel(new ImageIcon("src/main/java/com/airlines/images/update.png"));
		update.setBounds(330, 470, 32, 32);
		update.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelL.add(update);

		JLabel minus = new JLabel(new ImageIcon("src/main/java/com/airlines/images/minus.png"));
		minus.setBounds(450, 470, 32, 32);
		minus.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelL.add(minus);

		final JLabel msg = new JLabel("", SwingConstants.CENTER);
		msg.setVerticalAlignment(SwingConstants.CENTER);
		msg.setBounds(0, 505, 800, 50);
		msg.setFont(new Font("courier", Font.PLAIN, 20));
		panelL.add(msg);
		msg.setVisible(true);

		plus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Aircraft craft = new Aircraft();try{
				craft.setAircraftId(Craft.craftID());
				craft.setAircraftName(aircraftName.getText());
				craft.setSeatInFirstClass(Integer.parseInt(seatInFirstClass.getText()));
				craft.setSeatInBusinessClass(Integer.parseInt(seatInBusinessClass.getText()));
				craft.setSeatInEconomyClass(Integer.parseInt(seatInEconomyClass.getText()));
				craft.setSeatInPremiumEconomyClass(Integer.parseInt(seatInPremiumEconomyClass.getText()));
				
				AircarftDAOImpl aircraft = new AircarftDAOImpl();
				boolean flag = aircraft.saveAircraft(craft);
				if (flag) {
					msg.setText("Aircraft successfully Added!");
					msg.setForeground(new Color(71, 73, 73));
					System.out.println("add");
					aircraftName.setText(null);
					seatInFirstClass.setText(null);
					seatInBusinessClass.setText(null);
					seatInEconomyClass.setText(null);
					seatInPremiumEconomyClass.setText(null);

				} else {
					msg.setText("Something went wrong");
					msg.setForeground(Color.red);

				}
				}catch(Exception e1){
					msg.setText("Something went wrong");
					msg.setForeground(Color.red);
					
				}
				

			}
		});

		JLabel back = new JLabel("Back");
		back.setLocation(7, 720);
		back.setSize(90, 30);
		back.setForeground(new Color(204, 204, 204));
		back.setBackground(new Color(255, 255, 255));
		back.setOpaque(false);
		back.setFont(new Font("sans-serif", Font.PLAIN, 20));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					AircraftManagement.frame.dispose();
					AdminManagement.management();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				

			}

		});

		// panel.setOpaque(false);
		panel.add(panelL);
		frame.add(back);
		frame.add(panel);
		frame.add(heading);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.pack();
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

	}

}
