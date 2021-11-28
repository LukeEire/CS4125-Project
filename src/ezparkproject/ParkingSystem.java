package ezparkproject;

import java.sql.Date;
import java.util.ArrayList;

public class ParkingSystem {

	static ParkingFrame mainFrame;
	
	private ArrayList<ParkingSpace> slots = null;
	ArrayList<TicketSystem> ticketList = null;
	ParkingSpace slot = null;
	
	private long startTimeMilliseconds;
	private long startTime = 0;
	private long endTimeMilliseconds;
	private String durationParked;
	private Date date;
	
	private static final double fee = 2; // Parking fee 2 euro for every 60 minutes parked 
	private static final int minimumTime = 60;
	int timeInMinutes = 0;
	private double totalFee = 2;
	PaymentInfo payInfo = null;
	
	public ParkingSystem() 
	{
		Lot lot = new Lot();
		slots = lot.getParkingSlots();
		
		ticketList = new ArrayList<>(); // save tickets already made
	}
	
	public TicketSystem park()
	{
		ParkingSpace slot = checkAvailability(); // check for available slots
		
		if (slot != null)
		{
			startTimeMilliseconds = System.currentTimeMillis();
						
			TicketSystem ticketSystem = new TicketSystem(slot.getSlotNumber(), startTimeMilliseconds, date);
			ticketList.add(ticketSystem); // save the ticket in ticketList
			
			slot.setAvailability(false); // this slot is no more available
			return ticketSystem;
		}
		return null;		
	}
	
	
	public ParkingSpace checkAvailability()
	{
		for(int i = 0; i < slots.size(); i++)
		{
			slot = slots.get(i);
			
			// check availability
			if(slot.getAvailability() == true)
			{
				return slot;
			}
		}
		return null;
	}
	
	public void captureEndTime()
	{
		// capture end time
		endTimeMilliseconds = System.currentTimeMillis();
	}
	
	
	public boolean validateTicketNumber(int ticketNumEntered)
	{
		boolean isValid = false;
		
		for (int i = 0; i < ticketList.size(); i++)
		{
			int slotNumber = ticketList.get(i).getSlotNumber();
			
			if (ticketNumEntered == slotNumber)
			{
				isValid = true;
				startTime = ticketList.get(i).getStartTime();
				break;
			}
		}
		return isValid;
	}

	public void timeParked()
	{
		long durationMilliSeconds = endTimeMilliseconds - startTime; // total time the card was parked in the space
		durationParked = convertTimeFormat(durationMilliSeconds);
		String [] time = durationParked.split(":");
		int hours = Integer.parseInt(time[0]);
		int minutes = Integer.parseInt(time[1]);
		int seconds = Integer.parseInt(time[2]);
		timeInMinutes = (hours * 60) + minutes + (seconds / 60);
	}
	
	public double getTotalFee()
	{
		if(totalFee == 2)
		{
			if (timeInMinutes < 60)
				totalFee = 2;
			else
				totalFee = (timeInMinutes / minimumTime) * fee;
		}
		
		return totalFee;
	}
		
	
	public void spaceAvailable(int ticketNumber)
	{
		for (int i = 0; i < slots.size(); i++)
		{
			int slotNumber = slots.get(i).getSlotNumber();
			
			if (ticketNumber == slotNumber)
			{
				slot = slots.get(i);
				slot.setAvailability(true);
			}
		}
	}
	
	
	public void setPaymentInformation(String ccNumber, String cvvNumber, String expiry)
	{
		payInfo = new PaymentInfo(ccNumber, cvvNumber, expiry);
	}
	
	
	public boolean validateCreditCard()
	{
		PaymentCheck paymentCheck = new PaymentCheck(payInfo);
		return paymentCheck.validateCreditCard();
	}
	
	public String convertTimeFormat(long milliSeconds)
	{
	    long totalSeconds = milliSeconds / 1000;
	    long currentSecond = totalSeconds % 60;
	    long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;
	    long totalHours = totalMinutes / 60;
	    long currentHour = totalHours % 24;
		
	    return currentHour + ":" + currentMinute + ":" + currentSecond;
	
	}
	
	

}
