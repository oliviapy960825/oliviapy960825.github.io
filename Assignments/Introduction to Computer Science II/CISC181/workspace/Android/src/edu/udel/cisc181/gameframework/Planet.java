package edu.udel.cisc181.gameframework;

public class Planet extends CelestialBody{
public Planet(float m,Position p,DirectionVector d){
	super(p,d,m);
}
public void updatePosition(float t) { 
	getPosition().move(getDirection(), t);
}
public void updateDirectionFromSun(Sun s, float t) {
float dx = s.getPosition().getX() - getPosition().getX(); float dy = s.getPosition().getY() - getPosition().getY();
float dist = (float)Math.sqrt(dx*dx + dy*dy);
// Newton's gravitational constant in N m^2 kg^-2
float force = 6.67384E-11f * s.getMass() / (dist*dist*dist);
getDirection().setX(getDirection().getX() + t * force * dx );
getDirection().setY(getDirection().getY() + t * force * dy ); }
}
