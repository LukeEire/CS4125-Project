package PasswordPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import LoginPackage.LoginFunction;
import ezparkproject.Users;

/* Author: Ashutosh Yadav */

public class ForgotPasswordFrame extends Users implements ActionListener {
	
	JFrame frame;
	
	/* Buttons */
	
	
	JButton sendEmailButton = new JButton("Send Password Reset Email");
	JButton verifyAccountButton = new JButton("Verify Account");
	JButton backButton = new JButton("Back");
	

	/* Labels */
	
	
	JLabel emailLabel = new JLabel("Please Enter Your University Email Address");

	/* Text Fields */
	
	
	JTextField emailField = new JTextField();
	

	
	

	

	public ForgotPasswordFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
		
		
	}
	
	

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Forgot Password");
		frame.setBounds(450, 190, 1014, 597);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}


	public void setLocationAndSize() {
		
		
		/* Label locations */
		
		emailLabel.setBounds(500, 80, 220, 30);
		emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		emailLabel.setSize(300,200);
		

        
        /* Text Field Locations */
        
        emailField.setBounds(500, 225, 190, 23);  
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        emailField.setSize(350,50);
        emailField.setEditable(true);


        /* Send Email Button */
        
        sendEmailButton.setBounds(110, 172, 100, 73);
        sendEmailButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        sendEmailButton.setSize(300,50);
        

        
        
        /* Verify Account Button */
        
        verifyAccountButton.setBounds(110, 230, 100, 73);
        verifyAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        verifyAccountButton.setSize(300,50);
        
        /* Back Button Button */
        
        backButton.setBounds(110, 290, 100, 73);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backButton.setSize(300,50);
        
        

	}

	public void addComponentsToFrame() {
		

		/* Buttons */
		
		frame.add(sendEmailButton);
		frame.add(verifyAccountButton);
		frame.add(backButton);
		
		
		/* Labels */
				
		frame.add(emailLabel);
		
		/* Text fields */
		
		frame.add(emailField);


	}
	
	

	public void actionEvent() {

		sendEmailButton.addActionListener(this);
		verifyAccountButton.addActionListener(this);
		backButton.addActionListener(this);


	}
	

	public void actionPerformed(ActionEvent e) {
		
		String email = emailField.getText();

		/* Create Database before using */

		if (e.getSource() == sendEmailButton) {
			
			/* Send password reset email if user's email exists in DB */
			
			/* This is a proof of concept and not a fully impemented system due to time constraints */
			
			try {
				if (ForgotPasswordBackend.verifyEmail(email)) {
					
				
					JOptionPane.showMessageDialog(sendEmailButton, "If your email address is in our records, you will receive an email with reset instructions to " + email + "");
					
				} else {						
					
					JOptionPane.showMessageDialog(sendEmailButton, "No account with email: '" + email + "' found. Please double check your email address.");
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			
		}	
			
		if (e.getSource() == verifyAccountButton) {
			
			/* Verify that user exists in DB */
			
			try {
				if (ForgotPasswordBackend.verifyEmail(email)) {
					
				
					JOptionPane.showMessageDialog(verifyAccountButton, "Account '" + email + "' found!");
					
				} else {						
					
					JOptionPane.showMessageDialog(verifyAccountButton, "No account with email: '" + email + "' found. Please double check your email address.");
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		if (e.getSource() == backButton) {
			
			/* Go Back to Login page */

			frame.dispose();
			LoginFunction frame = new LoginFunction();
		       frame.setTitle("Login Form");
		       frame.setVisible(true);
		       frame.setBounds(500, 200, 1100, 600);
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       frame.setResizable(false);
		}
			        		
				

	}
	
	
}