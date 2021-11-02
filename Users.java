import java.util.*;

	
/* Author: Ashutosh Yadav */

public class Users {
    public String name;
    public String email_address;
    public int rank;
    private Date dob; //Date of Birth passed as date 
    private String password;
    public static int count = 1;
    public static String input;

    public Users(String R_emailaddress, String R_password) {

        this.email_address = R_emailaddress;
        this.password = R_password;
        count++;

        System.out.printf("User %s has been created \n", R_emailaddress);
        System.out.printf("Enter 'Email' and password to login or 'register' to create an account");

    }

    public static void login(String L_emailaddress, String L_password) {
        for (int i = 1; i <= count; i++) {
            System.out.printf("Enter 'Email' and password to login or 'register' to create an account");

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("login");
        System.out.println("register");
        input = scanner.nextLine();

                do{

                System.out.println("Enter \"login\", \"register\", or \"exit\"");
                input = scanner.nextLine();
                if (input.equals("login"))
                {
                    /* Fetch Login details */
                }
                else if (input.equals("register"))
                {
                    /* Fetch Registration details */
                }
                else if (input.equals("exit"))
                {
                    break; /* exit Loop */
                }
                else
                {
                    /* Error handling, invalid input. */
                }
        } while (true);
    }
}
