package Assignment2;

public abstract class HomestayRentalSystem {			//2.4 Abstraction
	
	private String companyName;							//2.3 Encapsulation - private variables
	private String companyContactNum;
	private String companyAddress;
	private String companyEmail;
	
	public HomestayRentalSystem(String compName) {
		setCompanyName(compName);
		setCompanyContact("05-847-0809 or 016-831-7755");
		setCompanyAddress("333, Raintree Street, 34000 Taiping, Perak");
		setCompanyEmail(compName.replaceAll("\\s","").toLowerCase() + "rentalsys@gmail.com");
	}
	
	public void printCompanyInfo() {
		System.out.println("\n-------------ABOUT US-------------");
		System.out.printf("%-20s: %s%n", "Company name", this.companyName);
		System.out.printf("%-20s: %s%n", "Contact number", this.companyContactNum);
		System.out.printf("%-20s: %s%n", "Office address", this.companyAddress);
		System.out.printf("%-20s: %s%n", "Email", this.companyEmail);
	}
	
	public String getCompanyName() {					//2.3 Encapsulation - getter & setter method
		return this.companyName;
	}
	
	public String getCompanyContactNum() {
		return this.companyContactNum;
	}
	
	public String getCompanyAddress() {
		return this.companyAddress;
	}
	
	public String getCompanyEmail() {
		return this.companyEmail;
	}
	
	public void setCompanyName(String n) {
		this.companyName = n;
	}
	
	public void setCompanyContact(String c) {
		this.companyContactNum = c;
	}
	
	public void setCompanyAddress(String a) {
		this.companyAddress = a;
	}
	
	public void setCompanyEmail(String e) {
		this.companyEmail = e;
	}
	
	
	abstract void printInfo();							//2.4 Abstraction
}