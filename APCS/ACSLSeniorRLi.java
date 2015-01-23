/* Lab 12.8 ACSLLand - Senior Division
 * Ruijing Li
 * 11/17/13
 * Period 3
 * Time Spent: 1 day 5 hours
 * FINALLY DONE. This lab was one of the hardest labs
 * I had to finish. I started off well getting the 
 * input and output to print correctly, moving the
 * 3 players and coding for the special case 4. However,
 * the hardest part was definitely coding for the special case 6.
 * I had a lot of trouble solving it, but by using if statements, modulus,
 * and variables I solved it!
 */

import java.util.StringTokenizer;
import java.util.Scanner;

public class ACSLSeniorRLi {
	int aPos, bPos, cPos, end;

    public ACSLSeniorRLi() {
    	aPos = 0;
    	bPos = 0;
    	cPos = 0;
    	end = 0;
    }
    
    public void print(){
    	//Print final result of A
    	if (aPos <= 0){
    		System.out.print("A-START, ");
    	}
    	else if(aPos >= 30){
    		System.out.print("A-END, ");
    	}
    	else
    		System.out.print("A-" + aPos + ", ");
    		
    	//Print final result of B
    	if (bPos <= 0){
    		System.out.print("B-START, ");
    	}
    	else if(bPos >= 30){
    		System.out.print("B-END, ");
    	}
    	else
    		System.out.print("B-" + bPos + ", ");
    		
    	//Print final result of C
    	if (cPos <= 0){
    		System.out.println("C-START");
    	}
    	else if(cPos >= 30){
    		System.out.println("C-END");
    	}
    	else
    		System.out.println("C-" + cPos);
    }
    
    public void play(int turn, int move){
    	//To end the game
    	if(aPos >= 30)
    		end = 1;
    	if(bPos >= 30)
    		end = 1;
    	if(cPos >= 30)
    		end = 1;
    	
    	if(end != 1){	
	    	//add # to a	
	    	if(turn % 3 == 1){
	    		if(move == 4){
	    			aPos -= move;
	    		}
	    		else if(move == 6){
	    			;
	    		}
	    		else
	    			aPos += move;
	    		
	    		if(aPos == bPos){
	    			bPos = 0;
	    		}
	    		
	    		if(aPos == cPos){
	    			cPos = 0;
	    		}
	    	}
	    	//add # to b
	    	else if(turn % 3 == 2){
	    		if(move == 4){
	    			bPos -= move;
	    		}
	    		else if(move == 6){
	    			;
	    		}
	    		else	
	    			bPos += move;
	    		
	    		if(bPos == aPos){
	    			aPos = 0;
	    		}
	    		
	    		if(bPos == cPos){
	    			cPos = 0;
	    		}
	    	}
	    	//add # to c
	    	else{
	    		if(move == 4){
	    			cPos -= move;
	    		}
	    		else if(move == 6){
	    			;
	    		}
	    		else
	    			cPos += move;
	    		
	    		if(cPos == bPos){
	    			bPos = 0;
	    		}
	    		
	    		if(cPos == aPos){
	    			aPos = 0;
	    		}
	    	}
    	}
    }   
}

class Driver{
	public static void main(String[] args){
		//To catch inputs
		int counter;
		int skip = 0;
		int track = -1;
		String result = "";
		int num = 0;
		Scanner keyboard = new Scanner(System.in);
		ACSLSeniorRLi game;
		String in;
		StringTokenizer st;
		// for 5 inputs
		for(int i = 1; i <= 5; i++){ 
			//initialize
			game = new ACSLSeniorRLi();
			System.out.print("Line #" + i + ":  ");
			in = keyboard.nextLine();
			st = new StringTokenizer(in);
			counter = 0;
			
			while(st.hasMoreTokens()){
				result = st.nextToken(",");
				
				if(result.equals("0"))
					break;
				
				counter++;
				num = Integer.parseInt(result);
				
				// to skip a turn
				if(skip == 1){
					if(counter % 3 == track){
						counter++;
						skip = 0;
					}
				}		
				
				// if rolled a 6, set skip to 1 to begin skipping
				if(num == 6){
					skip = 1;
					track = counter % 3; 
				}
				
				game.play(counter, num);
			}
			System.out.printf("%58s", "Output #" + i + ":  ");
			game.print();
		}
	}
}