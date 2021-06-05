package Assignment2;

import java.util.Scanner;									

public class AdvertisementAndMarketing extends HomestayRentalSystem{					//2.1 - Inheritance
	Scanner input = new Scanner(System.in);
	private String[] homestay = new String[15];
	private double[] profit = new double[15];											//2.3 Encapsulation - private variables
	private String highestProfitHomestay;
	private String lowestProfitHomestay;
	private int numOfHomestay;
	
	public AdvertisementAndMarketing(String compName) {					//1.4 - 0 argument constructor
		super(compName);
		this.numOfHomestay = 0;
		homestay[numOfHomestay] = "Orchid Suite, Langkawi";
		profit[numOfHomestay++] = 4100;
		
		homestay[numOfHomestay] = "Magic Studio, Georgetown";
		profit[numOfHomestay++] = 3530;
		
		homestay[numOfHomestay] = "Diamond House, Ipoh";
		profit[numOfHomestay++] = 5200;	
	}

	public String findMostProfitted() {
		double mostProfitted = 0;

		for(int i = 0; i <= numOfHomestay; i++) {
			if(profit[i] >= mostProfitted) {
				mostProfitted = profit[i] ;
				highestProfitHomestay = homestay[i];
			}
		}
		return highestProfitHomestay ;
	}
	
	public String findLeastProfitted() {
		double leastProfitted = profit[0];

		for(int i = 0; i <= numOfHomestay; i++) {
			if((leastProfitted >= profit[i])&&(profit[i]!=0)) {
				leastProfitted = profit[i];
				lowestProfitHomestay = homestay[i];
			}
		}
		return lowestProfitHomestay ;
	}
	
	public void printInfo() {								//2.2 Polymorphism
		System.out.println("---------"+ super.getCompanyName().toUpperCase() + "MARKETING REPORT----------");
		for (int i = 0; i < numOfHomestay; i++) {
			System.out.printf("%-20s: %s%n", "Homestay name", homestay[i]);
			System.out.printf("%-20s: RM%.2f%n%n", "Last month profit", profit[i]);
		}
		
		System.out.println(">>>The most profitted homestay\t: " + findMostProfitted());
		System.out.println(">>>The least profitted homestay\t: " + findLeastProfitted());
		System.out.println();
		
	}
	
	public void advertisementOption() {
		boolean repeat = true;
		while (repeat) {
			System.out.println("---------ADVERTISEMENT OPTION---------");
			System.out.println("Please select one of the following advertising option to boost business in "
					+ findLeastProfitted()
					+ ":\nA. Free gift for three or more night.\nB. RM5 KFC voucher for four or more night.\nC. Free breakfast for any booking.");
			System.out.print(">>>Option: ");
			String option = input.next().toUpperCase();

			switch (option) {
			case "A":
				System.out.println("Free gift will be prepared for the guest(s) who book for more than 3 nights.");
				repeat = false;
				break;
			case "B":
				System.out.println("KFC voucher will be given to guest(s) who stay for four or more nights");
				repeat = false;
				break;
			case "C":
				System.out.println("The staff will prepare the breakfast for the guest(s).");
				repeat = false;
				break;
			default:
				System.out.println("Invalid option. Try again\n");
			}
		}
		System.out.print("Input any key to return to admin menu\n>>>");
		input.next();
		System.out.println("\n\n");
		
	}
}
