package ParkingPackage;

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

import ezparkproject.Dashboard;

public class ParkingFrame implements ActionListener {

	JFrame frame;
	
	JButton checkIDButton = new JButton("Pay your Booking");
	JButton ParkNowButton = new JButton("Quick Park");	
	JButton backButton = new JButton("Back");
	
	JLabel idLabel = new JLabel("Enter your booking ID please!");
	JLabel qpLabel = new JLabel("Haven't booked? Click here to park now");

	JTextField idField = new JTextField();
	

	public ParkingFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
		
		
	}
	
	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Pay for Parking!");
		frame.setBounds(450, 190, 1014, 597);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}


	public void setLocationAndSize() {
		
		
		/* Label locations */
		
		idLabel.setBounds(350, 35, 2, 30);
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		idLabel.setSize(500,50);
		
		qpLabel.setBounds(330, 260, 2, 30);
		qpLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		qpLabel.setSize(500,50);
		
        
        /* Text Field Locations */
        
        idField.setBounds(410,75, 90, 23);  
        idField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        idField.setSize(100,50);
        idField.setEditable(true);


        /* Find ID Button */
        
        checkIDButton.setBounds(310, 150, 100, 73);
        checkIDButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        checkIDButton.setSize(300,50);
        

        ParkNowButton.setBounds(310,300, 100, 73);
        ParkNowButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ParkNowButton.setSize(300,50);
        
        /* Back Button Button */
        
        backButton.setBounds(310,450, 100, 73);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backButton.setSize(300,50);
        
        

	}

	public void addComponentsToFrame() {
		

		/* Buttons */
		
		frame.add(checkIDButton);
		frame.add(backButton);
		frame.add(ParkNowButton);
		
		
		/* Labels */
				
		frame.add(idLabel);
		frame.add(qpLabel);
		
		
		/* Text fields */
		
		frame.add(idField);


	}
	
	

	public void actionEvent() {

		checkIDButton.addActionListener(this);
		backButton.addActionListener(this);
		ParkNowButton.addActionListener(this);


	}
	

	public void actionPerformed(ActionEvent e) {
	
		

		if (e.getSource() == checkIDButton) {
			
			/* checks for existing ID's in the reservations field */
			int id = Integer.parseInt(idField.getText());
			
			try {
				if (ParkingBackend.checkID(id)) {
					
				
					JOptionPane.showMessageDialog(checkIDButton, "Booking number " + id + " is Valid. Taking you to Payment! ");
					frame.dispose();
					PaymentFrame frame = new PaymentFrame();
		            frame.setVisible(true);
				} else {						
					
					JOptionPane.showMessageDialog(checkIDButton, "Booking " + id + " not found. Check correct ID was entered.");
					
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			
		}	
			
		
		if (e.getSource() == ParkNowButton) {
			
			frame.dispose();
			ParkNowFrame frame = new ParkNowFrame();
            frame.setVisible(true);
	        
	        
		}
			        		
				


		
		
		if (e.getSource() == backButton) {
			
			frame.dispose();
			Dashboard frame = new Dashboard();
            frame.setVisible(true);
	        
		}
			        		
				

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	
	
}