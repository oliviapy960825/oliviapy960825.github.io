package edu.udel.cisc181.gameframework;

public class CelestialBody {
protected Position position;
protected DirectionVector directionvector;
protected float mass;
public CelestialBody(){
	
}
public CelestialBody(Position p,DirectionVector d,float m){
	position=p;
	directionvector=d;
	mass=m;
}
public Position getPosition(){
	return position;
}
public DirectionVector getDirection(){
	return directionvector;
}
public float getMass(){
	return mass;
}
}
