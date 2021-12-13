package ParkingPackage;

public class ParkingSpace 
{
	private int spaceNum;
	private boolean availability;
	
	public ParkingSpace(int slotNumber, boolean availability)
	{
		this.spaceNum = slotNumber;
		this.availability = availability;
	}

	public int getSlotNumber() {
		return spaceNum;
	}

	public void setSlotNumber(int slotNumber) {
		this.spaceNum = slotNumber;
	}

	public boolean getAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	
	
}
