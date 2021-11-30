package ezparkproject;

import javax.swing.*; 
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*; 

public class MyAccountFrame implements ActionListener{
	
	

	JFrame frame;
	
	
	JButton myBookingsButton = new JButton("My Bookings");
	JButton makeBookingButton = new JButton("Make Booking");
	JButton changeBookingButton = new JButton("Change My Booking");
	JButton backButton = new JButton("Back");

	

	MyAccountFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
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

	public void setLocationAndSize() {
		
        
        /* My Bookings Button */
        
        myBookingsButton.setBounds(240, 172, 100, 73);
        myBookingsButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
        myBookingsButton.setSize(500,50);
        

        
        
        /* Make Booking Button */
        
        makeBookingButton.setBounds(240, 244, 100, 73);
        makeBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
        makeBookingButton.setSize(500,50);
        
        
        /* Change Booking Button */
        
        changeBookingButton.setBounds(240, 316, 100, 73);
        changeBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
        changeBookingButton.setSize(500,50);
        
        
        /* Back Button */
        
        backButton.setBounds(240, 390, 100, 73);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
        backButton.setSize(500,50);

	}

	public void addComponentsToFrame() {
		

		/* Buttons */
		
		frame.add(myBookingsButton);
		frame.add(makeBookingButton);
		frame.add(changeBookingButton);
		frame.add(backButton);

	}
	
	

	public void actionEvent() {

		myBookingsButton.addActionListener(this);
		makeBookingButton.addActionListener(this);
		changeBookingButton.addActionListener(this);
		backButton.addActionListener(this);

	}
	

	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == myBookingsButton) {
			
			// Load current bookings for this user

			
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
		
		

	}
	
}
