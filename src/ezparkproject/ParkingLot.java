package ezparkproject;

import java.util.ArrayList;

/* @author Conall McAteer
 * Update of Lot Class
 */

public class ParkingLot 
{
	private static final int numberOfSlots = 10;
	
	private ArrayList<ParkingSlot> listOfSlots = null;
	
	public ParkingLot()
	{
		listOfSlots = new ArrayList<>();
	}
	
	/**
	 * This method returns list of all the parking slots 
	 * 
	 */
	public ArrayList<ParkingSlot> getParkingSlots()
	{
		for (int i = 1; i <= numberOfSlots; i++)
		{
			ParkingSlot slot = new ParkingSlot(i, true);
			listOfSlots.add(slot);
		}
		return listOfSlots;
	}
	
}
