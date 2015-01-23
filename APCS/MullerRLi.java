/* Ruijing Li
 * 9/12/13
 * Period 3
 * Time Spent: 1 hour 45 minutes
 * This lab took a while to complete. Although none of the concepts applied were difficult,
 * it took a lot of planning to figure out and a lot of typing. The hardest part was probably
 * making the rays for the Ponzo illusion. I ran into several problems inclduing drawing too 
 * many lines or too little lines. Generalizing the code also took a long time to think about.
 * However, writing helper methods was easy, since I learned how to in Java.
 */

import gpdraw.*;

public class MullerRLi {
	DrawingTool pen;
	int bodyLength;
	int verticalDist;
	int arrowLength;
	int myAngle;

    public MullerRLi(int length, int distance, int arrow, int angle) {
    	pen = new DrawingTool(new SketchPad(500,500));
    	bodyLength = length;
    	verticalDist = distance;
    	arrowLength = arrow;
    	myAngle = angle;
    }
    
    public void draw(){
    	drawBody();
    	drawArrowOut();
    	pen.home();
    	pen.setDirection(180);
    	drawArrowOut();
    	moveTo();
    	drawBody();
    	drawArrowIn();
    	moveTo();
    	pen.setDirection(180);
    	drawArrowIn();
    	drawLine();
    }
    
    public void drawBody(){
    	pen.setDirection(0);
    	pen.move(bodyLength);
    }
    
    public void drawArrowOut(){
    	pen.turn(myAngle);
    	pen.move(arrowLength);
    	pen.up();
    	pen.turn(180);
    	pen.move(arrowLength);
    	pen.down();
    	pen.turn(180-myAngle*2);
    	pen.move(arrowLength);
    }
    
    public void moveTo(){
    	//moves to second arrow starting point
    	pen.home();
    	pen.up();
    	pen.move(verticalDist);
    	pen.down();
    }
    
    public void drawArrowIn(){
    	pen.turn(180-myAngle);
    	pen.move(arrowLength);
    	pen.up();
    	pen.turn(180);
    	pen.move(arrowLength);
    	pen.down();
    	pen.turn(180+myAngle*2);
    	pen.move(arrowLength);
    }
    
    public void drawLine(){
    	pen.home();
    	pen.move(verticalDist);
    	pen.home();
    	pen.setDirection(0);
    	pen.up();
    	pen.move(bodyLength);
    	pen.down();
    	pen.setDirection(90);
    	pen.move(verticalDist);
    }
}