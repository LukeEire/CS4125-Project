package ezparkproject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class Users implements ActionListener {
	
	String name;
	String email;
	String status;
	Boolean disability;
	Boolean electric;
	
	/*public Users() {
		
	}*/
	
	public Users(String name, String email, String status, Boolean disability, Boolean electric) {
		
		this.name = name;
		this.email = email;
		this.status = status;
		this.disability = disability;
		this.electric = electric;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	
	JFrame frame;
	String[] uniStatus = { "Student", "Staff", "Guest" }; /* also known as rank from our analysis class diagram */
	String[] accessibilityStatus = { "Yes", "No" }; /* When checking for disabled spaces, they will show in reservations */
	String[] EVStatus = { "Yes", "No" }; /* Electric vehicle status - needs to be set to yes to show EV parking spaces */
	
	/* Labels */
	
	JLabel nameLabel = new JLabel("Name");
	JLabel university_statusLabel = new JLabel("Status");
	JLabel passwordLabel = new JLabel("Password");
	JLabel confirmPasswordLabel = new JLabel("Confirm Password");
	JLabel emailLabel = new JLabel("Email Address");
	JLabel EVLabel = new JLabel("Electric Vehicle?");
	JLabel accessibilityLabel = new JLabel("Disabled Permit");
	
	/* Text fields for labels */
	
	JTextField nameTextField = new JTextField();
	JComboBox uniComboBox = new JComboBox(uniStatus);
	JPasswordField passwordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JTextField emailTextField = new JTextField();
	
	/* Drop down menus */
	
	
	JComboBox accessibilityComboBox = new JComboBox(accessibilityStatus);
	JComboBox EVComboBox = new JComboBox(EVStatus);
	
	/* Buttons */
	
	
	JButton registerButton = new JButton("Register");
	JButton resetButton = new JButton("Reset");
	JButton loginButton = new JButton("Login");

	Users() {

		createWindow();
		setLocationAndSize();
		addComponentsToFrame();
		actionEvent();
	}

	public void createWindow() {

		frame = new JFrame();
		frame.setTitle("User Registration");
		frame.setBounds(40, 40, 380, 600);
		frame.getContentPane().setBackground(Color.white);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	}

	public void setLocationAndSize() {
		
		/* Label Bounds */

		nameLabel.setBounds(20, 20, 40, 70);
        university_statusLabel.setBounds(20, 70, 80, 70);
        passwordLabel.setBounds(20, 130, 80, 70);
        confirmPasswordLabel.setBounds(20, 180, 140, 70);
        emailLabel.setBounds(20, 225, 100, 70);
        EVLabel.setBounds(20, 280, 100, 70);
        accessibilityLabel.setBounds(20, 330, 100, 70);
        
        /* Text fields and drop downs bounds */
        
        nameTextField.setBounds(180, 43, 165, 23);
        uniComboBox.setBounds(180, 93, 165, 23);
        passwordField.setBounds(180, 155, 165, 23);
        confirmPasswordField.setBounds(180, 205, 165, 23);
        emailTextField.setBounds(180, 250, 165, 23);
        accessibilityComboBox.setBounds(180, 300, 165, 23);
        EVComboBox.setBounds(180, 350, 165, 23);
        
        /* Button Bounds */
        
        registerButton.setBounds(25, 500, 100, 35);
        resetButton.setBounds(250, 500, 100, 35);
        loginButton.setBounds(137, 500, 100, 35);
	}

	public void addComponentsToFrame() {
		
		/* Labels */

		frame.add(nameLabel);
		frame.add(university_statusLabel);
		frame.add(passwordLabel);
		frame.add(confirmPasswordLabel);
		frame.add(emailLabel);
		frame.add(EVLabel);
		frame.add(accessibilityLabel);
		
		/* Text fields and drop downs */
		
		frame.add(nameTextField);
		frame.add(uniComboBox);
		frame.add(passwordField);
		frame.add(confirmPasswordField);
		frame.add(emailTextField);
		frame.add(accessibilityComboBox);
		frame.add(EVComboBox);
		
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
				
				Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4448569","sql4448569", "rs5fNh4D5f");
				
				/* Pass values into Database */
				
				PreparedStatement Pstatement = con.prepareStatement("insert into ParkingDB values(?,?,?,?,?,?,?,?,?)");

				/* Specifying values */
				
				Pstatement.setString(1, nameTextField.getText());
				Pstatement.setString(2, uniComboBox.getSelectedItem().toString());
				Pstatement.setString(3, passwordField.getText());
				Pstatement.setString(4, confirmPasswordField.getText());
				Pstatement.setString(5, emailTextField.getText());
				Pstatement.setString(6, EVComboBox.getSelectedItem().toString());
				Pstatement.setString(7, accessibilityComboBox.getSelectedItem().toString());
				Pstatement.setInt(8, 0);
				Pstatement.setInt(9, 0);
				
				/* Check to see if name field was left blank */
				
				if (nameTextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "The field cannot be left blank. You must enter in a name");
				} else {
					
				/* Check to see if email field was left blank */
					
				if (emailTextField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "The field cannot be left blank. You must enter in an email");
				} else {
					
				
				/* Check to see if password field was left blank */
					
				if (passwordField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "You must enter a password");
				} else {
				
				/* Checking for the Password match */
				
				if (passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())) {

					Pstatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "You have successfully registered");
				} else {

					JOptionPane.showMessageDialog(null, "Please check your passwords match");
				}
				
				
			}
		}
	}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
			
		
		if (e.getSource() == resetButton) {

			nameTextField.setText("");
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