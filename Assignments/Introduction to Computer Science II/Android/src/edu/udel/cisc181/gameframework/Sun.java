package edu.udel.cisc181.gameframework;

public class Sun extends CelestialBody{
private static Position newP=new Position(0,0);;
private static DirectionVector newDV=new DirectionVector(0,0);;
private static float mass=1.9891E30f;;
public Sun(){
	
}
public Sun(Position p, DirectionVector d,float m){
	super(newP,newDV,mass);
	
	
}

public Position getPosition(){
	return newP;
}
public DirectionVector getDirection(){
	return newDV;
}
public float getMass(){
	return mass;
}
}
