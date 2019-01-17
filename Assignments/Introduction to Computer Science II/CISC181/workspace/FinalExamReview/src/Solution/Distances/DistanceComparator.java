package Solution.Distances;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Vehicle>{

	private Location location;
	
	public DistanceComparator(Location location) {
		this.location = location;
	}
	
	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		double distanceToFirst = o1.getCurrentLocation().distance(location);
		double distanceToSecond = o2.getCurrentLocation().distance(location);
		
		if (distanceToFirst > distanceToSecond) {
			return 1;
		}
		else if (distanceToFirst == distanceToSecond) {
			return 0;
		}
		else {
			return -1;
		}
	}

}
