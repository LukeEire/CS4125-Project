package ezparkproject;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PaymentMidFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton enterButton;
	private JButton backButton;
	
	ParkingSystem app;
	private PaymentMidFrame paymentMidFrame = this;
	
	double totalFee = 2;

	public PaymentMidFrame(ParkingSystem parkingApp) 
	{		
		this.app = parkingApp;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ticket Number!");
		setBounds(250, 190, 314, 150);
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JLabel lblEnterYourTicket = new JLabel("Enter your ticket number: ");
		lblEnterYourTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblEnterYourTicket);
		
		
		textField = new JTextField();
		contentPane.add(textField);
		
		textField.setColumns(3);
		
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int ticketNumEntered = Integer.parseInt(textField.getText());
				boolean ticketIsValid = app.validateTicketNumber(ticketNumEntered);
			
				if (ticketIsValid) 
				{
					paymentMidFrame.dispose(); //disposes frame 
					app.timeParked();
					totalFee = app.getTotalFee();
					
					int option = JOptionPane.showConfirmDialog(enterButton, "Total Payment: €" + totalFee + "\n" + "Continue to payment? ");
					
					if (option != JOptionPane.YES_OPTION)
					{
						JOptionPane.showMessageDialog(enterButton, "Re-directing.... ");
						ParkingFrame.mainFrame = new ParkingFrame(); //re-direct the user back to the parking frame 
						ParkingFrame.mainFrame.setVisible(true);
						return;
					}
					else
					{
						// make the slot available
						app.spaceAvailable(ticketNumEntered);
					if (option != JOptionPane.NO_OPTION)	
						try{
							PaymentFrame paymentFrame = new PaymentFrame(app);
							paymentFrame.setVisible(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}	
				else
				{
					JOptionPane.showMessageDialog(enterButton, "Please Enter Valid Ticket No!");
					textField.setText("");
					textField.requestFocus();
				}
			}
		});
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(10, 150, 100, 73);
		backButton.setSize(100,30);
		backButton.addActionListener(new ActionListener() {

	        	public void actionPerformed(ActionEvent e) {
	        		
	        		if (e.getSource() == backButton) {
	        		 dispose();
	       			 Dashboard frame = new Dashboard();
	                 frame.setVisible(true);
	       	        
	       		}
	       		
	        	}
	        });
		contentPane.add(backButton);
		contentPane.add(enterButton);
	}
	
	
}