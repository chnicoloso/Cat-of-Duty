/* Ruijing Li
 * Period 3
 * 1/30/14
 * Time Spent: 6 hours
 * Thanks to the advice I received in class and the use of lots of helper functions, I was able to complete this 
 * lab and get it fully running. It took a while, but by applying my knowledge of knights tour and fixing the mistakes
 * I made back in the previous lab, I managed to debug faster in this lab and fixed all the problems involved in the lab.
 * I think this is a good lab to do and definitely it was good to do the two previous knights tour even if I struggled with
 * those 2.
 */

import java.util.*;
import java.io.*;

public class Li_Ruijing_3_Life {
	char[][] grid;
	char[][] next;
	char[][] temp;
    
    // Constructor that initializes a game of Life from the given data file
	public Li_Ruijing_3_Life() {
		
	}
    
    public void loadData(String fileName){
    	try{
    		Scanner in = new Scanner(new File(fileName));
    		grid = new char[in.nextInt()][in.nextInt()];
			while(in.hasNextInt()){
				grid[in.nextInt()][in.nextInt()] = '*';
			}
    	}catch(FileNotFoundException e){
    		System.out.println(e.getMessage());
    	}
    	
    	next = new char[grid.length][grid[0].length];
    	temp = new char[grid.length][grid[0].length];
    }
    
    // Method that runs the Life simulation through the given generation
	// Generation 0 is the initial position, Generation 1 is the position after one round of Life, etc...
	public void runLife(int numGenerations) {
		for(int i = 1; i <= numGenerations; i++){
			int count = 0;
			for(int row = 0; row < grid.length; row++){
				for(int col = 0; col < grid[0].length; col++){
					count = checkNeighbors(row, col);
					if(count == 2 || count == 3){
						if(grid[row][col] == '*')
							next[row][col] = '*';
					}
					if(grid[row][col] != '*'){
						if(count == 3)
							next[row][col] = '*';
					}
				}
			}
			nextGeneration();
		}
	}
	// Method that returns the number of living cells in the given row
	// or returns -1 if row is out of bounds.  The first row is row 0.
	public int rowCount(int row) {
		int count = 0;
		
		for(int col = 0; col < grid[row].length; col++){
			if(grid[row][col] == '*')
				count++;
		}
		
		if(row >= 0 && row < grid.length)
			return count;
		else
			return -1;
	}
	
	// Method that returns the number of living cells in the given column
	// or returns -1 if column is out of bounds.  The first column is column 0.
	public int colCount(int col) {
		int count = 0;
		
		for(int row = 0; row < next.length; row++){
			if(grid[row][col] == '*')
				count++;
		}
		
		if(col >= 0 && col < grid.length)
			return count;
		else
			return -1;
	}
	
	// Method that returns the total number of living cells on the board
	public int totalCount() {
		int count = 0;
		for(int row = 0; row < grid.length; row++){
			for(int col = 0; col < grid[0].length; col++){
				if(grid[row][col] == '*')
					count++;
			}
		}
		return count;
	}
   
    //This helper method will check if that current spot is in bounds
	private boolean isLegal(int x, int y){
		if(x < 0 || x >= grid.length || y < 0 || y >= grid.length)
			return false;
		else 
			return true;
	}
						
    private int checkNeighbors(int x, int y){
    	int counter = 0;
    	counter += getNeighbor(x-1, y);
    	counter += getNeighbor(x-1, y-1);
    	counter += getNeighbor(x-1, y+1);
    	counter += getNeighbor(x+1, y);
    	counter += getNeighbor(x+1, y-1);
    	counter += getNeighbor(x+1, y+1);
    	counter += getNeighbor(x, y-1);
    	counter += getNeighbor(x, y+1);
    	return counter;
    }
    
    private int getNeighbor(int x, int y){
    	if(isLegal(x, y)){
    		if(grid[x][y] == '*')
    			return 1;
    	}

    	return 0;
    }
    
    // Advances Life forward one generation
	public void nextGeneration() {
		for(int row = 0; row < next.length; row++){
			for(int col = 0; col < next[0].length; col++){
				grid[row][col] = next[row][col];
				next[row][col] = temp[row][col];
			}
		}
	}
    
    // Prints out the Life array with row and column headers as shown in the example below.
	public void printBoard() {
	    System.out.printf("\n%3s", "");
 		for(int row = 0; row < grid.length; row++){
 			System.out.print(row%10);
 		}
 			
 		System.out.println();
 			
		for(int row = 0; row < grid.length; row++){
			System.out.printf("%-3d", row);
			for(int col = 0; col < grid[0].length; col++)
				System.out.print(grid[row][col]);
			
			System.out.println();
		}

		System.out.println("Number of Living Cells in row 9 --> " + rowCount(9));
		System.out.println("Number of Living Cells in col 9 --> " + colCount(9));
		System.out.println("Number of Living Cells total --> " + totalCount());
	}
}

class Ruijing_Driver{
	public static void main(String[] args){
		Li_Ruijing_3_Life l = new Li_Ruijing_3_Life();
		l.loadData("life100.txt");
		l.runLife(5);
		l.printBoard();
//		Li_Ruijing_3_Life l1 = new Li_Ruijing_3_Life("happy.txt");
//		l1.runLife(5);
//		l1.printBoard();
//		Li_Ruijing_3_Life l2 = new Li_Ruijing_3_Life("cross.txt");
//		l2.runLife(5);
//		l2.printBoard();
//		Li_Ruijing_3_Life l3 = new Li_Ruijing_3_Life("x.txt");
//		l3.runLife(5);
//		l3.printBoard();
	}
}