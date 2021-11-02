package ezparkproject;

import javax.swing.JFrame;

/* Author: Ashutosh Yadav 
 * Student ID: 18249094
 * Date: 02/11/2021
 * Version 1.01
 * */


public class Login {
    public static void main(String[] a) {
        LoginFunction frame = new LoginFunction();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10, 10, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}
