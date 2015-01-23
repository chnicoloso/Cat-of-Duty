/* Ruijing Li
 * Period 3
 * 10/27/13
 * Time Spent: 2 1/2 hours
 * This lab was easier than the shorthand, but overall was still
 * challenging. Punctuation took a while as well, but it was not
 * as bad as I thought. Only thought is that strings are incredibly hard,
 * shorthand was insane, and this pigLatin is challenging but doable.
 */
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class PigLatinator {

    public PigLatinator() {
    }
    
    public static String pigLatinator(String str){
    	String result = "";
    	StringTokenizer st = new StringTokenizer(str);
    	String englishWord = "";
    	String temp = "";
    	   	
    	while(st.hasMoreTokens()){
    		englishWord = st.nextToken();
    		
    		if(!isLetter(englishWord.charAt(englishWord.length()-1))){
    			temp += englishWord.charAt(englishWord.length()-1);
    			englishWord = englishWord.substring(0, englishWord.length()-1);		
    		}
    		
    		if((str.contains("a") || str.contains("e") 
    			|| str.contains("i") || str.contains("o")
    			|| str.contains("u") || str.contains("A")
    			|| str.contains("E") || str.contains("I") 
    			|| str.contains("O") || str.contains("U"))){
    				
    			result += checkLatin(englishWord) + temp + " ";
    			
			}
    		else{
    			result += englishWord + "ay" + temp + " ";    			
    		}
    		
    		temp = "";
    	}
    	
    	return result;
    }
    
    private static String checkLatin(String str){
    	String start = "";
    	String end = "";
    	String help = "";
    	
    	for(int i = 0; i < str.length(); i++){
    		
    		if(str.charAt(i) == 'A' || str.charAt(i) == 'E' 
    			|| str.charAt(i) == 'I' || str.charAt(i) == 'O' 
    			|| str.charAt(i) == 'U' || str.charAt(i) == 'a' 
    			|| str.charAt(i) == 'e' || str.charAt(i) == 'i'
    			|| str.charAt(i) == 'o' || str.charAt(i) == 'u'){
    		   		
    		   		if(i == 0){
    		   			help = str + "yay";
    		   			break;
    		   		}
    		   		else{
    		   			start = str.substring(0,i);
    		   			end = str.substring(i);
    		   				
    		   			if(Character.isUpperCase(str.charAt(0))){
    		   				end = Character.toUpperCase(str.charAt(i)) + str.substring(i+1);
    		   				start = start.toLowerCase();
    		   			}
    		   			
    		   			help = end + start + "ay";
    		   			break;		
    		   		}
    		}
    		
    	}
    	return help;	
    }
    
    private static boolean isLetter(char c){
  	if((c >= '0' &&  c <= '9') || (c >= 'a' &&  c <= 'z') || (c >= 'A' && c <= 'Z'))
  		return true;
    else
    	return false;
  }
  
}