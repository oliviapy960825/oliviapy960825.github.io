/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
public class Model{
	int DirFlagOfX = 1;
	 int DirFlagOfY = 1;
	final int xIncr = 8;
	 final int yIncr = 2;
	 int xloc = 0;
	 int yloc = 0;
	 int width;
	 int height;
	 final int frameWidth = 500;
	 final int frameHeight = 300;
	 int imgWidth = 165;
	 int imgHeight = 165;
	 Direction dir;
	public Model(int width, int height, int imageWidth, int imageHeight) {
		// TODO Auto-generated constructor stub
		this.width=width;
		this.height=height;
		this.imgWidth=imageWidth;
		this.imgHeight=imageHeight;
	}

	public void updateLocationAndDirection() {
		// TODO Auto-generated method stub
		 if (xloc < 0) {
			   DirFlagOfX = DirFlagOfX * (-1);
			  } else if (xloc > frameWidth - imgWidth) {
			   DirFlagOfX = DirFlagOfX * (-1);
			  } else if (yloc < 0) {
			   DirFlagOfY = DirFlagOfY * (-1);
			  } else if (yloc > frameHeight - imgHeight) {
			   DirFlagOfY = DirFlagOfY * (-1);
			  }
		 xloc += xIncr * DirFlagOfX;
		 yloc += yIncr * DirFlagOfY;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return xloc;
	}

	public int getY() {
		// TODO Auto-generated method stub
		return yloc;
	}

	public Direction getDirect() {
		// TODO Auto-generated method stub
		return dir;
	}
	
}