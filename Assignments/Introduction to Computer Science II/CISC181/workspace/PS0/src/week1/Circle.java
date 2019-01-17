package week1;

public class Circle {
	private double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius * 3.14159;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public static double getArea(double radius) {
		return radius * radius * 3.14159;
	}
	
	public static void main(String[] args) {
        System.out.println(Circle.getArea(2));
        // System.out.println(Circle.getArea()); // won't work because Circle is a class
        Circle ourCircle = new Circle(2);
        System.out.println(ourCircle.getArea()); // calling getArea() on an instance of a Circle


    }
}
