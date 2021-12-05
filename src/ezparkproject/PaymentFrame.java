package ezparkproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PaymentFrame implements ActionListener {

	JFrame frame;
	
	JLabel ccLabel = new JLabel("Credit Card Number: ");;
	JLabel cvvLabel = new JLabel("CVV Number (3-Digits: ");;
	JLabel expiryLabel = new JLabel("Expiry Date: ");;
	
	JTextField ccField = new JTextField();;
	JTextField cvvField = new JTextField();;
	JTextField expiryField = new JTextField();;
	
	JButton payButton = new JButton("Pay");;
	JButton backButton = new JButton("Back");;

	double Fee = 2;
	
	PaymentFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
		
		
	}
	
	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Payment Detail Screen");
		frame.setBounds(450, 190, 1014, 597);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}


	public void setLocationAndSize() {
		
		
		/* Label locations */
		
		ccLabel.setBounds(50, 100, 20, 30);
		ccLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		ccLabel.setSize(500,50);
		
		cvvLabel.setBounds(50, 200, 200, 30);
		cvvLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		cvvLabel.setSize(500,50);
		
		expiryLabel.setBounds(50, 300, 2, 30);
		expiryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		expiryLabel.setSize(500,50);
	
		/* text fields locations */
		
		ccField.setBounds(300, 110, 250, 100);  
		ccField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		ccField.setSize(300,30);
		ccField.setEditable(true);

		cvvField.setBounds(300,210, 90, 23);  
		cvvField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cvvField.setSize(300,30);
		cvvField.setEditable(true);
		
		expiryField.setBounds(300,310, 90, 23);  
		expiryField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		expiryField.setSize(300,30);
		expiryField.setEditable(true);


        /* Find ID Button */
        
		payButton.setBounds(210, 450, 100, 73);
		payButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		payButton.setSize(200,50);
		
		backButton.setBounds(510, 450, 100, 73);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setSize(200,50);
        

       
        

	}

	public void addComponentsToFrame() {
		

		/* Buttons */
		
		frame.add(payButton);
		frame.add(backButton);
		
		
		/* Labels */
				
		frame.add(ccLabel);
		frame.add(ccLabel);
		frame.add(ccLabel);
		
		frame.add(cvvLabel);
		frame.add(cvvLabel);
		frame.add(cvvLabel);
		
		frame.add(expiryLabel);
		frame.add(expiryLabel);
		frame.add(expiryLabel);
		
		/* Text fields */
		
		frame.add(ccField);
		frame.add(ccField);
		frame.add(ccField);
		
		frame.add(cvvField);
		frame.add(cvvField);
		frame.add(cvvField);
		
		frame.add(expiryField);
		frame.add(expiryField);
		frame.add(expiryField);



	}
	
	

	public void actionEvent() {

		payButton.addActionListener(this);


	}
	

	public void actionPerformed(ActionEvent e) {

		int created_on = Integer.parseInt(ccField.getText());
		
		if (e.getSource() == payButton) {
			
			
			try {
				if (PaymentBackend.checkTime(created_on)) {
					
				
					JOptionPane.showMessageDialog(payButton, "working ");
					
				} else {						
					
					JOptionPane.showMessageDialog(payButton, "not working.");
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			frame.dispose();
			ParkingFrame frame = new ParkingFrame();
			frame.setVisible(true);
		}	
			
		
		
		if (e.getSource() == backButton) {
			
			frame.dispose();
			ParkingFrame frame = new ParkingFrame();
            frame.setVisible(true);
	        
		}
			        		
				

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
	
}