/* Ruijing Li
 * Period 3
 * 12/7/13
 * Time Spent: 30 minutes
 * This lab was a nice breather from the compression 
 * and decompression labs. Most of it was easy, but 
 * switching around the positions in the array was
 * tricky because the size was static and therefore 
 * I couldn't add or remove elements like in arraylists.
 */

import java.util.*;
import java.io.*;

public class Compact {
	int[] array; 
	ArrayList<Integer> list;

    public Compact() {
    	list = new ArrayList<Integer>();	
    }
    
    public void readFile(String fileName){
    	Scanner in;
    	File file = new File(fileName);
    	int i = 0;
    	
    	try{
		     in = new Scanner(file);
		     while(in.hasNext()){
		     	list.add(in.nextInt());
		     	i++;
		     }
    	}catch(IOException e){
    		System.out.println("Error: " + e.getMessage());
    	}
    	
    	array = new int[i];
    	i = 0;
    	    	
    	try{
		     in = new Scanner(file);
		     while(in.hasNext()){
		     	array[i] = in.nextInt();
		     	i++;
		     }
    	}catch(IOException e){
    		System.out.println("Error: " + e.getMessage());
    	}		
    }
    
    public void compactArray(){
    	int temp, count;
    	
    	System.out.println("Array\n");
    	System.out.print("Before: ");
    	for(int i: array)
    		System.out.print(i + " ");
    	
    	for(int i = 0; i < array.length; i++){
    		if(array[i] == 0){
    			count = i;
    			while(i+1 < array.length && array[i] == 0){
    				i++;
    			}
    			temp = array[i];
    			array[i] = 0;
    			i = count;
    			array[i] = temp;
    		}
    	}
    		
    	System.out.print("\nAfter: ");
    	for(int i: array)
    		System.out.print(i + " ");
    	
    	System.out.println("\n");
    }
    
    public void compactArrayList(){
    	System.out.println("ArrayList\n");
    	System.out.print("Before: ");
    	for(int i: list)
    		System.out.print(i + " ");
    		
    	Iterator iter = list.iterator();
    	while(iter.hasNext()){
    		if(iter.next() == 0)
    			iter.remove();
    	}
    	
    	System.out.print("\nAfter: ");
    	for(int i: list)
    		System.out.print(i + " ");
    		
    	System.out.println("");
    }
}

class Driver{
	public static void main(String[] args){
		Compact c = new Compact();
		c.readFile("compact.txt");
		c.compactArray();
		c.compactArrayList();
	}
}