package LoginPackage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import PasswordPackage.ForgotPasswordFrame;
import RegistrationPackage.RegFrame;


/* Author: Conall McAteer, Ashutosh Yadav and Luke Kellet Murray */

public class LoginFunction extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton logoutButton;
    private JButton registerButton;
    private JButton forgotPWButton;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFunction frame = new LoginFunction();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginFunction() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 1100, 600);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        /* Adding an Image logo to the start of the login screen */
        
        label = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/ezparkproject/images/logo.png")).getImage();
        label.setIcon(new ImageIcon(img));
        label.setBounds(503, 13, 273, 93);
        label.setSize(100,100);
        contentPane.add(label);
                

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Your ID Number");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblUsername.setBounds(300, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPassword.setBounds(350, 286, 193, 52);
        contentPane.add(lblPassword);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        loginButton.setBounds(300, 392, 162, 73);
        loginButton.setSize(150,50);
        loginButton.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
        		int id = Integer.parseInt(textField.getText());                             
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
                
				
				//LoginBackend.loginFunction(id, password);
				
				
				if (LoginBackend.loginFunction(id, password)) {
						dispose();
						
					} else {						
						JOptionPane.showMessageDialog(loginButton, "Wrong Username or password, please try again");
					}
                
            } 
        });
        
        logoutButton = new JButton("Quit");
        logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        logoutButton.setBounds(700, 392, 162, 73);
        logoutButton.setSize(150,50);
        logoutButton.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
            }
        });
        
        registerButton = new JButton("Register");
        registerButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        registerButton.setBounds(500, 392, 162, 73);;
        registerButton.setSize(150,50);
        registerButton.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		new RegFrame();
        		
            }
        });
        
        forgotPWButton = new JButton("Forgot Password?");
        forgotPWButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        forgotPWButton.setBounds(450, 475, 162, 73);;
        forgotPWButton.setSize(250,50);
        forgotPWButton.addActionListener(new ActionListener() {

        	public void actionPerformed(ActionEvent e) {
        		
        		dispose();
        		new ForgotPasswordFrame();
        		
            }
        });

        contentPane.add(loginButton);
        contentPane.add(logoutButton);
        contentPane.add(registerButton);
        contentPane.add(forgotPWButton);
    }
}


