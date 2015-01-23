/* Ruijing Li
 * Period 3
 * 11/25/13
 * Time Spent: 1 hour 20 minutes
 * This was a sort of hard lab. It was definitely
 * harder than the last 2 labs we did, but nothing 
 * like shorthand or fractals. I had trouble using
 * ArrayLists and Point2D.Double, but found a friend
 * in typecasting.
 */
import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon{
   private ArrayList <Point2D.Double> myPolygon;
   private DrawingTool pen;
   private Point2D.Double pt, pt2;
   private double distance, temp;

   // constructors
   public IrregularPolygon() { 
   		myPolygon = new ArrayList<Point2D.Double>();
   		pen = new DrawingTool();
   	}

   // public methods
   public void add(Point2D.Double aPoint) { 
   		myPolygon.add(aPoint);
   	}

   public void draw() {
   		pen.up(); 
   		for(Point2D.Double d: myPolygon){
   			pt = d;
   			pen.move(d.getX(), d.getY());
   			pen.down();
   		}
   		pt = (Point2D.Double)myPolygon.get(0);
   		pen.move(pt.getX(), pt.getY());
   	}

   public double perimeter() { 
   	 	for(int i = 0; i < myPolygon.size()-1; i++){
   	 		pt = (Point2D.Double)myPolygon.get(i);
   	 		pt2 = (Point2D.Double)myPolygon.get(i+1);
   	 		distance += pt.distance(pt2);
   	 	}
   	 	pt = (Point2D.Double)myPolygon.get(0);
   	 	distance += pt2.distance(pt);
   		return distance;
   	}

   public double area() { 
   		//adding
   		for(int i = 0; i < myPolygon.size()-1; i++){
   	 		pt = (Point2D.Double)myPolygon.get(i);
   	 		pt2 = (Point2D.Double)myPolygon.get(i+1);
   	 		temp += pt.getX()*pt2.getY();
   		}
   		pt2 = (Point2D.Double)myPolygon.get(0);
   		pt = (Point2D.Double)myPolygon.get(myPolygon.size()-1);
   		temp += pt.getX()*pt2.getY();
   		
   		//subtracting
   		for(int i = 0; i < myPolygon.size()-1; i++){
   	 		pt = (Point2D.Double)myPolygon.get(i);
   	 		pt2 = (Point2D.Double)myPolygon.get(i+1);
   	 		temp -= pt.getY()*pt2.getX();
   		}
   		pt2 = (Point2D.Double)myPolygon.get(0);
   		pt = (Point2D.Double)myPolygon.get(myPolygon.size()-1);
   		temp -= pt.getY()*pt2.getX();
   		temp = .5*Math.abs(temp);
   		return temp;
   	}
}

class Driver{
	public static void main(String[] args){
		IrregularPolygon e = new IrregularPolygon();
		Point2D ptA = new Point2D.Double(20,10);
		Point2D ptB = new Point2D.Double(70, 20);
		Point2D ptC = new Point2D.Double(50,50);
		Point2D ptD = new Point2D.Double(0,40);
		e.add((Point2D.Double)ptA);
		e.add((Point2D.Double)ptB);
		e.add((Point2D.Double)ptC);
		e.add((Point2D.Double)ptD);
		e.draw();
		System.out.println("Perimeter: " + e.perimeter());
		System.out.println("Area: " + e.area());
	}
}