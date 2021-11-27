package ezparkproject;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ParkingFrame extends JFrame {

	private JPanel contentPane;
	JButton parkingButton;
	
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
		setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
		

        parkingButton = new JButton("Park Now");
		parkingButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
		parkingButton.setBounds(240, 200, 100, 73);
		parkingButton.setSize(500,50);
		parkingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				TicketSystem getNewTicket = app.park();
				
				if (getNewTicket == null)
				{
					JOptionPane.showMessageDialog(parkingButton, "Parking full!");
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
		contentPane.add(parkingButton, BorderLayout.CENTER);
		
		JButton exitButton = new JButton("Pay Now");
		exitButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
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
				
				mainFrame.setVisible(false); // hide the first frame
				paymentMidFrame.setVisible(true);
			}
		});
		contentPane.add(exitButton, BorderLayout.EAST);
	}
	

}