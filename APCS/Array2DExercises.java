/**
 * @(#)Array2DExercises.java
 *
 *
 * @author 
 * @version 1.00 2014/3/1
 */


public class Array2DExercises {

    public Array2DExercises() {
    }
    
    public static int max(int[][] a){
		int temp = a[0][0];
		
		for(int row = 0; row < a.length; row++){
			for(int col = 1; col < a[0].length; col++){
				if(temp < a[row][col])
					temp = a[row][col];
			}
		}
		return temp;
	} 
    
}