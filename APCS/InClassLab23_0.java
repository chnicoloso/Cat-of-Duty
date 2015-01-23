public class InClassLab23_0 {

	public static void main(String[] args) {

		TwoDeeArray td = new TwoDeeArray(9, 6);
		TwoDeeArray td2 = new TwoDeeArray(6, 9);
		td.fillArray();
		td.sums();
		td.print();
		td2.fillArray();
		td2.sums();
		td2.print(); 
	}

}

class TwoDeeArray {

	// Attribute:  A 2D array of integers
	private int[][] list;


	// Constructor:  Creates a new 2D array of integers with size:
	//				 (numRow + 1) rows
	//               (numCols + 1) columns.
	public TwoDeeArray(int numRows, int numCols) {
		list = new int[numRows+1][numCols+1];
	}


	/* Method: Starting with 1, fills the 2D array with consecutive numbers
	           leaving zeros in the last column and last row to be filled in
	           later.

	           For example:

	                  "5x5" array				"3x3" array

	           [[ 1,  2,  3,  4,  5, 0],		[[1, 2, 3, 0],
	            [ 6,  7,  8,  9, 10, 0],		 [4, 5, 6, 0],
	            [11, 12, 13, 14, 15, 0],		 [7, 8, 9, 0],
	            [16, 17, 18, 19, 20, 0],		 [0, 0, 0, 0]];
	            [21, 22, 23, 24, 25, 0],
	            [ 0,  0,  0,  0,  0, 0]]
	*/
	public void fillArray() {
		int temp = 1;
		for(int r = 0; r < list.length-1; r++){
			for(int c = 0; c < list[r].length-1; c++){
				list[r][c] = temp;
				temp++;
			}
		}
	}


	/* Method: Fills the last column with the sum of each row and fillss
	           the last row with the sum of each column.

	           For example:

	                  "5x5" array				"3x3" array

	           [[ 1,  2,  3,  4,  5,  15],		[[1,   2,  3,  6],
	            [ 6,  7,  8,  9, 10,  40],		 [4,   5,  6, 15],
	            [11, 12, 13, 14, 15,  65],		 [7,   8,  9, 24],
	            [16, 17, 18, 19, 20,  90],		 [12, 15, 18, 90]];
	            [21, 22, 23, 24, 25, 115],
	            [55, 60, 65, 70, 75, 650]]
	*/
	public void sums() {
		int rowTemp = 0;
		int colTemp =  0;
		int sum = 0;
		for(int r = 0; r < list.length; r++){
			rowTemp = 0;
			for(int c = 0; c < list[r].length; c++){
				if(r != list.length-1 || c != list[r].length-1)
					rowTemp += list[r][c];
				
				if(c == list[r].length-1)
					list[r][c] = rowTemp;
					
			}
		}
		
		for(int c = 0; c < list[0].length; c++){
			colTemp = 0;
			for(int r = 0; r < list.length; r++){
				if(r != list.length-1 || c != list[r].length-1){
					colTemp += list[r][c];
				}
				
				if(r == list.length-1)
					list[r][c] = colTemp;
			}
		}
		
		for(int r = 0; r < list.length; r++){
			for(int c = 0; c < list[r].length; c++){
				if(r == list.length-1 && c == list[r].length-1)
					list[r][c] = sum;
				else if(r == list.length-1 && c != list[r].length-1)
					sum += list[r][c];
				else if(r != list.length-1 && c == list[r].length-1)
					sum += list[r][c];
			}
		}
		
	}

	/* Method: Uses loops to print the array in a nice, 2D format as shown
	 		   above in the comments for fillArray() and sums().

	 		   Bonus:  Use formatting to align all the numbers to a field
	 		   width that is equal to the size of the largest number in the
	 		   array.
	*/
	public void print() {
		System.out.print("[");
		for(int r = 0; r < list.length; r++){
			if(r > 0)
				System.out.print(" ");
				
			System.out.print("[");
			
			for(int c = 0; c < list[r].length; c++){
					
				System.out.printf("%2d", list[r][c]);
				if(c != list[r].length-1)
					System.out.print(", ");
			}
			if(r < list.length-1)
				System.out.println("]");
			else
				System.out.print("]");
		}
		System.out.println("]");
	}

}