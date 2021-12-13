package BookingPackage;
import ezparkproject.Database;
import ezparkproject.Users;

import java.sql.Date;
import java.time.Duration;
import java.time.LocalDateTime;


public class BookNowReservation implements Reservation{

	private Users user;
    private String lot;
    Date checkOutDate;
    
    Database db;

    private String reg;
    private LocalDateTime reservationTime;
    private LocalDateTime duration;
    private Long hours;
    private int accessibility;
    private int chargingSpace;
    private int id;
	
    public BookNowReservation(Users user, String lot, int electricSpace, String reg, long hours) {

        this.user = user;
        this.setId(user.id);
        this.lot = lot;
        this.accessibility = user.accessibility;
        this.chargingSpace = electricSpace;
        this.reg = reg;
        this.reservationTime = LocalDateTime.now();
        this.setDuration(reservationTime.plus(Duration.ofHours(hours)));
        this.hours = hours;

        
    }
    
    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
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
    
    public int getAccessibilityCheck() {
    	return this.accessibility;
    }
    
    public void setAccessibility(int access) {
    	this.accessibility = access;
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

	public LocalDateTime getReservationTime() {
		return this.reservationTime;
	}
	
	public void setReservationtime(LocalDateTime time) {
		this.reservationTime = time;
	}
	
    
}
