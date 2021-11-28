package ezparkproject;

import java.sql.Date;
import java.util.ArrayList;

public class Lot {
	
	String lotName;
	int spaces;
	int disabilitySpaces;
	int chargingSpaces;
	
	public Lot() {
	}
	
	public Lot(String name, int spaces, int disabilitySpaces, int chargingSpaces) {
		this.lotName = name;
		this.spaces = spaces;
		this.disabilitySpaces = disabilitySpaces;
		this.chargingSpaces = chargingSpaces;
	}
	
	public int countSpaces() {
		
		return this.spaces;
		
	}
	
	public int countDisSpaces() {
		
		return this.disabilitySpaces;
		
	}
	
	public int countChargeSpaces() {
		
		return this.chargingSpaces;
		
	}
	


	public class ParkingLot 
	{
		private static final int numberOfSlots = 5; // Number of overall (pay as you go) parking spaces. 
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

	
	public Boolean blockForEvent(Date date, int numDays) {
		Boolean result = false;	
		return result;
	}
	
}
