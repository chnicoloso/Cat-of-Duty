import gpdraw.*;

public class PonzoRLi {
	DrawingTool pen;
	int angle;
	int lineWidth;
	int lineLength;
	int dist;

    public PonzoRLi(int ray, int width, int length, int distance) {
    	pen = new DrawingTool(new SketchPad(500,500));
    	angle = ray;
    	lineWidth = width;
    	lineLength = length;
    	dist = distance;
    }
    
    public void draw(){
    	pen.up();
    	pen.turnLeft();
    	pen.move(dist/2);
    	pen.turnRight();
    	pen.setWidth(lineWidth+1);
    	drawVerticalLine();
    	pen.turnRight();
    	pen.up();
    	pen.move(dist/2);
    	pen.turnLeft();
    	drawVerticalLine();
    	pen.setWidth(lineWidth);
    	drawRays();	
    }
    
    public void drawVerticalLine(){
    	pen.down();
    	pen.move(lineLength/2);
    	pen.turn(180);
    	pen.move(lineLength);
    	pen.home();
    }
    
    public void drawRays(){
    	int j = 65;
    	
    	for(int i = 0; i < 10; i++){
    		pen.up();
    		pen.move(-300,0);
    		pen.setDirection(90);
    		pen.turnRight(j);
    		pen.down();
    		pen.move(800);
    		j += angle;
    	}
    }
}