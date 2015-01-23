import gpdraw.*;
public class test {

    public static void main(String[] args) {
    	SketchPad win = new SketchPad(500,500);
    	DrawingTool pen = new DrawingTool(win);
    	pen.setDirection(0);
		pen.forward(100);
		pen.turnRight();
		pen.up();
		pen.backward(100);
		
		pen.turnRight();
		
		pen.forward(100);
		pen.down();
		pen.turnLeft();
		pen.forward(200);
    }
}