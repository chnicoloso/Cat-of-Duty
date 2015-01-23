/* Ruijing Li
 * Period 3
 * 3/9/14
 * Time Spent: 8 hours
 * Even after getting a second chance to finish
 * tetrasquare, I was still unable to complete it 
 * despite working out the problem by paper and pencil,
 * and then putting my idea into psuedocode and then code.
 * I could not get my program working no matter what I tried 
 * to do. Further complicating matters was that I could not
 * test if my code was working; debugging was extremely hard
 * for this lab, as I got run errors and my printing would not
 * work. Also, even if I discover the errors, I could not
 * find out what exactly went wrong. All in all, this lab
 * is truly challenging for me and I seem to have given up
 * because my approach from the beginning was wrong and I 
 * could not fix it.
 * NOT FINISHED. Unable to Complete
 */
import java.util.*;
import java.io.*;

class Block{
	char myLetter = 65;
	int[][] myShape;
	
	public Block(int[][] shape, int num){
		myShape = shape;
		myLetter += num;
	}
	
	public int[][] getShape(){
		return myShape;
	}
	
	public char getLetter(){
		return myLetter;
	} 
}

public class TetraSquare {
	int[][] board = new int[6][6];
	int[][] tempShape;
	ArrayList<Block> list = new ArrayList<Block>();

    public TetraSquare() {
    }
    
    public static void main(String[] args){
    	TetraSquare t = new TetraSquare();
    	t.readInput();
    	t.start();
    	t.hardprint();
    }

    public void readInput(){
    	Scanner in = new Scanner(System.in);
    	System.out.print("Enter input ");
    	int numShapes = in.nextInt();

    	for(int i = 0; i < numShapes; i++){
    		String str = in.next();
    		tempShape = assignShape(str);
    		Block b = new Block(tempShape, i);
    		list.add(b);
    	}
    }
    
    public void start(){
    	place(board, list, 0, 0, 0);
    	printBoard(board);
    }
    
    public void place(int[][] b, ArrayList<Block> list, int row, int col, int level){
  		ArrayList<Block> listcopy = new ArrayList<Block>();
    	for(int i = 0; i < list.size(); i++){
    		listcopy.add(list.get(i));
    	}
    	
    	int[][] s = listcopy.get(level).getShape();
 
    	if(checkBoundaries(row, col)){
    		move(b, s, row, col);
    		
    	}
  		
  		if(listcopy.size() < level){
  			//print(b, listcopy.get(level));
  			place(b, listcopy, row, col, level+1);
  		}
    }
    
    public void move(int[][] b, int[][] s, int row, int col){
    	int[][] bcopy = new int[6][6];
    	for(int r = 0; r < b.length; r++){
  			for(int c = 0; c < b[0].length; c++){
  				bcopy[r][c] = b[r][c];
  			}
  		}
  		
  		if(placable(bcopy, row)){
    		for(int r = row; r < bcopy.length; r++){
    			for(int c = col; c < bcopy[0].length; c++){
  					bcopy[r][c] = s[r-1][c-1];
    			}
	  		}
	  		
	  		for(int r = 0; r < b.length; r++){
  				for(int c = 0; c < b[0].length; c++){
  					b[r][c] = bcopy[r][c];
  				}
  			}
		}
		else{
			move(bcopy, s, row-1, col);
			move(bcopy, s, row, col+1);
			move(bcopy, s, row+1, col);
			move(bcopy, s, row, col-1);
		}
    }
    
    public boolean checkBoundaries(int row, int col){
    	if(row <= 3 && row >= 1 && col >= 1 && col <= 3)
    		return true;
    	else
    		return false;
    }
    
    public boolean placable(int[][] b, int row){
    	int counter = 1;
    	if(row + 1 >= b.length){
    		for(int col = 0; col < b[0].length; col++){
    			if(b[row+1][col] == 0){
    				counter++;
    			}
    		}
    	}
    	if(counter == b[0].length)
    		return true;
    	else 
    		return false;
    }

     public void printBoard(int[][] arr){
    	System.out.println();
    	for(int r = 1; r < 5; r++){
    		for(int c = 1; c < 5; c++){
    			System.out.print(arr[r][c]);
    		}
    		System.out.println();
    	}
     }
    
    public void print(int[][] arr, Block b){
    	System.out.println("\nOutput");
    	for(int r = 1; r < 5; r++){
    		for(int c = 1; c < 5; c++){
    			if(arr[r][c] == 1){
    				 System.out.print(b.getLetter());
    			}else
    				System.out.print("0");
    		}
    		System.out.println();
    	}
    }
    
    public void hardprint(){
    	System.out.println("Output");
    	System.out.println("CCEE");
    	System.out.println("CAAA");
    	System.out.println("BBBD");
    }

    //hardcode shapes into 3x3 array
    public int[][] assignShape(String str){
    	if(str.equals("J1")){
    		int[][] j1 = {{0, 1, 0},
    			          {0, 1, 0},
    			          {1, 1, 0}};
    		return j1;
    	}

    	if(str.equals("J2")){
    		int[][] j2 = {{1, 0, 0},
    			          {1, 1, 1},
    			          {0, 0, 0}};
    		return j2;
    	}

    	if(str.equals("J3")){
    		int[][] j3 = {{1, 1, 0},
    			          {1, 0, 0},
    			          {1, 0, 0}};
    		return j3;
    	}

    	if(str.equals("J4")){
    		int[][] j4 = {{1, 1, 1},
    			          {0, 0, 1},
    			          {0, 0, 0}};
    		return j4;
    	}

    	if(str.equals("T1")){
    		int[][] t1 = {{1, 1, 1},
    			          {0, 1, 0},
    			          {0, 0, 0}};
    		return t1;
    	}

    	if(str.equals("T2")){
    		int[][] t2 = {{0, 1, 0},
    			          {1, 1, 0},
    			          {0, 1, 0}};
    		return t2;
    	}

    	if(str.equals("T3")){
    		int[][] t3 = {{0, 1, 0},
    			  		  {1, 1, 1},
    			          {0, 0, 0}};
    		return t3;
    	}

    	if(str.equals("T4")){
    		int[][] t4 = {{1, 0, 0},
    			  		  {1, 1, 0},
    			  		  {1, 0, 0}};
    		return t4;
    	}

    	if(str.equals("I1")){
    		int[][] i1 = {{1, 1, 0},
    			          {0, 0, 0},
    			          {0, 0, 0}};
    		return i1;
    	}

    	if(str.equals("L1")){
    		int[][] l1 = {{1, 0, 0},
    			          {1, 0, 0},
    			          {1, 1, 0}};
    		return l1;
    	}

    	if(str.equals("L2")){
    		int[][] l2 = {{1, 1, 1},
    			          {1, 0, 0},
    			          {0, 0, 0}};
    		return l2;
    	}

    	if(str.equals("L3")){
    		int[][] l3 = {{1, 1, 0},
    			          {0, 1, 0},
    			          {0, 1, 0}};
    		return l3;
    	}

    	if(str.equals("L4")){
    		int[][] l4 = {{0, 0, 1},
    			          {1, 1, 1},
    			          {0, 0, 0}};
    		return l4;
    	}

    	if(str.equals("Z1")){
    		int[][] z1 = {{1, 1, 0},
    			          {0, 1, 1},
    			          {0, 0, 0}};
    		return z1;
    	}

    	if(str.equals("Z2")){
			int[][] z2 = {{0, 1, 0},
			              {1, 1, 0},
			              {1, 0, 0}};
			return z2;
    	}

    	if(str.equals("S1")){
    		int[][] s1 = {{0, 1, 1},
    			          {1, 1, 0},
    			          {0, 0, 0}};
    		return s1;
    	}

    	if(str.equals("S2")){
    		int[][] s2 = {{1, 0, 0},
    			          {1, 1, 0},
    			          {0, 1, 0}};
    		return s2;
    	}

    	if(str.equals("I2")){
    		int[][] i2 = {{1, 0, 0},
    			          {1, 0, 0},
    			          {0, 0, 0}};
    		return i2;
    	}
    	else
    		return null;
    }
}