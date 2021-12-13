package ezparkproject;

import java.sql.Date;
import java.time.LocalDateTime;

public interface Reservation {
	
	Users getUser();
	
	void setUser(Users user);
    
    Date getcheckOutDate();

    void setcheckOutDate(Date checkOutDate);

    String getLot();
    
    void setLot(String lot);
    
    String getReg();
    
    void setReg(String reg);
    
    Long getHours();
    
    public void setHours(Long hours);
    
    int getChargingCheck();
    
    void setCharging(int elec);

    void checkOut(Date checkOut);
    
    LocalDateTime getDuration();

	void setDuration(LocalDateTime duration);

	public int getId();

	void setId(int id);
	
	public LocalDateTime getReservationTime();
	
	public void setReservationtime(LocalDateTime time);
	
}
