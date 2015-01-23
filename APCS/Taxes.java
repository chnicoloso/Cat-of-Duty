/* Ruijing Li
 * 9/13/13
 * Period 3
 * Time Spent: 20 minutes
 * The program was easy to complete. With a calculator in hand, it
 * was easy to figure out what I needed to code to recreate the 
 * sample output. This lab was much easier than the previous lab.
 * Nothing gave me trouble after I figured out what to do.
 */

public class Taxes {
	private double hours;
	private double hourRate;
	private final double FEDERAL_TAX = 0.154;
	private final double FICA_TAX = 0.0775;
    private final double STATE_TAX = 0.04;
	private double grossPay;
	private double netPay;
	
    public Taxes(double hr, double rate) {
    	hours = hr;
    	hourRate = rate;
    	grossPay = hours * hourRate;
    }
    
    public double getHours(){
    	return hours;
    }
    
    public double getHourRate(){
    	return hourRate;
    }
    
    public void printGrossPay(){
    	System.out.println("\nGross Pay: " + grossPay);
    }
    
    public void printTaxes(){
    	System.out.println("\nFederal Tax (15.4%): " + (grossPay * FEDERAL_TAX));
    	System.out.println("FICA Tax (7.75%): " + (grossPay * FICA_TAX));
    	System.out.println("State Tax (4.0%): " + (grossPay * STATE_TAX));
    }
    
    public void calcNetPay(){
    	netPay = grossPay - (grossPay * FEDERAL_TAX) - (grossPay * FICA_TAX) - (grossPay * STATE_TAX); 
    	System.out.println("\nNet Pay: " + netPay);
    }
       
}