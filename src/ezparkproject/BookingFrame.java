package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import java.sql.*;

public class BookingFrame implements ActionListener{
	
	private JButton makeButton;
	private JButton cancelButton;
	private JButton changeButton;
	private JButton quitButton;
	private JTextField heading;
	
	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
	
	JFrame frame;
	String[] uniStatus = { "Student", "Staff", "Guest" }; /* also known as rank from our analysis class diagram */
	
	/* Labels */
	
	JLabel universityID = new JLabel("ID");
	JLabel firstNameLabel = new JLabel("First Name");
	JLabel lastNameLabel = new JLabel("Last Name");
	JLabel university_statusLabel = new JLabel("Status");
	JLabel passwordLabel = new JLabel("Password");
	JLabel emailLabel = new JLabel("Email Address");
	JLabel EVLabel = new JLabel("Electric Vehicle?");
	JLabel dobLabel = new JLabel("Date of Birth");
	JLabel accessibilityLabel = new JLabel("Disabled Permit");
	JLabel plateLabel = new JLabel("Car Registration");
	
	/* Text fields for labels */
	
	JTextField universityIDField = new JTextField();
	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JTextField emailTextField = new JTextField();
	JComboBox uniComboBox = new JComboBox(uniStatus);
	JTextField dobField = new JTextField();
	JTextField plate = new JTextField();
	
	
	
	
	
	/* Buttons */
	
	
	JButton registerButton = new JButton("Register");
	JButton resetButton = new JButton("Reset");
	JButton loginButton = new JButton("Login");

	BookingFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.CYAN);
		addComponentsToFrame();
		actionEvent();
	}
	
	

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("User Registration");
		frame.setBounds(40, 40, 1280, 720);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */

		universityID.setBounds(20, 20, 40, 70);
        firstNameLabel.setBounds(20, 70, 80, 70);
        lastNameLabel.setBounds(20, 130, 80, 70);
        passwordLabel.setBounds(20, 180, 140, 70);
        emailLabel.setBounds(20, 225, 100, 70);
        university_statusLabel.setBounds(20, 280, 100, 70);
        dobLabel.setBounds(20, 330, 100, 70);
        plateLabel.setBounds(20, 380, 100, 70);
        
        /* Text fields and drop downs bounds */
        
        universityIDField.setBounds(180, 43, 165, 23);
        firstNameField.setBounds(180, 93, 165, 23);
        lastNameField.setBounds(180, 155, 165, 23);
        passwordField.setBounds(180, 205, 165, 23);
        emailTextField.setBounds(180, 250, 165, 23);
        uniComboBox.setBounds(180, 300, 165, 23);
        dobField.setBounds (180, 350, 165, 23);
        plate.setBounds (180, 400, 165, 23);
        
        /* Button Bounds */
        
        registerButton.setBounds(25, 550, 100, 35);
        resetButton.setBounds(250, 550, 100, 35);
        loginButton.setBounds(137, 550, 100, 35);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(universityID);
		frame.add(firstNameLabel);
		frame.add(lastNameLabel);
		frame.add(passwordLabel);
		frame.add(emailLabel);
		frame.add(university_statusLabel);
		frame.add(EVLabel);
		frame.add(accessibilityLabel);
		frame.add(dobLabel);
		frame.add(plateLabel);
		
		/* Text fields and drop downs */
		
		frame.add(universityIDField);
		frame.add(firstNameField);
		frame.add(lastNameField);
		frame.add(passwordField);
		frame.add(emailTextField);
		frame.add(uniComboBox);
		frame.add(dobField);
		frame.add(plate);
		
		/* Buttons */
		
		frame.add(registerButton);
		frame.add(resetButton);
		frame.add(loginButton);
	}
	
	

	public void actionEvent() {

		registerButton.addActionListener(this);
		resetButton.addActionListener(this);
		loginButton.addActionListener(this);
	}
	

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == registerButton) {

		}	
			
		if (e.getSource() == resetButton) {

			firstNameField.setText("");
			universityID.setText("ID");
			dobField.setText("");
			lastNameField.setText("");
			uniComboBox.setSelectedItem("Student");			
			passwordField.setText("");
			emailTextField.setText("");
		}

		if (e.getSource() == loginButton) {

			/* Close current window */
			
			
			frame.dispose();
			
			/* Create new Login form */
			LoginFunction frame = new LoginFunction();
	        frame.setTitle("Login Form");
	        frame.setVisible(true);
	        frame.setBounds(500, 200, 1100, 600);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setResizable(false);
	        
	        
		}
		
		

	}
	
}