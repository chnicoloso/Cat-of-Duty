/* Ruijing Li
 * Period 3
 * 11/8/13
 * Time Spent: 1 hour 15 minutes
 * I actually struggled with this lab, mainly with drawing the polygon. 
 * Drawing the polygon shape was quite easy, but I had a really hard time
 * centering the polygon, especially using the radius of circumscribed circle.
 * Other than that, everything else in the lab was understandable.
 */

import gpdraw.*;

class GraphicPolygon extends RegularPolygon{
  private DrawingTool pen = new DrawingTool(new SketchPad(400, 400));
  private double xPosition, yPosition;

  // constructors

  // Initializes a polygon of numSides sides and sideLength
  // length in the superclass. The polygon is centered at
  // xPosition = yPosition = 0
  public GraphicPolygon(int numSides, double sideLength){
  	super(numSides, sideLength);
  	xPosition = 0;
  	yPosition = 0;
  }

  // Initializes a polygon of numSides sides and sideLength
  // length in the superclass. The polygon is centered at
  // xPosition = x and yPosition = y
  public GraphicPolygon(int numSides, double sideLength, double x, double y){
  	super(numSides, sideLength);
  	xPosition = x;
  	yPosition = y;
  }

  // public methods

  // Sets xPosition = x and yPosition = y to correspond to the new
  // center of the polygon
  public void moveTo(double x, double y){
  	pen.up();
  	pen.move(x, y);
  }

  // Draws the polygon about the center point (xPosition, yPosition).
  // Uses properties inherited from RegularPolygon to determine the
  // number and length of the sides, the radius of the inscribed circle,
  // and the vertex angle with which to draw the polygon
  public void draw(){
  	moveTo(xPosition, yPosition);
  	pen.setDirection(0);
  	pen.forward(getR());
  	pen.down();
 	pen.turnLeft(vertexAngle()- vertexAngle()/4 - 5);
 	
  	for(int i = 0; i < getNumSide(); i++){
  		pen.forward(getSideLength());
  		pen.turnLeft(180 - vertexAngle());
  	}
  }
}

class Driver{
	public static void main(String[] args){
		GraphicPolygon gPoly = new GraphicPolygon(9, 100);
		gPoly.draw();
	}
}