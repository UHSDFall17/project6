package com.EventBrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginPageTest extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	static EventPageTest eventPage;
	static LoginPageTest loginPage;
	public static UserDatabaseTest loggedInAs = new UserDatabaseTest();
	static ArrayList<UserDatabaseTest> theUsers;
	static ArrayList<EventDatabaseTest> theEvents;
	static ArrayList<String> corpCodes = new ArrayList<String>();
	static int numOfEvents = 0;
	static int numOfUsers = 0;
	private JPasswordField corpField;

	// Launch the application.

	public static void main(String[] args) {

		// Create the lists of users and events
		// Call these only once
		theUsers = InitUserData();
		theEvents = InitEventData();
		InitCorpCodes();

		// Check that info was read in properly
		/*
		 * for(int i=0; i<numOfUsers; i++) {
		 * System.out.println(theUsers.get(i).username); } for(int i=0; i<numOfEvents;
		 * i++) { System.out.println(theEvents.get(i).title); }
		 */

		//eventPage = new EventPageTest(theEvents, theUsers, loggedInAs);
		loginPage = new LoginPageTest(theUsers);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void InitCorpCodes() {
		try {
			File file = new File("Corporate Codes.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			// int x = 0;

			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);
				corpCodes.add(line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Read in Event Data
	public static ArrayList<EventDatabaseTest> InitEventData() {
		ArrayList<EventDatabaseTest> theEvents = new ArrayList<EventDatabaseTest>();
		int asset = 0;
		try {
			File file = new File("Fake Events.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			// int x = 0;

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println("Reading line " + line);
				if (asset == 0) {
					theEvents.add(new EventDatabaseTest());
					theEvents.get(numOfEvents).setTitle(line);
					asset = 1;
					continue;
				}
				if (asset == 1) {
					theEvents.get(numOfEvents).setDay(line);
					asset = 2;
					continue;
				}
				if (asset == 2) {
					theEvents.get(numOfEvents).setMonth(line);
					asset = 3;
					continue;
				}

				if (asset == 3) {
					theEvents.get(numOfEvents).setCity(line);
					asset = 4;
					continue;
				}
				if (asset == 4) {
					theEvents.get(numOfEvents).setState(line);
					asset = 5;
					continue;
				}
				if (asset == 5) {
					theEvents.get(numOfEvents).setBuildingNum(line);
					asset = 6;
					continue;
				}
				if (asset == 6) {
					theEvents.get(numOfEvents).setStreet(line);
					asset = 7;
					continue;
				}
				if (asset == 7) {
					theEvents.get(numOfEvents).setTime(line);
					asset = 8;
					continue;
				}
				if (asset == 8) {
					theEvents.get(numOfEvents).setTicketPrice(line);
					asset = 0;
					numOfEvents++;
					continue;
				}
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theEvents;
	}

	// Read in User Data
	public static ArrayList<UserDatabaseTest> InitUserData() {
		// System.out.println("Initialising");
		theUsers = new ArrayList<UserDatabaseTest>();
		try {
			// System.out.println("Trying");

			File file = new File("Fake Users.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			// int x = 0;
			int userPassMail = 0;
			boolean isUsername = true;

			while ((line = bufferedReader.readLine()) != null) {
				if (userPassMail == 0) {
					theUsers.add(new UserDatabaseTest());
					theUsers.get(numOfUsers).setUsername(line);
					userPassMail = 1;
					continue;
				}
				if (userPassMail == 1) {
					theUsers.get(numOfUsers).setPassword(line);
					userPassMail = 2;
					continue;
				}
				if (userPassMail == 2) {
					theUsers.get(numOfUsers).setEmail(line);
					userPassMail = 0;
				}

				numOfUsers++;
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return theUsers;
	}

	// Create the frame.
	public LoginPageTest(final ArrayList<UserDatabaseTest> theUsers) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		username = new JTextField();
		username.setBounds(172, 81, 116, 22);
		contentPane.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(172, 116, 116, 22);
		contentPane.add(password);

		corpField = new JPasswordField();
		corpField.setBounds(172, 151, 116, 22);
		contentPane.add(corpField);

		JLabel label = new JLabel("Username");
		label.setBounds(80, 84, 90, 16);
		contentPane.add(label);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(80, 119, 68, 16);
		contentPane.add(lblPassword);

		JLabel lblEventbrite = new JLabel("EventBrite");
		lblEventbrite.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEventbrite.setBounds(172, 13, 102, 42);
		contentPane.add(lblEventbrite);

		final JLabel label_1 = new JLabel("");
		label_1.setBounds(132, 218, 198, 22);
		contentPane.add(label_1);

		JLabel lblCorporateUser = new JLabel("Corporate User?");
		lblCorporateUser.setBounds(57, 154, 113, 16);
		contentPane.add(lblCorporateUser);

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < theUsers.size(); i++) {
					if (theUsers.get(i).loggingIn(username.getText(), password.getText())) {
						for (int y = 0; y < corpCodes.size(); y++) {
							if (corpCodes.get(y).equals(corpField.getText())) {
								theUsers.get(i).isCorporate = true;
							}
							else if(!corpCodes.get(y).equals(corpField.getText()) && !corpField.getText().equals("")) {
								label_1.setText(String.valueOf("Incorrect Corporate Code"));
							}
						}
						
						
						theUsers.get(i).loggedIn = true;
						loggedInAs = theUsers.get(i);
						
						eventPage = new EventPageTest(theEvents, theUsers, loggedInAs);
						
						loginPage.dispose();
						eventPage.setVisible(true);
						
						break;
					} else if (i == theUsers.size() - 1) {
						/*
						 * JOptionPane.showMessageDialog(null, "Incorrect Username or Password",
						 * "Failed to log in", JOptionPane.INFORMATION_MESSAGE);
						 */
						label_1.setText(String.valueOf("Incorrect username or password"));
						break;
					}
				}
			}
		});
		btnLogIn.setBounds(51, 183, 97, 25);
		contentPane.add(btnLogIn);

		JButton btnCreateAccount = new JButton("Create an Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(theUsers.size());
				SignUpTest signUp = new SignUpTest(theUsers, loginPage);
				signUp.setVisible(true);
				loginPage.dispose();
			}
		});

		btnCreateAccount.setBounds(172, 183, 148, 25);
		contentPane.add(btnCreateAccount);

	}
}
