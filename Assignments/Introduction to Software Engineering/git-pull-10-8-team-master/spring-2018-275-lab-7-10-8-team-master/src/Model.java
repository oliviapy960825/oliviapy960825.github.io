
public class Model {
	Direction d=Direction.EAST;
	Direction dirside;
	Direction dirup;
	int xloc=100;
	int yloc=100;
	final int xIncr = 1;
    final int yIncr = 1;
    int frameWidth = 700;
    int frameHeight = 700;
    int imgWidth = 165;
    int imgHeight = 165;
	
	public Model(int fWidth, int fHeight, int iWidth, int iHeight) {
		frameWidth = fWidth;
		frameHeight = fHeight;
		imgWidth = iWidth;
		imgHeight = iHeight;
	}
	
	public void updateLocationAndDirection(){
    	
    	switch(d) {
    		case NORTHEAST: xloc-=xIncr; yloc-=yIncr; break;
    		case NORTHWEST: xloc+=xIncr; yloc-=yIncr; break;
    		case SOUTHEAST: xloc-=xIncr; yloc+=yIncr; break;
    		case SOUTHWEST: xloc+=xIncr; yloc+=yIncr; break;
    		case WEST: xloc-=xIncr; break;
    		case EAST: xloc+=xIncr; break;
    		case NORTH: yloc-=yIncr; break;
    		case SOUTH: yloc+=yIncr; break;
    	}	
		
	}
	public int getX(){
		return xloc;
	}
	public int getY(){
		return yloc;
	}
	public Direction getDirect(){
		return d;
	}
	public void setDirect(Direction d){
		this.d = d;
	}
}
