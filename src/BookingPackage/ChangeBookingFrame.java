package BookingPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeBookingFrame implements ActionListener{
	BookingBackend Backend = new BookingBackend();
	
	String[] parkingLots = { "Lot A", "Lot B", "Lot C", "Lot D" };
	String[] hours = { "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00" };
	String[] duration = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	
	
	JFrame frame;
	
	/* Labels */
	
	JLabel bookingIDLabel = new JLabel("Booking ID");
	JLabel lotLabel = new JLabel("Parking Lot");
	JLabel dateLabel = new JLabel("Date of Booking");
	JLabel timeLabel = new JLabel("Time of Booking");
	JLabel durationLabel = new JLabel("Duration (Hours)");
	JLabel chargingLabel = new JLabel("Charging");
	
	/* Text fields for labels */
	
	JTextField bookingIDField = new JTextField();
	JComboBox<String> lotComboBox = new JComboBox<String>(parkingLots);
	JComboBox<String> timeComboBox = new JComboBox<String>(hours);
	JTextField dateField = new JTextField();
	JComboBox<String> durationComboBox = new JComboBox<String>(duration);
	
	
	/* JCheckbox for accessibility and EV status */
	
	JCheckBox EVCheckBox = new JCheckBox("Electric Vehicle?");
	
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
	
	
	JButton updateButton = new JButton("Update");
	JButton loadButton = new JButton("Load");
	JButton cancelButton = new JButton("Cancel");

	public ChangeBookingFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.lightGray);
		addComponentsToFrame();
		actionEvent();
	}
	
	

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("Change Booking");
		frame.setBounds(40, 40, 400, 700);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */

		bookingIDLabel.setBounds(20, 20, 40, 70);
		lotLabel.setBounds(20, 70, 80, 70);
        dateLabel.setBounds(20, 130, 140, 70);
        timeLabel.setBounds(20, 180, 100, 70);
        durationLabel.setBounds(20, 230, 100, 70);
        chargingLabel.setBounds(20, 280, 100, 70);
        
        /* Text fields and drop downs bounds */
        
        bookingIDField.setBounds(180, 43, 165, 23);
        lotComboBox.setBounds(180, 93, 165, 23);
        dateField.setBounds(180, 150, 165, 23);
        timeComboBox.setBounds(180, 200, 165, 23);
        durationComboBox.setBounds(180, 250, 165, 23);
        EVCheckBox.setBounds(180, 300, 165, 23);
        
        /* Button Bounds */
        
        updateButton.setBounds(25, 550, 100, 35);
        loadButton.setBounds(137, 550, 100, 35);
        cancelButton.setBounds(250, 550, 100, 35);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(bookingIDLabel);
		frame.add(lotLabel);
		frame.add(dateLabel);
		frame.add(timeLabel);
		frame.add(durationLabel);
		frame.add(chargingLabel);
		
		/* Text fields and drop downs */
		
		frame.add(bookingIDField);
		frame.add(dateField);
		frame.add(timeComboBox);
		frame.add(lotComboBox);
		frame.add(EVCheckBox);
		frame.add(durationComboBox);
		
		/* Buttons */
		
		frame.add(updateButton);
		frame.add(loadButton);
		frame.add(cancelButton);
	}
	
	

	public void actionEvent() {

		updateButton.addActionListener(this);
		loadButton.addActionListener(this);
		cancelButton.addActionListener(this);
	}
	

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == updateButton) {

			
		}	
			
		if (e.getSource() == loadButton) {
			
			Reservation res = new PreBookReservation();
			int resID = Integer.parseInt(bookingIDField.getText());
			res = Backend.loadBooking(resID);
			
			/*Date temp = res.getcheckInDate();
			DateFormat dateFormat = new SimpleDateFormat("yyy-mm-dd");
			String date = dateFormat.format(temp);*/
			
			
			
			

			lotComboBox.setSelectedItem(res.getLot());
			timeComboBox.setSelectedItem("09:00");
			durationComboBox.setSelectedItem("1");
			
			if (res.getChargingCheck() == 1) {
				EVCheckBox.setSelected(true);
			}else {
				EVCheckBox.setSelected(false);
			}
		}

		if (e.getSource() == cancelButton) {

	        frame.dispose();
	        new BookingMenuFrame();
	        
		}
		
		

	}

}
