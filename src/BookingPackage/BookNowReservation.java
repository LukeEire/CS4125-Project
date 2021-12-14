package BookingPackage;
import ezparkproject.Database;
import ezparkproject.Users;
import java.time.Duration;
import java.time.LocalDateTime;


public class BookNowReservation implements Reservation{

	private Users user;
    private String lot;
    private int status;
    
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
        this.status = 0;
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
	
    public void setStatus(int status) {
		this.status = status;
	}
    
    public int getStatus() {
		return status;
	}
}
