package _06_gridworld;

import java.awt.Color;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
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
	
	Location loc2 = new Location(4, 8);
	
	planet.add(loc2, BlueBug);

	BlueBug.turn();
	
	Flower Lflower = new Flower(Color.YELLOW);
	
	Location flow1 = new Location(4, 3);
	 
	planet.add(flow1, Lflower);
	
	Flower Rflower = new Flower(Color.CYAN);
	
	Location flow2 = new Location(4, 9);
	
	planet.add(flow2, Rflower);
	
	
}
	

}
