/* Ruijing Li
 * Period 3
 * 2/9/14
 * Time Spent: 2 hrs
 * The hardest part of this lab was converting little
 * Endian to Big endian since the pseudocode confused
 * me quite a bit. Other than that most of the lab was
 * easy after reading the lesson.
 */
import java.io.*;
import java.util.*;

public class SavegameReader {
	private byte numName;
	private String name;
	private byte numRace;
	private String race;
	private boolean hasMagic;
	private byte lives;
	private short level;
	private int gold;

    public SavegameReader() {
    	name = "";
    	race = "";
    }
    
    public void readFile(String fileName){
    	try {
			FileInputStream f = new FileInputStream(fileName);
			DataInputStream d = new DataInputStream(f);
			numName = d.readByte();
			for(int i = 0; i < numName; i++)
				name += d.readChar();
				
			numRace = d.readByte();
			for(int i = 0; i < numRace; i++)
				race += d.readChar();
				
			hasMagic = d.readBoolean();
			lives = d.readByte();
			level = d.readShort();
			gold = reverseByteOrder(d.readInt());
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		//System.out.println(numName);
		System.out.println("Player Name:\t" + name);
		//System.out.println(numRace);
		System.out.println("Player Race:\t" + race);
		System.out.println("Magic Ability:\t" + hasMagic);
		System.out.println("Lives Left:\t" + lives);
		System.out.println("Exp. Level:\t" + level);
		System.out.println("Gold:\t\t" + gold);
    }
        
	// Converts little-endian to big-endian, or vise-versa.
	public int reverseByteOrder(int input) {
	
		// To reverse the order of our 4 bytes, we will take
		// turns putting each byte into its desired position
	
		// Holds the reversed number, which we build byte by byte
		int output = 0;
	
		// A temporary number to work with shifting, etc
		int temp = 0;
		 
		// Move the first byte of our input into position and add it to our output by
		/*
		   Step 1:  Shift the first right by 3 bytes
		   Step 2:  Isolate the result by ANDing it with 0x000000FF
		   Step 3:  Either add or OR the shifted result to our output
		 */
		temp = input >> 24;		
		temp = temp & 0x000000FF; 
		output += temp;
		// Repeat a similar process for the remaining 3 bytes
		// Return the result, which is now in reverse byte order
		temp = input >> 8;
		temp = temp & 0x0000FF00;
		output += temp;
		temp = input << 8;
		temp = temp & 0x00FF0000;
		output += temp; 
		temp = input << 24;
		temp = temp & 0xFF000000;
		output += temp;  	 
		return output;
	}
}

class Driver{
	public static void main(String[] args){
		SavegameReader s = new SavegameReader();
		s.readFile("save002.dat");
	}
}