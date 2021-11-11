package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import java.sql.*;

public class UiFrame implements ActionListener{

	JFrame frame;
	
	
	
	/* Buttons */
	JButton newBookButton = new JButton("New Booking");
	JButton cancelBookButton = new JButton("Cancel Booking");
	JButton exitButton = new JButton("Exit");
	
	
	
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
