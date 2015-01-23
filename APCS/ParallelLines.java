/* Ruijing Li
 * Period 3
 * 11/13/13
 * Time Spent: 1 hour
 * This lab was a more challenging lab, but at the 
 * same time it was not as hard as I first thought
 * it to be. The comments at first confused me, but
 * thinking it over they guided what I had to code 
 * in order to create the illusion. I did the illusion
 * using nested for loops and offsets.
 */

import gpdraw.*;

public class ParallelLines {
	SketchPad pad;
	DrawingTool pen;
	double myX;
	double myY;

    public ParallelLines() {
    	pad = new SketchPad(500,500);
    	pen = new DrawingTool(pad);
    	
    }
    
    public void drawIllusion(double sideLength){
    	pen.setDirection(0);
    	pen.up();
    	pen.move(-300, 200);
    	myX = pen.getXPos();
    	pen.down();
    	
    	
    	for (int row = 0; row < 8; row++){
  			// calculate the start of the row of squares
  			myY = pen.getYPos();
  			pen.up();
  			pen.move(myX, myY);
  			pen.setDirection(270);
  			pen.forward(sideLength/2);
  			pen.setDirection(0);
  		
  			// calculate and add a horizontal offset
  			if(row % 4 == 1)
  				pen.forward(sideLength/2);
  			else if(row % 4 == 2)
  				pen.forward(sideLength);
  			else if(row % 4 == 3)
  				pen.forward(sideLength/2);
  			else
  				pen.forward(0);
  				
  			pen.down();

  			for (int col = 0; col < 7; col++){
  				// draw the square
  				pen.fillRect(sideLength, sideLength);
  			
  				// calculate and position for the next square
  				pen.up();
  				pen.forward(2*sideLength);
  				pen.down();
  			}

	 		 // calculate the location and draw the line
	 		 pen.setDirection(270);
	 		 pen.up();
	 		 pen.forward(sideLength/2);
	 		 pen.down();
	 		 pen.setDirection(0);
	 		 pen.move(myX-sideLength/2, myY - sideLength);
		}	
    }
    
}

class Driver{
	public static void main(String args[]){
	
		ParallelLines p = new ParallelLines();
		p.drawIllusion(40);
	}
}