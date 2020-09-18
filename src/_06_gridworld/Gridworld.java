package _06_gridworld;

import java.awt.Color;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {
public static void main(String[] args) {
	 World planet = new World();
	 planet.show();
	 
	 Bug bug = new Bug();
	 
	 Location loc = new Location(2,4);
	 
	planet.add(loc, bug);
	
	Bug BlueBug = new Bug(Color.BLUE);
	
//	BlueBug(Color blue);
	 
}
	

}
