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
import info.gridworld.grid.*;

public class DancingBug extends Bug {
	private int[] turnList;
	private int listNum;
	
    public DancingBug(int[] array) {
    	turnList = new int[array.length];
    	for(int i = 0; i < array.length; i++){
    		turnList[i] = array[i];
    	}
    	listNum = 0;
    }
    
    public void act(){
    	if(listNum == turnList.length)
    		listNum = 0;
    	
	    for(int i = 0; i < turnList[listNum]; i++){
	    	turn();
	    }
	    
	    listNum++;
	    super.act();
    } 
}
class DancingBugRunner{
	    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.setGrid(new UnboundedGrid());
        int[] turnArray = {2, 1, 5, 8, 23, 15};
        DancingBug alice = new DancingBug(turnArray);
        world.add(new Location(2, 4), alice);
        world.show();
    }
}