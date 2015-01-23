/* Ruijing Li
 * 10/5/13
 * Period 3
 * Time Spent: 50 minutes
 * This lab started out easy then turn confusing because I didn't 
 * understand the second and third part. After figuring out the 
 * directions, I struggled with the third multiply as the negative 
 * signs produced errors in my code. Luckily by testing the code and
 * thinking of a strategy by hand, I was able to solve the second 
 * multiply easily. I then attempted the bonus, but I could not get 
 * the largest number because I either got an error that said unreachable 
 * statement or got stack overflow. My attempt was to make a do-while loop 
 * and count the largest fibonacci num until it crashes, but the overflow 
 * error would fill the entire console, and I had no idea how to make it
 * stop at the largest value before it crashes. 
 */

public class Fibonacci {
    
    public static int fib(int n){
    	if(n <= 1)
    		return n;
    	else
    		return fib(n-1) + fib(n-2);	
    }
    
    public static int multiply(int one, int two){
    	if(two == 0)
    		return 0;
    	else
    		return one + multiply(one, two-1);
    }
    
    public static int multiply2(int one, int two){
    	if(two == 0)
    		return 0;
    	else if(one > 0 && two < 0)
    		return -1*one + multiply2(one, two+1);
    	else if(one < 0 && two < 0)
    		return -1*one + multiply2(one, two+1);
    	else
    		return one + multiply2(one, two-1); 		
    }
}