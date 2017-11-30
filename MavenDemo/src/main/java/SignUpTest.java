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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class SignUpTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtEmail;
	static ArrayList<UserDatabaseTest> knownUsers;
	static int x = 0; // Number of users
	private JLabel errorMessage;
	boolean exists;
	LoginPageTest backToLoginPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// InitTestData();
					// SignUpTest frame = new SignUpTest();
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
	public SignUpTest(ArrayList<UserDatabaseTest> theUsers, LoginPageTest loginPage) {
		knownUsers = theUsers;
		backToLoginPage = loginPage;
		
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

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				exists = IExist(txtUsername.getText(), txtEmail.getText());
			}
		});
		btnSubmit.setBounds(208, 84, 97, 25);
		contentPane.add(btnSubmit);

		errorMessage = new JLabel("");
		errorMessage.setBounds(80, 155, 187, 16);
		contentPane.add(errorMessage);
		if(exists) {
			System.out.println("Here's a user");
			errorMessage.setText("Username already Exists");
		}
		
	}

	public boolean IExist(String inputName, String inputEmail) {
		//System.out.println("checking database of size " + knownUsers.size());
		for (int i = 0; i < knownUsers.size(); i++) {
			if (knownUsers.get(i).username.equals(inputName)) {
				errorMessage.setText("Username already Exists");
				return true;
			}else if (knownUsers.get(i).email.equals(inputEmail)) {
				errorMessage.setText("Email already in use");
				return true;
			}else if(txtUsername.getText().equals("Username") || txtPassword.getText().equals("Password") || txtEmail.getText().equals("Email")) {
				errorMessage.setText("Unique information required");
			}
			else {
				WriteToUserList();
				
				this.dispose();
				backToLoginPage.setVisible(true);
				return false;
			}
		}

		return false;
	}
	public void WriteToUserList() {
		try {
			Writer output = new BufferedWriter(new FileWriter("Fake Users.txt", true));
			
			output.append("\n");
			output.append(txtUsername.getText());
			output.append("\n");
			
			output.append(txtPassword.getText());
			output.append("\n");
			
			output.append(txtEmail.getText());
			output.close();
			
			knownUsers.add(new UserDatabaseTest());
			knownUsers.get(x).setUsername(txtUsername.getText());
			knownUsers.get(x).setPassword(txtPassword.getText());
			knownUsers.get(x).setEmail(txtEmail.getText());
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
