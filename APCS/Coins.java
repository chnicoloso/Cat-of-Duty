/* Ruijing Li
 * Period 3
 * 9/3/13
 * Time Spent: 15-20 minutes
 * The program was similiar to the Easter Lab. The hardest
 * part of the lab was coming up with a way to solve the math.
 * At first I thought about using if statements but then I thought
 * that there would be an even simplier way of doing it. Of course
 * that way is to use integer division and modulus to get the coins.
 * This lab was a bit more challenging but still straightforward.
*/

public class Coins{
	int c;
	
	public Coins(int coins){
		c = coins;
	}
	
	public void calculate(){
		System.out.println(c + " cents =>");
		int q = c / 25;
		System.out.println("Quarter(s)    " + q);
		int r = c % 25;
		int d = r / 10;
		System.out.println("Dime(s)       " + d);
		r = r % 10;
		int n = r / 5;
		System.out.println("Nickel(s)     " + n);
		r %= 5;
		System.out.println("Penny(s)      " + r);
	}
}

/*
94 cents =>
Quarter(s)    3
Dime(s)       1
Nickel(s)     1
Penny(s)      4
Press any key to continue...


59 cents =>
Quarter(s)    2
Dime(s)       0
Nickel(s)     1
Penny(s)      4
Press any key to continue...


19 cents =>
Quarter(s)    0
Dime(s)       1
Nickel(s)     1
Penny(s)      4
Press any key to continue...
*/