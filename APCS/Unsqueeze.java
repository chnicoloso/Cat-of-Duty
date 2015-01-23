/* Ruijing Li
 * Period 3
 * 11/21/13
 * Time Spent: 30 minutes
 * This lab was easy to complete especially after
 * completing the squeeze lab beforehand. The only
 * hard part was converting a char into an int. 
 * I used the same methods used in Squeeze to complete 
 * this lab.
 */

import java.util.*;
import java.io.*;
public class Unsqueeze {

    public static void main(String[] args) {
    	Scanner in = null;
    	String str = "";
    	int num = 0;
    	String tabs = "";
    	String result = "";
    	File file = new File("LeetSpeakOutput.txt");
    	try{
    		in = new Scanner(file);
    	}catch(FileNotFoundException e){
    		System.out.println("Error: " + e.getMessage());
    	}
    	FileWriter out;
    		
    	while(in.hasNextLine()){
    		str = in.nextLine();
    		num = str.charAt(0) - '0';
    		tabs = "";
    		
    		for(int i = 0; i < num; i++){
    			tabs += "\t"; 
    		}
    		
    		result += tabs;
    		if(str.length() > 2)
    			result += str.substring(2);
    			
			result += "\r\n";
    	}
    	
    	System.out.println(result);
    	
    	try{
			out = new FileWriter("LeetSpeakUncompressed.txt");
		    out.write(result, 0, result.length());
		    out.close();
		}catch(IOException i){
		    System.out.println("Error: " + i.getMessage());
		}
    }
}