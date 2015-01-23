/* Ruijing Li
 * Period 3
 * 1/9/14
 * Time Spent: 10 minutes (computer only)
 * I managed to finish the lab quickly because I was just transferring
 * what I wrote on the handout to the computer. I spent a lot of time
 * working on insertion sort since the concept seemed a bit difficult
 * to understand. Luckily, I managed to figure it out. The rest were
 * pretty easy to understand since we went over them in great detail 
 * in class.
 */

import java.util.ArrayList;

public class Lab17_0 {

	public static void main(String[] args) {

		Lab17_0 lab = new Lab17_0();

		ArrayList <Comparable> list = lab.initializeList();

		System.out.println("Before Bubble Sort:");
		System.out.println(list);

		lab.bubbleSort(list);

		System.out.println("After Bubble Sort:");
		System.out.println(list);

		list = lab.initializeList();
		System.out.println("Before Selection Sort:");
		System.out.println(list);

		lab.selectionSort(list);

		System.out.println("After Selection Sort:");
		System.out.println(list);

		list = lab.initializeList();
		System.out.println("Before Insertion Sort:");
		System.out.println(list);

		lab.insertionSort(list);

		System.out.println("After Insertion Sort:");
		System.out.println(list);

	}

	/* Write code for a Bubble Sort algorithm that starts at the right side of
	 * of ArrayList of Comparable objects and "bubbles" the largest item to the
	 * left of the list.  The result should be an ArrayList arranged in descending
	 * order.
	*/
	void bubbleSort(ArrayList <Comparable> list) {
		for(int i = 0; i < list.size()-1; i++){
			for(int j = list.size()-1; j > i; j--){
				if(list.get(j).compareTo(list.get(j-1)) > 0)
					swap(j, j-1, list);
			}
		}
	}

	/* Write code for a Selection Sort algorithm that starts at the left side
	 * of an ArrayList of Comparable objects and searches through the list for
	 * the largest item and then swaps it with the last item in the list.  The
	 * "last item" then becomes the item to its left. The result should be
	 * an ArrayList arranged in ascending order.
	*/
	void selectionSort(ArrayList <Comparable> list) {
		for(int i = list.size() - 1; i > 0; i--){
			int index = 0;
			for(int j = 1; j <= i; j++){
				if(list.get(index).compareTo(list.get(j)) < 0)
					index = j;
			}
			swap(i, index, list);
		}
	}

	/* Write code for an Insertion Sort algorithm that starts at the left side
	 * of an ArrayList of Comparable objects and inserts the first item (in
	 * position 1) into it's correct place within the first two items...then
	 * inserts the third item into its correct place on the left, then the fourth
	 * item into its correct place on the left, etc, until the last item is
	 * inserted into the list.  Insert items so the result is an ArrayList arranged
	 * in descending order.
	*/
	void insertionSort(ArrayList <Comparable> list) {
		for(int i = 1; i < list.size(); i++){
			int position = i;
			Comparable temp = list.get(position);
			while(position > 0 && list.get(position-1).compareTo(temp) < 0){
				list.set(position, list.get(position-1));
				position--;
			}
			list.set(position, temp);
		}
	}
	
	private void swap(int indexA, int indexB, ArrayList<Comparable> list){
		Comparable temp = list.get(indexB);
		list.set(indexB, list.get(indexA));
		list.set(indexA, temp);
	}

	ArrayList <Comparable> initializeList() {

		String[] words = {"apple", "orange", "banana", "pear", "peach", "plum",
						  "grape", "cherry", "apricot", "strawberry"};

		ArrayList <Comparable> temp = new ArrayList<Comparable>();
		ArrayList <Comparable> list = new ArrayList<Comparable>();

		for (int i = 0; i < words.length; i++)
			temp.add(words[i]);

		list.clear(); // clear the list before adding to it

		while (temp.size() > 0) {
			list.add(temp.remove((int)(Math.random()*temp.size())));
		}

		return list;
	}

}