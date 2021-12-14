package BookingPackage;

import javax.swing.*;

import ezparkproject.Main;
import ezparkproject.TextHint;

import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.*; 

public class MakeBookingFrame implements ActionListener{
	
	BookingBackend Backend = new BookingBackend();
	
	String[] parkingLots = { "Lot A", "Lot B", "Lot C", "Lot D" };
	String[] hours = { "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" };
	String[] duration = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	
	JFrame frame;
	
	/* Labels */
	
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
	
	/* Buttons */
	
	JButton reserveButton = new JButton("Reserve");
	JButton resetButton = new JButton("Reset");
	JButton cancelButton = new JButton("Cancel");

	public MakeBookingFrame() {

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
	
	public void popupWindow(String flag) {
		JOptionPane.showMessageDialog(frame, flag);
	}
	
	public void actionEvent() {

		reserveButton.addActionListener(this);
		resetButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */
		String flag = "";

		if (e.getSource() == reserveButton) {

			String reg = Main.currentUser.getReg();
			Long hours = Long.parseLong(durationComboBox.getSelectedItem().toString());
			String startTimeString = timeComboBox.getSelectedItem().toString();
			int startTime = Integer.parseInt(startTimeString);
			String dateString = "2000-01-01";
			LocalDate dateStringLD = LocalDate.parse(dateString);
			
			try {
			dateString = dateField.getText();
			dateStringLD = LocalDate.parse(dateString);
			}catch(Exception f){
				flag = "Error with date format";
				System.out.println(flag);
			}
			
			
			dateString = dateString + " 16:00";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime startDateTime = LocalDateTime.parse(dateString, formatter);
			startDateTime = startDateTime.withHour(startTime);
			String selectedLot = lotComboBox.getSelectedItem().toString();
			
			CheckBox_Booking();
			
			System.out.println(Main.blockedDates.size());
			
			Boolean validFlag = false;
			for(int i = 0; i < Main.blockedDates.size(); i++) {
				
				if((Main.blockedDates.get(i).equals(dateStringLD)) && (selectedLot == Main.blockedLots.get(i))) {
					flag = "This Lot is blocked for given date";
					System.out.println(flag);
				}else if((startTime >= 9 && startTime <= 17) && (selectedLot == "Lot D")){
					flag = "This Lot is reserved for staff until 5pm";
					System.out.println(flag);
				}else if(dateStringLD != LocalDate.parse("2000-01-01")){
					validFlag = true;
					flag = "Reservation Made";
				}
				
			}
			if (validFlag) {
				Reservation res = new PreBookReservation(Main.currentUser, selectedLot, electricCheckBoxVal, reg, startDateTime, hours);
				Backend.createBooking(res);
				frame.dispose();
		        new BookingMenuFrame();
			}
			popupWindow(flag);
		}	
			
		if (e.getSource() == resetButton) {
			dateField.setText("");
			timeComboBox.setSelectedItem("09:00");	
			lotComboBox.setSelectedItem("Lot A");			
			durationComboBox.setSelectedItem("1");	
		}

		if (e.getSource() == cancelButton) {
	        frame.dispose();
	        new BookingMenuFrame();
		}
		
		

	}

}