/* Ruijing Li
 * Period 3
 * 11/10/13
 * Time Spent: 1 hour
 * For this Art show, I decided to utlize a for loop that would
 * draw 4 of my basic fractals at 4 randomly chosen spots, but
 * these spots would be close enough that each fractal would 
 * connect with the other. I also had it alternate left and right
 * so it would look cooler. Finally I put a pink background on
 * top of it.
 */ 

import gpdraw.*;
import java.util.Scanner;
import java.awt.Color;

public class MyFractalRLi {

	// Attributes
	SketchPad pad;
	DrawingTool pen;
	double r;
	int count;
	int sign;
	Color randc;

	// Constructor
	public MyFractalRLi() {
		pad = new SketchPad(400, 500);
		pen = new DrawingTool(pad);
		r = 1 / Math.sqrt(2);
		count = 0; 
		sign = 1;
		pen.setDirection(0);
	}
	
	// new code to combine 4 fractals together and present in art show
	public void draw(int level, double length, Color c){
		pen.setDirection(90);
		pen.setColor(c);
		pen.fillRect(1600, 2000);
		pen.up();
		pen.backward(200);
		pen.down();
		pen.setDirection(0);
		for(int i = 0; i < 4; i++){
			drawFractal(level, length, c);
			if(i % 2 == 0)
				pen.turnLeft(90);
			else
				pen.turnRight(90);
				
			pen.up();
			pen.move(length/5*Math.random()+1, length/5*Math.random()+1);
			pen.down();	
		}
	}

	public void drawFractal(int level, double length, Color c) {

		// Base case:  Draw an Line
		if (level == 0) {
			pen.setColor(c);
			pen.forward(length);    
		}
		
		//recursive case
		else {
			int red = (int)(255*Math.random());
			int green = (int)(255*Math.random());
			int blue = (int)(255*Math.random());
			randc = new Color(red, green, blue);
			
			if(count % 2 == 0)
				pen.turnLeft(45);
			else
				pen.turnRight(45);
				
			double dir = pen.getDirection();	
			drawFractal(level-1, length*r, randc);		
			pen.setDirection(dir*sign);
			count++;
			
			if(count % 2 == 1)
				pen.turnRight(90);
			else 
				pen.turnLeft(90);
				
			drawFractal(level-1, length*r, randc);
			count++;
		}
	}

	public static void main(String[] args) {
		int red = (int)(255*Math.random());
		int green = (int)(255*Math.random());
		int blue = (int)(255*Math.random());
		Color randc = new Color(red, green, blue);
		Scanner keyboard = new Scanner(System.in);
		int level;
		double length;
		
		MyFractalRLi fractal = new MyFractalRLi();
		
		System.out.println("Enter a level for the fractal (Recommended 15-18) ");
		level = keyboard.nextInt();
		System.out.println("Enter the length for the fractal (Recommended 200-400) ");
		length = keyboard.nextDouble();
		fractal.draw(level, length, randc);
	}	
}