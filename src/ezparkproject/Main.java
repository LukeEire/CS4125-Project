package ezparkproject;

import BookingPackage.Lot;
import LoginPackage.LoginFunction;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {
	
	
	public static Users currentUser = new Users();
	
	//These are static as they will need to be consistent through all pages of the program
	public static Lot LotA = new Lot ("LotA", 300, 10, 3);
	public static Lot LotB = new Lot ("LotB", 350, 15, 0);
	public static Lot LotC = new Lot ("LotC", 300, 15, 5);
	public static Lot LotD = new Lot ("LotD", 400, 20, 10);
	
	public static ArrayList<LocalDate> blockedDates = new ArrayList<LocalDate>();
	public static ArrayList<String> blockedLots = new ArrayList<String>();
	
	public static void initialiseArrays() {
		LocalDate tempDate = LocalDate.parse("2021-01-01");
		blockedLots.add("Lot A");
		blockedDates.add(tempDate);
	}
	
	
    public static void main(String[] args) throws Exception {
    	
    	LoginFunction frame = new LoginFunction();
	    frame.setTitle("Login Form");
	    frame.setVisible(true);
	    frame.setBounds(500, 200, 1100, 600);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    initialiseArrays();
	       
       //new AdminFrame();
		
    }
}