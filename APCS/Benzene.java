/* Ruijing Li
 * 8/25/13
 * Period 3
 * Time Spent: 2 hours 30 minutes
 * This challenge lab was difficult. At first I managed to get the circles
 * drawn. When I thought about doing the loop from drawing the circle and 
 * then bonds, this lab seemed impossible. Then I did the basic lab in 10
 * minutes and from it, I gained the idea that I should first draw the hexagon
 * and then in the loop draw the circles. With that all I had to do was change
 * the numbers and the problem became simple. I spent most of my time thinking
 * of the logic and then coding. I also should have commented my ideas cause 
 * sometimes I lost track of what one part of my function does. All in all, 
 * this challenge lab was not easy, but I am glad I completed it. 
 * P.S. What is gradient shading? I tried googling it but got more confused. 
*/
import gpdraw.*;
import java.awt.Color;

public class Benzene {
	DrawingTool pen;
	SketchPad paper;
	int x;
	double pos;
	
	public Benzene(){
		paper = new SketchPad(500, 500);
		pen = new DrawingTool(paper);
		x = 30;
	}
/*	
	public void drawBenzene(){
		pen.up();
    	pen.move(100);
    	pen.down();
    	pen.turnRight(120);
    	for(int i = 0; i < 6; i++){
    		if(i % 2 == 0){
    			pen.up();
    			pen.turnLeft();
    			pen.move(5);
    			pen.turnRight();
    			pen.down();
    			pen.move(100);
    			pen.up();
    			pen.turn(180);
    			pen.move(100);
    			pen.turnLeft();
    			pen.move(10);
    			pen.turnLeft();
    			pen.down();
    			pen.move(100);
    			pen.up();
    			pen.turn(180);
    			pen.move(100);
    			pen.turnRight();
    			pen.move(5);
    			pen.turnRight();
    			pen.move(100);
    			pen.down();	
    		}else
	    		pen.move(100);

    		drawCircle();
    		drawH();
    		pen.turnRight(60);
    		x -= 60;
    		pen.down();
		}
	}
	
	public void drawCircle(){
		pen.up();
		pen.move(30);
		pen.down();
		pen.drawCircle(30);
		pen.setColor(Color.lightGray);
		pen.fillCircle(29);
		pen.setColor(Color.black);
		pen.drawCircle(15);
		pen.setDirection(90);
		pen.turnRight();
		pen.up();
		pen.move(14);
		pen.down();
		pen.setColor(Color.lightGray);
		pen.fillCircle(15);
		pen.up();
		pen.turn(180);
		pen.move(14);
		//move up
		pen.setDirection(x);
		pen.move(30);
		pen.down();
	}
	
	public void drawH(){
		pen.setColor(Color.black);
		pen.move(50);
		pen.up();
		pen.move(15);
		pen.down();
		pen.setDirection(90);
		pen.drawCircle(15);
		pen.setColor(Color.yellow);
		pen.fillCircle(14);
		pen.setColor(Color.black);
		//draw H
		pen.turnLeft();
		pen.move(7);
		pen.turnRight();
		pen.move(7);
		pen.turn(180);
		pen.move(14);
		pen.up();
		pen.turn(180);
		pen.move(7);
		pen.turnRight();
		pen.down();
		pen.move(13);
		pen.turnLeft();
		pen.move(7);
		pen.turn(180);
		pen.move(14);
		pen.up();
		pen.turn(180);
		pen.move(7);
		//back to center of circle
		pen.turnLeft();
		pen.move(7);
		//go back
		pen.setDirection(x);
		pen.turn(180);
		pen.move(125);
		pen.turn(120);
		pen.move(30);	
	}
*/

	public void test(){
		pen.turnRight(30);
		pen.move(50);
		pen.turnRight(120);
		pen.move(50);
		pen.turnRight(120);
		pen.move(50);
		
	}
}
    