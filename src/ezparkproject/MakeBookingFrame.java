package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 

public class MakeBookingFrame implements ActionListener{

	BookingBackend Backend = new BookingBackend();
	
	String[] parkingLots = { "Lot A", "Lot B", "Lot C", "Lot D" };
	
	
	JFrame frame;
	
	/* Labels */
	
	JLabel userIDLabel = new JLabel("ID");
	//This can be updated to pull from userDB
	JLabel regLabel = new JLabel("Registration");
	JLabel lotLabel = new JLabel("Parking Lot");
	JLabel dateLabel = new JLabel("Date of Booking");
	JLabel timeLabel = new JLabel("Time of Booking");
	JLabel durationLabel = new JLabel("Duration of Booking (Hours)");
	//Pull this from user profile Electric can be optional
	JLabel accessibilityLabel = new JLabel("Disabled Permit");
	
	/* Text fields for labels */
	
	JTextField userIDField = new JTextField();
	JTextField regField = new JTextField();
	JComboBox lotComboBox = new JComboBox(parkingLots);
	JTextField dateField = new JTextField();
	JTextField timeField = new JTextField();
	JTextField durationField = new JTextField();
	
	
	/* JCheckbox for accessibility and EV status */
	
	JCheckBox EVCheckBox = new JCheckBox("Electric Vehicle?");
	
	int electricCheckBoxVal;
	
	public void itemStateChanged(ItemEvent e)
    {
        // if the state of checkbox1 is changed
        if (e.getSource() == EVCheckBox) {
            if (e.getStateChange() == 1)
                // Set to 1 
            	// AYOUBS FUNCTION TO CHANGE TO 1
            	electricCheckBoxVal = 1;
            	System.out.println("Set to 1");
        } else {
                // Set to 0
            	// AYOUBS FUNCTION TO CHANGE TO 0
            	electricCheckBoxVal = 0;
            	System.out.println("Set to 0");
        }
              
    }
	

	/* End of CheckBox function */
	
	
	/* Drop down menus */
	
	
	//JComboBox accessibilityComboBox = new JComboBox(accessibilityStatus);
	//JComboBox EVComboBox = new JComboBox(EVStatus);
	
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

		userIDLabel.setBounds(20, 20, 40, 70);
        regLabel.setBounds(20, 70, 80, 70);
        lotLabel.setBounds(20, 130, 80, 70);
        dateLabel.setBounds(20, 180, 140, 70);
        //emailLabel.setBounds(20, 225, 100, 70);
        timeLabel.setBounds(20, 225, 100, 70);
        durationLabel.setBounds(20, 280, 100, 70);
        accessibilityLabel.setBounds(20, 330, 100, 70);
        
        /* Text fields and drop downs bounds */
        
        userIDField.setBounds(180, 43, 165, 23);
        regField.setBounds(180, 93, 165, 23);
        dateField.setBounds(180, 155, 165, 23);
        timeField.setBounds(180, 205, 165, 23);
        //emailTextField.setBounds(180, 250, 165, 23);
        lotComboBox.setBounds(180, 250, 165, 23);
        EVCheckBox.setBounds(180, 400, 165, 23);
        //disabledCheckBox.setBounds(180, 450, 165, 23);
        durationField.setBounds (180, 300, 165, 23);
        //plate.setBounds (180, 350, 165, 23);
        
        /* Button Bounds */
        
        reserveButton.setBounds(25, 550, 100, 35);
        resetButton.setBounds(137, 550, 100, 35);
        cancelButton.setBounds(250, 550, 100, 35);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(userIDLabel);
		frame.add(regLabel);
		frame.add(lotLabel);
		frame.add(dateLabel);
		//frame.add(emailLabel);
		frame.add(timeLabel);
		frame.add(durationLabel);
		frame.add(accessibilityLabel);
		
		/* Text fields and drop downs */
		
		frame.add(userIDField);
		frame.add(regField);
		frame.add(dateField);
		frame.add(timeField);
		//frame.add(emailTextField);
		frame.add(lotComboBox);
		frame.add(EVCheckBox);
		frame.add(durationField);
		
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

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == reserveButton) {

			int id = Integer.parseInt(userIDField.getText());
			String reg = regField.getText();
			Long hours = Long.parseLong(durationField.getText());
			/*String lastName = lastNameField.getText();				
			String password = passwordField.getText();
			String status = uniComboBox.getSelectedItem().toString();
			int electric = electricCheckBoxVal;
			int accessibility = disabledCheckBoxVal;
			String dob = dobField.getText();
			String reg = plate.getText();*/
			
			Reservation res = new Reservation(false, null, reg, hours, 0);
			
			Backend.createBooking(res);
			
		}	
			
		if (e.getSource() == resetButton) {

			regField.setText("");
			userIDField.setText("");
			dateField.setText("");
			timeField.setText("");
			lotComboBox.setSelectedItem("Lot A");			
			durationField.setText("");
		}

		if (e.getSource() == cancelButton) {

			//Need to add message that says booked and return to Booking Menu
	        frame.dispose();
	        new BookingMenuFrame();
	        
		}
		
		

	}

}