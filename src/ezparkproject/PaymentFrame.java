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
	
	JLabel ccLabel;
	JLabel cvvLabel;
	JLabel expiryLabel;
	
	JTextField ccField;
	JTextField cvvField;
	JTextField expiryField;
	
	JButton payButton;
	JButton backButton;
	

	PaymentFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
		
		
	}
	
	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Test!");
		frame.setBounds(450, 190, 1014, 597);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}


	public void setLocationAndSize() {
		
		
		/* Label locations */
		
		ccLabel.setBounds(350, 35, 2, 30);
		ccLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		ccLabel.setSize(500,50);
		
		cvvLabel.setBounds(350, 35, 2, 30);
		cvvLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		cvvLabel.setSize(500,50);
		
		expiryLabel.setBounds(350, 35, 2, 30);
		expiryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));	
		expiryLabel.setSize(500,50);
	
		/* text fields locations */
		
		ccField.setBounds(410, 75, 90, 23);  
		ccField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		ccField.setSize(100,50);
		ccField.setEditable(true);

		cvvField.setBounds(410,75, 90, 23);  
		cvvField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cvvField.setSize(100,50);
		cvvField.setEditable(true);
		
		expiryField.setBounds(410,75, 90, 23);  
		expiryField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		expiryField.setSize(100,50);
		expiryField.setEditable(true);


        /* Find ID Button */
        
		payButton.setBounds(310, 150, 100, 73);
		payButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		payButton.setSize(300,50);
		
		backButton.setBounds(310, 150, 100, 73);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backButton.setSize(300,50);
        

       
        

	}

	public void addComponentsToFrame() {
		

		/* Buttons */
		
		frame.add(payButton);
		frame.add(backButton);
		
		
		/* Labels */
				
		frame.add(ccLabel);
		frame.add(ccLabel);
		frame.add(ccLabel);
		/* Text fields */
		
		frame.add(ccField);
		frame.add(ccField);
		frame.add(ccField);


	}
	
	

	public void actionEvent() {

		payButton.addActionListener(this);


	}
	

	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource() == payButton) {
			
			/* checks for existing ID's in the reservations field */
			
			
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