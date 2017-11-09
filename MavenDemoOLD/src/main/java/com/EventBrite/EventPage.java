package com.EventBrite;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class EventPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventPage frame = new EventPage();
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
	public EventPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblEventbrite = new JLabel("EventBrite");
		lblEventbrite.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblEventbrite.setBounds(397, 13, 255, 32);
		contentPane.add(lblEventbrite);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.WHITE);
		//lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Etienne\\Desktop\\Personal\\Classes\\Software Design\\Last Stand of the Crimson Fists x 1000.jpg"));
		lblNewLabel.setIcon(new ImageIcon("Last Stand of the Crimson Fists x 1000.jpg"));
		lblNewLabel.setBounds(12, 58, 958, 653);
		contentPane.add(lblNewLabel);
	}
}
