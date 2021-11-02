package ezparkproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFunction extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel nameLabel = new JLabel("Name");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetPWButton = new JButton("Forgot Password");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFunction() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        nameLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(150, 300, 100, 30);
        resetPWButton.setBounds(125, 350, 150, 30);


    }

    public void addComponentsToContainer() {
        container.add(nameLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetPWButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetPWButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            
            /* Test case to check if the authentication works, needs to be linked to DB */
            if (userText.equalsIgnoreCase("Ashutosh") && pwdText.equalsIgnoreCase("pleasehelpme")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        
        /* Calls reset password class */
        if (e.getSource() == resetPWButton) {
            
        	/* Code goes here */
        }
        
        /* Show Password Function */
      
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}


