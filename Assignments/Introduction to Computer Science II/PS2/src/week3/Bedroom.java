package week3;

public class Bedroom {
	private double width;
	public Bedroom(double width) {
		this.width = width;
	}
	public double getArea() {
		return width * 10.0; // assumes all bedrooms are 10 feet long 
	}
}
