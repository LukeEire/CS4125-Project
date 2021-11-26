package ezparkproject;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *  @author Conall McAteer
 *
 * This class is the USer Interface to enter the ticket (slot) number.
 */
public class SlotFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnEnter;
	
	ParkingSystemApp app;
	private SlotFrame slotFrame = this;
	
	double totalFee = 0;

	/**
	 * Create the frame.
	 */
	public SlotFrame(ParkingSystemApp parkingApp) 
	{		
		this.app = parkingApp;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ticket!");
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(3, 3));
		setContentPane(contentPane);
		
		JLabel lblEnterYourTicket = new JLabel("Enter your ticket number: ");
		contentPane.add(lblEnterYourTicket);
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(2);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int ticketNumEntered = Integer.parseInt(textField.getText());
				
				boolean isValid = app.validateTicketNumber(ticketNumEntered);
			
				if (isValid) 
				{
				 	// hide current frame
					slotFrame.dispose();
					
					app.calculateTotalMinutes();
					
					totalFee = app.getTotalFee();
					
					int option = JOptionPane.showConfirmDialog(btnEnter, "Your total parking fee is: €" + totalFee + "\n" +
																	 "Continue with the payment? ");
					if (option != JOptionPane.YES_OPTION)
					{
						JOptionPane.showMessageDialog(btnEnter, "!");
						ParkingSystemFrame.mainFrame = new ParkingSystemFrame();
						ParkingSystemFrame.mainFrame.setVisible(true);
						return;
					}
					else
					{
						// make the slot available
						app.makeSlotAvailable(ticketNumEntered);
						
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
					JOptionPane.showMessageDialog(btnEnter, "Please Enter Valid Ticket No!");
					textField.setText("");
					textField.requestFocus();
				}
			}
		});
		contentPane.add(btnEnter);
	}
	
	
}