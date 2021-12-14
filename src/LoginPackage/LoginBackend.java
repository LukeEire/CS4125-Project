package LoginPackage;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import ezparkproject.Dashboard;
import ezparkproject.Database;
import ezparkproject.Main;


/* Author:  Ashutosh Yadav  */

public class LoginBackend {
	
	LoginBackend() {
		
	}
	
	public static boolean loginFunction(int id, String password) {
		
	try {
		
		Database db = new Database();
		
		
		if (db.verifyUser(id, password)) {
			
			Dashboard frame = new Dashboard();
            frame.setVisible(true);
            System.out.print("You have successfully logged in \n");
            
            try {
				Main.currentUser = db.getUser(id);
			} catch (Exception e) {
				System.out.println("Could not connect to the database " + e.getMessage());
			}
            
            return true;   
            
		
		}else {
			
			
			System.out.print("Incorrect username or password");
			
		}
		
	} catch (SQLException error) {

		System.out.println("Could not connect to the database " + error.getMessage());

	}
	return false;
	

	
	
}

}

