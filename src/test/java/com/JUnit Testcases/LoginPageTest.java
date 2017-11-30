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
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class LoginPageTest extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	EventPageTest eventPage;
	public static UserDatabaseTest loggedInAs = new UserDatabaseTest();
	static int numOfEvents = 0;
	static int numOfUsers = 0;
	private JPasswordField corpField;
	boolean corpInput = false;
	private boolean corpCodeCorrect = false;
	private boolean userInfoCorrect = false;
	private int foundUserIndex;
	private boolean goodToGo = false;

	// Launch the application.

	public static void initialize() {
		numOfEvents = 0;
		numOfUsers = 0;

	}

	public static void main(String[] args) {

		// Create the lists of users and events
		// Call these only once
		final LoginPageTest loginPage = new LoginPageTest();
		ReadInDataTest Reading = new ReadInDataTest();
		Reading.InitUserData();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Read in Event Data

	// Read in User Data

	// Create the frame.
	public LoginPageTest() {
		
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 448);
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

		final JCheckBox amICorporate = new JCheckBox("");
		amICorporate.setBounds(172, 147, 30, 25);
		contentPane.add(amICorporate);

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

		final JLabel ErrorMessage = new JLabel("");
		ErrorMessage.setBounds(104, 216, 198, 22);
		contentPane.add(ErrorMessage);

		JLabel lblCorporateUser = new JLabel("Corporate User?");
		lblCorporateUser.setBounds(57, 184, 113, 16);
		contentPane.add(lblCorporateUser);

		corpField = new JPasswordField();
		corpField.setBounds(172, 181, 116, 22);
		contentPane.add(corpField);
		corpField.setEnabled(false);

		amICorporate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					corpField.setEnabled(true);
				}
			}
		});

		JButton btnLogIn = new JButton("Log In");

		// btnLogIn.addActionListener(new ActionListener() {
		// @SuppressWarnings("deprecation")
		// public void actionPerformed(ActionEvent e) {
		// if (corpField.getText().equals("")) {
		// corpInput = false;
		// } else {
		// corpInput = true;
		// }
		// login_loop: for (int i = 0; i < theUsers.size(); i++) {
		// if (theUsers.get(i).loggingIn(username.getText(), password.getText())) {
		// userInfoCorrect = true;
		// foundUserIndex = i;
		// if (amICorporate.isSelected()) {
		//
		// SearchCorporateCodes(corpField.getText());
		// }
		//
		// if (userInfoCorrect) {
		// if (corpCodeCorrect && amICorporate.isSelected()) {
		// theUsers.get(foundUserIndex).isCorporate = true;
		// goodToGo = true;
		// } else if (amICorporate.isSelected() && !corpCodeCorrect) {
		// ErrorMessage.setText(String.valueOf("Please enter the correct code"));
		// } else if (!amICorporate.isSelected() && !corpInput) {
		// goodToGo = true;
		// }
		//
		// }
		//
		// break;
		// } else if (i == theUsers.size() - 1) {
		// /*
		// * JOptionPane.showMessageDialog(null, "Incorrect Username or Password",
		// * "Failed to log in", JOptionPane.INFORMATION_MESSAGE);
		// */
		// ErrorMessage.setText(String.valueOf("Incorrect username or password"));
		// break;
		// }
		// }
		// if (goodToGo) {
		//
		// theUsers.get(foundUserIndex).loggedIn = true;
		// loggedInAs = theUsers.get(foundUserIndex);
		//
		// // eventPage = new EventPageTest(theEvents, theUsers, loggedInAs);
		//
		// // loginPage.dispose();
		// eventPage.setVisible(true);
		// }
		//
		// }
		// });

		btnLogIn.setBounds(73, 251, 97, 25);
		contentPane.add(btnLogIn);

		JButton btnCreateAccount = new JButton("Create an Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// SignUpTest signUp = new SignUpTest(theUsers, loginPage);
				// signUp.setVisible(true);
				// loginPage.dispose();
			}
		});

		btnCreateAccount.setBounds(182, 251, 148, 25);
		contentPane.add(btnCreateAccount);

		JLabel lblNewLabel = new JLabel("Corporate User?");
		lblNewLabel.setBounds(57, 151, 113, 16);
		contentPane.add(lblNewLabel);

	}

	boolean SearchCorporateCodes(String corpText) {
		// for (int y = 0; y < corpCodes.size(); y++) {
		// if (corpCodes.get(y).equals(corpField.getText())) {
		// corpCodeCorrect = true;
		// break;
		// }
		// }
		return corpCodeCorrect;
	}
}
