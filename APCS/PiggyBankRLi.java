/* Ruijing Li
 * 9/11/13
 * Period 3
 * Time Spent: 30 minutes
 * This lab was simple. Not much to learn except making a new class
 * from scratch. It did take me a couple of minutes to plan out my 
 * addCoins and calculate methods, but nothing gave me trouble.
 */ 

public class PiggyBankRLi {
	//Attributes
	private int pennies;
	private int nickels;
	private int dimes;
	private int quarters;

	//Constructors
    public PiggyBankRLi() {
    	pennies = 0;
    	nickels = 0;
	    dimes = 0;
	    quarters = 0;
    }
    
    public PiggyBankRLi(int p, int n, int d, int q) {
    	pennies = p;
    	nickels = n;
    	dimes = d;
    	quarters = q;
    }
    
    //Methods
    public int getPennies() {
    	return pennies;
    }
    
    public int getNickels() {
    	return nickels;
    }
    
    public int getDimes() {
    	return dimes;
    }
    
    public int getQuarters() {
    	return quarters;
    }
    
    public void addCoins(int p, int n, int d, int q) {
    	//one method to add any type of coin in
    	pennies += p;
    	nickels += n;
    	dimes += d;
    	quarters += q;
    }
    
    public void calculate() {
    	//prints total amount of coins in dollars
    	double amount = 0;
    	amount = pennies*.01 + nickels*.05 + dimes*.1 + quarters*.25;
   		System.out.println("The total amount in dollars is " + amount);
    }
}