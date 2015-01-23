/* Ruijing Li
 * Period 3
 * 11/18/13
 * Time Spent: 30 minutes
 * This lab was a nice breather since the hard lab we did
 * in ACSLLand. Although there were a lot of new and important
 * concepts like reading and writing a file, they are easy to
 * understand, at least for now.
 */

import java.io.*;
import java.util.Scanner;

public class Average {
	
    public static void main(String[] args){
    	int num = 0;
    	int counter = 0;
    	double average = 0;
    	//Read file
    	File file = new File("numbers.txt");
    	Scanner in = null;
    	
    	try{
    		in = new Scanner(file);
    	}catch(FileNotFoundException e){
    			System.out.println("Error is " + e.getMessage());
    	}
    	
    	while(in.hasNext()){
    		num += in.nextInt();
    		counter++;
    	}
    	
    	average = (double)num/counter;
    	System.out.printf("Average is: %.2f\n", average);
    	//Write file
    	String result = "Average is: " + average + "\n";
    	FileWriter out = null;
    	try{	
    		out = new FileWriter("output.txt");
    		out.write(result, 0, result.length());
    		out.close();
    	}
    	catch(IOException i){
    		System.out.println("Error: " + i.getMessage());
    	}
    }
}