package ezparkproject;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


/* Author: Ashutosh Yadav 
 * Student ID: 18249094
 * Date: 02/11/2021
 * Version 1.02
 * */



public class Users implements ActionListener {
    JFrame frame;
    String[] uniStatus={"Student","Staff","Guest"}; //also known as rank from our analysis class diagram
    JLabel nameLabel=new JLabel("Name");
    JLabel university_statusLabel=new JLabel("Status");
    JLabel passwordLabel=new JLabel("Password");
    JLabel confirmPasswordLabel=new JLabel("Confirm Password");
    JLabel emailLabel=new JLabel("Email Address");
    JTextField nameTextField=new JTextField();
    JComboBox uniComboBox=new JComboBox(uniStatus);
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("Register");
    JButton resetButton=new JButton("Reset");
    JButton loginButton=new JButton("Login");


    Users(){
    	
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    
    public void createWindow(){
    	
        frame=new JFrame();
        frame.setTitle("User Registration");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    
    public void setLocationAndSize(){
    	
        nameLabel.setBounds(20,20,40,70);
        university_statusLabel.setBounds(20,70,80,70);
        passwordLabel.setBounds(20,170,100,70);
        confirmPasswordLabel.setBounds(20,220,140,70);
        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        uniComboBox.setBounds(180,93,165,23);
        passwordField.setBounds(180,193,165,23);
        confirmPasswordField.setBounds(180,243,165,23);
        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(25,400,100,35);
        resetButton.setBounds(250,400,100,35);
        loginButton.setBounds(137,400,100,35);
    }
    
    public void addComponentsToFrame(){
    	
        frame.add(nameLabel);
        frame.add(university_statusLabel);
        frame.add(passwordLabel);
        frame.add(confirmPasswordLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(uniComboBox);
        frame.add(passwordField);
        frame.add(confirmPasswordField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
        frame.add(loginButton);
    }
    
    public void actionEvent(){
    	
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @SuppressWarnings("deprecation")
	@Override
    public void actionPerformed(ActionEvent e) {
    	
    	/*Create Database before using */
    	
        if(e.getSource()==registerButton){
        	
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","root");
                //Prepared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,uniComboBox.getSelectedItem().toString());
                Pstatement.setString(3,passwordField.getText());
                Pstatement.setString(4,confirmPasswordField.getText());
                Pstatement.setString(5,emailTextField.getText());
                //Checking for the Password match
                if(passwordField.getText().equalsIgnoreCase(confirmPasswordField.getText())){
                	
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                }
                else{
                	
                    JOptionPane.showMessageDialog(null,"password did not match");
                }

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if(e.getSource()==resetButton){
        	
            nameTextField.setText("");
            uniComboBox.setSelectedItem("Student");
            passwordField.setText("");
            confirmPasswordField.setText("");
            emailTextField.setText("");
        }
        
        if(e.getSource()==loginButton){
                
        	/* Link Login.java and dispose of current frame */
        	
        }

    }
}
