package ezparkproject;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;

public class Main {
	
	static Users currentUser = new Users();
	
	//These are static as they will need to be consistent through all pages of the program
	static Lot LotA = new Lot ("LotA", 300, 10, 3);
	static Lot LotB = new Lot ("LotB", 350, 15, 0);
	static Lot LotC = new Lot ("LotC", 300, 15, 5);
	static Lot LotD = new Lot ("LotD", 400, 20, 10);
	
	
    public static void main(String[] args) throws Exception
    {
    	
    	// LoginFunction frame = new LoginFunction();
	    //    frame.setTitle("Login Form");
	    //    frame.setVisible(true);
	    //    frame.setBounds(500, 200, 1100, 600);
	    //    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //    frame.setResizable(false);
	       
       //new AdminFrame();
		
	   //Testing email
	   ForgotPasswordBackend.sendVerificationEmail("ayoubjdair00@gmail.com");
    }
}