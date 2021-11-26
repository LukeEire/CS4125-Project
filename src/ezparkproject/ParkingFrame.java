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
	JButton btnPark;
	
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
		setTitle("Book and Pay");
		setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		

        btnPark = new JButton("Park");
		btnPark.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnPark.setBounds(240, 200, 100, 73);
		btnPark.setSize(500,50);
		btnPark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				TicketSystem ticketSystem = app.park();
				
				if (ticketSystem == null)
				{
					JOptionPane.showMessageDialog(btnPark, "Parking full!");
				}
				else
				{
					Date date = ticketSystem.getDate();
					int ticketNumber = ticketSystem.getSlotNumber();
					long time = ticketSystem.getStartTime();
					
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
					date = new Date(time);
					dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
										
					JOptionPane.showMessageDialog(btnPark, "Today's Date: " + dateFormat.format(date) + "\n" +
														   "Your parking ticket number: " + ticketNumber + "\n" +
														   "Start Time: " + timeFormat.format(date));
				}
			}
		});
		contentPane.add(btnPark, BorderLayout.CENTER);
		
		JButton btnPayExit = new JButton("Pay");
		btnPayExit.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnPayExit.setBounds(240, 300, 100, 73);
		btnPayExit.setSize(500,50);
		btnPayExit.addActionListener(new ActionListener() {
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
		contentPane.add(btnPayExit, BorderLayout.EAST);
	}
	

}