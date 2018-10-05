package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

import org.jdesktop.swingx.JXDatePicker;

import com.airlines.controller.Craft;
import com.airlines.dao.impl.AircarftDAOImpl;
import com.airlines.dao.impl.FlightDAOImpl;
import com.airlines.entity.Aircraft;
import com.airlines.entity.Flight;
import com.airlines.util.ComboBoxUI;

public class FlightManagement {

	static JFrame frame = new JFrame("");

	public static void flightManagemntView() throws IOException {

		UIManager.put("ComboBox.background", new Color(229, 243, 251));
		UIManager.put("ComboBox.foreground", new Color(96, 95, 95));
		UIManager.put("ComboBox.selectionBackground", new Color(229, 243, 251));
		UIManager.put("ComboBox.selectionForeground", new Color(35, 20, 21));
		UIManager.put("ComboBox.border", BorderFactory.createEmptyBorder());
		UIManager.put("JScrollPane.border", new Color(255, 255, 255));

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
		Color clr = new Color(35, 20, 21);

		final JPanel panelL = Panel.panel();
		panelL.setBounds(100, 50, 1000, 560);
		panelL.setBackground(new Color(255, 255, 255));

		final Border bor = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(9, 195, 218));

		JLabel leftHeader = new JLabel("<html><h1>&Nbsp&Nbsp&Nbsp MANAGE FLIGHT<h1>", SwingConstants.LEFT);
		leftHeader.setVerticalAlignment(SwingConstants.CENTER);
		leftHeader.setBounds(0, 0, 1000, 100);
		leftHeader.setFont(new Font("courier", Font.PLAIN, 25));
		leftHeader.setForeground(new Color(255, 255, 255));
		leftHeader.setBackground(new Color(108, 201, 217));
		leftHeader.setOpaque(true);
		panelL.add(leftHeader);

		JLabel from = new JLabel("<html>From<font color=red>*</font><html>");
		from.setBounds(40, 140, 200, 50);
		from.setForeground(new Color(71, 73, 73));
		from.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(from);

		final JTextField fromTF = new JTextField();
		fromTF.setBounds(200, 140, 280, 50);
		fromTF.setFont(font);
		fromTF.setForeground(clr);
		fromTF.setBackground(Color.white);
		fromTF.setOpaque(true);
		fromTF.setBorder(bor);
		panelL.add(fromTF);

		JLabel to = new JLabel("<html>To<font color=red>*</font><html>");
		to.setBounds(540, 140, 200, 50);
		to.setForeground(new Color(71, 73, 73));
		to.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(to);

		final JTextField toTF = new JTextField();
		toTF.setBounds(660, 140, 280, 50);
		toTF.setFont(font);
		toTF.setForeground(clr);
		toTF.setBackground(Color.white);
		toTF.setOpaque(true);
		toTF.setBorder(bor);
		panelL.add(toTF);

		JLabel departT = new JLabel("<html>Depart Time<font color=red>*</font><html>");
		departT.setBounds(40, 210, 200, 50);
		departT.setForeground(new Color(71, 73, 73));
		departT.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(departT);

		JSpinner departTF = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(departTF, "HH:mm:ss");

		departTF.setEditor(timeEditor);
		departTF.setValue(new Date());
		departTF.setBounds(200, 210, 280, 50);
		departTF.setForeground(clr);
		departTF.setBackground(Color.white);
		departTF.setFont(font);
		departTF.setBorder(null);
		JButton arrowBtn = (JButton) departTF.getComponent(1);
		arrowBtn.setBackground(Color.BLACK);
		arrowBtn.setOpaque(false);

		panelL.add(departTF);

		JLabel arrivalTL = new JLabel("<html>Arrival Time<font color=red>*</font><html>");
		arrivalTL.setBounds(540, 210, 200, 50);
		arrivalTL.setForeground(new Color(71, 73, 73));
		arrivalTL.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(arrivalTL);

		final JTextField arrivalTF = new JTextField();
		arrivalTF.setBounds(690, 210, 250, 50);
		arrivalTF.setFont(font);
		arrivalTF.setForeground(clr);
		arrivalTF.setBackground(Color.white);
		arrivalTF.setOpaque(true);
		arrivalTF.setBorder(bor);
		panelL.add(arrivalTF);

		JLabel date = new JLabel("<html>Depart Date<font color=red>*</font><html>");
		date.setBounds(40, 280, 200, 50);
		date.setForeground(new Color(71, 73, 73));
		date.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(date);

		JXDatePicker departDate = new JXDatePicker();
		departDate.getEditor().setBorder(null);
		departDate.setDate(Calendar.getInstance().getTime());
		departDate.setFormats(new SimpleDateFormat(" EEE dd MMMMM, yyyy"));
		departDate.setFont(font);
		departDate.setForeground(new Color(35, 20, 21));
		departDate.setBounds(200, 280, 280, 50);
		departDate.setBackground(new Color(240, 240, 240));
		JButton dateBtn = (JButton) departDate.getComponent(1);
		BufferedImage editImage = ImageIO.read(new File("src/main/java/com/airlines/images/cal.png"));

		dateBtn.setIcon(new ImageIcon(editImage));
		dateBtn.setFocusPainted(false);

		dateBtn.setMargin(new Insets(0, 0, 0, 0));
		dateBtn.setContentAreaFilled(false);
		dateBtn.setBorderPainted(false);
		dateBtn.setOpaque(false);
		panelL.add(departDate);

		JLabel aircraftN = new JLabel("<html>Aircraft<font color=red>*</font><html>");
		aircraftN.setBounds(540, 280, 200, 50);
		aircraftN.setForeground(new Color(71, 73, 73));
		aircraftN.setFont(new Font("courier", Font.PLAIN, 25));
		panelL.add(aircraftN);

		JComboBox<String> aircraft = items();
		aircraft.setBounds(660, 280, 300, 50);
		panelL.add(aircraft);

		final JLabel msg = new JLabel("", SwingConstants.CENTER);
		msg.setVerticalAlignment(SwingConstants.CENTER);
		msg.setBounds(0, 505, 1000, 50);
		msg.setFont(new Font("courier", Font.PLAIN, 20));
		panelL.add(msg);
		msg.setVisible(true);
		panelL.add(msg);

		JLabel plus = new JLabel(new ImageIcon("src/main/java/com/airlines/images/plus.png"));
		plus.setBounds(490, 470, 32, 32);
		plus.setCursor(new Cursor(Cursor.HAND_CURSOR));
		plus.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Flight flight = new Flight();
				FlightDAOImpl flights = new FlightDAOImpl();
				try {
					flight.setFromF(fromTF.getText());
					flight.setToF(toTF.getText());
					flight.setArrivalTime(arrivalTF.getText().trim().substring(0, 1).toUpperCase()
							+ arrivalTF.getText().trim().substring(1, arrivalTF.getText().length()));
					flight.setDepartTime(departTF.getValue().toString());
					flight.setDepartDate(departDate.getDate().toString());
					flight.setAircraftName(String.valueOf(aircraft.getSelectedItem()).trim());
					flight.setFlightId(Craft.flightID());
					boolean flag = flights.saveFlight(flight);

					if (flag) {
						msg.setText("Flight successfully Added");
						msg.setForeground(new Color(71, 73, 73));
						System.out.println("add");
						fromTF.setText(null);
						toTF.setText(null);
						arrivalTF.setText(null);

					} else {
						msg.setText("Something went wrong");
						msg.setForeground(Color.red);

					}
				} catch (Exception e1) {
					msg.setText("Something went wrong");
					msg.setForeground(Color.red);

				}
			}
		});

		panelL.add(plus);

		JLabel update = new JLabel(new ImageIcon("src/main/java/com/airlines/images/update.png"));
		update.setBounds(430, 470, 32, 32);
		update.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelL.add(update);

		JLabel minus = new JLabel(new ImageIcon("src/main/java/com/airlines/images/minus.png"));
		minus.setBounds(550, 470, 32, 32);
		minus.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelL.add(minus);

		panelL.add(leftHeader);
		panel.add(panelL);

		JLabel back = new JLabel("Back");
		back.setLocation(7, 720);
		back.setSize(90, 30);
		back.setForeground(new Color(204, 204, 204));
		back.setBackground(new Color(251, 251, 251));
		back.setOpaque(true);
		back.setFont(new Font("sans-serif", Font.PLAIN, 20));
		back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FlightManagement.frame.dispose();
					AdminManagement.management();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});

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

	@SuppressWarnings("unchecked")
	private static JComboBox<String> items() {

		System.out.println("Hit");
		JComboBox<String> comboBox = null;
		comboBox = new JComboBox<String>();
		comboBox.setBounds(200, 130, 280, 50);
		comboBox = ComboBoxUI.comboUI(comboBox);
		comboBox.setFont(new Font("courier", Font.PLAIN, 22));
		AircarftDAOImpl craft = new AircarftDAOImpl();
		final List<Aircraft> craftList = craft.getAllCarft();
		for (Aircraft list : craftList) {
			comboBox.addItem("  " + list.getAircraftName());
			System.out.println(list.getAircraftName());
		}
		return comboBox;
	}

}
