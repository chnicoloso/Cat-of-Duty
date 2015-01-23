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
import info.gridworld.world.World;
import java.util.ArrayList;
import java.awt.Color;
import java.util.Random;
import javax.swing.*;

public class Ruijing_Li_P3_BugSlamWorld extends ActorWorld {
    ArrayList<Color> colorList = new ArrayList<Color>(); // Attribute
    private Random r = new Random();

   public Ruijing_Li_P3_BugSlamWorld(Grid<Actor> g) {
		super(g);
		colorList.add(Color.red);
		colorList.add(Color.orange);
		colorList.add(Color.green);
		colorList.add(Color.blue);
		colorList.add(Color.pink);
		colorList.add(Color.magenta);
		colorList.add(Color.black);
   }

   public ArrayList<Color> getColorList() {
		return colorList;
   }
    
   public boolean keyPressed(java.lang.String description, Location loc) {
   		int dir;
 		
   		if(description.equals("UP")){
   			dir = 0;
   			moveAllBugs(dir);
   			processBugs(dir);
			add(new Location(getGrid().getNumRows()-1, r.nextInt(getGrid().getNumCols())), new PlainBug(getColorList().get(0)));
   		}
   		else if(description.equals("DOWN")){
   			dir = 180;
   			moveAllBugs(dir);
   			processBugs(dir);
   			add(new Location(0, r.nextInt(getGrid().getNumCols())), new PlainBug(getColorList().get(0)));
   		}
   		else if(description.equals("LEFT")){
   			dir = 270;
   			moveAllBugs(dir);
   			processBugs(dir);
   			add(new Location(r.nextInt(getGrid().getNumRows()), getGrid().getNumCols()-1), new PlainBug(getColorList().get(0)));
   		}
   		else if(description.equals("RIGHT")){
   			dir = 90;
   			moveAllBugs(dir);
   			processBugs(dir);
   			add(new Location(r.nextInt(getGrid().getNumRows()), 0), new PlainBug(getColorList().get(0)));
   		}
   		return true;	
   }
   
   public void moveAllBugs(int dir){
   		ArrayList<Location> locList = getGrid().getOccupiedLocations();
   		if(locList.size() == getGrid().getNumCols()*getGrid().getNumRows()){
   			JOptionPane.showMessageDialog(null, "You lose :(");
			System.exit(0);
   		}
   			
   		if(dir == Location.NORTH || dir == Location.WEST){
	   		for(int i = 0; i < locList.size(); i++){
	   			Location loc = locList.get(i);
	   			Location loc2 = loc.getAdjacentLocation(dir);
	   			while(getGrid().isValid(loc2)){
	   				if(getGrid().get(loc2) == null){
	   					getGrid().get(loc).moveTo(loc2);
	   					loc = loc2;
	   					loc2 = loc.getAdjacentLocation(dir);
	   				}else{
	   					break;
	   				}
	   			}
	   		}
   		}else{
   			for(int i = locList.size()-1; i >= 0; i--){
	   			Location loc = locList.get(i);
	   			Location loc2 = loc.getAdjacentLocation(dir);
	   			while(getGrid().isValid(loc2)){
	   				if(getGrid().get(loc2) == null){
	   					getGrid().get(loc).moveTo(loc2);
	   					loc = loc2;
	   					loc2 = loc.getAdjacentLocation(dir);
	   				}else{
	   					break;
	   				}
	   			}
	   		}
   		}
   }
   
   public void processBugs(int dir){
   		if(dir == Location.NORTH){
			for(int r = 0; r < getGrid().getNumRows(); r++){
				for(int c = 0; c < getGrid().getNumCols(); c++){
					Location loc2 = new Location(r+1, c);
					Location loc = new Location(r,c);
					if(getGrid().isValid(loc2)
					   && getGrid().get(loc) != null && getGrid().get(loc2) != null
					   && getGrid().get(loc).getColor().equals(getGrid().get(loc2).getColor())){
						Color col = getGrid().get(loc).getColor();
						if(col == Color.black){
							JOptionPane.showMessageDialog(null, "You win!");
							System.exit(0);
						}
						getGrid().get(loc2).removeSelfFromGrid();
						getGrid().get(loc).removeSelfFromGrid();
						Ruijing_Li_P3_PlainBug bug = new Ruijing_Li_P3_PlainBug(getColorList().get(colorList.indexOf(col)+1));
						bug.putSelfInGrid(getGrid(), loc);
					}
				}
			}
        }else if(dir == Location.SOUTH){
        	for(int r = getGrid().getNumRows()-1; r >= 0; r--){
				for(int c = getGrid().getNumCols()-1; c >= 0; c--){
					Location loc2 = new Location(r-1, c);
					Location loc = new Location(r,c);
					if(getGrid().isValid(loc2)
					   && getGrid().get(loc) != null && getGrid().get(loc2) != null
					   && getGrid().get(loc).getColor().equals(getGrid().get(loc2).getColor())){
						Color col = getGrid().get(loc).getColor();
						if(col == Color.black){
							JOptionPane.showMessageDialog(null, "You win!");
							System.exit(0);
						}
						getGrid().get(loc2).removeSelfFromGrid();
						getGrid().get(loc).removeSelfFromGrid();
						Ruijing_Li_P3_PlainBug bug = new Ruijing_Li_P3_PlainBug(getColorList().get(colorList.indexOf(col)+1));
						bug.putSelfInGrid(getGrid(), loc);
					}
				}
			}
        }else if(dir == Location.EAST){
        	for(int c = getGrid().getNumCols()-1; c >= 0; c--){
				for(int r = getGrid().getNumRows()-1; r >= 0; r--){
					Location loc2 = new Location(r, c-1);
					Location loc = new Location(r, c);
					if(getGrid().isValid(loc2)
					   && getGrid().get(loc) != null && getGrid().get(loc2) != null
					   && getGrid().get(loc).getColor().equals(getGrid().get(loc2).getColor())){
						Color col = getGrid().get(loc).getColor();
						if(col == Color.black){
							JOptionPane.showMessageDialog(null, "You win!");
							System.exit(0);
						}
						getGrid().get(loc2).removeSelfFromGrid();
						getGrid().get(loc).removeSelfFromGrid();
						Ruijing_Li_P3_PlainBug bug = new Ruijing_Li_P3_PlainBug(getColorList().get(colorList.indexOf(col)+1));
						bug.putSelfInGrid(getGrid(), loc);
					}
				}
			}
        }else{
        	for(int c = 0; c < getGrid().getNumCols(); c++){
				for(int r = 0; r < getGrid().getNumRows(); r++){
					Location loc2 = new Location(r, c+1);
					Location loc = new Location(r, c);
					if(getGrid().isValid(loc2)
					   && getGrid().get(loc) != null && getGrid().get(loc2) != null
					   && getGrid().get(loc).getColor().equals(getGrid().get(loc2).getColor())){
						Color col = getGrid().get(loc).getColor();
						if(col == Color.black){
							JOptionPane.showMessageDialog(null, "You win!");
							System.exit(0);
						}
						getGrid().get(loc2).removeSelfFromGrid();
						getGrid().get(loc).removeSelfFromGrid();
						Ruijing_Li_P3_PlainBug bug = new Ruijing_Li_P3_PlainBug(getColorList().get(colorList.indexOf(col)+1));
						bug.putSelfInGrid(getGrid(), loc);
					}
				}
			}
        }
   } 
}