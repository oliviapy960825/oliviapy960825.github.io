

public enum Direction {

	NORTH("north"),
	NORTHEAST("northeast"),
	EAST("east"),
	SOUTHEAST("southeast"),
	SOUTH("south"),
	SOUTHWEST("southwest"),
	WEST("west"),
	NORTHWEST("northwest");
	
	private String name = null;
	
	private Direction(String s){
		name = s;
	}
	public String getName() {
		return name;
	}
	int xloc = 0;
		 int yloc = 0;
		 final int xIncr = 8;
		 final int yIncr = 2;


}
