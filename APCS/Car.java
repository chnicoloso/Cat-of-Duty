/* Ruijing Li
 * 9/7/13
 * Period 3
 * Time Spent: 15 minutes planning on paper, 5 minutes coding
 * This lab was simple to plan out. The only trouble I had was
 * when I had to figure out what happens when you call the 
 * fillUp method two times in a row. Other than that, I figured
 * the rest out quickly. 
 */
public class Car{
	int myStartMiles;
	int myEndMiles;
	double myGallonsUsed;
	
	public Car(int odometerReading){
		myStartMiles = odometerReading;
	}
	
	public void fillUp(int odometerReading, double gallons){
		myEndMiles = odometerReading;
		myGallonsUsed += gallons;
	}
	
	public double calculateMPG(){
		return ((myEndMiles - myStartMiles) / myGallonsUsed);
	}
	
	public void resetMPG(){
		myStartMiles = myEndMiles;
		myGallonsUsed = 0;
	}
}
