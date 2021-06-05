package Assignment2;

import java.util.Scanner;					

public class HomestayMain {						//Main class
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		boolean repeatMenu = true;
		
		HomestayRentalSystem rentalSystem = new InventoryManagement("Bona Fide");

		while(repeatMenu) {
			boolean client = true;
			boolean admin = true;
			System.out.println("++++++WELCOME TO "+ rentalSystem.getCompanyName().toUpperCase() +" HOMESTAY RENTAL SYSTEM++++++");

			rentalSystem.printCompanyInfo();

			System.out.print("\nLogin with your role\n1. Client.\n2. Admin\nX. Quit\n>>>");
			String menuOption = input.next().toUpperCase();
			
			switch(menuOption) {
			case "1":
				while(client) {
					InventoryManagement invt = new InventoryManagement(rentalSystem.getCompanyName());
					System.out.println("\nHi our beloved client.\nPlease select one homestay to continue.");
					for(int i = 0; i < 3; i++) {
						if (invt.getHomestayName(i) != null)
						System.out.printf("%2d. %-30sRM%.2f%n", (i+1), invt.getHomestayName(i), invt.getHomestayPricePerNight(i));
					}
					System.out.print(" X. Back to Main Menu\n>>>"); 
					String homestayChoice = input.next().toUpperCase();
					int num = 0;
					switch(homestayChoice) {

						case"1":
							num = 0;
							break;
						case"2":
							num = 1;
							break;
						case"3":
							num = 2 ;
							break;
						case"X":
							client = false;
							System.out.println();
							break;
						default:
							System.out.println("Invalid choice. Try again.");
					}
					
					if (client) {
						HomestayDescription a = new HomestayDescription(rentalSystem.getCompanyName(), invt.getHomestayName(num), invt.getHomestayPricePerNight(num), invt.getMaxGuest(num), invt.getNumOfBed(num));
						a.printInfo();
						
						SalesSystem pos = new SalesSystem(invt.getHomestayName(num), invt.getHomestayPricePerNight(num));
						pos.getPayment();
						
						System.out.println("\n***Any enquiries:\nCall\t: " + rentalSystem.getCompanyContactNum() + "\nEmail\t: " + rentalSystem.getCompanyEmail());
						System.out.print("\nRedirect back to homestay page.\nInput any key to continue\n>>>");
						input.next();
					}
				}
				break;
				
			case "2":
				System.out.println("\nHi admin!\nPlease log in into the system.");
				
				System.out.printf("%-20s: ", "User Name");
				String username = input.next();
				System.out.printf("%-20s: ", "Password");
				String password = input.next();

				if ((username.equals("spongebob") && (password.equals("277275")))) {
					System.out.println("\nADMIN \"" + username + "\" LOG IN SUCCESSFULLY!");

					while (admin) {
						System.out.print(
								"Choose one option to continue\n1. Employee Management\n2. Inventory Management\n3. Finance\n4. Advertisement and Marketing\nX. Back to Main Menu\n>>>");
						String adminChoice = input.next().toUpperCase();

						switch (adminChoice) {
						case "1":
							EmployeeManagement empMngmt = new EmployeeManagement(rentalSystem.getCompanyName());
							empMngmt.employeeManagementSystem();
							break;
						case "2":
							InventoryManagement invt = new InventoryManagement(rentalSystem.getCompanyName());
							invt.inventoryManagementSystem();
							break;
						case "3":
							Finance fin = new Finance(rentalSystem.getCompanyName(), 12830, 1000);
							fin.printInfo();
							break;
						case "4":
							AdvertisementAndMarketing ads = new AdvertisementAndMarketing(rentalSystem.getCompanyName());
							ads.printInfo();
							ads.advertisementOption();
							break;
						case "X":
							admin = false;
							System.out.println();
							break;
						default:
							System.out.println("Invalid choice. Try again.\n");
						}
					}
				}else {
					System.out.println("Incorrect user name and password. Try again.\n\n");
				}

				break;
			case "X":
				System.out.println("THANK YOU FOR USING "+ rentalSystem.getCompanyName().toUpperCase() + " HOMESTAY RENTAL SYSTEM");
				repeatMenu = false;
				break;
			default:
				System.out.println("Invalid input. Please try again.");

			}
		}
	}
}
