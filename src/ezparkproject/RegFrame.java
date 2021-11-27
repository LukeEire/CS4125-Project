package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import
java.sql.*;

public class RegFrame implements ActionListener{
	
	RegBackend Backend = new RegBackend();
	
	
	/*Required timestamp to pass during registration and DOB */
	
	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
	
	JFrame frame;
	String[] uniStatus = { "Student", "Staff", "Guest" }; /* also known as rank from our analysis class diagram */
	//String[] accessibilityStatus = { "Yes", "No" }; /* When checking for disabled spaces, they will show in reservations */
	//String[] EVStatus = { "Yes", "No" }; /* Electric vehicle status - needs to be set to yes to show EV parking spaces */
	
	/* Labels */
	
	JLabel universityID = new JLabel("ID");
	JLabel firstNameLabel = new JLabel("First Name");
	JLabel lastNameLabel = new JLabel("Last Name");
	JLabel university_statusLabel = new JLabel("Status");
	JLabel passwordLabel = new JLabel("Password");
	//JLabel confirmPasswordLabel = new JLabel("Confirm Password");
	JLabel emailLabel = new JLabel("Email Address");
	JLabel EVLabel = new JLabel("Electric Vehicle?");
	JLabel dobLabel = new JLabel("Date of Birth");
	JLabel accessibilityLabel = new JLabel("Disabled Permit");
	JLabel plateLabel = new JLabel("Car Reg");
	
	/* Text fields for labels */
	
	JTextField universityIDField = new JTextField();
	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JTextField emailTextField = new JTextField();
	JComboBox uniComboBox = new JComboBox(uniStatus);
	JTextField dobField = new JTextField();
	JTextField plate = new JTextField();
	
	
	
	
	/* JCheckbox for accessibility and EV status */
	
	JCheckBox EVCheckBox = new JCheckBox("Disabled Permit?");
	JCheckBox disabledCheckBox = new JCheckBox("Electric Vehicle?");
	
	int electricCheckBoxVal;
	int disabledCheckBoxVal;
	
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
        
        if (e.getSource() == disabledCheckBox) {
            if (e.getStateChange() == 1)
                // Set to 1             	
            	// AYOUBS FUNCTION TO CHANGE TO 1
            	disabledCheckBoxVal = 1;
            	System.out.println("Set to 1");
        } else {
                // Set to 0
            	// AYOUBS FUNCTION TO CHANGE TO 0
        		disabledCheckBoxVal = 0;
            	System.out.println("Set to 0");
        }
  
        
    }
	

	/* End of CheckBox function */
	
	
	JPasswordField confirmPasswordField = new JPasswordField();
	
	
	/* Drop down menus */
	
	
	//JComboBox accessibilityComboBox = new JComboBox(accessibilityStatus);
	//JComboBox EVComboBox = new JComboBox(EVStatus);
	
	/* Buttons */
	
	
	JButton registerButton = new JButton("Register");
	JButton resetButton = new JButton("Reset");
	JButton loginButton = new JButton("Login");

	RegFrame() {

		createWindow();
		setLocationAndSize();
		frame.getContentPane().setBackground(Color.lightGray);
		addComponentsToFrame();
		actionEvent();
	}
	
	

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("User Registration");
		frame.setBounds(40, 40, 400, 700);
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
        EVCheckBox.setBounds(180, 450, 165, 23);
        disabledCheckBox.setBounds(180, 500, 165, 23);
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
		frame.add(disabledCheckBox);
		frame.add(EVCheckBox);
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
	
	//Placeholder code
	/*public Boolean createUser(Boolean test, int id, String firstName, String lastName, String password, String status, int electric, int accessibility, String dob, String reg){
		Users User1 = new Users(false, id, firstName, lastName, password, "@dbsucksballz", status, electric, accessibility, dob, reg);
		Database db = new Database();
		db.addUser(User1);
		
	}*/
	

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == registerButton) {

			int id = Integer.parseInt(universityIDField.getText());
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();				
			String password = passwordField.getText();
			String status = uniComboBox.getSelectedItem().toString();
			int electric = electricCheckBoxVal;
			int accessibility = disabledCheckBoxVal;
			String dob = dobField.getText();
			String reg = plate.getText();
			
			Backend.addUser(id, firstName, lastName, password, status, electric, accessibility, dob, reg);
			
			
			
			/*try {

				Database db = new Database();
				int id = Integer.parseInt(universityIDField.getText());
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();				
				String password = passwordField.getText();
				String status = uniComboBox.getSelectedItem().toString();
				int electric = electricCheckBoxVal;
				int accessibility = disabledCheckBoxVal;
				String dob = dobField.getText();
				String reg = plate.getText();
				//db.newUser(id, firstName, lastName, password, status, electric, accessibility, dob, reg);
				
			} catch (SQLException error) {

				System.out.println("Could not connect to the database " + error.getMessage());

			}*/
			
			
			
		}	
			
		if (e.getSource() == resetButton) {

			firstNameField.setText("");
			universityID.setText("ID");
			dobField.setText("");
			lastNameField.setText("");
			uniComboBox.setSelectedItem("Student");			
			passwordField.setText("");
			confirmPasswordField.setText("");
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

