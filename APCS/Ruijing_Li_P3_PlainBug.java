/* Ruijing Li
 * Period 3
 * 4/19/14
 * Time Spent: 3 hours 30 min
 * Finally finished bug 2048 =D.
 * I was originally stuck on moving the bugs all 
 * the way because they were blocked by another bug.
 * I then realized that my solution was to process the bugs
 * in a different order and that made the problem a lot easier
 * to solve. I also wasn't sure if I should have renamed my classes
 * but figured there's no harm in putting my name in the file name.
 * I also created a package because that was the only way to compile my program without moving it
 * to the folder with world, actor, etc.
 */
package info.gridworld.actor; 
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

public class Ruijing_Li_P3_PlainBug extends Bug {
	public Ruijing_Li_P3_PlainBug(Color c){
		setColor(c);
	}

   	public void move(){
   		Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
   	}
    
}
