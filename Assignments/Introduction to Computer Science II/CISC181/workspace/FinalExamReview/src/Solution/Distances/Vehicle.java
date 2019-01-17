package Solution.Distances;

public abstract class Vehicle implements Drivable {
	
	protected Location location;
	
	public Vehicle(Location location) {
		this.location = location;
	}
	
	public Location getCurrentLocation() {
		return location;
	}
	
	public double driveTo(Location destination) {
		double time = location.distance(destination) / 20;
		this.location = destination;
		return time;
	}
	

}
