/* Ruijing Li
 * 9/27/13
 * Period 3
 * Time Spent: 40 minutes
 * I spent most of the time using sample outputs and doing the calculations by 
 * hand before starting to code. Because of this, I managed to get
 * the math coding done very fast. Also the code was easy to do
 * because of if-else statements and switch statements which made the
 * logic flow much easier. I did not experience any troubles with the code.
 */

import java.util.Scanner;

public class IRS {

    public static void main(String[] args) {
    	int status; //martial status, 1 for single, 2 for married
    	double income;
    	double tax = 0;
    	Scanner keyboard = new Scanner(System.in);
    	System.out.print("Enter marital status (1=single, 2=married): ");
    	status = keyboard.nextInt();
    	System.out.print("Enter taxable income: $ ");
    	income = keyboard.nextDouble();
    	
    	switch(status){
    		case 1:
    			if(income <= 27050)
    				tax = 0.15*income;
    			else if(income > 27050 && income <= 65550)
    				tax = 4057.5 + 0.275*(income-27050);
    			else if(income > 65550 && income <= 136750)
    				tax = 14645 + 0.305*(income-65550);
    			else if(income > 136750 && income <= 297350)
    				tax = 36361 + 0.355*(income-136750);
    			else
    				tax = 93374 + 0.391*(income-297350);
    			break;
    		
    		case 2:
    			if(income <= 45200)
    				tax = 0.15*income;
    			else if(income > 45200 && income <= 109250)
    				tax = 6780 + 0.275*(income-45200);
    			else if(income > 109250 && income <= 166500)
    				tax = 24393.75 + 0.305*(income-109250);
    			else if(income > 166500 && income <= 297350)
    				tax = 41855 + 0.355*(income-166500);
    			else
    				tax = 88306 + 0.391*(income-297350);
    			break;
    	}
    	
    	System.out.println("Your Federal tax = $ " + tax);
    }
    
    
}