package Pretest;

public class Horse extends Animal implements Move {
public Horse(String name, int legs){
	super(name, legs);
}
public String move(){
	return "hooves";
}
@Override
public String speak() {
	// TODO Auto-generated method stub
	return "YOO";
}
}
