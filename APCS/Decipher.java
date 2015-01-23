/**
 * @(#)Decipher.java
 *
 *
 * @author 
 * @version 1.00 2013/12/14
 */

import java.util.Scanner;
public class Decipher {

    public Decipher() {
    }
    
    public String decipherNote(String str){
    	String result = "";
    	for(int i = 0;  i < str.length(); i++){
    		if(i + 2 < str.length() && str.substring(i, i+3).equals("sup")){
    			result += (char)(32 + 65);
    			i += 2;
    		}
    		else if(i + 2 < str.length() && str.substring(i, i+3).equals("pie")){
    			result += (char)(36 + 65);
    			i += 2;
    		}
    		else if(i + 2 < str.length() && str.substring(i, i+3).equals("why")){
    			result += (char)(56 + 65);
    			i += 2;
    		}
    		
			else if(i + 3 < str.length() && str.substring(i, i+4).equals("dawg")){
    			result += (char)(12 + 65);
    			i += 3;
    		}
    		else if(i + 3 < str.length() && str.substring(i, i+4).equals("nope")){
    			result += (char)(51 + 65);
    			i += 3;
    		}
    		else if(i + 3 < str.length() && str.substring(i, i+4).equals("lolz")){
    			result += (char)(34 + 65);
    			i += 3;
    		}
    		else if(i + 3 < str.length() && str.substring(i, i+4).equals("cats")){
    			result += (char)(40 + 65);
    			i += 3;
    		}
		
			else if(i+5 < str.length() &&str.substring(i, i+6).equals("gotcha")){
    			result += (char)(25 + 65);
    			i += 5;
    		}
    		
			else
    			result += str.charAt(i);
    	}
    	
    	return result;
    }
    
    public void calculateTime(String str){
    	int ans = 0;
    	for(int i = 0; i < str.length(); i++){
    		if(Character.isLetter(str.charAt(i)))
    			ans += str.charAt(i);
    	}
    	ans %= 36;
    	System.out.println("Time is: " + ans + " o\'clock"); 
    }
    
}

class Driver{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the message ");
		String result = in.nextLine();
		Decipher d = new Decipher();
		String str = d.decipherNote(result);
		System.out.println(str);
		d.calculateTime(str);
	}
}