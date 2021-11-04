package ezparkproject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

/* Author: Ashutosh Yadav 
 * Student ID: 18249094
 * Date: 02/11/2021
 * Version 1.04
 * */

public class Users implements ActionListener {
	JFrame frame;
	String[] uniStatus = { "Student", "Staff", "Guest" }; // also known as rank from our analysis class diagram
	String[] accessibilityStatus = { "Yes", "No" };
	String[] EVStatus = { "Yes", "No" };
	
	JLabel nameLabel = new JLabel("Name");
	JLabel university_statusLabel = new JLabel("Status");
	JLabel passwordLabel = new JLabel("Password");
	JLabel confirmPasswordLabel = new JLabel("Confirm Password");
	JLabel emailLabel = new JLabel("Email Address");
	JLabel EVLabel = new JLabel("Electric Vehicle?");
	JLabel accessibilityLabel = new JLabel("Disabled Permit");
	
	JTextField nameTextField = new JTextField();
	JComboBox uniComboBox = new JComboBox(uniStatus);
	JPasswordField passwordField = new JPasswordField();
	JPasswordField confirmPasswordField = new JPasswordField();
	JTextField emailTextField = new JTextField();
	
	
	JComboBox accessibilityComboBox = new JComboBox(accessibilityStatus);
	JComboBox EVComboBox = new JComboBox(EVStatus);
	
	
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
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		/* Create Database before using */

		if (e.getSource() == registerButton) {

			try {
				
				/* Create Connection Object */
				
				Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4448569","sql4448569", "rs5fNh4D5f");
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
				
				/* Checking for the Password match */
				
				if (passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())) {

					Pstatement.executeUpdate();
					JOptionPane.showMessageDialog(null, "User Successfully Registered");
				} else {

					JOptionPane.showMessageDialog(null, "Please check you entered the password correctly");
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

			/* Create Login.java and close current window */

		}

	}
}