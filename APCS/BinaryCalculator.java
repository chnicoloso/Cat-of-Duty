/* RESUBMIT
 * Ruijing Li
 * Period 3
 * 2/8/14
 * Time Spent: 2 hours
 * The first time on this lab, I was careless and did not 
 * see that we could not use java's in built methods.
 * Therefore, I redid this lab using my own String logic.
 * The output works, but it does not remove excess zeros.
 * The hardest part of this lab was the complement.
 */

import java.util.*;

public class BinaryCalculator {
	private String num;
	private String num2;
	private int count;
	private int count2;
	private int answer;
	private String result;
	private boolean negative;
	private String temp;

    public BinaryCalculator() {
    	negative = false;
    }

    public void calc(){
    	Scanner in = new Scanner(System.in);
    	System.out.println("-=:| Binary Calculator v0.a by Ruijing Li |:=-");
    	System.out.println("    ---------------------------------------\n");
   		System.out.println("Menu");
   		System.out.println(" (1) op1 AND op2");
   		System.out.println(" (2) op1 OR op2");
   		System.out.println(" (3) op1 XOR op2");
   		System.out.println(" (4) COMPLEMENT op1\n");
   		System.out.printf("Choose an option> ");
   		int option = in.nextInt();
   		System.out.println();
   		switch(option){
   			case 1:
   				System.out.print("Enter op1> ");
   				num = in.next();
   				System.out.print("Enter op2> ");
   				num2 = in.next();
   				andOp(num, num2);
   				break;
   			case 2:
   				System.out.print("Enter op1> ");
   				num = in.next();
   				System.out.print("Enter op2> ");
   				num2 = in.next();
   				orOp(num, num2);
   				break;
   			case 3:
   				System.out.print("Enter op1> ");
   				num = in.next();
   				System.out.print("Enter op2> ");
   				num2 = in.next();
   				xorOp(num, num2);
   				break;
   			case 4:
   				System.out.print("Enter op1> ");
   				num = in.next();
   				complement(num);
   				break;
   			default: 
   				System.out.println("Not a valid option. Try again next time"); 
   				break;
   		}
    }

    public void andOp(String byte1, String byte2){
    	result = "";
    	temp = "";
    	System.out.println();
    	count = binaryToInt(byte1);
    	count2 = binaryToInt(byte2);
    		
    	for(int i = 0; i < byte1.length(); i++){
    		if(byte1.charAt(i) == byte2.charAt(i)){
    			result += byte1.charAt(i);
    		}
    		else{
    			result += 0;
    		}
    	}
    	answer = binaryToInt(result);
    	System.out.println("Binary Result:\n    " + byte1 
    		               + " AND " + byte2 + " = " 
    		               + result);
    	System.out.println("\nBase-10 Result:\n    " + count + " AND " 
    		               + count2 + " = " + answer);
    }

    public void orOp(String byte1, String byte2){
    	result = "";
    	temp = "";
    	System.out.println();
    	count = binaryToInt(byte1);
    	count2 = binaryToInt(byte2);
    	
    	for(int i = 0; i < byte1.length(); i++){
    		if(byte1.charAt(i) != byte2.charAt(i))
    			result += 1;
    		else
    			result += byte1.charAt(i);
    	}
    	answer = binaryToInt(result);
    	System.out.println("Binary Result:\n    " + byte1 
    		               + " OR " + byte2 + " = " 
    		               + result);
    	System.out.println("\nBase-10 Result:\n    " + count + " OR " 
    		               + count2 + " = " + answer);
    }

    public void xorOp(String byte1, String byte2){
    	result = "";
    	temp = "";
    	System.out.println();
    	count = binaryToInt(byte1);
    	count2 = binaryToInt(byte2);
    	
    	for(int i = 0; i < byte1.length(); i++){
    		if(byte1.charAt(i) == byte2.charAt(i))
    			result += 0;
    		else
    			result += 1;
    	}	
    	answer = binaryToInt(result);
    	System.out.println("Binary Result:\n    " + byte1 
    		               + " XOR " + byte2 + " = " 
    		               + result);
    	System.out.println("\nBase-10 Result:\n    " + count + " XOR " 
    		               + count2 + " = " + answer);
    }

    public void complement(String byte1){
    	result = "";
    	temp = "";
		System.out.println();
    	count = binaryToInt(byte1);
    	
    	for(int i = 0; i < 32-byte1.length(); i++)
    		temp += 0;
    	
    	byte1 = temp + byte1;
    	
    	for(int i = 0; i < byte1.length(); i++){
    		if(byte1.charAt(i) == '0')
    			result += 1;
    		else
    			result += 0;
    	}
    	negative = true;
    	answer = binaryToInt(result);
    	byte1 = removeZeros(byte1);
    	result = removeZeros(result);
    	System.out.println("Binary Result:\n    " + " COMPLEMENT " 
    					   + byte1 + " = " + result);
    	System.out.println("\nBase-10 Result:\n    " + " COMPLEMENT " 
    		               + count + " = " + answer);
    }
    
    private int binaryToInt(String str){
    	int result = 0;
    	int step = 1;
    	
    	for(int i = 1; i < str.length(); i++){
    		step*=2;
    	}
    	
    	for(int i = 0; i < str.length(); i++){
    		if(str.charAt(i) == '1'){
    			result+= step;
    		}
    		step /= 2;	
    	}
    	if(negative){
    		negative = false;
    		result *= -1;
    	}
    	return result;
    }
    
    private String removeZeros(String str){
    	String help = "";
    	for(int i = 0; i < str.length(); i++){
    		if(str.charAt(i) == '1'){
    			for(int j = i; j < str.length(); j++){
    				help += str.charAt(j);
    			}
    			break;
    		}
    	}
    	return help;
    }
}

class Driver{
	public static void main(String[] args){
		BinaryCalculator b = new BinaryCalculator();
		b.calc();
	}
}