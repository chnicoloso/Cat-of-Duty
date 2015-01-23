/* Ruijing Li
 * Period 3
 * 1/26/14
 * Time Spent: 4 hours
 * I struggled a lot with a bug in my code that 
 * caused the knight to move to a higher access value
 * even though it should logically be moving toward a lower access 
 * value according to my code. Since it was extremely hard to 
 * debug my program I ended up not finding where the logic error 
 * was in my program.
 */

import java.io.*;
import java.util.*;

public class KnightsTour2 extends KnightsTour1 {
	int[][] access;
	ArrayList<Integer> b = new ArrayList<Integer>();
	
    public KnightsTour2() {
    	super();
    	access = new int[9][9];
    }
    
    public void initializeBoard(String fileName){
    	try{
    		Scanner in = new Scanner(new File(fileName));
    		while(in.hasNextInt()){
    			access[row][col] = in.nextInt();
    			col++;
    			if(col == 9){
    				col = 1;
    				row++;
    			}
    		}
    	}catch(FileNotFoundException e){
    		System.out.println(e.getMessage());
    	}
    }
    
    public void move(){
    	row = 1;
    	col = 1;
    	board[row][col] = counter;
    	temp = row;
    	key = col;
    	
    	while(counter < 65){
			for(int i = 1; i < 9; i++){
	 			moveNumber = i;
				row = row + vertical[moveNumber];
				col = col + horizontal[moveNumber];
				isInBounds(col, row, moveNumber);
				row = temp;
	 			col = key;
			}
			
			if(a.size() == 0)
				break;

			for(int i = 1; i < b.size(); i++){
				int index = 0;
				if(b.get(index) < b.get(i)){
					a.remove(i);
					b.remove(i);
				}
				else if(b.get(index) > b.get(i)){
					a.remove(index);
					b.remove(index);
					index = i;
				}
					
			}
			
			moveNumber = a.get(r.nextInt(a.size()));
			row = row + vertical[moveNumber];
			col = col + horizontal[moveNumber];
	    	board[row][col] = ++counter;	
	    	temp = row;
	    	key = col;
	    	a.clear();
	    	b.clear();
	    	lowerAccess();
    	}
    }
    
    public void lowerAccess(){
    	for(int i = 1; i < 9; i++){
    		moveNumber = i;
			row = row + vertical[moveNumber];
			col = col + horizontal[moveNumber];
			if(row > 0 && row < 9){
				if(col > 0 && col < 9){
					access[row][col] = access[row][col] - 1;
				}
			}
			row = temp;
	 		col = key;
    	}
    }
    
    public void isInBounds(int x, int y, int num){
		if(x > 0 && x < 9){
			if(y > 0 && y < 9){
				if(board[y][x] == 0){
					a.add(num);
					//b.add(access[y][x]);
				}
			}
 		}
 	}  
    
    public void printAccessiblity(){
    	System.out.print(" ");
 		for(int row = 1; row < 9; row++)
 			System.out.printf("%5d", row);
 			
 		System.out.println("\n");
 			
		for(int row = 1; row <= 8; row++){
			System.out.print(row);
			for(int col = 1; col <= 8; col++)
				System.out.printf("%5d", access[row][col]);
			
			System.out.println();
		}
		System.out.println("\n");
    }
}

class Driver{
	public static void main(String[] args){
		KnightsTour2 kt = new KnightsTour2();
		kt.setDirections();
		kt.initializeBoard("access.txt");
		//kt.printAccessiblity();
		kt.move();
		//kt.printAccessiblity();
		kt.printBoard();
	}
}