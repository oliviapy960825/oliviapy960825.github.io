package week3;

public class Circle {
    private double radius;

    // default constructor 
    public Circle() {
        this(1.0);
    }
    
    // constructor
    public Circle(double radius) {
        this.radius = radius;
//        setRadius(radius);
    }

    // accessor
    public double getArea() {
        return radius * radius * 3.14159;
    }

    // accessor
    public double getRadius() {
        return this.radius;
    }

    // mutator
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    // mutator    
    public void increaseRadius() {
        this.radius += 1;
    }

    // static factory method
    public static Circle makeUnitCircle() {
        return new Circle(1.0);
    }

    // just a formula
    public static double getArea(double radius) {
        return radius * radius * 3.14159;
    }
    
    public static double getArea(Circle c) {
        return getArea(c.getRadius());
    }
}
