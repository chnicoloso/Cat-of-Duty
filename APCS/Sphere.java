/* Ruijing Li
 * Period 3
 * 9/5/13
 * Time Spent: 25-30 minutes
 * The most important lesson I learned from this lab is to never
 * start any comp sci homework late at night. I took super long
 * because my mind was all fuzzy. Some errors I had was not even
 * adding a main method and making drawingtool and sketchpad local.
 * Other than that, the lab was mostly what we learned in class today.
 */ 

import gpdraw.*;
import java.awt.Color;

public class Sphere {
	private int radius;
	private String name;
	private Color color;
	private boolean isAwesome;
	public DrawingTool pen;
	public SketchPad pad;

    public Sphere(int r, Color c, String n, boolean a) {
    	pad = new SketchPad(500,500);
    	pen = new DrawingTool(pad);
    	radius = r;
    	color = c;
    	name = n;
    	isAwesome = a;
    }
    
    public boolean checkAwesome(){
    	return isAwesome;
    } 
    
    public void setColor(){
    	pen.setColor(color);
    }	
    
    public void changeName(String newName){
    	name = newName;
    }
    
    public String getName(){
    	return name;
    }
    
    public void draw(){
    	pen.drawCircle(radius);
    	pen.drawOval(2*radius, radius/2);
    }
}

class Driver{
	public static void main(String[] args){
		Sphere s = new Sphere(100, Color.blue, "Crasy", true);
		System.out.println("The sphere is awesome: " + s.checkAwesome());
		s.setColor();
		System.out.println("The sphere is named: " + s.getName());
		s.changeName("NCrasy");
		System.out.println("The sphere is named: " + s.getName());
		s.draw();
	}
}

/* Output

The sphere is awesome: true
The sphere is named: Crasy
The sphere is named: NCrasy
Press any key to continue...
*/