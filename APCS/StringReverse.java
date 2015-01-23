/* Ruijing Li
 * 10/17/13
 * Period 3
 * Time Spent: 25 minutes
 * This lab was fairly easy to complete. The iteration was very easy
 * with a for loop. The recursion took a bit of time and thinking, 
 * but it also was straightforward after I used an example and did
 * the logic on paper 
 */ 

public class StringReverse {
	
    public StringReverse() {
    }
    
    public static String reverseStrIter(String str){
    	String ans = "";
    	
    	for(int i = str.length()-1; i >= 0; i--)
    		ans += str.charAt(i);
    		
        return ans;	
    }
    
    public static String reverseStrRecursion(String str, int index){
    	if(index == str.length()-1)
    		return str.charAt(index) + "";
    	else
    		return reverseStrRecursion(str, index+1) + str.charAt(index);
    }
}