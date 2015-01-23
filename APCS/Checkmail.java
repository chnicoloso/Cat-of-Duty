/* Ruijing Li
 * 9/26/13
 * Period 3
 * Time Spent: 40 minutes
 * At first I was confused by the layout of the 
 * instructions; however, after reading them carefully,
 * I found the code to be simply if-else logic and 
 * scanner use. Nothing was too hard because all the info
 * needed to solve this problem was in the instructions
 * and pseudocode
 */

import java.util.Scanner;

public class Checkmail {

    public static void main(String[] args) {
    	int dim1, dim2, dim3, weight, temp, girth, size;
    	Scanner keyboard = new Scanner(System.in);
    	System.out.print("Enter a dimension of the package: ");
    	dim1 = keyboard.nextInt();
    	System.out.print("Enter second dimension of the package: ");
    	dim2 = keyboard.nextInt();
    	System.out.print("Enter third dimension of the package: ");
    	dim3 = keyboard.nextInt();
    	System.out.print("Enter the weight of the package: ");
    	weight = keyboard.nextInt(); //pounds
    	
    	if(dim2 > dim3 && dim2 > dim1){
    		temp = dim1;
    		dim1 = dim2;
    		dim2 = temp;
    	}
    	else if(dim3 > dim2 && dim3 > dim1){
    		temp = dim1;
    		dim1 = dim3;
    		dim3 = temp;
    	}
    	
    	girth = 2*dim2 + 2*dim3; 
    	size = girth + dim1; //inches
    		
    	if(weight > 70 && size > 100)
    		System.out.println("Package is too large and too heavy.");
    	
    	else if(weight > 70 && size <= 100)
    		System.out.println("Package is too heavy.");
    		
    	else if(weight <= 70 && size > 100)
    		System.out.println("Package is too large.");
    		
    	else
    		System.out.println("Package is acceptable.");
    }
}