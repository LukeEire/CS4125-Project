package BookingPackage;

import java.time.LocalDateTime;
import ezparkproject.Users;

public interface Reservation {
	
	Users getUser();
	
	void setUser(Users user);

    String getLot();
    
    void setLot(String lot);
    
    String getReg();
    
    void setReg(String reg);
    
    Long getHours();
    
    public void setHours(Long hours);
    
    int getChargingCheck();
    
    void setCharging(int elec);
    
    LocalDateTime getDuration();

	void setDuration(LocalDateTime duration);

	public int getId();

	void setId(int id);
	
	public LocalDateTime getReservationTime();
	
	public void setReservationtime(LocalDateTime time);
	
    public void setStatus(int status);
    
    public int getStatus();
}
