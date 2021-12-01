package ezparkproject;

import javax.swing.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.*;

/* Author:  Ashutosh Yadav  */

public class AdminFrame implements ActionListener{
	

	// Declarations 
	
	ArrayList<Users> users;
	AdminBackend Backend = new AdminBackend();
	//String usersData = Backend.fetchUserFunction();
		
	JFrame frame;
	
	/* Labels */
	
	JLabel reservationsPanel = new JLabel("Reservations Panel");
	JLabel usersPanel = new JLabel("Users Panel");
	JLabel transactionsPanel = new JLabel("Transactions Panel");
	JLabel userBanLabel = new JLabel("Select User ID to ban");
	JComboBox firstNameBox, userIDBox;
    

	
	
	/* Text fields for labels */
	
	JTextField userIDTextField = new JTextField();

	
	
	/* Buttons */
	
	
	JButton banUserButton = new JButton("Ban User");
	JButton unbanUserButton = new JButton("Un-Ban User");
	JButton deleteUserButton = new JButton("Delete User");
	JButton logoutButton = new JButton("Logout");
	JButton applyPenaltyButton = new JButton("Apply Penalty");
	JButton blockforEventButton = new JButton("Block Lot for event");
	
	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Admin Panel");
		frame.setBounds(450, 190, 1100, 597);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.validate();
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void userBox() {
		
		try {

            

        	Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4450358","sql4450358", "dcCxqbDW1K");

            PreparedStatement ps = con.prepareStatement("select firstName from Users");
            PreparedStatement ps1 = con.prepareStatement("select id from Users");

            ResultSet resultSet = ps.executeQuery();
            ResultSet resultSet1 = ps1.executeQuery();


			Vector results = new Vector();
            Vector results_id = new Vector();

            while (resultSet.next()) {

                String firstNameVal = resultSet.getString(1);               
                results.add(firstNameVal);

            }
            
            while (resultSet1.next()) {

                String userID = resultSet1.getString(1);
                results_id.add(userID);

            }
            
            /* Test to see if the methods display */
            
            System.out.println("Users"+results);
            System.out.println("IDs"+results_id);
            
            firstNameBox = new JComboBox(results);          
            firstNameBox.setBounds(350, 110, 40, 70);
            firstNameBox.setSize(150,25);
            
            userIDBox = new JComboBox(results_id);          
            userIDBox.setBounds(110, 63, 100, 73);
            userIDBox.setSize(200,25);

            frame.add(firstNameBox);
            frame.add(userIDBox);
            
            firstNameBox.setVisible(true);
            userIDBox.setVisible(true);
 

        } catch (Exception ex) {

            System.out.println(ex);

        }
		
	}


	AdminFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();	
		userBox();
		
		
        
	}
	
	



	public void setLocationAndSize() {
		
		/* Label Bounds */

		usersPanel.setBounds(350, 75, 40, 70);
		usersPanel.setSize(200,20);
		
		reservationsPanel.setBounds(600, 75, 40, 70);
		reservationsPanel.setSize(200,20);
		
		transactionsPanel.setBounds(850, 75, 40, 70);
		transactionsPanel.setSize(200,20);
		
		userBanLabel.setBounds(110, 23, 100, 73);
		userBanLabel.setSize(200,20);
		

        
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

		frame.add(usersPanel);	
		frame.add(reservationsPanel);
		frame.add(transactionsPanel);
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
		blockforEventButton.addActionListener(this);
	}
	
	
	/* Create Database before using */
	
	public void actionPerformed(ActionEvent e) {

		/* Takes ID as an int from the textField */
		
		int id = Integer.parseInt((String)userIDBox.getSelectedItem()); 
		
		String firstName = firstNameBox.getSelectedItem().toString();
		

		if (e.getSource() == banUserButton) {
			
			
			
			AdminBackend.BanUserFunction(id);
		}	
			
		if (e.getSource() == unbanUserButton) {
			
			

			AdminBackend.unBanUserFunction(id);
		}

		if (e.getSource() == deleteUserButton) {
			
			
			try {
				AdminBackend.deleteUserFunction(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
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
