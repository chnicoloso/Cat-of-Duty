/* Ruijing Li
 * Period 3
 * 11/20/13
 * Time Spent: 40 minutes
 * This lab was a lot easier to complete when I thought
 * of the psuedocode beforehand so I could just implement
 * my strategy. The only issue I encountered was reading
 * tabs from a new line, but that was only because I made
 * a logic error. Other than that this lab is pretty 
 * straightforward.
 */

// PsuedoCode
//First use nextLine() to read a whole line from file. 
//Continue reading by putting a while loop and using hasNext(). 
//Then put the line into a for loop that runs until end of 
//string. Check for str.charAt(i) == "\t". 
//When str.charAt() != "\t" then copy remaining string with 
//substring and then break. Then write that into file.
import java.util.*;
import java.io.*;

public class Squeeze {

    public static void main(String[] args){
    	String line = "";
    	String result = "";
    	int counter = 0;
    	String temp = "";
    	File file = new File("LeetSpeak.java");
    	Scanner in = null;
    	try{
    		in = new Scanner(file);
    	}catch(FileNotFoundException e){
    		System.out.println("Error is " + e.getMessage());
    	}
    	
    	while(in.hasNext()){
    		line = in.nextLine();
    		counter = 0;
    		temp = "";
    		
    		for(int i = 0; i < line.length(); i++){
    			
    			if(line.charAt(i) == '\t'){
    				counter++;
    			}
    			else{
    				temp = line.substring(i);
    				break;
    			}
    		}
    		result += counter + " " + temp + "\r\n";	
    	}
    	
    	FileWriter out;
    	try{
      		out = new FileWriter("LeetSpeakOutput.txt");
      		out.write(result, 0, result.length());
      		out.close();
		}catch(IOException i){
      		System.out.println("Error: " + i.getMessage());
		}
    }
}