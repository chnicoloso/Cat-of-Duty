/* Ruijing Li
 * Period 3
 * 3/1/14
 * Time Spent: 3 hours
 * I struggled quite a bit on this lab, before realizing how easy it 
 * actually was. The problem I had was not separating the recursion 
 * into its own method, which caused a lot of backtracking. Also I 
 * realized I didn't even need to create local references of my maze.
 * By separating recursion into its own method, I found this lab
 * a lot easier to code.
 */
import java.util.*;
import java.io.*;

public class EraseObject {
	private final int MAXROW = 20;
	private final int MAXCOL = 20;
	char[][] myMaze = new char[MAXROW+1][MAXCOL+1];
	int myRow;
	int myCol;
	
    public EraseObject() {
    }
    
    public void generate(String fileName){
    	loadMaze(fileName);
    	System.out.println("Image before an erasure\n");
    	printMaze(myMaze);
    	requestStart();
    	System.out.println("\nImage after first erasure\n");
    	removeObject(myMaze, myRow, myCol);
    	requestStart();
    	System.out.println("\nImage after second erasure\n");
    	removeObject(myMaze, myRow, myCol);
    	
    }
    
    public void loadMaze(String fileName){
    	for(int row = 1; row < myMaze.length; row++){
    		for(int col = 1; col < myMaze[0].length; col++){
    			myMaze[row][col] = '-';
    		}
    	}
    	
    	try{
    		Scanner in = new Scanner(new File(fileName));
    		int numCoordinates = in.nextInt();
    		for(int i = 0; i < numCoordinates; i++){
    			myMaze[in.nextInt()][in.nextInt()] = '@'; 
    		}
    	}catch(FileNotFoundException e){
    		System.out.println(e.getMessage());
    	}
    }
    
   public void requestStart(){
   		Scanner key = new Scanner(System.in);
   		System.out.println("Enter starting row: ");
   		myRow = key.nextInt();
   		System.out.println("Enter starting col: ");
   		myCol = key.nextInt();
   }
   
   public void removeObject(char[][] maze, int row, int col){
   		erase(maze, row, col);
   		printMaze(maze);
   }
   
   public void erase(char[][] maze, int row, int col){
   		if(checkBoundaries(row, col)){
   			if(maze[row][col] == '@'){
   				maze[row][col] = '-';
   				erase(maze, row-1, col);
   				erase(maze, row, col+1);
   				erase(maze, row+1, col);
   				erase(maze, row, col-1);		
   			}
   		}
   }
   
   public void printMaze(char[][] maze){
   		System.out.print("   ");
 		for(int row = 1; row < maze[0].length; row++)
 			System.out.print(row%10);
 			
 		System.out.println();
 			
		for(int row = 1; row < maze.length; row++){
			System.out.printf("%2d ", row);
			for(int col = 1; col < maze[0].length; col++)
				System.out.print(maze[row][col]);
			
			System.out.println();
		}
   }
   
   private boolean checkBoundaries(int row, int col){
   		if(row >= 1 && row <= MAXROW && col >= 1 && col <= MAXCOL)
   			return true;
   		else 
   			return false;
   } 
}

class Driver{
	public static void main(String[] args){
		EraseObject e = new EraseObject();
		e.generate("digital.txt");
	}
}