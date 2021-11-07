package ezparkproject;

import java.sql.Date;

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
	
	public Boolean blockForEvent(Date date, int numDays) {
		Boolean result = false;
		
		
		
		
		return result;
	}
	
}
