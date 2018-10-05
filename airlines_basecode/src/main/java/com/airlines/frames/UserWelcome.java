package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import org.jdesktop.swingx.JXDatePicker;

import com.airlines.dao.impl.FlightDAOImpl;
import com.airlines.entity.Flight;
import com.airlines.util.ComboBoxUI;

public class UserWelcome {
	public static JFrame frame;
	public static JLabel msgL;

	public static void welcomeFrame(final String email) throws IOException {

		UIManager.put("ComboBox.background", new Color(240, 240, 240));
		UIManager.put("ComboBox.foreground", new Color(96, 95, 95));
		UIManager.put("ComboBox.selectionBackground", new Color(240, 240, 240));
		UIManager.put("ComboBox.selectionForeground", new Color(35, 20, 21));
		UIManager.put("ComboBox.border", BorderFactory.createEmptyBorder());
		UIManager.put("JScrollPane.border", new Color(255, 255, 255));

		System.out.println(email);
		frame = new JFrame();
		Font f = new Font("SansSerif", Font.BOLD, 40);
		JLabel heading;
		JLabel msg1;
		JLabel msg2;

		heading = new JLabel("Airline", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 1200, 100);
		heading.setOpaque(true);
		heading.setBackground(new Color(9, 195, 218));
		heading.setForeground(Color.WHITE);
		heading.setFont(f);

		JPanel panel = Panel.panel();
		panel.setBounds(30, 280, 1130, 60);
		frame.add(panel);
		panel.setVisible(true);
		panel.setBackground(new Color(240, 240, 240));
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(253, 253, 253)));

		JPanel panel2 = Panel.panel();
		panel2.setBounds(30, 340, 1130, 100);
		frame.add(panel2);
		panel2.setVisible(true);
		panel2.setBackground(new Color(244, 244, 244));
		
		JPanel panel3 = Panel.panel();
		panel3.setBounds(30, 515, 1130, 50);
		frame.add(panel3);
		panel3.setVisible(true);
		panel3.setBackground(new Color(244, 244, 244));
		
		JPanel panel4 = Panel.panel();
		panel4.setLayout(new GridLayout());
		panel4.setBounds(30, 570, 1130, 160);
		frame.add(panel4);
		panel4.setVisible(true);
		panel4.setBackground(new Color(244, 244, 244));
		
		 JScrollPane scrollPane = new JScrollPane(panel4);
		 scrollPane.setBounds(30, 570, 1130, 160);
		 scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.add(scrollPane);
		
		
		

		
		JLabel from = new JLabel("<html>&Nbsp&Nbsp&Nbsp From</html>", SwingConstants.LEFT);

		JLabel flight = new JLabel("FLIGHTS", SwingConstants.CENTER);
		flight.setVerticalAlignment(SwingConstants.CENTER);
		flight.setForeground(new Color(255, 255, 255));
		flight.setBackground(new Color(13, 13, 14));
		flight.setOpaque(true);
		flight.setBounds(0, 0, 200, 60);
		flight.setFont(new Font("Courier", Font.PLAIN, 27));
		panel.add(flight);
		flight.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(255,255,255)));

		final JComboBox<Flight> fromField = fromList();
		fromField.setBounds(30, 440, 300, 50);
		fromField.setVisible(false);

		final JComboBox<Flight> toField = toList();
		toField.setBounds(330, 440, 300, 50);
		toField.setVisible(false);

		frame.add(fromField);
		frame.add(toField);

		from.setVerticalAlignment(SwingConstants.CENTER);
		from.setForeground(new Color(72, 66, 66));
		from.setBackground(new Color(244, 244, 244));
		from.setOpaque(true);
		from.setBounds(0, 0, 300, 100);
		from.setFont(new Font("Courier", Font.PLAIN, 27));
		from.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(255, 255, 255)));
		from.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				fromField.setVisible(true);
			}

		});

		panel2.add(from);

		JLabel to = new JLabel("<html>&Nbsp&Nbsp&Nbsp To</html>", SwingConstants.LEFT);
		to.setVerticalAlignment(SwingConstants.CENTER);
		to.setForeground(new Color(72, 66, 66));
		to.setBackground(new Color(244, 244, 244));
		to.setOpaque(true);
		to.setBounds(300, 0, 300, 100);
		to.setFont(new Font("Courier", Font.PLAIN, 27));
		to.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(255, 255, 255)));
		to.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				toField.setVisible(true);
			}

		});

		panel2.add(to);

		JLabel departDate = new JLabel("<html>&Nbsp&Nbsp&Nbsp Depart Date</html>", SwingConstants.LEFT);
		departDate.setVerticalAlignment(SwingConstants.CENTER);
		departDate.setForeground(new Color(72, 66, 66));
		departDate.setBackground(new Color(244, 244, 244));
		departDate.setOpaque(true);
		departDate.setBounds(600, 0, 300, 100);
		departDate.setFont(new Font("Courier", Font.PLAIN, 27));
		departDate.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, new Color(255, 255, 255)));
		panel2.add(departDate);

		JXDatePicker picker = new JXDatePicker();
		picker.getEditor().setBorder(null);
		picker.setDate(Calendar.getInstance().getTime());
		picker.setFormats(new SimpleDateFormat(" EEE dd MMMMM, yyyy"));
		picker.setFont(new Font("courier", Font.PLAIN, 22));
		picker.setForeground(new Color(35, 20, 21));
		picker.setBounds(635, 440, 300, 50);
		picker.setBackground(new Color(240, 240, 240));
		JButton dateBtn = (JButton) picker.getComponent(1);
		BufferedImage editImage = ImageIO.read(new File("src/main/java/com/airlines/images/cal.png"));

		dateBtn.setIcon(new ImageIcon(editImage));
		dateBtn.setFocusPainted(false);

		dateBtn.setMargin(new Insets(0, 0, 0, 0));
		dateBtn.setContentAreaFilled(false);
		dateBtn.setBorderPainted(false);
		dateBtn.setOpaque(false);

		dateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

		frame.add(picker);

		JLabel search = new JLabel("Search", SwingConstants.CENTER);
		search.setVerticalAlignment(SwingConstants.CENTER);
		search.setForeground(new Color(72, 66, 66));
		search.setBackground(new Color(247, 245, 245));
		search.setOpaque(true);
		search.setBounds(900, 0, 230, 100);
		search.setFont(new Font("Courier", Font.BOLD, 25));
		search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		search.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255, 255, 255)));

		search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				search.setForeground(new Color(255, 255, 255));
				search.setBackground(new Color(13, 13, 14));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				search.setForeground(new Color(72, 66, 66));
				search.setBackground(new Color(247, 245, 245));
			}
			
			JPanel res =null;

			@Override
			public void mouseClicked(MouseEvent e) {
				FlightDAOImpl searchList = new FlightDAOImpl();
				ArrayList<Flight> getSearchList = new ArrayList<>();
				String whereFrom = String.valueOf(fromField.getSelectedItem()).trim();
				String whereTo = String.valueOf(toField.getSelectedItem()).trim();
				String date = picker.getDate().toString();
				getSearchList = (ArrayList<Flight>) searchList.search(whereFrom, whereTo, date);
				for (Flight f : getSearchList) {
					
					res = Panel.panel();
					res.setSize(1130,80);
					
					res.setBackground(Color.black);
					res.setVisible(true);
					res.setOpaque(true);
					res.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));
					panel4.add(res);
					
					System.out
							.println(f.getFlightId() + " " + f.getAircraftName() + " " + f.getFromF() + " " + f.getToF()
									+ " " + f.getDepartDate() + " " + f.getDepartTime() + " " + f.getArrivalTime());

				}

			}
		});
		
		
		

		panel2.add(search);
		msg1 = new JLabel("Hello.", SwingConstants.CENTER);
		msg1.setVerticalAlignment(SwingConstants.CENTER);
		msg1.setBounds(0, 120, 1200, 100);
		msg1.setOpaque(true);
		msg1.setBackground(Color.white);
		msg1.setForeground(new Color(9, 195, 218));
		msg1.setFont(new Font("SansSerif", Font.BOLD, 70));

		msg2 = new JLabel("Welcome to the world's travel engine.", SwingConstants.CENTER);
		msg2.setVerticalAlignment(SwingConstants.CENTER);
		msg2.setBounds(0, 185, 1200, 100);
		msg2.setOpaque(true);
		msg2.setBackground(Color.white);
		msg2.setForeground(Color.BLACK);
		msg2.setFont(new Font("SansSerif", Font.BOLD, 30));

		msgL = new JLabel("", SwingConstants.CENTER);
		msgL.setVerticalAlignment(SwingConstants.CENTER);
		msgL.setFont(new Font("Courier", Font.BOLD, 20));
		msgL.setForeground(new Color(91, 192, 222));
		msgL.setBounds(0, 605, 1200, 30);

		JLabel updateProfile = new JLabel("Update Profile", SwingConstants.CENTER);
		updateProfile.setBackground(new Color(248, 140, 109));
		updateProfile.setForeground(Color.WHITE);
		updateProfile.setLocation(700, 500);
		updateProfile.setSize(500, 100);
		updateProfile.setFont(f);
		updateProfile.setOpaque(true);
		updateProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updateProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProfileUpdate update = new ProfileUpdate();
				update.updateFrame(email);
			}

		});

		final JLabel logout = new JLabel("Logout");

		logout.setLocation(7, 728);
		logout.setSize(200, 30);
		logout.setFont(new Font("Courier", Font.PLAIN, 20));
		logout.setForeground(new Color(230, 230, 230));
		logout.setBackground(Color.white);
		logout.setOpaque(true);
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Login.loginFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				frame.dispose();
			}

		});
		frame.setLayout(null);
		frame.add(msgL);
		frame.add(heading);
		frame.add(msg1);
		frame.add(msg2);
		// frame.add(updateProfile);
		frame.add(logout);

		frame.pack();
		frame.setSize(1200, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private static JComboBox fromList() {
		JComboBox list = new JComboBox();
		list = ComboBoxUI.comboUI(list);
		list.setFont(new Font("courier", Font.PLAIN, 22));
		FlightDAOImpl impl = new FlightDAOImpl();
		ArrayList<Flight> fromList = new ArrayList<>();
		fromList = (ArrayList<Flight>) impl.getWhereFrom();
		HashSet<Flight> source = new HashSet<>();
		source.addAll(fromList);
		Iterator<Flight> iterator = source.iterator();
		while (iterator.hasNext()) {
			list.addItem("   " + iterator.next());
		}
		return list;
	}

	private static JComboBox toList() {
		JComboBox list = new JComboBox();
		list = ComboBoxUI.comboUI(list);
		list.setFont(new Font("courier", Font.PLAIN, 22));
		FlightDAOImpl impl = new FlightDAOImpl();
		ArrayList<Flight> toList = new ArrayList<>();
		toList = (ArrayList<Flight>) impl.getWhereTo();
		HashSet<Flight> destination = new HashSet<>();
		destination.addAll(toList);
		Iterator<Flight> iterator = destination.iterator();
		while (iterator.hasNext()) {
			list.addItem("   " + iterator.next());
		}
		return list;
	}

}
