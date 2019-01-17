/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 * detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/

//This lab is done by Peiyu Wang and Mandi Li
public class Model{

	int xloc = 0;
	int yloc = 0;
	
	final int xIncr = 8;
	final int yIncr = 2;
	
	int DirFlagOfX = 1;
	int DirFlagOfY = 1;

	Direction d;
	
	public int getDirFlagOfX() {
		return DirFlagOfX;
	}

	public int getDirFlagOfY() {
		return DirFlagOfY;
	}

	public Direction getD() {
		return d;
	}

	public void setD(Direction d) {
		this.d = d;
	}

	public Model(int width, int height, int imageWidth, int imageHeight) {
	}

	public void updateLocationAndDirection() {
		if(getX() < 0) {
			DirFlagOfX = DirFlagOfX * (-1);
		} 
		else if(getX() > View.frameWidth - View.imgWidth) {
			DirFlagOfX = DirFlagOfX * (-1);
		} 
		else if (getY() < 0) {
			DirFlagOfY = DirFlagOfY * (-1);
		} 
		else if (getY() > View.frameHeight - View.imgHeight) {
			DirFlagOfY = DirFlagOfY * (-1);
		}
		
		if (DirFlagOfX == 1 && DirFlagOfY == 1) {
			d = Direction.SOUTHEAST;
		} 
		else if (DirFlagOfX == -1 && DirFlagOfY == 1) {
			d = Direction.SOUTHWEST;
		} 
		else if (DirFlagOfX == 1 && DirFlagOfY == -1) {
			d = Direction.NORTHEAST;
		} 
		else if (DirFlagOfX == -1 && DirFlagOfY == -1) {
			d = Direction.NORTHWEST;
		}
		
	}
	
	public int updateX() {
		xloc += xIncr * getDirFlagOfX();
		return xloc;
	}
	
	public int updateY() {
		yloc += yIncr * getDirFlagOfY();
		return yloc;
	}

	public Direction getDirect() {
		return d;
	}

	public int getX() {
		return xloc;
	}
	public void setXloc(int xloc) {
		this.xloc = xloc;
	}


	public int getY() {
		return yloc;
	}
	public void setYloc(int yloc) {
		this.yloc = yloc;
	}

	
}
