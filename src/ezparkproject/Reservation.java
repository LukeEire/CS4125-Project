package ezparkproject;
import ezparkproject.Users;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;


public class Reservation {
	/* Code here */
	
    private Users user;
    //private Lot lot ;
    //private Spaces space;
    //int duration; //in minutes
    Date checkInDate;
    Date checkOutDate;

    private String lot;
    private String reg;
    private LocalDateTime expiry;
    private LocalDateTime reservationTime;
    private LocalTime duration;
    private int accessibility;
    private int electric;
    private int id;
    Database db = new Database();

    // public Reservation(Users user, int duration) {
    //     this.user = user;
    //     //this.space = space;
    //     this.duration = duration;
    //     //Review these two lines of code
    //     checkInDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    //     //checkOutDate = checkInDate.plusMinutes(duration);
    // }

    // Ayoub - new Reservation constructor
    // Adds reservation to DB
    public Reservation(Users user, String lot, /* has to be of format HH:mm */String sduration) {
        
        this.user = user;
        this.id = user.id;
        this.accessibility = user.accessibility;
        this.electric = user.electric;
        this.reg = user.getDefultPlate();
        this.reservationTime = LocalDateTime.now();
        this.duration = LocalTime.parse(sduration);
        System.out.println("Testing time: Duration = " + duration );
        this.expiry = reservationTime.plus(duration);
        
        db.reserve(id, reg, lot, electric, accessibility, expiry.toString());
        
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getcheckInDate() {
        return checkInDate;
    }

    public void setcheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }
    
    public Date getcheckOutDate() {
        return checkOutDate;
    }

    public void setcheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    //This may be handled by ScheduleManagement
    public void makeReservation(Users user, int duration){
    	
    }
    
    public boolean checkAvailability() {
    	
		return false;
    	
    }
    
    //Move the penalty part to the ScheduleManagement?
//    public void checkOut(LocalDateTime checkOut) {
//    	if(checkOut.isAfter(checkOutDate)) {
//    		System.out.println("You overstayed your welcome!");
//    		Penalty p = new Penalty();
//    		p.addInfraction(user.id);
//    	} else {
//    		System.out.println("See you next time!");
//    	}
//    }
    
    public void checkOut(Date checkOut) {
    		this.setcheckOutDate(checkOutDate);
    		System.out.println("See you next time!");
    	}
    
    
    
    
    
}