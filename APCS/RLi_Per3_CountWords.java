/* Ruijing Li
 * Period 3
 * 1/22/14
 * Time Spent: 4 hours 
 * I found the parsing in this lab easier than I expected with StringTokenizer and checking for special cases.
 * Unfortunately, I struggled with trying to find multiple instances of a word. I ended up not using a search 
 * function to complete it but instead went through the loop and counted the instances of the same word until it 
 * hit a new word, then repeat for that word. I used the idea of creating a new word class called WordToken which
 * would store the word and the number of times it appears as an object. The rest of the lab was pretty straightforward,
 * stuff covered in the previous Store lab.
 */

import java.util.*;
import java.io.*;

public class RLi_Per3_CountWords  {
	ArrayList<String> a = new ArrayList<String>();
	ArrayList<WordToken> b = new ArrayList<WordToken>();
	String str = "";

    public RLi_Per3_CountWords() {
    }

    public void parse(String fileName){
    	try{
    		Scanner in = new Scanner(new File(fileName));
    		while(in.hasNext())
    			str += in.nextLine() + "\r\n";

    		StringTokenizer st = new StringTokenizer(str);
    		while (st.hasMoreTokens()) {
         		String result = checkWord(st.nextToken());
         		if(result.length() > 0)
         			a.add(result.toLowerCase());
     		}
    	}
    	catch(IOException e){
    		System.out.println(e.getMessage());
    	}
    }

    private String checkWord(String str){
    	String result = "";
    	for(int i = 0; i < str.length(); i++){
    		if(Character.isLetter(str.charAt(i)))
    			result += str.charAt(i);
    		else{
    			if(str.length() > 1){
	    			if(str.charAt(i) == '-' || str.charAt(i) == '\'')
	    				result += str.charAt(i);
    			}
    		}
    	}
    	return result;
    }
    
    public void count(){
    	bubbleSortStr(a);
    	WordToken w = new WordToken(a.get(0), 0);
    	for(int i = 0; i < a.size(); i++){
    		if(w.getToken().equals(a.get(i)))
    			w.addFrequency();
    		else{
 				b.add(w);
    			w = new WordToken(a.get(i), 1);
    		}
    	}
    	bubbleSortWord(b);
    }
    
    public void displayNum(){
    	System.out.println("Top 30 words used\n");
    	for(int i = 0; i < 30; i++)
    		System.out.printf("%5d %5d    %-5s\n", i+1, b.get(i).getCount(), b.get(i).getToken());
    		
    	System.out.println("\nNumber of unique words used = " + (b.size() + 1));
    	System.out.println("Total # of words = " + a.size());
    }	
    
    public void bubbleSortStr(ArrayList <String> list){
		for(int i = 0; i < list.size()-1; i++){
			for(int j = list.size()-1; j > i; j--){
				if(list.get(j).compareTo(list.get(j-1)) < 0){
					swapStr(j, j-1, list);
				}
			}
		}
    }
    
    public void swapStr(int indexA, int indexB, ArrayList<String> list){
		String temp = list.get(indexB);
		list.set(indexB, list.get(indexA));
		list.set(indexA, temp);
	}
	
	public void bubbleSortWord(ArrayList <WordToken> list){
		for(int i = 0; i < list.size()-1; i++){
			for(int j = list.size()-1; j > i; j--){
				if(list.get(j).compareTo(list.get(j-1)) > 0){
					swapWord(j, j-1, list);
				}
			}
		}
    }
    
    public void swapWord(int indexA, int indexB, ArrayList<WordToken> list){
		WordToken temp = list.get(indexB);
		list.set(indexB, list.get(indexA));
		list.set(indexA, temp);
	}

}

class Driver{
	public static void main(String[] args){
		CountWords c = new CountWords();
		c.parse("dream.txt");
		c.count();
		c.displayNum();
	}
}