
public class Rectangle {
//Problem 1
private double width;
private double height;
Rectangle(){
	double width=1.0;
	double height=1.0;
}
Rectangle(double newWidth,double newHeight){
	this.width=newWidth;
	this.height=newHeight;
}
public double getWidth(){
	return width;
}
public double getHeight(){
	return height;
}
public double getArea(){
	return width*height;
}
public double getPerimeter(){
	return 2*(width+height);
}
//Problem 2
public static Rectangle makeGoldenRectangle(double longerSide){
	double height=longerSide;
	double width=longerSide/1.618;
	Rectangle makeGoldenRectangle=new Rectangle(width,height);
	return makeGoldenRectangle;
}
}