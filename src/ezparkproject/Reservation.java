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

    //This may be handled by ScheduleManagement
    public void makeReservation(Users user, int duration){
    	
    }
    
    public boolean checkAvailability() {
    	
		return false;
    	
    }
    
    public void checkOut(LocalDateTime checkOut) {
    	if(checkOut.isAfter(checkOutDate)) {
    		System.out.println("You overstayed your welcome!");
    		Penalty p = new Penalty();
    		p.addInfraction(user.id);
    	} else {
    		System.out.println("See you next time!");
    	}
    }
}