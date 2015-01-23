/* Ruijing Li
 * 10/7/13
 * Period 3
 * Time Spent: 20 minutes
 * This lab was really easy because Ferrante showed us the
 * logic behind the lab. The only thing that gave me 
 * trouble was figuring out how to draw the snowflake, but
 * otherwise I had no difficulty. If I had more time I 
 * would draw the Koch Antisnowflake.
 */

import gpdraw.*;

public class KochCurve {
	DrawingTool pen;
	SketchPad pad;

    public KochCurve() {
    	pad = new SketchPad(500,500);
    	pen = new DrawingTool(pad);
    }
    
    public void drawKochSnowflake(){
    	pen.setDirection(0);
    	for(int i = 0; i < 3; i++){
    		drawKochCurve(6,300);
    		pen.turnRight(120);
    	}
    	
    }
    
    public void drawKochCurve(int level, double length){
    	if(level<1)
    		pen.forward(length);
    	else{
    		drawKochCurve(level-1, length/3.0);
    		pen.turnLeft(60);
    		drawKochCurve(level-1, length/3.0);
    		pen.turnRight(120);
    		drawKochCurve(level-1, length/3.0);
    		pen.turnLeft(60);
    		drawKochCurve(level-1, length/3.0);
    	}
    }
}