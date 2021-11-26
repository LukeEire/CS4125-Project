package ezparkproject;

import java.util.ArrayList;

public class ParkingLot 
{
	private static final int numberOfSlots = 100;
	
	private ArrayList<ParkingSpace> listOfSlots = null;
	
	public ParkingLot()
	{
		listOfSlots = new ArrayList<>();
	}

	public ArrayList<ParkingSpace> getParkingSlots()
	{
		for (int i = 1; i <= numberOfSlots; i++)
		{
			ParkingSpace slot = new ParkingSpace(i, true);
			listOfSlots.add(slot);
		}
		return listOfSlots;
	}
	
}
