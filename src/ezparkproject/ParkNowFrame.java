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

public class ParkNowFrame implements ActionListener {

	JFrame frame;
	
	JButton checkIDButton = new JButton("Pay");
	JButton backButton = new JButton("Back");
	
	JLabel idLabel = new JLabel("Enter your Ticket ID please!");

	JTextField idField = new JTextField();
	

	ParkNowFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
		
		
	}
	
	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Quick Pay!");
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}


	public void setLocationAndSize() {
		
		
		/* Label locations */
		
		idLabel.setBounds(120, 25, 20, 30);
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		idLabel.setSize(200,50);
		
        
        /* Text Field Locations */
        
        idField.setBounds(120,75, 90, 23);  
        idField.setFont(new Font("Tahoma", Font.PLAIN, 26));
        idField.setSize(200,50);
        idField.setEditable(true);


        /* Find ID Button */
        
        checkIDButton.setBounds(90, 150, 100, 73);
        checkIDButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        checkIDButton.setSize(100,50);
        

        /* Back Button Button */
        
        backButton.setBounds(250, 150, 100, 73);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        backButton.setSize(100,50);
        
        

	}

	public void addComponentsToFrame() {
		

		/* Buttons */
		
		frame.add(checkIDButton);
		frame.add(backButton);
	
		/* Labels */
				
		frame.add(idLabel);
		
		
		/* Text fields */
		
		frame.add(idField);


	}
	
	

	public void actionEvent() {

		checkIDButton.addActionListener(this);
		backButton.addActionListener(this);


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