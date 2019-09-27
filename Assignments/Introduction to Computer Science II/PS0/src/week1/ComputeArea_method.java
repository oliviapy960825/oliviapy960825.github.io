package week1;

public class ComputeArea_method {
    
    public static double computeArea(double radius) {
        return radius * radius * 3.14159;
    }
    
	/** Main method */
	public static void main(String[] args) {
		double radius;
		double area;

		// Assign a radius
		radius = 20;

		// Compute area
		area = radius * radius * 3.14159;

		// Display results
		System.out.println("The area for the circle of radius " + radius
				+ " is " + area);
	}
}
