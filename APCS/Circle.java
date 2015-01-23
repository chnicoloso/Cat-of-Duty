import gpdraw.*;

public class Circle {
	private double myX;
	private double myY;
	private double radius;
	private DrawingTool pen;

    public Circle(SketchPad pad) {
    	myX = 0;
    	myY = 0;
    	radius = 0;
    	pen = new DrawingTool(pad);
    }
    
    public Circle(double x, double y, double r, SketchPad pad){
    	myX = x;
    	myY = y;
    	radius = r;
    	pen = new DrawingTool(pad);
    }
    
    public double getCircumference(){
    	return (2*radius*3.14);
    } 
    
    public double getArea(){
    	return (radius*radius*3.14);
    }
    
    public void draw(){
    	pen.up();
    	pen.move(myX, myY);
    	pen.setDirection(90);
    	pen.down();
    	pen.drawCircle(radius);
    }
}