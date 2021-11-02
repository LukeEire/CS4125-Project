import java.util.*;

public class Users {
    public String name;
    public String email_address;
    public int rank;
    private Date dob;
    private String password;
    public static int count = 1;
    public static String input;

    public Users(String Remailaddress, String Rpassword) {

        this.email_address = Remailaddress;
        this.password = Rpassword;
        count++;

        System.out.printf("User %s has been created \n", Remailaddress);
        System.out.printf("Enter 'Email' and password to login or 'register' to create an account");

    }

    public static void login(String Lemailaddress, String Lpassword) {
        for (int i = 1; i <= count; i++) {
            System.out.printf("Enter 'Email' and password to login or 'register' to create an account");

        }
    }

}