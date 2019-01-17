
public class Model {
	int xloc = 0;
	 int yloc = 0;
	 final int xIncr = 8;
	 final int yIncr = 2;
	 int frameWidth = 500;
	 int frameHeight = 300;
	 int imgWidth = 165;
	 int imgHeight = 165;
	public Model(int width, int height, int imageWidth, int imageHeight) {
		// TODO Auto-generated constructor stub
		this.frameWidth=width;
		this.frameHeight=height;
		this.imgWidth=imageWidth;
		this.imgHeight=imageHeight;
	}

	public void updateLocationAndDirection() {
		// TODO Auto-generated method stub
		
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
		return Direction.EAST;
	}

}
