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
import info.gridworld.world.World;
import info.gridworld.grid.*;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.awt.Color;

public class Ruijing_Li_P3_GameDriver{
    public static void main(String[] args){
    	BoundedGrid<Actor> grid = new BoundedGrid<Actor>(5, 5);
        Ruijing_Li_P3_BugSlamWorld world = new Ruijing_Li_P3_BugSlamWorld(grid);
		// Add two Plainbugs to random empty locations on the board
		// The color of the bugs should be the same as the first color
		// in the color list.  Use getColorList() to access the list.
		ArrayList<Color> list = world.getColorList();
		Ruijing_Li_P3_PlainBug joeStar = new Ruijing_Li_P3_PlainBug(list.get(0));
		Ruijing_Li_P3_PlainBug dioBrand = new Ruijing_Li_P3_PlainBug(list.get(0));
		world.add(joeStar);
		world.add(dioBrand);	
        world.show();
    }
}
