package ezparkproject;

import java.sql.SQLException;

import javax.swing.JFrame;

/* Author: Ashutosh Yadav 
 * Student ID: 18249094
 * Date: 02/11/2021
 * Version 1.02
 * */


public class Main {
    public static void main(String[] args) throws Exception
    {

    	LoginFunction frame = new LoginFunction();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(500, 200, 1100, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
       
    }
}