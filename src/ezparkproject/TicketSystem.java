package ezparkproject;

import java.sql.Connection;
import java.sql.Date;

public class TicketSystem 
{
	
	private int spaceNum;
	private long startTime;
	private Date date;
	
	public TicketSystem(int slotNumber, long startTime, Date date)
	{
		this.spaceNum = slotNumber;
		this.startTime = startTime;
		this.date = date;
	}

	public int getSlotNumber() {
		return spaceNum;
	}

	public long getStartTime() {
		return startTime;
	}

	public Date getDate() {
		return date;
	}
	
	
}


