package com.airlines.frames;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.airlines.dao.impl.UserDAOImpl;
import com.airlines.entity.User;

public class FirstPanel {

	public static JPanel firstPanel() throws Exception {
		Font f = new Font("SansSerif", Font.BOLD, 40);
		final JPanel frontpanel = Panel.panel();

		BufferedImage picture = ImageIO.read(new File("src/main/java/com/airlines/images/assistant.png"));
		final JLabel bg = new JLabel(new ImageIcon(picture));

		JLabel manageFlights = new JLabel("Manage Flights", SwingConstants.CENTER);
		manageFlights.setVerticalAlignment(SwingConstants.CENTER);

		JLabel uList = new JLabel("Get Users List", SwingConstants.CENTER);
		uList.setVerticalAlignment(SwingConstants.CENTER);

		JLabel getUserByEmail = new JLabel("Get User By Email", SwingConstants.CENTER);
		getUserByEmail.setVerticalAlignment(SwingConstants.CENTER);

		JLabel getUserByUserName = new JLabel("Get User By Username", SwingConstants.CENTER);
		getUserByUserName.setVerticalAlignment(SwingConstants.CENTER);

		manageFlights.setBackground(new Color(248, 140, 109));
		manageFlights.setForeground(Color.WHITE);
		manageFlights.setLocation(700, 185);
		manageFlights.setSize(500, 100);
		manageFlights.setFont(f);
		manageFlights.setOpaque(true);
		manageFlights.setCursor(new Cursor(Cursor.HAND_CURSOR));

		manageFlights.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				try {
					AdminManagement.management();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				AdminWelcome.frontpanel.setVisible(false);
				AdminWelcome.frame.dispose();
				
			}
		});

		uList.setBackground(new Color(248, 140, 109));
		uList.setForeground(Color.WHITE);
		uList.setLocation(700, 300);
		uList.setSize(500, 100);
		uList.setFont(f);
		uList.setOpaque(true);
		uList.setCursor(new Cursor(Cursor.HAND_CURSOR));
		uList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserDAOImpl user = new UserDAOImpl();

				List<User> list = user.getAllUser();
				if (list != null) {
					AdminService.serviceFrameToGetUserList(list);
					AdminService.sf.addWindowFocusListener(new WindowFocusListener() {

						public void windowLostFocus(WindowEvent e) {
							AdminService.sf.dispose();
						}

						public void windowGainedFocus(WindowEvent arg0) {
						}
					});
				} else {
				}
			}
		});

		getUserByEmail.setBackground(new Color(248, 140, 109));
		getUserByEmail.setForeground(Color.WHITE);
		getUserByEmail.setLocation(700, 415);
		getUserByEmail.setSize(500, 100);
		getUserByEmail.setFont(f);
		getUserByEmail.setOpaque(true);
		getUserByEmail.setCursor(new Cursor(Cursor.HAND_CURSOR));

		getUserByEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GetUser.getCommand = 0;
				GetUser.getUserDialogFrame();
				GetUser.label.setText("Get Member by Email Address:");
				++GetUser.getCommand;
			}

		});

		getUserByUserName.setBackground(new Color(248, 140, 109));
		getUserByUserName.setForeground(Color.WHITE);
		getUserByUserName.setLocation(700, 530);
		getUserByUserName.setSize(500, 100);
		getUserByUserName.setFont(f);
		getUserByUserName.setOpaque(true);
		getUserByUserName.setCursor(new Cursor(Cursor.HAND_CURSOR));

		getUserByUserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GetUser.getCommand = 0;
				GetUser.getUserDialogFrame();
				GetUser.label.setText("Get Member by Username:");

			}

		});
		final JLabel logout = new JLabel("Logout");

		logout.setLocation(7, 620);
		logout.setSize(90, 30);
		logout.setForeground(new Color(243, 243, 243));
		logout.setBackground(Color.white);

		logout.setOpaque(true);
		logout.setFont(new Font("sans-serif", Font.PLAIN, 20));
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Login.loginFrame();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				AdminWelcome.frontpanel.setVisible(false);
				AdminWelcome.frame.dispose();
				
			}

		});

		bg.setSize(512, 512);
		bg.setLocation(100, 100);

		frontpanel.add(bg);
		frontpanel.add(uList);
		frontpanel.add(getUserByEmail);
		frontpanel.add(getUserByUserName);
		frontpanel.add(logout);
		frontpanel.add(manageFlights);

		return frontpanel;

	}
}
