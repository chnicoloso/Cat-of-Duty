import gpdraw.DrawingTool;
import gpdraw.SketchPad;
import java.awt.Color;

class DrawHouse {
	DrawingTool pen;
	SketchPad paper;
	Color c;
	
    DrawHouse() {
    	paper = new SketchPad(500, 500);
    	pen = new DrawingTool(paper);
        c = new Color(255,60,80);
    }
    
    void background(){
    	pen.setColor(Color.cyan);
    	pen.up();
    	pen.move(100);
    	pen.down();
    	pen.fillRect(500,450);
    	pen.up();
    	pen.move(-300);
    	pen.down();
    	pen.setColor(Color.green);
    	pen.fillRect(500,250);
    }
    
    void drawBody(){
    	pen.setWidth(1);
    	pen.up();
    	pen.move(0,0);
    	pen.setDirection(90);
    	pen.down();
    	pen.setColor(Color.black);
    	pen.drawRect(300,200);
    }
    
    void changeColor(){
    	pen.setColor(c);
    }
    
    void drawRoof(){
    	pen.up();
    	pen.move(-150, 100);
    	pen.down();
    	pen.setDirection(90);
    	pen.turnRight(60);
	    pen.move(200);
	    pen.turnRight(69);
    	pen.move(170);
    	pen.turnLeft();
    	pen.move(50);
    	pen.turnLeft(106);
    	pen.move(170);
    }
    
    void windows(){
    	pen.setColor(Color.blue);
    	pen.up();
    	pen.move(0,0);
    	pen.setDirection(90);
    	pen.turnLeft();
    	pen.move(100);
    	pen.setDirection(90);
    	pen.move(50);
    	pen.down();
    	pen.fillRect(50,50);
    	pen.up();
    	pen.turnRight();
    	pen.move(200);
    	pen.turnLeft();
    	pen.down();
    	pen.fillRect(50,50);
    }
    
    void door(){
    	pen.setColor(Color.red);
    	pen.up();
    	pen.move(0,0);
    	pen.setDirection(270);
    	pen.move(50);
    	pen.down();
    	pen.fillRect(50, 100);
    }
    
    void knob(){
    	pen.up();
    	pen.setColor(Color.black);
    	pen.setDirection(0);
    	pen.move(15);
    	pen.down();
    	pen.fillCircle(10);
    }
    
    void bodyTwo(){
    	pen.setColor(Color.black);
    	pen.up();
    	pen.move(150, -100);
    	pen.down();
    	pen.setDirection(90);
    	pen.turnRight(60);
    	pen.move(50);
    	pen.turnLeft(60);
    	pen.move(210);
    }   
}