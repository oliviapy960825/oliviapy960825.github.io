
abstract class Fruit {
protected String color;
protected double weight;
Fruit(){
	
}
Fruit(String color,double weight){
	this.color=color;
	this.weight=weight;
}
Fruit(double weight){
	this.weight=weight;
}
public double getWeight(){
	return weight;
}
public String getColor(){
	return color;
}
public abstract double getCalories();
public boolean equals(Object other){
	if(other instanceof Fruit){
		Fruit otherFruit=(Fruit)other;
		return this.color==otherFruit.color&&this.weight==otherFruit.weight;
	}
	return false;
}
}
