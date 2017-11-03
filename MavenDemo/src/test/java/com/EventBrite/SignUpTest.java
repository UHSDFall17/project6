package com.EventBrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class SignUpTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtEmail;
<<<<<<< HEAD
	static ArrayList<UserDatabaseTest> knownUsers = new ArrayList<UserDatabaseTest>();
	static int x = 0; // Number of users
	private JLabel lblNewLabel;
	boolean exists;
=======
	static ArrayList<UserDatabaseTest> theUsers = new ArrayList<UserDatabaseTest>();
	static int x = 0; // Number of users
>>>>>>> d7ca2f021fb616693f80c100ff0b4db9b80cf2aa

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
<<<<<<< HEAD
					// InitTestData();
					// SignUpTest frame = new SignUpTest();
					// frame.setVisible(true);
=======
					InitTestData();
					SignUpTest frame = new SignUpTest();
					frame.setVisible(true);
>>>>>>> d7ca2f021fb616693f80c100ff0b4db9b80cf2aa
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

<<<<<<< HEAD
	/*public static void InitTestData() {
=======
	public static void InitTestData() {
>>>>>>> d7ca2f021fb616693f80c100ff0b4db9b80cf2aa
		try {
			File file = new File("Fake Users.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			int userPassMail = 0;
			boolean isUsername = true;

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println(line);
				if (userPassMail == 0) {
					theUsers.add(new UserDatabaseTest());
					theUsers.get(x).setUsername(line);
					userPassMail = 1;
					continue;
				}
				if (userPassMail == 1) {
					theUsers.get(x).setPassword(line);
					userPassMail = 2;
					continue;
				}
				if (userPassMail == 2) {
					theUsers.get(x).setEmail(line);
					userPassMail = 0;
				}

				x++;
			}

			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		 for (int i = 0; i < x; i++) { System.out.println(theUsers.get(i).username); }
		 
	}
*/
=======
		/*
		 * for (int i = 0; i < x; i++) { System.out.println(theUsers.get(i).username); }
		 */
	}
>>>>>>> d7ca2f021fb616693f80c100ff0b4db9b80cf2aa

	/**
	 * Create the frame.
	 */
<<<<<<< HEAD
	public SignUpTest(ArrayList<UserDatabaseTest> theUsers) {
		knownUsers = theUsers;
		
=======
	public SignUpTest() {
>>>>>>> d7ca2f021fb616693f80c100ff0b4db9b80cf2aa
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtUsername = new JTextField();
		txtUsername.setText("Username");
		txtUsername.setBounds(80, 56, 116, 22);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setText("Password");
		txtPassword.setBounds(80, 85, 116, 22);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(80, 120, 116, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

<<<<<<< HEAD
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(txtUsername.getText());
				
				exists = IExist(txtUsername.getText());
=======
		final JLabel lblUsernameAlreadyExists = new JLabel();
		lblUsernameAlreadyExists.setBounds(80, 155, 176, 16);
		contentPane.add(lblUsernameAlreadyExists);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IExist(txtUsername.getText());
>>>>>>> d7ca2f021fb616693f80c100ff0b4db9b80cf2aa
			}
		});
		btnSubmit.setBounds(208, 84, 97, 25);
		contentPane.add(btnSubmit);
<<<<<<< HEAD

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(80, 155, 149, 16);
		contentPane.add(lblNewLabel);
		if(exists) {
			System.out.println("Here's a user");
			lblNewLabel.setText("Username already Exists");
		}
		
	}

	public boolean IExist(String inputName) {
		//System.out.println("checking database of size " + knownUsers.size());
		for (int i = 0; i < knownUsers.size(); i++) {
			//System.out.println("Checking " + knownUsers.get(i).username + " with " + inputName);
			if (knownUsers.get(i).username.equals(inputName)) {
				//System.out.println("Found one");
				lblNewLabel.setText("Username already Exists");
				return true;
			}
			// System.out.println("username already exists");
			else {
				//LoginPageTest.main(null);
				return false;
			}
		}

=======
	}

	public boolean IExist(String inputName) {
		for (int i = 0; i < x; i++) {
			if (theUsers.get(i).username.equals(inputName)) {
				return false;
			}
				// System.out.println("username already exists");
				//lblUsernameAlreadyExists.setText("Username Already Extsis");
			 else {
				return true;
			}
		}
		
>>>>>>> d7ca2f021fb616693f80c100ff0b4db9b80cf2aa
		return false;
	}
}
