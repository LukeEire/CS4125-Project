package ezparkproject;

import javax.swing.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;

/* Author:  Ashutosh Yadav  */

public class AdminFrame implements ActionListener{
	
	AdminBackend Backend = new AdminBackend();

		
	JFrame frame;
	
	/* Labels */
	
	JLabel reservationsPanel = new JLabel("Reservations Panel");
	JLabel usersPanel = new JLabel("Users Panel");
	JLabel transactionsPanel = new JLabel("Transactions Panel");
	JLabel userBanLabel = new JLabel("Enter User ID");

	
	/* Text fields for labels */
	
	JTextField userIDTextField = new JTextField();

	
	
	/* Buttons */
	
	
	JButton banUserButton = new JButton("Ban User");
	JButton unbanUserButton = new JButton("Un-Ban User");
	JButton deleteUserButton = new JButton("Delete User");
	JButton logoutButton = new JButton("Logout");
	JButton loadUsersButton = new JButton("Load Users");
	JButton loadReservationsButton = new JButton("Load Reservations");
	JButton loadTransactionsButton = new JButton("Load Transactions");
	JButton applyPenaltyButton = new JButton("Apply Penalty");
	JButton blockforEventButton = new JButton("Block Lot for event");
	
	

	AdminFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();		
		
	}
	
	

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Admin Panel");
		frame.setBounds(450, 190, 425, 597);//'
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */
		
		userBanLabel.setBounds(170, 23, 100, 73);
		userBanLabel.setSize(200,20);
		
    
        /* Text fields and drop downs bounds */
        
		userIDTextField.setBounds(110, 63, 100, 73);
		userIDTextField.setSize(200,20);
		
      
        /* Ban User Button */
        
        banUserButton.setBounds(110, 100, 100, 73);
        banUserButton.setSize(200,50);
        
        
        /* Unban User Button */
        
        unbanUserButton.setBounds(110, 172, 100, 73);
        unbanUserButton.setSize(200,50);
        
        
        /* Delete User Button */
        
        deleteUserButton.setBounds(110, 244, 100, 73);
        deleteUserButton.setSize(200,50);
        
        
        /* Logout Button */
        
        logoutButton.setBounds(110, 380, 100, 73);
        logoutButton.setSize(200,50);
        
        /* Apple Penalty Button */
        
        applyPenaltyButton.setBounds(110, 316, 100, 73);
        applyPenaltyButton.setSize(200,50);
        
		
        /* Block for event button */
        
        blockforEventButton.setBounds(110, 460, 100, 73);
        blockforEventButton.setSize(200,50);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(userBanLabel);

		/* Text fields and drop downs */
		
		
		frame.add(userIDTextField);

	
		/* Buttons */
		
		frame.add(banUserButton);
		frame.add(unbanUserButton);
		frame.add(deleteUserButton);
		frame.add(logoutButton);
		frame.add(blockforEventButton);
		frame.add(applyPenaltyButton);
	}
	


	public void actionEvent() {

		banUserButton.addActionListener(this);
		unbanUserButton.addActionListener(this);
		deleteUserButton.addActionListener(this);
		logoutButton.addActionListener(this);
		loadUsersButton.addActionListener(this);
		loadReservationsButton.addActionListener(this);
		loadTransactionsButton.addActionListener(this);
		blockforEventButton.addActionListener(this);
	}
	
	
	/* Create Database before using */
	/* Takes ID as an int from the textField */
	
	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == banUserButton) {
			
			int id = Integer.parseInt(userIDTextField.getText());
			
			try {
				if (AdminBackend.verifyUserID(id)) {
					
					
					JOptionPane.showMessageDialog(banUserButton, "User " +id + " has been banned successfully");
					AdminBackend.BanUserFunction(id);
					
				} else {						
					
					JOptionPane.showMessageDialog(banUserButton, "User " +id + " couldn't be found");
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		
			
		}	
			
		if (e.getSource() == unbanUserButton) {
			
			int id = Integer.parseInt(userIDTextField.getText());
			
			try {
				if (AdminBackend.verifyUserID(id)) {
					
					
					JOptionPane.showMessageDialog(unbanUserButton, "User " +id + " has been unbanned");
					AdminBackend.unBanUserFunction(id);
					
				} else {						
					
					JOptionPane.showMessageDialog(unbanUserButton, "User " +id + " couldn't be found");
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			
		}

		if (e.getSource() == deleteUserButton) {
			
			int id = Integer.parseInt(userIDTextField.getText());
			
			try {
				AdminBackend.deleteUserFunction(id);
				JOptionPane.showMessageDialog(deleteUserButton, "User " +id + " has been deleted from the system");
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		}
		

		
		if (e.getSource() == blockforEventButton) {
			
			// load block lot action
			
		}

		if (e.getSource() == logoutButton) {
			
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
