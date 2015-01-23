/* Ruijing Li
 * Period 3
 * 10/31/13
 * Time Spent: 45 minutes
 * Although writing the psuedocode in class made the lab 
 * much more easier, it still take a bit of a while to 
 * convert the English into code because there were bugs
 * and specific details I had to learn in order to 
 * correctly code this lab.
 */

import java.util.ArrayList;

public class PrimeFactorization {
	private int temp;
	private ArrayList<Integer> array;

    public PrimeFactorization(int n) {
    	temp = n;
    	array = new ArrayList<Integer>();
    }
    
    public void factor(){
    	for(int i = 2; i <= temp; i++){
    		if(temp % i == 0){
    			array.add(i);
    			temp = temp / i;
    			
    			for(int j = 2; j <= temp; j++){
    				if(temp % j == 0){
	    				array.add(j);
	    				temp = temp / j;
	    				j = 2;
    				}
    				
	    			if(temp == 1){
    					break;
    				}
    			}
    		if(temp == 1)
    			System.out.println(array);	
    		}
    	}
   }    
}

class Driver{
	public static void main(String[] args){
		PrimeFactorization p = new PrimeFactorization(30);
		PrimeFactorization p2 = new PrimeFactorization(180);
		PrimeFactorization p3 = new PrimeFactorization(490);
		PrimeFactorization p4 = new PrimeFactorization(22869);
		p.factor();
		p2.factor();
		p3.factor();
		p4.factor();
	}
}