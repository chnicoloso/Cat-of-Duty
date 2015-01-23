/* Ruijing Li
 * 10/30/13
 * Period 3
 * Time Spent: 35 minutes
 * The hardest part of the lab, or of any lab, is trying to 
 * figure out what is asked of you and how to use the 
 * techniques you learned to solve the lab. For me, it
 * was figuring out how to count the letter grades in the input
 * by the user and then evaluate it based on that.
 */

import java.util.Scanner;

public class Grades {
	double gpa;
	String grades;
	int aCount = 0;
	int bCount = 0;
	int cCount = 0;
	int dCount = 0;
	int fCount = 0;
	int classCount = 0;

    public Grades(String result) {
    	grades = result;
    }
    
    public void calcGPA(){
    	grades = grades.toUpperCase();
    	for(int i = 0; i < grades.length(); i++){
    		if(grades.charAt(i) == 'A'){
    			aCount++;
    			classCount++;
    		}
    		else if(grades.charAt(i) == 'B'){
    			bCount++;
    			classCount++;
    		}
    		else if(grades.charAt(i) == 'C'){
    			cCount++;
    			classCount++;
    		}
    		else if(grades.charAt(i) == 'D'){
    			dCount++;
    			classCount++;
    		}
    		else if(grades.charAt(i) == 'F'){
    			fCount++;
    			classCount++;
    		}
    	}
    	gpa = (aCount*4.0 + bCount*3.0 + cCount*2.0 + dCount*1.0 + fCount*0) / (aCount+bCount+cCount+dCount+fCount);
    	System.out.print("GPA = " + gpa + "    ");
    		
    	if(classCount >= 4){
    		if(gpa >= 2.0){
    			if(fCount == 0)
    				System.out.println("Eligible");
    			else
    				System.out.println("Ineligible, gpa above 2.0 but has F grade");
    		}
    		else if(gpa < 2.0 && fCount > 0)
    			System.out.println("Ineligible, gpa below 2.0 and has F grade");
    		else
    			System.out.println("Ineligible, gpa below 2.0");
    	}
    	else
    		System.out.println("Ineligible, taking less than 4 classes");
    }
}

class Driver{
	public static void main(String[] args){
		String result = "";
		String temp = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Please enter the grades of your classes ");
		while(true){
			temp = keyboard.nextLine();
			temp = temp.toUpperCase();
			if(temp.contains("A") || temp.contains("B") || temp.contains("C") 
				|| temp.contains("D") || temp.contains("F"))
					result += temp;
			else 
				break;
		}
		Grades g = new Grades(result);
		g.calcGPA();
	}
}