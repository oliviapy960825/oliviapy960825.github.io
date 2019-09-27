public class Banana extends Fruit implements Edible{
String color="Yellow";
double weight;
Banana(){
	
}
Banana(String color,double weight){
	super(color,weight);
	this.color=color;
	this.weight=weight;
}
Banana(double weight){
	super(weight);
	this.weight=weight;
}
public double getWeight(){
	return weight;
}
public String getColor(){
	return color;
}
public double getCalories(){
	double calories=10*weight;
	return calories;
}
public String toString(){
	return this.getClass().getName();
}
}
