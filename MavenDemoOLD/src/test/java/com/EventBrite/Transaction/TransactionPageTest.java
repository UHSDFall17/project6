<<<<<<< HEAD:MavenDemoOLD/src/test/java/com/EventBrite/Transaction/TransactionPageTest.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EventBrite.Transaction;

import com.EventBrite.EventDatabaseTest;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


/**
 *
 * @author Lindsie Dinh
 */
public class TransactionPageTest extends JFrame{
    
    private JPanel contentPane;
    private long amount;
    private int bankID;
    
    
    public TransactionPageTest(EventDatabaseTest event) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Transaction");
        title.setBounds(50, 10, 179, 16);
        contentPane.add(title);
        
        
        JLabel nameLabel = new JLabel("Name on Card:");
        nameLabel.setBounds(10, 20, 179, 16);
        contentPane.add(nameLabel);
        
        
        JTextArea name = new JTextArea("name");
        name.setBounds(10, 40, 179, 16);
        contentPane.add(name);
        
        
        JLabel adressLabel = new JLabel("Billing Adress: ");
        adressLabel.setBounds(10, 60, 179, 16);
        contentPane.add(adressLabel);
        
        
        JTextArea adress = new JTextArea("adress");
        adress.setBounds(10, 80, 179, 16);
        contentPane.add(adress);
        
        JLabel creditLabel = new JLabel("Credit Number:");
        creditLabel.setBounds(10, 100, 179, 16);
        contentPane.add(creditLabel);
        
        
        JTextArea creditNumber = new JTextArea("");
        creditNumber.setBounds(10, 120, 179, 16);
        contentPane.add(creditNumber);
        
        
        JLabel crvLabel = new JLabel("CRV");
        crvLabel.setBounds(10, 140, 179, 16);
        contentPane.add(crvLabel);
        
        JTextArea crv = new JTextArea("crv");
        crv.setBounds(10, 160, 179, 16);
        contentPane.add(crv);
        
        
        
    }
    
    
    
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EventBrite.Transaction;

import com.EventBrite.EventDatabaseTest;
import com.EventBrite.EventDetailsTest;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author Lindsie Dinh
 */
public class TransactionPageTest extends JFrame{
    
    private JPanel contentPane;
    private long amount;
    private int bankID;
    
    
    public TransactionPageTest(EventDatabaseTest event, final EventDetailsTest eventDetail) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel title = new JLabel("Transaction");
        title.setBounds(50, 10, 179, 16);
        contentPane.add(title);
        
        JLabel receiptLabel = new JLabel("Receipt : "+ event.getPrice()/100f);
        receiptLabel.setBounds(200, 20, 179, 16);
        contentPane.add(receiptLabel);
        
        JButton finalizePurchaseButton = new JButton("Pay");
        finalizePurchaseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println(theUsers.size());
                
                eventDetail.setVisible(true);
            }
        });
        finalizePurchaseButton.setBounds(200, 50, 100, 20);
        contentPane.add(finalizePurchaseButton);
        
        
        
        JLabel nameLabel = new JLabel("Name on Card:");
        nameLabel.setBounds(10, 20, 179, 16);
        contentPane.add(nameLabel);
        
        
        JTextArea name = new JTextArea("name");
        name.setBounds(10, 40, 179, 16);
        contentPane.add(name);
        
        
        JLabel adressLabel = new JLabel("Billing Adress: ");
        adressLabel.setBounds(10, 60, 179, 16);
        contentPane.add(adressLabel);
        
        
        JTextArea adress = new JTextArea("adress");
        adress.setBounds(10, 80, 179, 16);
        contentPane.add(adress);
        
        JLabel creditLabel = new JLabel("Credit Number:");
        creditLabel.setBounds(10, 100, 179, 16);
        contentPane.add(creditLabel);
        
        
        JTextArea creditNumber = new JTextArea("");
        creditNumber.setBounds(10, 120, 179, 16);
        contentPane.add(creditNumber);
        
        
        JLabel crvLabel = new JLabel("CRV");
        crvLabel.setBounds(10, 140, 179, 16);
        contentPane.add(crvLabel);
        
        JTextArea crv = new JTextArea("crv");
        crv.setBounds(10, 160, 179, 16);
        contentPane.add(crv);
        
        
        
    }
    
    
    
}
>>>>>>> origin/master:MavenDemo/src/test/java/com/EventBrite/Transaction/TransactionPageTest.java
