/* Ruijing Li
 * Period 3
 * 4/7/14
 * Time Spent: 50 minutes for both ZBug amd DancingBug
 * I actually spent way too much time on ZBug because I 
 * overcomplicated the process a bit, thinking of using
 * while and for loops when I forgot that the run button 
 * will run the program continously. However, the logic
 * was easy to implement. As for DancingBug, it was pretty easy. 
 */
import info.gridworld.actor.Bug;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
	private int steps;
	private int sideLength;
	private int turnCount;

    public ZBug(int length) {
    	steps = 0;
    	turnCount = 0;
    	sideLength = length;
    }
    
    public void act(){
    	if(turnCount != 2){
	    	if(canMove()){
	    		if(steps < sideLength){
	    			move();
	    			steps++;
	    		}else if(turnCount == 0){
	    			turn();
	    			turn();
	    			turn();
	  				steps = 0;
	    			turnCount++;
	    		}else if (turnCount == 1){
	    			turn();
	    			turn();
	    			turn();
	    			turn();
	    			turn();
	    			steps = 0;
	    			turnCount++;
	    		}
	    	}
	    }
	    else{
	    	if(steps < sideLength){
    			move();
    			steps++;
	    	}
	    }	

    }
}
class ZBugRunner{
	    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        ZBug alice = new ZBug(4);
        alice.setDirection(90);
        world.add(new Location(2, 4), alice);
        world.show();
    }
}