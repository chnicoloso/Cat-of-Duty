public class Driver{
	public static void main(String[] args){
		RegularPolygon poly = new RegularPolygon();
		RegularPolygon square = new RegularPolygon(4, 10); //number of sides, length of side
		RegularPolygon octagon = new RegularPolygon(8, 5.75);
		RegularPolygon enneadecagon = new RegularPolygon(19, 2);
		RegularPolygon enneacontakaihenagon = new RegularPolygon(91, 0.5);
		//square
		System.out.println("Square: n = " + square.getNumside());
		System.out.println("s = " + square.getSideLength());
		System.out.println("(degrees) = " + square.vertexAngle());
		System.out.println("r = " + square.getr());
		System.out.println("R = " + square.getR());
		System.out.println("Perimeter = " + square.Perimeter());
		System.out.println("Area = " + square.Area());
		//octagon
		System.out.println("\nOctagon: n = " + octagon.getNumside());
		System.out.println("s = " + octagon.getSideLength());
		System.out.println("(degrees) = " + octagon.vertexAngle());
		System.out.println("r = " + octagon.getr());
		System.out.println("R = " + octagon.getR());
		System.out.println("Perimeter = " + octagon.Perimeter());
		System.out.println("Area = " + octagon.Area());
		//enneadecagon
		System.out.println("\nEnneadecagon: n = " + enneadecagon.getNumside());
		System.out.println("s = " + enneadecagon.getSideLength());
		System.out.println("(degrees) = " + enneadecagon.vertexAngle());
		System.out.println("r = " + enneadecagon.getr());
		System.out.println("R = " + enneadecagon.getR());
		System.out.println("Perimeter = " + enneadecagon.Perimeter());
		System.out.println("Area = " + enneadecagon.Area());
		//Enneacontakaihenagon
		System.out.println("\nEnneacontakaihenagon: n = " + enneacontakaihenagon.getNumside());
		System.out.println("s = " + enneacontakaihenagon.getSideLength());
		System.out.println("(degrees) = " + enneacontakaihenagon.vertexAngle());
		System.out.println("r = " + enneacontakaihenagon.getr());
		System.out.println("R = " + enneacontakaihenagon.getR());
		System.out.println("Perimeter = " + enneacontakaihenagon.Perimeter());
		System.out.println("Area = " + enneacontakaihenagon.Area());
	}
}