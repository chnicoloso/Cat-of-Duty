/* Ruijing Li
 * 9/9/13
 * Period 3
 * Time Spent: 1 hour
 * This lab wasn't hard but the directions seemed unclear 
 * to me and what I was exactly supposed to do. The hardest 
 * part was figuring out what to do in my driver class and 
 * also how to adjust the coordinates of the rectangle so that
 * x would be the left edge and y at the bottom edge.
 */

import gpdraw.*;

public class Rectangle{
	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private DrawingTool pen;

	
	public Rectangle(SketchPad pad){
		myX = 0;
		myY = 0;
		myWidth = 0;
		myHeight = 0;
		pen = new DrawingTool(pad);
	}
	
	public Rectangle(double x, double y, double width, double height, SketchPad pad){
		myX = x;
		myY = y;
		myWidth = width;
		myHeight = height;
		pen = new DrawingTool(pad);
	}
	
	public double getPerimeter(){
		return (2*myWidth + 2*myHeight);
	}
	
	public double getArea(){
		return (myWidth*myHeight);
	}
	
	public void draw(){
		pen.up();
		pen.move(myX+myWidth/2, myY+myHeight/2);
		pen.setDirection(90);
		pen.down();
		pen.drawRect(myWidth, myHeight);
	}
}