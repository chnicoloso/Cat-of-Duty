/**
 * @(#)DrawSquare.java
 *
 *
 * @author 
 * @version 1.00 2013/8/20
 */
import gpdraw.*;

public class DrawSquare {
	private DrawingTool myPencil;
	private SketchPad myPaper;

    public DrawSquare() {
    	myPaper = new SketchPad(300,300);
    	myPencil = new DrawingTool(myPaper);
    }
    
    public void draw(){
    	myPencil.forward(100);
    	myPencil.turnLeft();
    	myPencil.forward(100);
    	myPencil.turnLeft();
    	myPencil.forward(100);
    	myPencil.turnLeft();
    	myPencil.forward(100);
    	myPencil.move(-50,-50);
    }
    
    
}