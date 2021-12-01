package ezparkproject;

import javax.swing.*; 
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*; 


/* Author:  Ashutosh Yadav  */

public class MyAccountFrame extends Users implements ActionListener {
	
	int id = Main.currentUser.getID();
	String firstName = Main.currentUser.getFirstName();
	String lastName = Main.currentUser.getLastName();
	String password = Main.currentUser.getPassword();
	String status = Main.currentUser.getStatus();
	String dob = Main.currentUser.getsDOB();
	String reg = Main.currentUser.getReg();
	
	
	JFrame frame;
	
	/* Buttons */
	
	
	JButton myBookingsButton = new JButton("My Bookings");
	JButton makeBookingButton = new JButton("Make Booking");
	JButton changeBookingButton = new JButton("Change My Booking");
	JButton backButton = new JButton("Back");
	JButton updateDetailsButton = new JButton("Change Password");
	
	
	
	/* Labels */
	
	
	JLabel yourDetails = new JLabel("Your Details");
	JLabel universityID = new JLabel("ID");
	JLabel firstNameLabel = new JLabel("First Name");
	JLabel lastNameLabel = new JLabel("Last Name");
	JLabel university_statusLabel = new JLabel("Status");
	JLabel passwordLabel = new JLabel("Password");
	JLabel dobLabel = new JLabel("Date of Birth");
	JLabel accessibilityLabel = new JLabel("Disabled Permit");
	JLabel plateLabel = new JLabel("Car Reg");
	JLabel welcomeLabel = new JLabel("Welcome");
	JLabel wUserLabel = new JLabel (Main.currentUser.getFirstName() + " " +  Main.currentUser.getLastName());
	
	
	/* Text Fields */
	
	
	JTextField universityIDField = new JTextField();
	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JTextField statusField = new JTextField();
	JTextField dobField = new TextHint("Example: 1999-01-01");  // adds hint of format
	JTextField plate = new JTextField();
	
	
	

	

	MyAccountFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
		getUserDetails();
		
		
	}
	
	

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("My Account");
		frame.setBounds(450, 190, 1014, 597);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}
	
	public void getUserDetails() {
		
		
		
		// test to see what each string returns
		
		System.out.println(firstName);		
		
		firstNameField.setText(firstName);
	    universityIDField.setText("" +id);
	    dobField.setText("");
	    lastNameField.setText(lastName);	
	    passwordField.setText("");
	    plate.setText(reg);
	    statusField.setText(status);
	    dobField.setText(dob);
		
			   
	}

	public void setLocationAndSize() {
		
		
		/* Label locations */
		
		yourDetails.setBounds(700, 20, 200, 70);
		yourDetails.setFont(new Font("Tahoma", Font.PLAIN, 28));	
		
		universityID.setBounds(600, 70, 40, 70);
        firstNameLabel.setBounds(600, 130, 80, 70);
        lastNameLabel.setBounds(600, 180, 80, 70);
        passwordLabel.setBounds(600, 225, 140, 70);
        university_statusLabel.setBounds(600, 280, 100, 70);
        dobLabel.setBounds(600, 330, 100, 70);
        plateLabel.setBounds(600, 380, 100, 70);
        
        welcomeLabel.setBounds(120, 20, 200, 70);
        welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
        
        wUserLabel.setBounds(120, 60, 100, 70);
        wUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        wUserLabel.setSize(200,100);
        
     
        
        /* Text Field Locations */
        
        universityIDField.setBounds(700, 93, 165, 23);
        firstNameField.setBounds(700, 155, 165, 23);
        lastNameField.setBounds(700, 205, 165, 23);
        passwordField.setBounds(700, 250, 165, 23);
        statusField.setBounds(700, 300, 165, 23);        
        dobField.setBounds (700, 350, 165, 23);
        plate.setBounds (700, 400, 165, 23);
        
        /* Set certain fields to be read only */
        
        universityIDField.setEditable(false);
        firstNameField.setEditable(false);
        lastNameField.setEditable(false);
        statusField.setEditable(false);
        dobField.setEditable(false);
        plate.setEditable(false);
		
        
        /* My Bookings Button */
        
        myBookingsButton.setBounds(110, 172, 100, 73);
        myBookingsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        myBookingsButton.setSize(300,50);
        

        
        
        /* Make Booking Button */
        
        makeBookingButton.setBounds(110, 230, 100, 73);
        makeBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        makeBookingButton.setSize(300,50);
        
        
        /* Change Booking Button */
        
        changeBookingButton.setBounds(110, 290, 100, 73);
        changeBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        changeBookingButton.setSize(300,50);
        
        
        /* Back Button */
        
        backButton.setBounds(110, 350, 100, 73);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backButton.setSize(300,50);
        
        /* Update Details */
        
        updateDetailsButton.setBounds(675, 475, 100, 73);
        updateDetailsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        updateDetailsButton.setSize(200,30);

	}

	public void addComponentsToFrame() {
		

		/* Buttons */
		
		frame.add(myBookingsButton);
		frame.add(makeBookingButton);
		frame.add(changeBookingButton);
		frame.add(backButton);
		frame.add(updateDetailsButton);
		
		/* Labels */
		
		frame.add(universityID);
		frame.add(firstNameLabel);
		frame.add(lastNameLabel);
		frame.add(passwordLabel);
		frame.add(university_statusLabel);
		frame.add(accessibilityLabel);
		frame.add(dobLabel);
		frame.add(plateLabel);
		frame.add(yourDetails);
		frame.add(welcomeLabel);
		frame.add(wUserLabel);
		
		/* Text fields */
		
		frame.add(universityIDField);
		frame.add(firstNameField);
		frame.add(lastNameField);
		frame.add(passwordField);
		frame.add(statusField);
		frame.add(dobField);
		frame.add(plate);

	}
	
	

	public void actionEvent() {

		myBookingsButton.addActionListener(this);
		makeBookingButton.addActionListener(this);
		changeBookingButton.addActionListener(this);
		backButton.addActionListener(this);
		updateDetailsButton.addActionListener(this);

	}
	

	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == myBookingsButton) {
			
			/* Load current bookings for this user */

			
		}	
			
		if (e.getSource() == makeBookingButton) {
			
			
			frame.dispose();
			new MakeBookingFrame();	
			
		}

		if (e.getSource() == changeBookingButton) {
			
			
			frame.dispose();
			new ChangeBookingFrame();
		}
		

		if (e.getSource() == backButton) {
			
			frame.dispose();
			Dashboard frame = new Dashboard();
            frame.setVisible(true);
	        
		}
		
		if (e.getSource() == updateDetailsButton) {
			
			try {
				Database db = new Database();
				
				db.changePassword(id, password);
				
				System.out.println(id);
				System.out.println(password);
				
				JOptionPane.showMessageDialog(updateDetailsButton, "You have successfully changed your password");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
		}
		
		

	}
	
}
