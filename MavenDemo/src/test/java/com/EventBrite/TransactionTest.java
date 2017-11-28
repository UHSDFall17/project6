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

public class TransactionTest extends JFrame {

    private JPanel contentPane;
    private JTextField NameOnCard;
    private JTextField BillingAddress;
    private JTextField CardNumber;
    private JTextField CRV;
    PaymentConfirmationTest payment = new PaymentConfirmationTest();

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
    public TransactionTest(EventDatabaseTest theEvent, UserDatabaseTest user) {
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

        JLabel crvLabel = new JLabel("CRV");
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

        JButton finalizePurchaseButton = new JButton("Pay");
        finalizePurchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (NameOnCard.getText().equals("") || BillingAddress.getText().equals("")
                        || CardNumber.getText().equals("") || CRV.getText().equals("")) {
                    ThankYou.setText("Please fill out all boxes with valid information");
                } else {
                    payment.setVisible(true);
                }

            }
        });
        finalizePurchaseButton.setBounds(200, 50, 100, 20);
        contentPane.add(finalizePurchaseButton);
        
        WhoAmI.setText(user.getUsername());

//        for (int i = 0; i < theUsers.size(); i++) {
//            if (theUsers.get(i).loggedIn == true) {
//                WhoAmI.setText(theUsers.get(i).username);
//            }
//        }
    }
}
