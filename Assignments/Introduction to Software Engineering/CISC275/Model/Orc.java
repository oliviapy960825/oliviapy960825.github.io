package Model;

public class Orc {
	// fields	
	public enum directions{
		NORTH(0, (-2)), SOUTH(0, 2), EAST(8,0), WEST(-8,0), 
		NORTH_EAST(8, -2), SOUTH_EAST(8, 2), SOUTH_WEST(-8, 2), NOTRH_WEST(-8,-2); 
		int xIncr = 8;
		int yIncr = 2;
		
		directions(int xIncr, int yIncr){
			this.xIncr = xIncr;
			this.yIncr = yIncr;
		}
	};	

	String[] actions = {"running", "jumping", "shooting"};
	int xLoc; // location
	int yLoc;
	
	
	
	
	
}
