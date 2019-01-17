
public class Orange extends Fruit implements Edible{
protected String color="Orange";
protected double weight;
Orange(){
	
}
Orange(double weight){
	this.weight=weight;
}
public double getCalories(){
	double calories=5*weight;
	return calories;
}
public double getWeight(){
	return weight;
}
public String getColor(){
	return color;
}
public String toString(){
	return this.getClass().getName();
}

}
