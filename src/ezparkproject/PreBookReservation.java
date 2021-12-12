package ezparkproject;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;

public class PreBookReservation implements Reservation{
	/* Code here */
	
    private Users user;
    private String lot;
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

    
    public PreBookReservation() {
    	
    }
    
//    public PreBookReservation(Users user, String lot, int electricSpace, String reg, long hours) {
//
//        this.user = user;
//        this.id = user.id;
//        this.lot = lot;
//        this.accessibility = user.accessibility;
//        this.chargingSpace = electricSpace;
//        this.reg = reg;
//        this.reservationTime = LocalDateTime.now();
//        this.duration = reservationTime.plus(Duration.ofHours(hours));
//        this.hours = hours;
//
//        System.out.println("Testing time: Duration = " + duration );
//        
//    }
    
    public PreBookReservation(Users user, String lot, int electricSpace, String reg, LocalDateTime beginTime, long hours) {

        this.user = user;
        this.id = user.id;
        this.lot = lot;
        this.accessibility = user.accessibility;
        this.chargingSpace = electricSpace;
        this.reg = reg;
        this.reservationTime = LocalDateTime.now();
        this.duration = reservationTime.plus(Duration.ofHours(hours));
        this.hours = hours;

        
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
    
    public int getAccessibilityCheck() {
    	return this.accessibility;
    }
    
    public void setAccessibility(int access) {
    	this.accessibility = access;
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
    
    public void checkOut(Date checkOut) {
    		this.setcheckOutDate(checkOutDate);
    		System.out.println("See you next time!");
    }
    
    public LocalDateTime getDuration() {
		return duration;
	}

	public void setDuration(LocalDateTime duration) {
		this.duration = duration;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    
    
}