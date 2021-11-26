package ezparkproject;

import java.sql.Date;

public class TicketSystem 
{
	private int slotNumber;
	private long startTime;
	private Date date;
	
	public TicketSystem(int slotNumber, long startTime, Date date)
	{
		this.slotNumber = slotNumber;
		this.startTime = startTime;
		this.date = date;
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public long getStartTime() {
		return startTime;
	}

	public Date getDate() {
		return date;
	}
}


