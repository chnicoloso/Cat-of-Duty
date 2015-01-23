/* Ruijing Li
 * Period 3
 * 11/23/13
 * Time Spent: 30 minutes
 * ArrayLists seem quite complex, but after using them
 * I found they weren't as hard as they seemed. I didn't
 * really have any troubles with the lab since I had 
 * already got the logic of it and just needed to 
 * implement it in code.
 */

import java.util.*;

public class Permutations implements PermutationGenerator {
	ArrayList<Integer> temp;
	ArrayList<Integer> myList;
	int count, num, z;
	Random r;

    public Permutations() {
    	myList = new ArrayList<Integer>();
 		temp = new ArrayList<Integer>();
 		count = 0;
 		r = new Random();
    }
    
    public void generatePermutation(){
		for(int i = 1; i <= 10; i++){
			myList.clear();
	    	refill();
	    	z = 10;	
		    for(int j = 0; j < 10; j++){
		    	count = r.nextInt(z);
		    	z--;
		    	num = temp.get(count);
		    	myList.add(num);
		    	temp.remove(count);
    		}
    		System.out.println("List " + i + ": " + myList);
		}
    }
    
    // Returns an ArrayList of Integers that are a permutation of the numbers 1-10
    public ArrayList<Integer> nextPermutation(){
    	return myList;
    }
    
    private void refill(){
    	for(int i = 1; i <= 10; i++)
	    	temp.add(i);
    }
}

class Driver{
	public static void main(String[] args){
		Permutations p = new Permutations();
		System.out.println("Random Permutation List Generator\n");
		p.generatePermutation();
	}
}