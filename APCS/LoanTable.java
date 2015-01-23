/* Ruijing Li
 * Period 3
 * 10/30/13 (Absent from Challenge Day)
 * Time Spent: 40 minutes
 * The conecept in this lab was simple to comprehend and execute, use math and
 * for loops to calculate monthly payment. The tedious part was formatting the
 * output using printf which took a long time to get it exactly like the run
 * output.
 */

import java.util.Scanner;

public class LoanTable {
	double principal, interest1, interest2;
	int time;

    public LoanTable(double p, int t, double i1, double i2) {
    	principal = p;
    	time = t;
    	interest1 = i1;
    	interest2 = i2;
    }
    
    public void printTable(){
    	System.out.println("Mortgage problem\n");
    	System.out.printf("Principal = $%.2f", principal);
    	System.out.println("\nTime = " + time + " years");
    	System.out.printf("Low Rate = %.0f%s", interest1, "%");
    	System.out.printf("\nHigh Rate = %.0f%s", interest2, "%");
    	System.out.println("\n");
    	System.out.printf("%3s", "Annual Interest Rate");
    	System.out.printf("%20s", "Monthly Payment");
    	
    	for(double i = interest1; i <= interest2; i+= 0.25){
    		System.out.printf("\n%10.2f", i);
    		System.out.printf("%23.2f", principal * i/100 /12.0 
    			              * Math.pow(1+i/100 /12.0, time*12.0) / 
    			              (Math.pow(1+i/100 /12.0, time*12.0)-1));
    	} 	
    }
}

class Driver{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);

		System.out.print("Please enter the amount you want to loan in dollars ");
		double principal = keyboard.nextDouble();
		System.out.print("Please enter the time of the loan in years ");
		int time = keyboard.nextInt();
		System.out.print("Please enter the low interest rate in % ");
		double interest1 = keyboard.nextDouble();
		System.out.print("Please enter the high interest rate in % ");
		double interest2 = keyboard.nextDouble();
		
		LoanTable lt = new LoanTable(principal, time, interest1, interest2);
		lt.printTable();
		System.out.println();
	}
}
