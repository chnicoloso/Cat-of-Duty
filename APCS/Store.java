/* Ruijing Li
 * Period 3
 * 1/18/14
 * Time Spent: 1 hour
 * This lab was easier than expected, and I think I grasped
 * the concept of binary search after reading the lesson.
 * I also revised my store class to print out the blank spaces
 * for each 10 items in the store that I forgot to do.
 * The code for the new lab is on the front with the old store
 * code below it.
 */

import java.util.*;
import java.io.*;

public class Store{
  private ArrayList <Item> myStore = new ArrayList <Item>();

  // Creates a Store object from data stored in the given file name
  public Store(String fName){
  	 loadFile(fName); 
  }
  
  public void testSearch(){
	   int idToFind;
	   int invReturn;
	   int index;
	   Scanner in = new Scanner(System.in);
	
	   System.out.println("Testing search algorithm\n");
	   do{
	      System.out.println();
	      System.out.print("Enter Id value to search for (-1 to quit) ---> ");
	      idToFind = in.nextInt();
	      //index = bsearch(new Item(idToFind, 0));
	      //recursive version call
	      index = bsearch (new Item(idToFind, 0), 0, myStore.size()-1);
	      System.out.print("Id # " + idToFind);
	      if (index == -1){
	         System.out.println(" No such part in stock");
	      }else{
	         System.out.println(" Inventory = " + myStore.get(index).getInv());
	      }
	   } while (idToFind >= 0);
	}

	/**
	   * Searches the myStore ArrayList of Item Objects for the specified
	   * item object using a iterative binary search algorithm
	   *
	   * @param idToSearch Item object containing id value being searched for
	   * @return index of Item if found, -1 if not found
	*/
	private int bsearch(Item idToSearch){
		int first = 0;
		int last = myStore.size();
		while(first <= last){
			int mid = (first+last)/2;
			if(idToSearch.equals(myStore.get(mid))){
				return mid;
			}else{
				if(last-first == 1)
					break;
					
				if(idToSearch.compareTo(myStore.get(mid)) < 0)
					last = mid;
				else
					first = mid;
			}
		}
	    return -1;
	}
	
	/**
	* Searches the specified ArrayList of Item Objects for the specified
	   * id using a recursive binary search algorithm
	   *
	   * @param idToSearch Id value being search for
	   * @param first Starting index of search range
	   * @param last Ending index of search range
	   * @return index of Item if found, -1 if not found
	*/
	private int bsearch(Item idToSearch, int first, int last){
		int mid = (first+last)/2;
	    if(idToSearch.equals(myStore.get(mid)))
	    	return mid;
	    else if(last- first == 0)
	    	return -1;
	    else{
	    	mid = (first+last)/2;
	    	if(idToSearch.compareTo(myStore.get(mid)) < 0)
	    		return bsearch(idToSearch, first, mid);
	    	else
	    		return bsearch(idToSearch, mid+1, last);
	   	}
	}
	

  // Populates the ArrayList with items stored in the given text file
  private void loadFile(String inFileName){
  	try{
	  	Scanner in = new Scanner(new File(inFileName));
	  	while(in.hasNext()){
	  		Item i = new Item(in.nextInt(), in.nextInt());
	  		myStore.add(i);
	  	} 
  	}catch(FileNotFoundException e){
  		System.out.println(e.getMessage());
  	}
  }

  // Prints the store contents in the format shown below
  // Line #   	 Id	     	 Inv
  // 1	       	184	    	 14
  // 2	       	196	    	 60
  public void displayStore(){
  	System.out.printf("%-5s %5s %8s\n", "Line #", "Id", "Inv");
  	for(int i = 0; i < myStore.size(); i++){
  		Item obj = myStore.get(i);
  		System.out.printf("%-5d  %5d%8d\n", i+1, obj.getId(), 
  						  obj.getInv());
  		if((i+1) % 10 == 0)
  			System.out.println();
  	}
  } 

  // Sorts the store ArrayList using bubble sort
  public void Sort(){
  	bubbleSort(myStore);
  } 

  private void bubbleSort(ArrayList <Item> list){
	//replace these lines with your code
	for(int i = 0; i < list.size()-1; i++){
		for(int j = list.size()-1; j > i; j--){
			if(list.get(j).compareTo(list.get(j-1)) < 0){
				swap(j, j-1, list);
			}
		}
	}
  }
  
  private void swap(int indexA, int indexB, ArrayList<Item> list){
		Item temp = list.get(indexB);
		list.set(indexB, list.get(indexA));
		list.set(indexA, temp);
  }	  
}

class Driver{
	public static void main(String[] args){
		Store s = new Store("file50.txt");
		s.Sort();
		s.displayStore();
		s.testSearch();
	}
}