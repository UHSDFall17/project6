package com.EventBrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EventPageTest extends JFrame {
	private JButton btnLookForEvent;

	private JPanel contentPane;
	EventDetailsTest eventDetailPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventPageTest(final ReadInDataTest librarian, final UserDatabaseTest loggedUser) {


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
		
		JPanel panel = new JPanel();
		panel.setBounds(49, 149, 921, 390);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 6, 0, 0));
		
		for (int i = 0; i < librarian.getTheEvents().size(); i++) {

			final JButton b = new JButton(String.valueOf(librarian.getTheEvents().get(i).title));
			b.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					for (int x = 0; x < librarian.getTheEvents().size(); x++) {
						if (b.getText().equals(librarian.getTheEvents().get(x).title)) {

							eventDetailPage = new EventDetailsTest(librarian, x, loggedUser);
							break;
						}
					}
					eventDetailPage.setVisible(true);
					//DisposeThisPage();
				}
			});
			panel.add(b);
		}
		
		JButton btnLookForEvent_1 = new JButton("Look for Event");
		btnLookForEvent_1.setBounds(603, 75, 117, 25);
		contentPane.add(btnLookForEvent_1);

		JLabel lblEvents = new JLabel("Events");
		lblEvents.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEvents.setBounds(49, 92, 147, 32);
		contentPane.add(lblEvents);



		JLabel lblNoDetails = new JLabel("");
		lblNoDetails.setBounds(609, 103, 56, 16);
		contentPane.add(lblNoDetails);
	}

}
