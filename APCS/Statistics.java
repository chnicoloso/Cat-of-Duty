/* Ruijing Li
 * Period 3
 * 12/10/13
 * Time Spent: 1 and 30 minutes
 * I kind of struggled with the mode portion of the lab, trying 
 * to figure out exactly how to get mutliple modes until I 
 * realized I made a very simple logical error which made
 * the lab difficult for me. Other than that, the lab 
 * was fairly easy to accomplish.
 */

import java.io.*;
import java.util.*;
public class Statistics {
	int[] array;
	
    public Statistics() {
    }
    
    public void readFile(String fileName){
    	int i = 0;
    	File file = new File(fileName);
    	
    	try{
    		Scanner in = new Scanner(file);
    		while(in.hasNextInt()){
    			in.nextInt();
    			i++;
    		}
    	}catch(FileNotFoundException e){
    		System.out.println("Error Message is " + e.getMessage());
    		System.exit(0);
    	}
    	
    	array = new int[i];
    	i = 0;
    	
		try{
			Scanner in = new Scanner(file);
			while(in.hasNextInt()){
				array[i] = in.nextInt();
				i++;
			}
    	}catch(FileNotFoundException e){
    		System.out.println("Error Message is " + e.getMessage());
    		System.exit(0);
    	}
    }
    
    public double average(){
    	double sum = 0;
    	double num = 0;
    	double average;
    	for(int i = 0; i < array.length; i++){
    		sum += array[i];
    		num = i+1;
    	}
    	
    	average = sum/num;
    	return average;
    }
    
    public double stddeviation(){
    	double average = average();
    	double diff = 0;
    	int num = 0;
    	for(int i: array){
    		diff += Math.pow(i - average, 2);
    		num++;
    	}
    	return Math.sqrt(diff/(num-1));
    }
    
    public void mode(){
    	ArrayList<Integer> mode = new ArrayList<Integer>();
    	int count = 0;
    	int temp;
    	int pos = -1;
    	
    	for(int i = 0; i < array.length; i++){
    		temp = 0;
    		for(int j = i; j < array.length; j++){
    			
    			if(array[i] == array[j]){
    				temp++;
    			}
    		}
    		if(temp >= count){
    			count = temp;
    			mode.add(array[i]);
    		}
    	}
    	System.out.print("\nThe mode(s): ");
    	for(int i: mode){
    		 System.out.print(i + "  ");
    	}
    	System.out.println("");
    }
}

class Driver{
	public static void main(String[] args){
		Statistics s = new Statistics();
		s.readFile("numbers.txt");
		System.out.printf("Average is: %.2f", s.average());
		System.out.printf("\nStandard Deviation is: %.2f", s.stddeviation());
		s.mode();
	}
}