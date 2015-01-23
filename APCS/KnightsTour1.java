/* Ruijing Li
 * Period 3
 * 1/26/14
 * Time Spent: 5 hours
 * I struggled quite a lot with this program,
 * mostly because I was unsure where to start.
 * It took me quite a while until I could effectively
 * break down the problem into steps and solve each one.
 * I ran into bugs which I discovered were caused by
 * forgetting to clear the arraylist.
 */
import java.util.*;

public class KnightsTour1 {
	ArrayList<Integer> a;
	int[][] board;
	int[] horizontal;
	int[] vertical;
	int counter = 1;
	int row = 1;
	int col = 1;
	int moveNumber;
	Random r;
	int temp;
	int key;

    public KnightsTour1() {
    	r = new Random();
    	board = new int[9][9];
    	horizontal = new int[9];
    	vertical = new int[9];
    	a = new ArrayList<Integer>();
    }
    
    public void move(){
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
			moveNumber = a.get(r.nextInt(a.size()));
			row = row + vertical[moveNumber];
			col = col + horizontal[moveNumber];
	    	board[row][col] = ++counter;		
	    	temp = row;
	    	key = col;
	    	a.clear();
    	}
    }
 	
 	public void isInBounds(int x, int y, int num){
		if(x > 0 && x < 9){
			if(y > 0 && y < 9){
				if(board[y][x] == 0)
					a.add(num);
			}
 		}
 		
 	}  
 		
 	public void	printBoard(){
 		System.out.print(" ");
 		for(int row = 1; row < 9; row++)
 			System.out.printf("%5d", row);
 			
 		System.out.println("\n");
 			
		for(int row = 1; row <= 8; row++){
			System.out.print(row);
			for(int col = 1; col <= 8; col++)
				System.out.printf("%5d", board[row][col]);
			
			System.out.println();
		}
		
		System.out.println("\n" + counter + " squares were visited");
 	}
    
    public void setDirections(){
    	//horizontal directions
    	horizontal[1] = 1;
    	horizontal[2] = 2;
    	horizontal[3] = 2;
    	horizontal[4] = 1;
    	horizontal[5] = -1;
    	horizontal[6] = -2;
    	horizontal[7] = -2;
    	horizontal[8] = -1;
    	//vertical directions
    	vertical[1] = -2;
    	vertical[2] = -1;
    	vertical[3] = 1;
    	vertical[4] = 2;
    	vertical[5] = 2;
    	vertical[6] = 1;
    	vertical[7] = -1;
    	vertical[8] = -2;
    }
}

class Driver{
	public static void main(String[] args){
		KnightsTour1 k = new KnightsTour1();
		k.setDirections();
		k.move();
		k.printBoard();
	}
}