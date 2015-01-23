public class RegularPolygon {
		
	private int myNumSides;			// # of sides
	private double mySideLength;	// length of side
	private double myR;				// radius of circumscribed circle
	private double myr;				// radius of inscribed circle
	
	// constructors
	public RegularPolygon() {		// default constructor
	
		myNumSides = 3;
		mySideLength = 100;
		calcR();
		calcr();
	}
	
	public RegularPolygon(int numSides, double sideLength) {
		
		myNumSides = numSides;
		mySideLength = sideLength;
		calcR();
		calcr();
	}
	
	// private methods
	private void calcr() {
		myr = mySideLength / (2*Math.tan(Math.PI/myNumSides));
	}
	
	private void calcR() {
		myR = mySideLength / (2*Math.sin(Math.PI/myNumSides));
	}
	
	// public methods
	public double vertexAngle() {
		return (myNumSides - 2) * 180 / myNumSides; // return value is in DEGREES
	}
	
	public double Perimeter() {
		return myNumSides * mySideLength;
	}
	
	public double Area() {
		return myNumSides * mySideLength * myr / 2;
	}
	
	public double getNumSide() {
		return myNumSides;
	}

	public double getSideLength() {
		return mySideLength;
	}
	
	public double getR() {
		return myR;
	}
	
	public double getr() {
		return myr;
	}
		
}