package Solution.Distances;

public class BananaCar extends Banana implements Drivable {

	protected Location location;
	
	public BananaCar(Location location) {
		this.location = location;
	}
	
	@Override
	public double driveTo(Location location) {
		this.location = location;
		return 0;
	}

	@Override
	public Location getCurrentLocation() {
		return location;
	}

}
