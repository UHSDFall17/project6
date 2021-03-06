//package com.EventBrite.EventBriteDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class PaymentConfirmation extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public PaymentConfirmation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ThankYou = new JLabel("Confirmation of Payment has ben emailed");
		ThankYou.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ThankYou.setBounds(25, 95, 374, 40);
		contentPane.add(ThankYou);
		
		JLabel lblNewLabel = new JLabel("Thank you for purchasing");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(86, 77, 277, 19);
		contentPane.add(lblNewLabel);
	}
}
