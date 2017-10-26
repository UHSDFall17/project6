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
import java.util.ArrayList;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EventPageTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtDay;
	private JTextField txtMonth;
	private JTextField txtCity;
	private JTextField txtState;
	private JButton btnLookForEvent;

	static ArrayList<EventDatabaseTest> theEvents = new ArrayList<EventDatabaseTest>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InitTestData();
					EventPageTest frame = new EventPageTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EventPageTest() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblEventbrite = new JLabel("EventBrite");
		lblEventbrite.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEventbrite.setBounds(662, 9, 255, 32);
		contentPane.add(lblEventbrite);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.WHITE);
		// lblNewLabel.setIcon(new
		// ImageIcon("C:\\Users\\Etienne\\Desktop\\Personal\\Classes\\Software
		// Design\\Last Stand of the Crimson Fists x 1000.jpg"));
		lblNewLabel.setIcon(new ImageIcon(
				"C:\\Users\\Etienne\\eclipse-workspace\\MavenDemo\\src\\test\\resources\\eventBrite screenshot.png"));
		lblNewLabel.setBounds(12, 169, 1458, 771);
		contentPane.add(lblNewLabel);

		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLookForEvent = new JButton("Look For Event");
				btnLookForEvent.setBounds(1077, 94, 130, 25);
				contentPane.add(btnLookForEvent);
			}
		});
		btnMenu.setBounds(607, 71, 97, 25);
		contentPane.add(btnMenu);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMonth = new JTextField();
				txtMonth.setText("Month");
				txtMonth.setBounds(835, 108, 116, 22);
				contentPane.add(txtMonth);
				txtMonth.setColumns(10);

				txtCity = new JTextField();
				txtCity.setText("City");
				txtCity.setBounds(956, 84, 116, 22);
				contentPane.add(txtCity);
				txtCity.setColumns(10);

				txtDay = new JTextField();
				txtDay.setText("Day");
				txtDay.setBounds(835, 84, 116, 22);
				contentPane.add(txtDay);
				txtDay.setColumns(10);

				txtState = new JTextField();
				txtState.setText("State");
				txtState.setBounds(956, 108, 116, 22);
				contentPane.add(txtState);
				txtState.setColumns(10);

				btnLookForEvent = new JButton("Look For Event");
				btnLookForEvent.setBounds(1077, 94, 130, 25);
				contentPane.add(btnLookForEvent);

			}
		});
		btnSearch.setBounds(733, 71, 97, 25);
		contentPane.add(btnSearch);

		JLabel lblEvents = new JLabel("Events");
		lblEvents.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEvents.setBounds(694, 124, 76, 32);
		contentPane.add(lblEvents);

	}

	public static void InitTestData() {
		int x = 0;
		int asset = 0;
		try {
			File file = new File("Fake Events.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;

			while ((line = bufferedReader.readLine()) != null) {
				if (asset == 0) {
					theEvents.add(new EventDatabaseTest());
					theEvents.get(x).setTitle(line);
					asset = 1;
					continue;
				}
				if (asset == 1) {
					theEvents.get(x).setMonth(line);
					asset = 2;
					continue;
				}
				if (asset == 2) {
					theEvents.get(x).setDay(line);
					asset = 3;
					continue;
				}
				if (asset == 3) {
					theEvents.get(x).setCity(line);
					asset = 4;
					continue;
				}
				if (asset == 4) {
					theEvents.get(x).setState(line);
					asset = 5;
					continue;
				}
				if (asset == 5) {
					theEvents.get(x).setTime(line);
					asset = 0;
					x++;
					continue;
				}
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
