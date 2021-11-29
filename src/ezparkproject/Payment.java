package ezparkproject;

import java.sql.SQLException;

public class Payment {
	
	Payment() {
		
	}
	
	public static boolean checkID(int id) {
		
	try {
		
		Database db = new Database();
		
		
		if (db.checkID(id)) {
			
			Payment frame = new Payment();
            frame.setVisible(true);
            System.out.print("Test");
            
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

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}