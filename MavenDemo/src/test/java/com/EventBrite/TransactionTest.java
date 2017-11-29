package com.EventBrite;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TransactionTest extends JFrame {

	private JPanel contentPane;
	private JTextField NameOnCard;
	private JTextField BillingAddress;
	private JTextField CardNumber;
	private JTextField CRV;
	PaymentConfirmationTest payment = new PaymentConfirmationTest();
	private int normalLimit = 5;
	private int corporateLimit = 30;
	private boolean overLimit = false;
	private JTextField howManyToBuy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// TransactionTest frame = new TransactionTest();
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
	public TransactionTest(EventDatabaseTest theEvent, final UserDatabaseTest loggedUser) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nameLabel = new JLabel("Name on Card:");
		nameLabel.setBounds(10, 20, 179, 16);
		contentPane.add(nameLabel);

		JLabel adressLabel = new JLabel("Billing Adress: ");
		adressLabel.setBounds(10, 60, 179, 16);
		contentPane.add(adressLabel);

		JLabel creditLabel = new JLabel("Credit Number:");
		creditLabel.setBounds(10, 100, 179, 16);
		contentPane.add(creditLabel);

		JLabel crvLabel = new JLabel("CVV");
		crvLabel.setBounds(10, 140, 179, 16);
		contentPane.add(crvLabel);

		NameOnCard = new JTextField();
		NameOnCard.setBounds(10, 37, 179, 22);
		contentPane.add(NameOnCard);
		NameOnCard.setColumns(10);

		BillingAddress = new JTextField();
		BillingAddress.setBounds(10, 76, 179, 22);
		contentPane.add(BillingAddress);
		BillingAddress.setColumns(10);

		CardNumber = new JTextField();
		CardNumber.setBounds(10, 116, 179, 22);
		contentPane.add(CardNumber);
		CardNumber.setColumns(10);
		
		final JLabel ErrorMessage = new JLabel("");
		ErrorMessage.setBounds(201, 100, 201, 22);
		contentPane.add(ErrorMessage);

		CRV = new JTextField();
		CRV.setBounds(10, 160, 116, 22);
		contentPane.add(CRV);
		CRV.setColumns(10);

		JLabel title = new JLabel("Transaction");
		title.setBounds(10, 0, 179, 16);
		contentPane.add(title);

		JLabel receiptLabel = new JLabel("Receipt : " + theEvent.getTicketPrice());
		receiptLabel.setBounds(200, 20, 179, 16);
		contentPane.add(receiptLabel);

		JLabel WhoAmI = new JLabel();
		WhoAmI.setBounds(347, 20, 146, 16);
		contentPane.add(WhoAmI);

		final JLabel ThankYou = new JLabel();
		ThankYou.setBounds(201, 82, 317, 16);
		contentPane.add(ThankYou);
		
		howManyToBuy = new JTextField();
		howManyToBuy.setBounds(313, 37, 116, 22);
		contentPane.add(howManyToBuy);
		howManyToBuy.setColumns(10);

		JButton finalizePurchaseButton = new JButton("Pay");
		finalizePurchaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(loggedUser.getCorporate()) {
					int buying = Integer.parseInt(howManyToBuy.getText());
					if(buying>corporateLimit) {
						overLimit = true;
						ErrorMessage.setText(String.valueOf("Ticket limit of 30 per purchase"));
					}
				}else if (!loggedUser.isCorporate) {
					int buying = Integer.parseInt(howManyToBuy.getText());
					if(buying>normalLimit) {
						overLimit = true;
						ErrorMessage.setText(String.valueOf("Ticket limit of 5 per purchase"));
					}
				}
				
				
				if (NameOnCard.getText().equals("") || BillingAddress.getText().equals("")
						|| CardNumber.getText().equals("") || CRV.getText().equals("")) {
					ThankYou.setText("Please fill out all boxes with valid information");
				} else {
					payment.setVisible(true);
				}

			}
		});
		finalizePurchaseButton.setBounds(10, 195, 100, 20);
		contentPane.add(finalizePurchaseButton);
		
		JLabel lblNumberOfTickets = new JLabel("Number of Tickets");
		lblNumberOfTickets.setBounds(201, 40, 116, 16);
		contentPane.add(lblNumberOfTickets);
		

		/*for (int i = 0; i < theUsers.size(); i++) {
			if (theUsers.get(i).loggedIn == true) {
				WhoAmI.setText(theUsers.get(i).username);
			}
		}*/
	}
}
