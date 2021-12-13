package ezparkproject;

import javax.swing.*; 
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.*; 

public class MakeBookingFrame implements ActionListener{
	
	BookingBackend Backend = new BookingBackend();
	
	String[] parkingLots = { "Lot A", "Lot B", "Lot C", "Lot D" };
	//String[] hours = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" };
	String[] hours = { "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" };
	String[] duration = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	
	
	JFrame frame;
	
	/* Labels */
	
	//JLabel regLabel = new JLabel("Registration");
	JLabel lotLabel = new JLabel("Parking Lot");
	JLabel dateLabel = new JLabel("Date of Booking");
	JLabel timeLabel = new JLabel("Time of Booking");
	JLabel durationLabel = new JLabel("Duration (Hours)");
	JLabel chargingLabel = new JLabel("Charging");
	
	/* Text fields for labels */
	
	JComboBox<String> lotComboBox = new JComboBox<String>(parkingLots);
	JComboBox<String> timeComboBox = new JComboBox<String>(hours);
	JTextField dateField = new TextHint("Example: 2021-01-01");  // adds hint of format
	JComboBox<String> durationComboBox = new JComboBox<String>(duration);
	
	
	
	/* JCheckbox for accessibility and EV status */
	
	JCheckBox EVCheckBox = new JCheckBox("Required?");
	int electricCheckBoxVal;
	
	
	public void CheckBox_Booking()
	{
		
		if(EVCheckBox.isSelected()) {
			electricCheckBoxVal=1;
		}else {
			electricCheckBoxVal=0;
		}
	}
	

	/* End of CheckBox function */
	
	
	/* Buttons */
	
	JButton reserveButton = new JButton("Reserve");
	JButton resetButton = new JButton("Reset");
	JButton cancelButton = new JButton("Cancel");

	MakeBookingFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.lightGray);
		addComponentsToFrame();
		actionEvent();
	}
	
	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Reservations");
		frame.setBounds(40, 40, 400, 700);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */

        lotLabel.setBounds(20, 70, 80, 70);
        dateLabel.setBounds(20, 130, 140, 70);
        timeLabel.setBounds(20, 180, 100, 70);
        durationLabel.setBounds(20, 230, 100, 70);
        chargingLabel.setBounds(20, 280, 100, 70);
        
        /* Text fields and drop downs bounds */
        
        lotComboBox.setBounds(180, 93, 165, 23);
        dateField.setBounds(180, 150, 165, 23);
        timeComboBox.setBounds(180, 200, 165, 23);
        durationComboBox.setBounds(180, 250, 165, 23);
        EVCheckBox.setBounds(180, 300, 165, 23);
        
        /* Button Bounds */
        
        reserveButton.setBounds(25, 550, 100, 35);
        resetButton.setBounds(137, 550, 100, 35);
        cancelButton.setBounds(250, 550, 100, 35);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(lotLabel);
		frame.add(dateLabel);
		frame.add(timeLabel);
		frame.add(durationLabel);
		frame.add(chargingLabel);
		
		/* Text fields and drop downs */
		
		frame.add(dateField);
		frame.add(timeComboBox);
		frame.add(lotComboBox);
		frame.add(EVCheckBox);
		frame.add(durationComboBox);
		
		/* Buttons */
		
		frame.add(reserveButton);
		frame.add(resetButton);
		frame.add(cancelButton);
	}
	
	

	public void actionEvent() {

		reserveButton.addActionListener(this);
		resetButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == reserveButton) {

			String reg = Main.currentUser.getReg();
			Long hours = Long.parseLong(durationComboBox.getSelectedItem().toString());
			String startTimeString = timeComboBox.getSelectedItem().toString();
			int startTime = Integer.parseInt(startTimeString);
			String dateString = dateField.getText();
			dateString = dateString + " 16:00";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime startDateTime = LocalDateTime.parse(dateString, formatter);
			startDateTime = startDateTime.withHour(startTime);
			String selectedLot = lotComboBox.getSelectedItem().toString();
			
			CheckBox_Booking();
			
			
			Reservation res = new PreBookReservation(Main.currentUser, selectedLot, electricCheckBoxVal, reg, startDateTime, hours);
			
			Backend.createBooking(res);
			
		}	
			
		if (e.getSource() == resetButton) {

			//regField.setText("");
			dateField.setText("");
			timeComboBox.setSelectedItem("09:00");	
			lotComboBox.setSelectedItem("Lot A");			
			durationComboBox.setSelectedItem("1");	
		}

		if (e.getSource() == cancelButton) {

			//Need to add message that says booked and return to Booking Menu
	        frame.dispose();
	        new BookingMenuFrame();
	        
		}
		
		

	}

}