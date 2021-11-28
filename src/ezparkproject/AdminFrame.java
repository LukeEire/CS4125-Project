package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 

public class AdminFrame implements ActionListener{
	

	// Declarations 
	
	int id;
	

	JFrame frame;
	
	/* Labels */
	
	JLabel reservationsPanel = new JLabel("Reservations Panel");
	JLabel usersPanel = new JLabel("Users Panel");
	JLabel transactionsPanel = new JLabel("Transactions Panel");
	
	/* Scrollable Containers */
	
	JPanel userContainer = new JPanel();
	JPanel reservationContainer = new JPanel();
	JPanel transactionsContainer = new JPanel();
	
	JScrollPane userScrollPane = new JScrollPane(userContainer);
	JScrollPane reservationScrollPane = new JScrollPane(reservationContainer);
	JScrollPane transactionsScrollPane = new JScrollPane(transactionsContainer);

	
	
	/* Text fields for labels */
	
	JTextField adminTextField = new JTextField();

	
	
	/* Buttons */
	
	
	JButton banUserButton = new JButton("Ban User");
	JButton unbanUserButton = new JButton("Un-Ban User");
	JButton deleteUserButton = new JButton("Delete User");
	JButton logoutButton = new JButton("Logout");
	JButton loadUsersButton = new JButton("Load Users");
	JButton loadReservationsButton = new JButton("Load Reservations");
	JButton loadTransactionsButton = new JButton("Load Transactions");
	JButton blockforEventButton = new JButton("Block Lot for event");
	
	

	AdminFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		addComponentsToFrame();
		actionEvent();
	}
	
	

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Admin Panel");
		frame.setBounds(450, 190, 1100, 597);//'
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */

		usersPanel.setBounds(350, 75, 40, 70);
		usersPanel.setSize(200,20);
		
		reservationsPanel.setBounds(600, 75, 40, 70);
		reservationsPanel.setSize(200,20);
		
		transactionsPanel.setBounds(850, 75, 40, 70);
		transactionsPanel.setSize(200,20);
		
		/* Scroll bounds */
		
		userScrollPane.setBounds(350, 100, 40, 70);
		userScrollPane.setSize(200,350);
		
		reservationScrollPane.setBounds(600, 100, 40, 70);
		reservationScrollPane.setSize(200,350);
		
		transactionsScrollPane.setBounds(850, 100, 40, 70);
		transactionsScrollPane.setSize(200,350);
        
        /* Text fields and drop downs bounds */
        
        //adminTextField.setBounds(800, 63, 165, 23);
        
        
        /* Ban User Button */
        
        banUserButton.setBounds(110, 100, 100, 73);
        banUserButton.setSize(200,50);
        
        
        /* Unban User Button */
        
        unbanUserButton.setBounds(110, 172, 100, 73);
        unbanUserButton.setSize(200,50);
        
        
        /* Delete User Button */
        
        deleteUserButton.setBounds(110, 244, 100, 73);
        deleteUserButton.setSize(200,50);
        
        
        /* Logout Button */
        
        logoutButton.setBounds(110, 316, 100, 73);
        logoutButton.setSize(200,50);
        
        
        
        /* Load Users Button */
        
        loadUsersButton.setBounds(350, 460, 100, 73);
        loadUsersButton.setSize(200,50);
  
        
        
        
        /* Load Reservations Button */
        
        loadReservationsButton.setBounds(600, 460, 100, 73);
        loadReservationsButton.setSize(200,50);
		
		/* Load Transactions Button */
        
        loadTransactionsButton.setBounds(850, 460, 100, 73);
		loadTransactionsButton.setSize(200,50);
		
        /* Block for event button */
        
        blockforEventButton.setBounds(110, 460, 100, 73);
        blockforEventButton.setSize(200,50);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(usersPanel);
		frame.add(reservationsPanel);
		frame.add(transactionsPanel);
		frame.add(userScrollPane);
		frame.add(reservationScrollPane);
		frame.add(transactionsScrollPane);
		frame.add(transactionsScrollPane);
		

		
		/* Text fields and drop downs */
		
		//frame.add(adminTextField);
		
		

		
		/* Buttons */
		
		frame.add(banUserButton);
		frame.add(unbanUserButton);
		frame.add(deleteUserButton);
		frame.add(logoutButton);
		frame.add(loadUsersButton);
		frame.add(loadReservationsButton);
		frame.add(loadTransactionsButton);
		frame.add(blockforEventButton);
	}
	
	

	public void actionEvent() {

		banUserButton.addActionListener(this);
		unbanUserButton.addActionListener(this);
		deleteUserButton.addActionListener(this);
		logoutButton.addActionListener(this);
		loadUsersButton.addActionListener(this);
		loadReservationsButton.addActionListener(this);
		loadTransactionsButton.addActionListener(this);
		blockforEventButton.addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == banUserButton) {
			
			

			AdminBackend.BanUserFunction(id);
		}	
			
		if (e.getSource() == unbanUserButton) {
			
			

			AdminBackend.unBanUserFunction(id);
		}

		if (e.getSource() == deleteUserButton) {
			
			
			try {
				AdminBackend.deleteUserFunction(id);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (e.getSource() == loadUsersButton) {
			
			try {
				AdminBackend.fetchUserFunction();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (e.getSource() == loadReservationsButton) {
			
			try {
				AdminBackend.fetchReservationFunction();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		if (e.getSource() == loadTransactionsButton) {
			
			try {
				AdminBackend.fetchTransactionsFunction();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (e.getSource() == blockforEventButton) {
			
			// load block lot action
			
		}

		if (e.getSource() == logoutButton) {
			
			 	frame.dispose();
			 
			 	LoginFunction frame = new LoginFunction();
		        frame.setTitle("Login Form");
		        frame.setVisible(true);
		        frame.setBounds(500, 200, 1100, 600);
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setResizable(false);
	        
		}
		
		

	}
	
}
