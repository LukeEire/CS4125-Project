package ezparkproject;

import java.sql.Date;
import java.util.ArrayList;


public class Lot {
	
	private static final int numberOfSlots = 7; // Number of overall (pay as you go) parking spaces. 
	private ArrayList<ParkingSpace> listOfSlots = null;
	
	String lotName;
	int spaces;
	int disabilitySpaces;
	int chargingSpaces;
	
	public Lot() {
		
			listOfSlots = new ArrayList<>();
		}

		public ArrayList<ParkingSpace> getParkingSlots()	//incrementing car park spaces for every ticket created 
		{
			for (int i = 1; i <= numberOfSlots; i++)
			{
				ParkingSpace slot = new ParkingSpace(i, true);
				listOfSlots.add(slot);
			}
			return listOfSlots;
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
	
	public void setSpaces(int newCount) {
		this.spaces = newCount;
	}
		
	
	public Boolean blockForEvent(Date date, int numDays) {
		Boolean result = false;	
		return result;
	}

}
