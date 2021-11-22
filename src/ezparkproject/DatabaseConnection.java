package ezparkproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    

    public static Connection getConnection() throws SQLException {
    	Connection con = DriverManager.getConnection("jdbc:mysql://sql4.freesqldatabase.com:3306/sql4450358","sql4450358","dcCxqbDW1K");
		return con;
    }
}