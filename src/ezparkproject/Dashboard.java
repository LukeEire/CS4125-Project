package ezparkproject;

	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;
	import javax.swing.border.EmptyBorder;

import ezparkproject.MyAccountandPasswords.MyAccountFrame;
import ezparkproject.PreBooking.BookingMenuFrame;

	public class Dashboard extends JFrame {
		
	    private static final long serialVersionUID = 1L;
	    private JButton bookingsButton;
	    private JButton reserveButton;
	    private JButton paymentButton;
	    private JButton lotsButton;
	    private JButton logoutButton;
	    private JButton myAccountButton;
	    private JPanel contentPane;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	Dashboard frame = new Dashboard();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    /**
	     * Create the frame.
	     */
	    public Dashboard() {
	    	
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1014, 597);
	        setResizable(false);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);

	        JLabel lblNewLabel = new JLabel("EZPark");
	        lblNewLabel.setForeground(Color.BLACK);
	        lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 46));
	        lblNewLabel.setBounds(423, 13, 273, 93);
	        contentPane.add(lblNewLabel);

	        bookingsButton = new JButton("Bookings");
	        bookingsButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        bookingsButton.setBounds(240, 122, 100, 73);
	        bookingsButton.setSize(500,50);
	        bookingsButton.addActionListener(new ActionListener() {

	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	           		new BookingMenuFrame();
	            }
	        });
	        
	        	        
	        lotsButton = new JButton("Payment");
	        lotsButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lotsButton.setBounds(240, 200, 100, 73);
	        lotsButton.setSize(500,50);
	        lotsButton.addActionListener(new ActionListener() {
	        
	        public void actionPerformed(ActionEvent e) {
	        	if (e.getSource() == lotsButton) {
        			
	       			 dispose();
	       			 ParkingFrame frame = new ParkingFrame();
	                 frame.setVisible(true);
	       	        
	            }
	        }});
	        
	        reserveButton = new JButton("Reserve");
	        reserveButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        reserveButton.setBounds(240, 272, 100, 73);
	        reserveButton.setSize(500,50);
	        reserveButton.addActionListener(new ActionListener() {

	        	public void actionPerformed(ActionEvent e) {
	                //listener goes here
	            }
	        });
	        
	        
	        
	        paymentButton = new JButton("Available Lots");
	        paymentButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        paymentButton.setBounds(240, 342, 100, 73);
	        paymentButton.setSize(500,50);
	        paymentButton.addActionListener(new ActionListener() {

	        	public void actionPerformed(ActionEvent e) {
	                //listener goes here
	            }
	        });
	        
	        myAccountButton = new JButton("My Account");
	        myAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        myAccountButton.setBounds(240, 420, 100, 73);
	        myAccountButton.setSize(500,50);
	        myAccountButton.addActionListener(new ActionListener() {

	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	           		new MyAccountFrame();
	            }
	        });
	        
	        logoutButton = new JButton("Quit");
	        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        logoutButton.setBounds(440, 500, 200, 73);
	        logoutButton.setSize(100,30);
	        logoutButton.addActionListener(new ActionListener() {

	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	            }
	        });

	        contentPane.add(bookingsButton);
	        contentPane.add(paymentButton);
	        contentPane.add(lotsButton);
	        contentPane.add(reserveButton);
	        contentPane.add(logoutButton);
	        contentPane.add(myAccountButton);
	    }
	}