/* Ruijing Li
 * 9/23/13
 * Period 3
 * Time Spent: 20 mintues
 * Initially I had trouble with scanner and printf, however after
 * today's lecture I was able to understand printf and scanner more
 * easily. Therefore this lab was simple to complete. The thing that 
 * gave me the most trouble in this lab was where to put the scanner 
 * methods and not importing the scanner class because I thought 
 * it was already part of Java. This lab was good practice for 
 * understanding Scanner and printf.
 */

import java.util.Scanner;

public class GroceryList{
	public static void main(String[] args){
		double item1, item2, item3, item4, item5;
		double total = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter item #1: ");
		item1 = in.nextDouble();
		System.out.print("Enter item #2: " );
		item2 = in.nextDouble();
		System.out.print("Enter item #3: " );
		item3 = in.nextDouble();
		System.out.print("Enter item #4: " );
		item4 = in.nextDouble();
		System.out.print("Enter item #5: " );
		item5 = in.nextDouble();
		System.out.printf("\n%s %10s %10s" , "Item:", "Cost:", 
			              "Total:");
		System.out.println();
		total += item1;
		System.out.printf("%5s %10.2f %10.2f", "#1", item1, total);
		System.out.println();
		total += item2;
		System.out.printf("%5s %10.2f %10.2f", "#2", item2, total);
		System.out.println();
		total += item3;
		System.out.printf("%5s %10.2f %10.2f", "#3", item3, total);
		System.out.println();
		total += item4;
		System.out.printf("%5s %10.2f %10.2f", "#4", item4, total);
		System.out.println();
		total += item5;
		System.out.printf("%5s %10.2f %10.2f", "#5", item5, total);
		System.out.println();
	}
}