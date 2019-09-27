public class NavalOrange extends Orange{
protected String color;
protected double weight;
NavalOrange(){
	
}
NavalOrange(double weight){
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
	double calories=5*weight*1.1;
	return calories;
}
public String toString(){
	if(weight>=100){
		return "ReallyBigNavalOrange";
	}
	else{
		return "NavalOrange";
	}
}
}

