package Assignment2;

import java.util.Scanner;								

public class InventoryManagement extends HomestayRentalSystem {				//2.1 - Inheritance		
	Scanner input = new Scanner(System.in);
	private boolean repeat = true;											//2.3 Encapsulation - private variables
	private String[] homestay = new String[10];
	private double[] price = new double[10];
	private int[] numOfBed = new int[10];
	private int[] maxGuest = new int[10];
	private int numOfHomestay;

	public InventoryManagement(String compName) {
		super(compName);
		this.numOfHomestay = 0;
		homestay[numOfHomestay] = "Orchid Suite, Langkawi";
		price[numOfHomestay] = 68.0;
		numOfBed[numOfHomestay] = 4;
		maxGuest[numOfHomestay++] = 5;
		
		homestay[numOfHomestay] = "Magic Studio, Georgetown";
		price[numOfHomestay] = 98.0;
		numOfBed[numOfHomestay] = 3;
		maxGuest[numOfHomestay++] = 4;
		
		homestay[numOfHomestay] = "Diamond House, Ipoh";
		price[numOfHomestay] = 112.5;	
		numOfBed[numOfHomestay] = 3;
		maxGuest[numOfHomestay++] = 5;
	}

	public void printInfo() {							//2.2 Polymorphism
		System.out.printf("|%-3s|%25s|%10s|%15s|%20s|%n", "No.", "Hostel name", "Price(RM)", "Number of beds", "Max number of guest");

		for (int i = 0; i < 10; i++) {
			if (homestay[i] != null)
				System.out.printf("|%-3d|%25s|%10.2f|%15d|%20d|%n", (i + 1), homestay[i], price[i], numOfBed[i], maxGuest[i]);
		}
	}
	
	public void inventoryManagementSystem() {
		while (repeat) {
			System.out.println("-----"+ super.getCompanyName().toUpperCase() + " INVENTORY MANAGEMENT SYSTEM-----");
			printInfo();
			System.out.print("\nPlease select operation:\n1. Add data\n2. Delete data\n3. Edit data.\n4. Exit\n>>>");
			String option = input.next();
			switch (option) {
			case "1":
				addData();
				break;
			case "2":
				deleteData();
				break;
			case "3":
				editData();
				break;
			case "4":
				repeat = false;
				break;
			default:
				System.out.println("Invalid option. Try again.");
			}
		}
	}

	public void addData() {
		if (numOfHomestay < homestay.length) {
			System.out.print("Enter new data.\nName\t\t\t: ");
			input.nextLine();
			String newName = input.nextLine();
			homestay[numOfHomestay] = newName;

			System.out.print("Price\t\t\t: ");
			double newPrice = input.nextDouble();
			price[numOfHomestay] = newPrice;
			
			System.out.print("Number of beds\t\t: ");
			int newNum = input.nextInt();
			numOfBed[numOfHomestay] = newNum;

			System.out.print("Max number of guests\t: ");
			int newMax = input.nextInt();
			maxGuest[numOfHomestay++] = newMax;
			
		} else
			System.out.println("The list is full.");

	}
	
	public void deleteData() {
		if (numOfHomestay == 0)
			System.out.println("The list is empty");
		else {
			System.out.print("Enter number of row to delete that data: ");
			int numOfRow = input.nextInt();
			for (int i = numOfRow; i < homestay.length; i++) {
				homestay[i - 1] = homestay[i];
				price[i - 1] = price[i];
				numOfBed[i - 1] = numOfBed[i];
				maxGuest[i - 1] = maxGuest[i];
			}
			numOfHomestay--;
		}
	}

	public void editData() {
		if (numOfHomestay == 0)
			System.out.println("The list is empty");
		else {
			System.out.print("Enter number of row to edit data: ");
			int numOfRow = input.nextInt();
			System.out.print("New name\t\t:");
			input.nextLine();
			String newName = input.nextLine();

			System.out.print("New price\t\t:");
			double newPrice = input.nextDouble();
			
			System.out.print("New num of beds\t\t: ");
			int newNum = input.nextInt();

			System.out.print("New max of guests\t: ");
			int newMax = input.nextInt();

			homestay[numOfRow - 1] = newName;
			price[numOfRow - 1] = newPrice;
			numOfBed[numOfRow - 1] = newNum;
			maxGuest[numOfRow - 1] = newMax;

		}
	}
	
	public String getHomestayName(int i) {						//2.3 Encapsulation
		return homestay[i];
	}
	
	public double getHomestayPricePerNight(int i) {
		return price[i];
	}
	
	public int getNumOfBed(int i) {
		return numOfBed[i];
	}
	
	public int getMaxGuest(int i) {
		return maxGuest[i];
	}
}