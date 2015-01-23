/* Ruijing Li
 * Period 3
 * 11/1/13
 * Time Spent: 50 minutes
 * This lab took a while to figure out, but once the strategy
 * worked for this lab, it was very easy to code it out. 
 * I used if statements to solve LCM and one while loop
 * with if statements to solve GCF. For both I used modulus.
 */
 
public class MathFun {

    public MathFun() {
    }

    public int LCM(int a, int b){
    	int result = a*b;
    	int divisor = 0;
    	
    	if(a > b)
    		divisor = a%b;
    	else
    		divisor = b%a;

    	if(divisor == 0){
    		if(a > b)
    			result /= b;
    		else
    			result /= a;
    	}
    	else
    		result /= divisor;

    	return result;
    }
    
    public int GCF(int a, int b){
    	int temp = 0;
    	if(a > b)
    		temp = a%b;
    	else
    		temp = b%a;
    	
    	if(a > b){
    		while(b % temp != 0){
    			temp = b % temp;
    		}	
    	}
    	else{
    		while(a % temp != 0){
    			temp = a% temp;
    		}
    	}
    	
    	return temp;
    }
}

class Driver{
	public static void main(String[] args)
	{
		 MathFun fun = new MathFun();
		 System.out.println("LCM (15,18) = " + fun.LCM (15,18));
		 System.out.println("LCM (40,12) = " + fun.LCM (40,12));
		 System.out.println("LCM (2,7)   = " + fun.LCM (2,7));
		 System.out.println("LCM (100,5) = " + fun.LCM (100,5));
		 System.out.println();
		 System.out.println("GCF (30,12) = " + fun.GCF (30,12));
		 System.out.println("GCF (40,12) = " + fun.GCF (40,12));
		 System.out.println("GCF (5,9)   = " + fun.GCF (5,9));
		 System.out.println("GCF (1024,46) = " + fun.GCF (1024,46));

	}
}