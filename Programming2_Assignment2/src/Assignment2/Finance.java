package Assignment2;

import java.util.Scanner;							

public class Finance extends EmployeeManagement implements Payment{				//2.1 - Inheritance, 2.5 Interface
	Scanner input = new Scanner(System.in);
	private double totalRevenue;												//2.3 Encapsulation - private variables
	private double totalExpense;
	private double totalSponsorship;
	private boolean repeat;
	
	public Finance(String compName, double a, double b) {
		super(compName);
		setTotalRevenue(a);
		setTotalExpense(b);
		setTotalSponsorship(5000);
		this.repeat = true;
	}
	
	public double calculateNetProfit() {
		return this.totalRevenue - this.totalExpense - super.getTotalSalary() + this.totalSponsorship;
	}
	
	public void printInfo() {													//2.2 Polymorphism
		while(repeat) {
			System.out.println("\n---------"+ super.getCompanyName().toUpperCase() +"FINANCIAL STATEMENT----------");
			System.out.printf("%-25s: RM%.2f%n", "Total Revenue", this.totalRevenue);
			System.out.printf("%-25s: RM%.2f%n", "Total Employees Salary", super.getTotalSalary());
			System.out.printf("%-25s: RM%.2f%n", "Total Expense", this.totalExpense);
			System.out.printf("%-25s: RM%.2f%n", "Total Sponsorship", this.totalSponsorship);
			System.out.printf("%-25s: RM%.2f%n%n", "Total Net Profit", calculateNetProfit());
			System.out.printf("%-25s: RM%.2f%n%n", "Total Pay Amount", getPayment());
			
			System.out.print("E. Edit\nX. Back\n>>>");
			String option = input.next().toUpperCase();
			
			switch(option) {
			case"E":
				edit();
				break;
			case"X":
				System.out.println("Back to admin menu.\n");
				repeat = false;
				break;
			default:
				System.out.println("Invalid input. Try again.");
			}
		}
	}
	
	public double getPayment() {												// 2.5 Interface
		return this.totalExpense + super.getTotalSalary();
	}
	
	public void edit() {
		System.out.printf("%-20s: RM", "Total Revenue");
		this.totalRevenue = input.nextDouble();
		System.out.printf("%-20s: RM", "Total Expense");
		this.totalExpense = input.nextDouble();
		System.out.printf("%-20s: RM", "Total Sponsorship");
		this.totalSponsorship = input.nextDouble();
	}
	
	
	public void setTotalRevenue(double r) {
		this.totalRevenue = r;
	}
	public void setTotalExpense(double e) {
		this.totalExpense = e;
	}
	public void setTotalSponsorship(double s) {
		this.totalSponsorship = s;
	}

	
}
