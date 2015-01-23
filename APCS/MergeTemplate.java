/* Ruijing Li
 * Period 3
 * 1/13/14
 * Time Spent: 30 minuters
 * I found the merge algorithm was easier to do using all while
 * loops rather than using double for loops. Also for screen 
 * output I found the console can't hold more than 10 columns
 * with tabs between. The biggest mistake I made before 
 * I caught it was forgetting to put else so that it doesn't
 * need to check again. 
 */

import java.util.*;

public class MergeTemplate {
 
	/**
	*  Sorts any ArrayList of Comparable objects using Selection Sort.
	*
	* @param  list  reference to an array of integers to be sorted
	*/
	public void selectionSort(ArrayList <Comparable> list) {
		for(int i = list.size() - 1; i > 0; i--){
			int index = 0;
			for(int j = 1; j <= i; j++){
				if(list.get(index).compareTo(list.get(j)) < 0)
					index = j;
			}
			swap(i, index, list);
		}
	}
 
	/**
	 *  Write a merge method to merge two sorted lists.
	 *
	 *  Preconditions: Lists A and B are sorted in nondecreasing order.
	 *  Action:        Lists A and B are merged into one list, C.
	 *  Postcondition: List C contains all the values from
	 *                 Lists A and B, in nondecreasing order.
	 */
/*	public void merge (ArrayList <Comparable> a, ArrayList <Comparable> b, ArrayList <Comparable> c) {
		int i = 0;
		int j = 0;
		while(i < a.size() && j < b.size()){
			if(a.get(i).compareTo(b.get(j)) < 0){
				c.add(a.get(i));
				i++;
			}
			else if(a.get(i).compareTo(b.get(j)) >= 0){
				c.add(b.get(j));
				j++;
			}
		}
		
		if(i >= a.size()){
			while(j < b.size()){
				c.add(b.get(j));
				j++;
			}
		}
		
		else if(j >= b.size()){
			while(i < a.size()){
				c.add(a.get(i));
				i++;
			}
		}
	}*/
	
	public void merge(ArrayList <Comparable> a, int first, int mid, int last){
	//replace these lines with your code
	//steps += 2;
	int i = first;
	int j = mid;
//	steps += 2;
	while(i <= mid && j <= last){
	//	steps += 4;
		if(a.get(i).compareTo(a.get(j)) < 0){
			i++;
		}else if(a.get(i).compareTo(a.get(j)) >= 0){
		//	steps += 4;
		//	steps += 2;
			a.add(i, a.get(j));
		//	steps += 3;
			i++;
			j++;
			a.remove(j);
		}
		//steps += 2;
	}
  }

	/**
	*  Write a method to
	*    - Ask the user how many numbers to generate
	*    - Ask the user to enter the largest integer to generate
	*    - Initialize an ArrayList of random Integers from 1 to largestInt
	*	- Return the ArrayList
	*
	* @return  an ArrayList of size specified by the user filled
	*          with random numbers
	*/
	public ArrayList <Comparable> fillArray() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter how many numbers you wish to generate: ");
		int num = in.nextInt();
		System.out.print("Please enter largest integer you wish to generate: ");
		int large = in.nextInt();
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		Random r = new Random();
		for(int i = 0; i < num; i++)
			list.add(r.nextInt(large) + 1);
			
		return list;
	}

	/**
	*  Write a method to print out the contents of the ArrayList
	*  in tabular form, 20 columns.  You can use the \t escape character
	*  or use printf to format using fields.
	*/
	public void screenOutput(ArrayList <Comparable> temp) {
		for(int i = 0; i < temp.size(); i++){
			if(i % 20 == 0)
				System.out.println();
			
			System.out.print(temp.get(i) + "\t");
		}
	}
	
	private void swap(int indexA, int indexB, ArrayList<Comparable> list){
		Comparable temp = list.get(indexB);
		list.set(indexB, list.get(indexA));
		list.set(indexA, temp);
	}
}

