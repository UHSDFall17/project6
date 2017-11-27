package com.EventBrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class EventDetailsTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// EventDetailsTest frame = new EventDetailsTest();
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
	public EventDetailsTest(final EventDatabaseTest theEvent, final ArrayList<UserDatabaseTest> theUsers) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("");
		title.setBounds(50, 13, 179, 16);
		contentPane.add(title);

		JLabel day = new JLabel("New label");
		day.setBounds(50, 42, 179, 16);
		contentPane.add(day);
		day.setText(theEvent.day);

		JLabel month = new JLabel("");
		month.setBounds(50, 73, 179, 16);
		contentPane.add(month);

		JLabel city = new JLabel("");
		city.setBounds(50, 102, 179, 16);
		contentPane.add(city);

		JLabel state = new JLabel("");
		state.setBounds(50, 131, 179, 16);
		contentPane.add(state);

		JLabel buildingNum = new JLabel("");
		buildingNum.setBounds(50, 160, 179, 16);
		contentPane.add(buildingNum);

		JLabel street = new JLabel("");
		street.setBounds(50, 189, 179, 16);
		contentPane.add(street);

		JLabel time = new JLabel("");
		time.setBounds(50, 218, 179, 16);
		contentPane.add(time);

		JLabel ticketPrice = new JLabel("");
		ticketPrice.setBounds(268, 160, 56, 16);
		contentPane.add(ticketPrice);

		title.setText(theEvent.title);
		month.setText(theEvent.month);
		city.setText(theEvent.city);
		state.setText(theEvent.state);
		buildingNum.setText(theEvent.buildingNum);
		street.setText(theEvent.street);
		time.setText(theEvent.time);
		ticketPrice.setText("$"  + theEvent.ticketPrice);

		JButton btnBookTickets = new JButton("Book Tickets");
		btnBookTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TransactionTest paymentPage = new TransactionTest(theEvent, theUsers);
				paymentPage.setVisible(true);
				Dispose();
			}
		});
		btnBookTickets.setBounds(241, 122, 108, 25);
		contentPane.add(btnBookTickets);

	}

	public void Dispose() {
		this.dispose();
	}

}
