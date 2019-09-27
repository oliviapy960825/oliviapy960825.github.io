
public class IceCream implements Edible{
public String color;
public double weight;
IceCream(){
	
}
public String getColor(){
	return color;
}
public double getWeight(){
	return weight;
}
public double getCalories(){
	double calories=1000.0;
	return calories;
}
public String toString(){
	return this.getClass().getName();
}



}
