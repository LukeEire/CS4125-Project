package ezparkproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class ParkingFrame extends JFrame {

	private JPanel contentPane;
	private JButton parkingButton;
	private JButton logoutButton;
	private JButton backButton;
	
	
	private static ParkingSystem app = new ParkingSystem();
	static ParkingFrame mainFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame = new ParkingFrame();
					mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ParkingFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PayNow Parking");
		contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(null);
		setBounds(450, 190, 1014, 597);
        setResizable(false);
        
        JLabel lblNewLabel = new JLabel("EZPark");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);
      		
        parkingButton = new JButton("ParkNow");
		parkingButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		parkingButton.setBounds(240, 200, 100, 73);
		parkingButton.setSize(500,50);
		parkingButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{				
				TicketSystem getNewTicket = app.park();
				
				if (getNewTicket == null)
				{
					JOptionPane.showMessageDialog(parkingButton, "Parking unavailable");
				}
				else
				{
					Date date = getNewTicket.getDate();
					int ticketNumber = getNewTicket.getSlotNumber();
					long time = getNewTicket.getStartTime();
					
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
					date = new Date(time);
					dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
										
					JOptionPane.showMessageDialog(parkingButton, "Today's Date: " + dateFormat.format(date) + "\n" +
														   "Your parking ticket number: " + ticketNumber + "\n" +
														   "Start Time: " + timeFormat.format(date));
				}
			}
		});
	
		
		JButton exitButton = new JButton("Pay for Parking");
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		exitButton.setBounds(240, 300, 100, 73);
		exitButton.setSize(500,50);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				app.captureEndTime(); 
				
				PaymentMidFrame paymentMidFrame = null;
				
				try {
					paymentMidFrame = new PaymentMidFrame(app); // display new frame for entering ticket number
					
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
				
				// mainFrame.setVisible(false); // hides the frame 
				paymentMidFrame.setVisible(true);
			}
		});
		
		backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(340, 450, 200, 73);
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
		
		logoutButton = new JButton("Quit");
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
        logoutButton.setBounds(540, 450, 200, 73);
        logoutButton.setSize(100,30);
        logoutButton.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
            }
        });
		
		contentPane.add(parkingButton);
		contentPane.add(exitButton);
		contentPane.add(logoutButton);
		contentPane.add(backButton);
	}
	

}