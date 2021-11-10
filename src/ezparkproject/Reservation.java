package ezparkproject;
import ezparkproject.Users;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.Period;


public class Reservation {
	/* Code here */
	
    private Users user;
    //private Lot lot ;
    //private Spaces space;
    int duration; //in minutes
    LocalDateTime checkInDate;
    LocalDateTime checkOutDate;


    public Reservation(Users user, int duration) {
        this.user = user;
        //this.space = space;
        this.duration = duration;
        checkInDate = LocalDateTime.now();
        checkOutDate = checkInDate.plusMinutes(duration);
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getcheckInDate() {
        return checkInDate;
    }

    public void setcheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }
    
    public LocalDateTime getcheckOutDate() {
        return checkOutDate;
    }

    public void setcheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void makeReservation(Users user, Spaces space, int duration){
    	space.setAvailablity(false); //may be redundant, could pass false into method below
    	space.bookSpace(user, checkInDate, checkOutDate);
    }
    
    public boolean checkAvailability(Spaces space) {
    	if(!space.isAvailable()) {
    		System.out.println("Spave unavailable");
    		return false;
    	} else {
    		return true;
    	}
    }
    
    public void checkOut(LocalDateTime checkOut) {
    	if(checkOut.isAfter(checkOutDate)) {
    		System.out.println("You overstayed your welcome!");
    		Penalty p = new Penalty();
    		p.addInfraction(user.toString(), 1);
    	} else {
    		System.out.println("See you next time!");
    	}
    }
}