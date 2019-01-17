package Solution.Distances;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationDriver {
	
	public static void main(String[] args) { 
		List<Drivable> things = new ArrayList<Drivable>();
		things.add(new Bus(new Location(5, 5)));
		things.add(new BananaCar(new Location(3, 2)));
		Vehicle v = new Bus(new Location(0, 0));
		things.add(v);
		v.driveTo(new Location(7, 8));
		DistanceComparator c = new DistanceComparator(new Location(0, 0));
		/*
		// Not surer why the following line throws an error
		Drivable closestDrivable = Collections.min(things, c);
		System.out.println("Zipping around in a " +
				closestDrivable.getClass().getSimpleName());
		*/
	}

}
