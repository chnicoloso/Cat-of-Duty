/* Resubmit: Fixed vowel removal and some shorthand abbreviations
 * Ruijing Li
 * Period 3
 * 11/19/13
 * Time Spent: 30 minutes
 * Fixed shorthand vowel removal and abbreviation. Felt easier
 * to fix. 
 *
 *
 * Ruijing Li
 * Period 3
 * 10/24/13
 * Time Spent: 2 days
 * isPalindrome was a fairly okay lab problem but shorthand is 
 * very challenging. 
 *  No matter what I tried I could not get it to work.
 * If I had a whole day free
 * to just do comp sci, I believe I could solve this, 
 * but since I have a lot of
 * other workload, I found it too difficult. 
 * I tried pen and paper, debugging, and even some regex, 
 * but unfortunately none
 *  of them worked at all.
 * This shorthand really reflects the difficulty of strings 
 * and I feel it 
 * should have been a weekend 
 * lab.
 * Edit: Last minute I believed I found the solution 
 * and got it to mostly work!
 * Hooray!!!! Was missing a ans += str.charAt() before the else.
*/

public class StringMethods {
    
    public static boolean isPalindrome(String str){
    	String reverse = "";
    	
    	str = str.toLowerCase();
    	
    	for(int i = str.length()-1; i >= 0; i--){
    		if(isLetter(str.charAt(i)))
    			reverse += str.charAt(i);			
    	}
    	
    	str = "";
    	
    	for(int i = reverse.length()-1; i >= 0; i--){
    		str += reverse.charAt(i); 
    	}
    			
    	return reverse.equals(str);
    }
    
    public static String shorthand(String str){
    	//NEw strategy, check for punctation and white space, as soon as hit whitespace 
    	//immediately check the next few characters (check boundaries)
    	//after using substring  to see if it matches keyword, if true returns the replaced word 
    	//in a newly created  
    	//string, else it adds the char of original 
    	//string, however, before it does that it does one check to see if vowel in there, 
    	//if true, do nothing,
    	// else continue adding char of original
    	//string
    	String ans = "";
    	
    	for(int i = 0; i < str.length(); i++){
    		if((i == 0 || i == str.length()-2) && str.length() > 2 && 
	    	   (str.substring(i, i+2).equalsIgnoreCase("to") 
	    	   	|| str.substring(str.length()-2, str.length()).equalsIgnoreCase("to"))){
	    			ans += "" + '2';
	    			i += 2;
	    	}
    		
    		if(!isLetter(str.charAt(i))){
    			if(i + 5 < str.length() ){
    				if(str.substring(i+1, i+4).equalsIgnoreCase("and") && 
    					!isLetter(str.charAt(i+4))){
    						
    					ans +=  "" + str.charAt(i) + '&';
    					i+=3;
    				}
    					
    				else if(i != 0 && str.substring(i+1, i+3).equalsIgnoreCase("to") && 
    					!isLetter(str.charAt(i+3))) {
    						
    					ans += "" + str.charAt(i) + '2';
    					i+=2;
    				}
    				
    				else if(str.substring(i+1, i+4).equalsIgnoreCase("you") &&
    					 !isLetter(str.charAt(i+4))) {
    					 	
    					ans += "" + str.charAt(i) + 'u';
    					i+=3;
    				}
    				
    				else if(str.substring(i+1, i+4).equalsIgnoreCase("for") &&
    					 !isLetter(str.charAt(i+4))) {
    					 	
    					ans += "" + str.charAt(i) + '4';
    					i+=3;
    				}
    				else
    					ans += str.charAt(i);
    			}	
    		}
    		else	
    			if(i-1 >= 0 && i+1 < str.length() && (isLetter(str.charAt(i-1)) || 
    				isLetter(str.charAt(i+1)))){
    					    					
    				if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
    					 || str.charAt(i) == 'o' || str.charAt(i) == 'u' 
    					 || str.charAt(i) == 'A' || str.charAt(i) == 'E' 
    					 || str.charAt(i) == 'I' || str.charAt(i) == 'O' 
    					 || str.charAt(i) == 'U')
    					ans += "";
    				
    				else
    					ans += str.charAt(i);
    			}
    			else
    			    ans += str.charAt(i);
    				
    	}
    	return ans;
    }   
    
  private static boolean isLetter(char c){
  	if((c >= '0' &&  c <= '9') || (c >= 'a' &&  c <= 'z') || (c >= 'A' && c <= 'Z'))
  		return true;
    else
    	return false;
  }
  
  private static String removePunctuation(String str){
  	String help = "";
  	
  	for(int i = 0; i < str.length(); i++){
  		if(isLetter(str.charAt(i)))
  			help += str.charAt(i);
  	}
  	
  	return help;
  }
}