package ezparkproject;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
// import java.time.LocalTime;
// import java.time.Period;
// import java.util.Calendar;
// import ezparkproject.Users;
// import java.sql.Time;




public class Reservation {
	/* Code here */
	
    private Users user;
    //private Lot lot ;
    private String lot;
    //private Spaces space;
    //int duration; //in minutes
    Date checkInDate;
    Date checkOutDate;
    
    Database db;

    private String reg;
    private LocalDateTime reservationTime;
    private LocalDateTime duration;
    private Long hours;
    private int accessibility;
    private int chargingSpace;
    private int id;

    // public Reservation(Users user, int duration) {
    //     this.user = user;
    //     //this.space = space;
    //     this.duration = duration;
    //     //Review these two lines of code
    //     checkInDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    //     //checkOutDate = checkInDate.plusMinutes(duration);
    // }

    
    public Reservation() {
    	
    }
    // Ayoub - new Reservation constructor
    public Reservation(Users user, String lot, int electricSpace, String reg, long hours) {

        //db = new Database();
        this.user = user;
        this.id = user.id;
        this.lot = lot;
        this.accessibility = user.accessibility;
        this.chargingSpace = electricSpace;
        this.reg = reg;
        this.reservationTime = LocalDateTime.now();
        this.duration = reservationTime.plus(Duration.ofHours(hours));
        this.hours = hours;

        System.out.println("Testing time: Duration = " + duration );

        /*if(addReservationToDb){
            try {
                db.reserve(id, reg, lot, user.electric, accessibility, hours);
            } catch (SQLException e) {
                System.out.println("Error Reserving a spot through the reservatins class constructor: " + e.getMessage() );
                e.printStackTrace();
            }
        }*/
        
    }
    
    public Reservation(Users user, String lot, int electricSpace, String reg, LocalDateTime beginTime, long hours) {

        //db = new Database();
        this.user = user;
        this.id = user.id;
        this.lot = lot;
        this.accessibility = user.accessibility;
        this.chargingSpace = electricSpace;
        this.reg = reg;
        this.reservationTime = LocalDateTime.now();
        this.duration = reservationTime.plus(Duration.ofHours(hours));
        this.hours = hours;

        System.out.println("Testing time: Duration = " + duration );

        /*if(addReservationToDb){
            try {
                db.reserve(id, reg, lot, user.electric, accessibility, hours);
            } catch (SQLException e) {
                System.out.println("Error Reserving a spot through the reservatins class constructor: " + e.getMessage() );
                e.printStackTrace();
            }
        }*/
        
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

    public String getLot() {
    	return this.lot;
    }
    
    public void setLot(String lot) {
    	this.lot = lot;
    }
    
    
    
    public String getReg() {
    	return this.reg;
    }
    
    public void setReg(String reg) {
    	this.reg = reg;
    }
    
    public Long getHours() {
    	return this.hours;
    }
    
    public void setHours(Long hours) {
    	this.hours = hours;
    }
    
    public int getChargingCheck() {
    	return this.chargingSpace;
    }
    
    public void setCharging(int elec) {
    	this.chargingSpace = elec;
    }
    
    public boolean checkAvailability() {
    	
		return false;
    	
    }
    
    //Move the penalty part to the ScheduleManagement?
//    public void checkOut(LocalDateTime checkOut) {
//    	if(checkOut.isAfter(checkOutDate)) {
//    		System.out.println("You over stayed your welcome!");
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