package com.EventBrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class EventPageTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtCity;
	private JTextField txtState;
	private JButton btnLookForEvent;
	EventDetailsTest eventDetailPage;
	UserDatabaseTest whoAmI;
	ArrayList<EventDatabaseTest> theEvents;
	// ArrayList<EventDatabaseTest> thisEvent;

	static int numOfEvents; // Number of events in the system

	// static ArrayList<EventDatabaseTest> theEvents = new
	// ArrayList<EventDatabaseTest>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// InitTestData();
					// EventPageTest frame = new EventPageTest(theEvents);
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventPageTest(final ArrayList<EventDatabaseTest> Events, final ArrayList<UserDatabaseTest> theUsers,
			UserDatabaseTest loggedInAs) {
		theEvents = Events;
		
		if(loggedInAs.isCorporate == true) {
			CutPrices();
		}
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1011, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblEventbrite = new JLabel("EventBrite");
		lblEventbrite.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEventbrite.setBounds(401, 13, 255, 32);
		contentPane.add(lblEventbrite);

		txtMonth = new JTextField();
		txtMonth.setText("Month");
		txtMonth.setBounds(360, 100, 116, 22);
		contentPane.add(txtMonth);
		txtMonth.setColumns(10);

		txtCity = new JTextField();
		txtCity.setText("City");
		txtCity.setBounds(481, 76, 116, 22);
		contentPane.add(txtCity);
		txtCity.setColumns(10);

		txtDay = new JTextField();
		txtDay.setText("Day");
		txtDay.setBounds(360, 76, 116, 22);
		contentPane.add(txtDay);
		txtDay.setColumns(10);

		txtState = new JTextField();
		txtState.setText("State");
		txtState.setBounds(481, 100, 116, 22);
		contentPane.add(txtState);
		txtState.setColumns(10);

		JButton btnLookForEvent_1 = new JButton("Look for Event");
		btnLookForEvent_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < theEvents.size(); i++) {
					theEvents.get(i).SearchEvent(txtDay.getText(), txtMonth.getText(), txtCity.getText(),
							txtState.getText());
				}
			}
		});
		btnLookForEvent_1.setBounds(603, 75, 117, 25);
		contentPane.add(btnLookForEvent_1);

		JLabel lblEvents = new JLabel("Events");
		lblEvents.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEvents.setBounds(49, 92, 147, 32);
		contentPane.add(lblEvents);

		JPanel panel = new JPanel();
		panel.setBounds(49, 149, 921, 390);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 6, 0, 0));

		JLabel lblNoDetails = new JLabel("");
		lblNoDetails.setBounds(609, 103, 56, 16);
		contentPane.add(lblNoDetails);

		for (int i = 0; i < theEvents.size(); i++) {

			final JButton b = new JButton(String.valueOf(theEvents.get(i).title));
			b.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					for (int x = 0; x < theEvents.size(); x++) {
						if (b.getText().equals(theEvents.get(x).title)) {

							eventDetailPage = new EventDetailsTest(theEvents.get(x), theUsers);
						}
					}
					eventDetailPage.setVisible(true);
					DisposeThisPage();
				}
			});
			panel.add(b);
		}

	}

	public void DisposeThisPage() {
		this.dispose();
	}

	public void CutPrices() {
		for(int x = 0; x<theEvents.size(); x++) {
			double salePrice = Double.parseDouble(theEvents.get(x).ticketPrice)*0.6;
			
			DecimalFormat df = new DecimalFormat("#.00");
			String salePriceFormated = df.format(salePrice);
			
			theEvents.get(x).ticketPrice = String.valueOf(salePriceFormated);
		}
	}

}
