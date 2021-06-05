package Assignment2;

public class HomestayDescription extends InventoryManagement{		//2.1 - Inheritance

	 private String name;
	 private double pricePerNight;									//2.3 Encapsulation - private variables
	 private String facilities;
	 private int maxGuest;
	 private int numOfBed;

	public HomestayDescription(String compName, String n, double ppn, int maxG, int bed) {
		super(compName);
		this.name = n;
		this.pricePerNight = ppn;
		this.facilities = "TV, Wifi, stove and air-conditioner";
		this.maxGuest = maxG;
		this.numOfBed = bed;
	}
	
	public void printInfo() {										//2.2 Polymorphism
		System.out.println("\n\n--------HOMESTAY DESCRIPTION--------");
		System.out.printf("%-20s: %s%n", "Homestay name", this.name);
		System.out.printf("%-20s: RM%.2f%n", "Price per Night", this.pricePerNight);
		System.out.printf("%-20s: %s%n", "Facilities", this.facilities);
		System.out.printf("%-20s: %d%n", "Max number of guest", this.maxGuest);
		System.out.printf("%-20s: %d%n%n", "Number of beds", this.numOfBed);
	}

}