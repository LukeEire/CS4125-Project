package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 

/* Author:  Ashutosh Yadav & Luke Kellet Murray */

public class BookingMenuFrame implements ActionListener{

	JFrame frame;
	BookingBackend Backend = new BookingBackend();
	
	/* Labels */
	
	JLabel liveCounter = new JLabel("Live Counter");
	JLabel LotA_Counter = new JLabel("Lot A Counter");
	JLabel LotB_Counter = new JLabel("Lot B Counter");
	JLabel LotC_Counter = new JLabel("Lot C Counter");
	JLabel LotD_Counter = new JLabel("Lot D Counter");
	
	
	/* Text fields for labels */
	
	JTextField lotA_CounterField = new JTextField();
	JTextField lotB_CounterField = new JTextField();
	JTextField lotC_CounterField = new JTextField();
	JTextField lotD_CounterField = new JTextField();
	
	
	/* Buttons */
	
	
	JButton makeBookingButton = new JButton("Make Booking");
	JButton changeBookingButton = new JButton("Change Booking");
	JButton viewBookingButton = new JButton("View My Bookings");
	JButton backButton = new JButton("Back");

	BookingMenuFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.CYAN);
		addComponentsToFrame();
		actionEvent();
		loadCounters();
	}
	
	public String[] returnSpaces() {
		String temp = Backend.returnLot();
		String[] lots = temp.split(","); 
		
		return lots;
		
	}
	
	public void loadCounters() {
		String[] temp = returnSpaces();
		lotA_CounterField.setText(temp[0]);
		lotB_CounterField.setText(temp[1]);
		lotC_CounterField.setText(temp[2]);
		lotD_CounterField.setText(temp[3]);
		
	}

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Bookings");
		frame.setBounds(450, 190, 1014, 597);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */

		liveCounter.setBounds(800, 20, 40, 70);
		liveCounter.setSize(200,20);
		LotA_Counter.setBounds(800, 43, 40, 70);
		LotA_Counter.setSize(200,20);
		LotB_Counter.setBounds(800, 83, 40, 70);
		LotB_Counter.setSize(200,20);
		LotC_Counter.setBounds(800, 123, 40, 70);
		LotC_Counter.setSize(200,20);
		LotD_Counter.setBounds(800, 163, 40, 70);
		LotD_Counter.setSize(200,20);
		
        
        /* Text fields and drop downs bounds */
        
        lotA_CounterField.setBounds(800, 63, 165, 23);
        lotA_CounterField.setEditable(false);
        lotB_CounterField.setBounds(800, 103, 165, 23);
        lotB_CounterField.setEditable(false);
        lotC_CounterField.setBounds(800, 143, 165, 23);
        lotC_CounterField.setEditable(false);
        lotD_CounterField.setBounds(800, 183, 165, 23);
        lotD_CounterField.setEditable(false);
        
        /* Make Booking Button */
        
        makeBookingButton.setBounds(110, 200, 100, 73);
        makeBookingButton.setSize(500,50);
        
        
        /* Change Booking Button */
        
        changeBookingButton.setBounds(110, 272, 100, 73);
        changeBookingButton.setSize(500,50);
        
        /* View Booking Button */
        
        viewBookingButton.setBounds(110, 350, 100, 73);
        viewBookingButton.setSize(500,50);
        
        /* Logout Button */
        
        backButton.setBounds(110, 427, 100, 73);
        backButton.setSize(500,50);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(liveCounter);
		frame.add(LotA_Counter);
		frame.add(LotB_Counter);
		frame.add(LotC_Counter);
		frame.add(LotD_Counter);

		
		/* Text fields and drop downs */
		
		frame.add(lotA_CounterField);
		
		frame.add(lotA_CounterField);
		frame.add(lotB_CounterField);
		frame.add(lotC_CounterField);
		frame.add(lotD_CounterField);

		
		/* Buttons */
		
		frame.add(makeBookingButton);
		frame.add(changeBookingButton);
		frame.add(viewBookingButton);
		frame.add(backButton);
	}
	
	

	public void actionEvent() {

		makeBookingButton.addActionListener(this);
		changeBookingButton.addActionListener(this);
		viewBookingButton.addActionListener(this);
		backButton.addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == makeBookingButton) {
			
			frame.dispose();
			new MakeBookingFrame();

			// Make booking action TODO
		}	
			
		if (e.getSource() == changeBookingButton) {
			
			frame.dispose();
			new ChangeBookingFrame();

			// Change booking action TODO
		}

		if (e.getSource() == viewBookingButton) {
			
			//frame.dispose();
			Backend.decrementTest();
			
		}

		if (e.getSource() == backButton) {
			
			 frame.dispose();
			 Dashboard frame = new Dashboard();
             frame.setVisible(true);
	        
		}
		
		

	}
	
}
