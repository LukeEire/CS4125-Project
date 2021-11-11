package ezparkproject;

import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*; 
import
java.sql.*;

public class RegFrame implements ActionListener{
	
	JFrame frame;
	String[] uniStatus = { "Student", "Staff", "Guest" }; /* also known as rank from our analysis class diagram */
	String[] accessibilityStatus = { "Yes", "No" }; /* When checking for disabled spaces, they will show in reservations */
	String[] EVStatus = { "Yes", "No" }; /* Electric vehicle status - needs to be set to yes to show EV parking spaces */
	
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
	
	/* Text fields for labels */
	
	JTextField universityIDField = new JTextField();
	JTextField firstNameField = new JTextField();
	JTextField lastNameField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JTextField emailTextField = new JTextField();
	JComboBox uniComboBox = new JComboBox(uniStatus);
	JTextField dobField = new JTextField();
	
	
	JPasswordField confirmPasswordField = new JPasswordField();
	
	
	/* Drop down menus */
	
	
	JComboBox accessibilityComboBox = new JComboBox(accessibilityStatus);
	JComboBox EVComboBox = new JComboBox(EVStatus);
	
	/* Buttons */
	
	
	JButton registerButton = new JButton("Register");
	JButton resetButton = new JButton("Reset");
	JButton loginButton = new JButton("Login");

	RegFrame() {

		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("User Registration");
		frame.setBounds(40, 40, 400, 600);
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
        EVLabel.setBounds(20, 330, 100, 70);
        accessibilityLabel.setBounds(20, 380, 100, 70);
        dobLabel.setBounds(20, 430, 100, 70);
        
        /* Text fields and drop downs bounds */
        
        universityIDField.setBounds(180, 43, 165, 23);
        firstNameField.setBounds(180, 93, 165, 23);
        lastNameField.setBounds(180, 155, 165, 23);
        passwordField.setBounds(180, 205, 165, 23);
        emailTextField.setBounds(180, 250, 165, 23);
        uniComboBox.setBounds(180, 300, 165, 23);
        EVComboBox.setBounds(180, 350, 165, 23);
        accessibilityComboBox.setBounds(180, 400, 165, 23);
        dobField.setBounds(180, 450, 165, 23);
        
        /* Button Bounds */
        
        registerButton.setBounds(25, 500, 100, 35);
        resetButton.setBounds(250, 500, 100, 35);
        loginButton.setBounds(137, 500, 100, 35);
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
		
		/* Text fields and drop downs */
		
		frame.add(universityIDField);
		frame.add(firstNameField);
		frame.add(lastNameField);
		frame.add(passwordField);
		frame.add(emailTextField);
		frame.add(uniComboBox);
		frame.add(accessibilityComboBox);
		frame.add(EVComboBox);
		frame.add(dobField);
		
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

			try {
				
				/* Create Connection Object */
				Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com:3306/sql4450358","sql4450358","dcCxqbDW1K");
				
				/* Pass values into Database */
				
				PreparedStatement Pstatement = con.prepareStatement("insert into ParkingDB values(?,?,?,?,?,?,?,?,?,?,?,?)");

				/* Specifying values */
				
				Pstatement.setString(1, universityIDField.getText());
				Pstatement.setString(2, firstNameField.getText());
				Pstatement.setString(3, lastNameField.getText());				
				Pstatement.setString(4, passwordField.getText());
				Pstatement.setString(5, emailTextField.getText());
				Pstatement.setString(6, uniComboBox.getSelectedItem().toString());
				Pstatement.setString(7, EVComboBox.getSelectedItem().toString());				
				Pstatement.setInt(8, 0);
				Pstatement.setInt(9, 0);
				Pstatement.setString(10, accessibilityComboBox.getSelectedItem().toString());
				Pstatement.setInt(11, 0); // Needs to get current date 
				Pstatement.setString(12, dobField.getText()); // Needs to get DOB this is TBD at the moment
				
				//Check to see if name field was left blank 
				if (firstNameField.getText().isEmpty()){
					
					JOptionPane.showMessageDialog(null, "You must enter in a name");
				} else {
					
					Pstatement.executeUpdate();
					firstNameField.setText("");
					universityID.setText("");
					dobField.setText("");
					lastNameField.setText("");
					uniComboBox.setSelectedItem("Student");
					EVComboBox.setSelectedItem("Yes");
					accessibilityComboBox.setSelectedItem("Yes");
					passwordField.setText("");
					confirmPasswordField.setText("");
					emailTextField.setText("");
					JOptionPane.showMessageDialog(null, "You have successfully registered");
				}	

			} catch (SQLException e1) {
				e1.printStackTrace();
		}

		}
		
			
		if (e.getSource() == resetButton) {

			firstNameField.setText("");
			universityID.setText("ID");
			dobField.setText("");
			lastNameField.setText("");
			uniComboBox.setSelectedItem("Student");
			EVComboBox.setSelectedItem("Yes");
			accessibilityComboBox.setSelectedItem("Yes");
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

