/* Ruijing Li
 * Period 3
 * 12/5/13
 * Time Spent: 1 day
 * FINALLY DONE. Decompression was as hard as compression =(. I started using arrays but got really confused.
 * After a break, I chose to delete my old code, and used strings since I had an easier time debugging and 
 * manipulating them than with arrayLists. I am glad that I managed to complete the two hardest labs of 
 * first semseter =).
 */

import java.io.*;
import java.util.*;

class Driver {

	public static void main(String[] args) {

		SlidingWindowRLi demo = new SlidingWindowRLi();
		demo.readFile("pease_porridge_output.txt");
		//demo.compressAndSaveAs("output.txt");
		demo.decompressAndSaveAs("input.txt");
		demo.printStats();
	}
}

class SlidingWindowRLi {

	// Declare a stream of input
	DataInputStream inStream;

	// Store the bytes of input file in a String
	ArrayList<Character> fileArray = new ArrayList<Character>();

	// Our sliding window
	ArrayList<Character> window = new ArrayList<Character>();

	// Store file sizes to see how much compression we get
	long inFileSize;
	long outFileSize;

	// Track how many bytes we've read. Useful for large files.
	int byteCount;

	public void readFile(String fileName) {

		try {
			// Create a new File object, get size
			File inputFile = new File(fileName);
			inFileSize = inputFile.length();

			// The constructor of DataInputStream requires an InputStream
			inStream = new DataInputStream(new FileInputStream(inputFile));
		}

		// Oops.  Errors.
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}


		// Read the input file
		try {

			// While there are more bytes available to read...
			while (inStream.available() > 0) {

				// Read in a single byte and store it in a character
				char c = (char)inStream.readByte();

				if ((++byteCount)% 1024 == 0)
					System.out.println("Read " + byteCount/1024 + " of " + inFileSize/1024 + " KB...");

				// Print the characters to see them for debugging purposes
				//System.out.print(c);

				// Add the character to an ArrayList
				fileArray.add(c);
			}

			// clean up
			inStream.close();
			System.out.println("Done!!!\n");
		}

		// Oops.  Errors.
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

		// Print the ArrayList contents for debugging purposes
	//	System.out.println(fileArray);
	}


	public void compressAndSaveAs(String fileName) {
		// At this point, the ArrayList fileArray contains the file as a raw collection of Characters
		// Compress the input file by processing the ArrayList and writing the result to a new output file
		int startIndex, endIndex, currentPos, currentLength, maxPos, maxLength;
		boolean match = false;
		maxPos = 0;
		maxLength = 0;
		
		//initialize window
		for(int i = 0; i < 30; i++)
			window.add(fileArray.get(i));
		
		for(int i = 0; i < fileArray.size()-30; i++){
			
			startIndex = i;
			endIndex = startIndex + 29;
			
			//Find the longest match
			for(int j = startIndex; j <= endIndex; j++){
				
				currentLength = 0;
				if(fileArray.get(j) == fileArray.get(endIndex+1)){
					match = true;
					//Debugging
					//System.out.println("Found a match at position " + (j-startIndex));
					
					currentPos = j;
					for(int k = endIndex+1; k < fileArray.size(); k++){
						if(fileArray.get(j++) != fileArray.get(k)){
							break;
						}
						
						currentLength++;
					}
					
					j = currentPos;
					
					if(currentLength >= maxLength){
						maxLength = currentLength;
						maxPos = Math.abs(currentPos-startIndex);
					}	
				}
			}
			
			if(maxLength <= 3)
				match = false;
			
			//Debugging Purposes	
			//System.out.println(maxPos);
			//System.out.println(maxLength);
			
			
			if(match){
				window.add((char)7);
				window.add((char)maxPos);
				window.add((char)maxLength);
				i += maxLength-1;
				match = false;
			}
			else{
				window.add(fileArray.get(endIndex+1));
			}
			maxLength = 0;
//			Debugging
//			System.out.println(startIndex);
//			System.out.println(endIndex);
//			System.out.println(endIndex+1);
//			System.out.println(fileArray.get(endIndex+1));	
//			System.out.println(window);
		}
		
		String result = "";
		
		for(char one : window){
    		result += one;
		}
				
		FileWriter out;
		try{
		      out = new FileWriter(fileName);
		      out.write(result, 0, result.length());
		      out.close();
		}catch(IOException i){
		      System.out.println("Error: " + i.getMessage());
		}
		
		// Create a new File object, get size
		File outputFile = new File(fileName);
		outFileSize = outputFile.length();
	}
	
	public void decompressAndSaveAs(String fileName){
		int startIndex = 0;
		int temp = 0;
		String result = "";
		String yes = "";
		String ans = "";
		
		for(char c: fileArray){
			result += c;
		}
		//System.out.println(result);
		
		for(int i = 0; i < result.length(); i++){
			temp = startIndex;
			yes = "";
			ans = "";
			
			if(result.charAt(i) == (char)7){
				//System.out.println("\nFound, preparing for change");
				if((int)result.charAt(i+2) < result.length()){
					startIndex += (int)result.charAt(i+1);
					//System.out.println(startIndex);
					ans = result.substring(startIndex, startIndex + (int)result.charAt(i+2));
					
					for(int j = 0; j < i; j++){
						yes += result.charAt(j);
					}
					
//					System.out.println("temp string: " + yes);
//					System.out.println("Special chars: " + result.substring(i, i+3));
//					System.out.println("This should be copied: " + ans);
					startIndex = temp + 1;
					
					for(int j = i+3; j < result.length(); j++){
						ans += result.charAt(j);
					}
					
					result = yes + ans;
					//System.out.println("result: " + result);
				}
			}
			else{
				if(i > 30){
					startIndex++;
				}
			}			
		}
		FileWriter out;
		try{
		      out = new FileWriter(fileName);
		      out.write(result, 0, result.length());
		      out.close();
		}catch(IOException i){
		      System.out.println("Error: " + i.getMessage());
		}
		
		// Create a new File object, get size
		File outputFile = new File(fileName);
		outFileSize = outputFile.length();	
	}
	
	
	public void printStats() {

		System.out.printf("Original size = %,d bytes\n", inFileSize);
		System.out.printf("Compressed size = %,d bytes\n", outFileSize);
		System.out.printf("Compression ratio = %.1f%s\n\n", 100 * (1.0 - outFileSize/(double)inFileSize), "%");

	}

}