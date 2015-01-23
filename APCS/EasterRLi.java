/* Ruijing Li
 * Period 3
 * 8/30/13
 * Time Spent: 10 min
 * This lab was a piece of cake. It felt like a simple review lab to check if 
 * we either read lesson 3 or paid attention in class. Since I read, I didn't 
 * struggle with anything in the code.
*/
public class EasterRLi {
  
     private int y;

     public EasterRLi(int year) {     
          y = year;
     }

     public void calculate() {
          int a = y % 19;
          System.out.println("a = " + a);
          int b = y / 100;
          System.out.println("b = " + b);
          int c = y % 100;
          System.out.println("c = " + c);
          int d = b / 4;
          System.out.println("d = " + d);
          int e = b % 4;
          int f = (b + 8) / 25;
          int g = (b-1+f) / 3;
          int h = (19*a+b-d-g+15) % 30;
          int i = c / 4;
          int k = c % 4;
          int r = (32+2*e+2*i-h-k) % 7;
          int m = (a+11*h+22*r) / 451;
          int n = (h+r-7*m+114) / 31;
          int p = (h+r-7*m+114) % 31;
          System.out.println("e = " + e);
          System.out.println("f = " + f);
          System.out.println("g = " + g);
          System.out.println("h = " + h);
          System.out.println("i = " + i);
          System.out.println("k = " + k);
          System.out.println("r = " + r);
          System.out.println("m = " + m);
          System.out.println("n = " + n);
          System.out.println("p = " + p);
          System.out.println("\nEaster in " + y + " falls on " + n + "/" + (p+1));
     }
}