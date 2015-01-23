/* Ruijing Li
 * Period 3
 * 1/15/14
 * Time Spent: 3 hours
 * This lab took me quite a while. Merge was extremely hard
 * to code, due to having only one arraylist to manipulate.
 * Not sure if my merge method is completely correct either.
 */

import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Ruijing Li
 * @created    Jan 12, 2014
 */
public class Sorts{
  private long steps;

  /**
   *  Description of Constructor
   *
   * @param  steps  Number of steps to run the method
   */
  public Sorts(){
    steps = 0;
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void bubbleSort(ArrayList <Comparable> list){
	//replace these lines with your code
	steps += 4;
	for(int i = 0; i < list.size()-1; i++){
		steps += 4;
		for(int j = list.size()-1; j > i; j--){
			steps += 5;
			if(list.get(j).compareTo(list.get(j-1)) > 0){
				steps += 2;
				swap(j, j-1, list);
			}
			steps += 2;
		}
		steps += 4;
	}
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(ArrayList <Comparable> list){
	//replace these lines with your code
	steps += 4;
	for(int i = list.size() - 1; i > 0; i--){
		steps++;
		int index = 0;
		steps += 2;
		for(int j = 1; j <= i; j++){
			steps += 4;
			if(list.get(index).compareTo(list.get(j)) < 0){
				steps++;
				index = j;
			}
			steps += 2;
		}
		steps++;
		swap(i, index, list);
		steps += 2;
	}
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void insertionSort(ArrayList <Comparable> list){
	//replace these lines with your code
	steps += 3;
	for(int i = 1; i < list.size(); i++){
		steps++;
		int position = i;
		steps += 2;
		Comparable temp = list.get(position);
		steps += 5;
		while(position > 0 && list.get(position-1).compareTo(temp) < 0){
			steps += 3;
			list.set(position, list.get(position-1));
			steps++;
			position--;
		}
		steps++;
		list.set(position, temp);
		steps += 3;
	}
  }

 /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
  private void merge(ArrayList <Comparable> a, int first, int mid, int last){
	//replace these lines with your code
	steps += 2;
	int i = first;
	int j = mid;
	steps += 2;
	while(i <= mid && j <= last){
		steps += 4;
		if(a.get(i).compareTo(a.get(j)) < 0){
			i++;
		}else if(a.get(i).compareTo(a.get(j)) >= 0){
			steps += 4;
			steps += 2;
			a.add(i, a.get(j));
			steps += 3;
			i++;
			j++;
			a.remove(j);
		}
		steps += 2;
	}
  }

  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(ArrayList <Comparable> a, int first, int last){
  	System.out.println("first: " + first + " is " + a.get(first));
  	System.out.println("last: " + last + " is " + a.get(last));
  	
	//replace these lines with your code
	steps += 2;
    if (last - first < 1){
      //do nothing
      ;
    }else if (last - first < 2){
   	  steps += 2;
      //sort it if necessary
      steps += 4;
      if(a.get(first).compareTo(a.get(last)) > 0){
		steps++;    
      	swap(first, last, a);
      }
    }else{ // recursion, divide list into two halves
      //Find midpoint of current sublist
      steps += 3;
      int mid = (first + last) / 2;
      //Call mergeSort and process left sublist
      steps++;
      mergeSort(a, first, mid);
      //Call mergeSort and process right sublist
      steps += 2;
      mergeSort(a, mid+1, last);
      //merge left and right sublists
      steps++;
      merge(a, first, mid, last);
   } 
  }
 
  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount(){
    return steps;
  }
  
  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(long stepCount){
    steps = stepCount;
  }
  
   /**
   *  Interchanges two elements in an ArrayList
   *
   * @param  list  reference to an array of integers
   * @param  indexA     index of integer to be swapped
   * @param  indexB     index of integer to be swapped
   */
  public void swap(int indexA, int indexB, ArrayList<Comparable> list){
  		steps += 5;
		Comparable temp = list.get(indexB);
		list.set(indexB, list.get(indexA));
		list.set(indexA, temp);
	}
}
