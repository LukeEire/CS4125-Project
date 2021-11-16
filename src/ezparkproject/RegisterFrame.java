package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import java.sql.*;

public class UiFrame implements ActionListener{

	JFrame frame;
	
	/* Labels */
	
	JLabel Home = new JLabel("Home");
	
	
	
	/* Buttons */
	JButton newBookButton = new JButton("New Booking");
	JButton cancelBookButton = new JButton("Cancel Booking");
	JButton exitButton = new JButton("Exit");
	
	UiFrame() {

		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}
	
	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Booking Home");
		frame.setBounds(40, 40, 1200, 720);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */

		Home.setBounds(20, 20, 40, 70);
        
        /* Button Bounds */
        
        newBookButton.setBounds(25, 500, 100, 35);
        cancelBookButton.setBounds(250, 500, 100, 35);
        exitButton.setBounds(137, 500, 100, 35);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(Home);
		
		/* Buttons */
		
		frame.add(newBookButton);
		frame.add(cancelBookButton);
		frame.add(exitButton);
	}
	
	
	
	public void actionEvent() {

		newBookButton.addActionListener(this);
		cancelBookButton.addActionListener(this);
		exitButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == newBookButton) {

			try {
				
				/* Create Connection Object */
				Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com:3306/sql4450358","sql4450358","dcCxqbDW1K");
				
				/* Pass values into Database */
				PreparedStatement Pstatement = con.prepareStatement("insert into Register values(?,?,?,?,?,?,?,?,?)");
			

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
			
		
		if (e.getSource() == cancelBookButton) {
			
		}

		if (e.getSource() == exitButton) {

			/* Close current window */
			frame.dispose();
	        
		}
	}
	
}
