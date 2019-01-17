package edu.udel.cisc181.gameframework;

public class SolarModel {
Sun newSun;
Planet newPlanet;
SolarModel(Sun s,Planet p){
	newSun=s;
	newPlanet=p;
}
public Sun getSun(){
	return newSun;
}
public Planet getPlanet(){
	return newPlanet;
}
public void update(float time){
	newPlanet.updatePosition(time);
	newPlanet.updateDirectionFromSun(newSun, time);
}
}
