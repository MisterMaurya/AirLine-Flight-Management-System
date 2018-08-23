package com.airlines.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import com.airlines.entity.User;

public class AdminService {
	static JFrame sf;

	public static void serviceFrameToGetUser(User u) throws IOException {

		sf = new JFrame();
		JLabel heading;
		BufferedImage picture = null;
		Font f = new Font("SansSerif", Font.BOLD, 40);
		Font f2 = new Font("SansSerif", Font.BOLD, 25);
		JLabel fullName;
		JLabel userName;
		JLabel email;
		JLabel gender;
		JLabel contact;
		JLabel address;
		JLabel dob;
		JLabel icon;
		heading = new JLabel("Airline Member", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 700, 100);
		heading.setOpaque(true);
		heading.setBackground(new Color(43, 59, 78));
		heading.setForeground(Color.WHITE);
		heading.setFont(f);

		if (u.getGender().equals("Male")) {
			picture = ImageIO.read(new File("src/main/java/com/airlines/images/Bo.png"));
		} else {
			picture = ImageIO.read(new File("src/main/java/com/airlines/images/gi.png"));
		}

		icon = new JLabel(new ImageIcon(picture));
		icon.setBounds(210, 122, 256, 256);

		fullName = new JLabel(u.getFullName(), SwingConstants.CENTER);
		fullName.setVerticalAlignment(SwingConstants.CENTER);
		fullName.setBounds(0, 370, 700, 100);
		fullName.setForeground(new Color(253, 132, 105));
		fullName.setFont(f);

		userName = new JLabel(u.getUserName());
		userName.setBounds(100, 420, 700, 100);
		userName.setForeground(new Color(50, 74, 94));
		userName.setFont(f2);

		email = new JLabel(u.getEmail());
		email.setBounds(100, 455, 700, 100);
		email.setForeground(new Color(50, 74, 94));
		email.setFont(f2);

		dob = new JLabel(u.getDob());
		dob.setBounds(100, 490, 700, 100);
		dob.setForeground(new Color(50, 74, 94));
		dob.setFont(f2);

		gender = new JLabel(u.getGender());
		gender.setBounds(100, 525, 700, 100);
		gender.setForeground(new Color(50, 74, 94));
		gender.setFont(f2);

		contact = new JLabel(u.getContact());
		contact.setBounds(100, 560, 700, 100);
		contact.setForeground(new Color(50, 74, 94));
		contact.setFont(f2);

		address = new JLabel(u.getAddress());
		address.setBounds(100, 595, 700, 100);
		address.setForeground(new Color(50, 74, 94));
		address.setFont(f2);
		
		sf.addWindowFocusListener(new WindowFocusListener() {
			
			public void windowLostFocus(WindowEvent e) {
				sf.dispose();
				
			}
			
			public void windowGainedFocus(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		sf.setLayout(null);
		sf.add(heading);
		sf.add(icon);
		sf.add(fullName);

		sf.add(userName);
		sf.add(email);
		sf.add(dob);
		sf.add(gender);
		sf.add(contact);
		sf.add(address);

		sf.setSize(700, 800);
		sf.setResizable(false);
		sf.setLocationRelativeTo(null);
		sf.getContentPane().setBackground(Color.WHITE);
		sf.setVisible(true);

	}

	public static void serviceFrameToGetUserList(List<User> list) {
		sf = new JFrame();
		sf.setLayout(null);

		JLabel heading;
		Font f = new Font("SansSerif", Font.BOLD, 40);

		heading = new JLabel("Airline Members", SwingConstants.CENTER);
		heading.setVerticalAlignment(SwingConstants.CENTER);
		heading.setBounds(0, 0, 1200, 100);
		heading.setOpaque(true);
		heading.setBackground(new Color(9, 195, 218));
		heading.setForeground(Color.WHITE);
		heading.setFont(f);

		String[] header = { "Full Name", "Username", "Email", "Date of Birth", "Gender", "Contact", "Address" };
		String rowData1[][] = new String[list.size()][header.length];

		int i = 0;
		for (User u : list) {
			if (i < list.size()) {

				rowData1[i][0] = u.getFullName();
				rowData1[i][1] = u.getUserName();
				rowData1[i][2] = u.getEmail();
				rowData1[i][3] = u.getDob();
				rowData1[i][4] = u.getGender();
				rowData1[i][5] = u.getContact();
				rowData1[i][6] = u.getAddress();
				++i;
			}
		}

		JTable table = new JTable(rowData1, header);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		DefaultTableCellRenderer color = new DefaultTableCellRenderer();
		color.setBackground(new Color(235, 235, 235));
		
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(5);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);

		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
		table.setFont(new Font("Verdana", Font.PLAIN, 16));
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 20));
		JTableHeader head = table.getTableHeader();
		head.setPreferredSize(new Dimension(100, 45));
		table.getTableHeader().setBackground(new Color(243, 243, 243));

		table.setRowHeight(42);
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);

		JScrollPane scrollPane1 = new JScrollPane(table);

		scrollPane1.setLocation(0, 120);
		scrollPane1.setSize(1200, 630);
		sf.add(scrollPane1);

		sf.add(heading);
		sf.setSize(1200, 800);
		sf.setResizable(false);
		sf.setLocationRelativeTo(null);
		sf.getContentPane().setBackground(Color.WHITE);
		sf.setVisible(true);

	}

}
