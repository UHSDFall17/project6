//package com.EventBrite.EventBriteDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JPasswordField corpField;
	private JTextField username;
	private JTextField password;
	UserDatabase loggedInAs = new UserDatabase();
	EventPage eventPage;
	LoginPage loginPage;
	Authentication warden;

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
	public LoginPage( final Authentication theWarden) {
		
		warden = theWarden;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel ErrorMessage = new JLabel("");
		ErrorMessage.setBounds(104, 216, 198, 22);
		contentPane.add(ErrorMessage);

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

		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				theWarden.Authenticate(username.getText(), password.getText(), amICorporate.isSelected(),
						corpField.getPassword());
				
				if (theWarden.getCredValidation()) {
					// Log in as Normal
					if (theWarden.getCorpValidation() == 0) {
						eventPage = new EventPage(theWarden.getReader(), theWarden.getLoggedUser());
						eventPage.setVisible(true);
					}
					if (theWarden.getCorpValidation() == 1) {
						eventPage = new EventPage(theWarden.getReader(), theWarden.getLoggedUser());
						eventPage.setVisible(true);
					}
					if (theWarden.getCorpValidation() == 2) {
						ErrorMessage.setText("Incorrect Corporate Code");
					}
				}else {
					ErrorMessage.setText("Incorrect username or Password");
				}
			}
		});
		btnLogIn.setBounds(73, 251, 97, 25);
		contentPane.add(btnLogIn);

		JLabel lblEventbrite = new JLabel("EventBrite");
		lblEventbrite.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblEventbrite.setBounds(172, 13, 102, 42);
		contentPane.add(lblEventbrite);

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

		JButton btnCreateAccount = new JButton("Create an Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoToSignUp();
			}
		});

		btnCreateAccount.setBounds(182, 251, 148, 25);
		contentPane.add(btnCreateAccount);

		JLabel lblNewLabel = new JLabel("Corporate User?");
		lblNewLabel.setBounds(57, 151, 113, 16);
		contentPane.add(lblNewLabel);
	}
	public void GoToSignUp() {
		SignUp signUpPage = new SignUp(warden.getTheUsers(), this);
		signUpPage.setVisible(true);
	}
}
