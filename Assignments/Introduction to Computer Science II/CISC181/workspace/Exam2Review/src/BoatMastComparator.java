import java.util.Comparator;

public class BoatMastComparator implements Comparator<Boat> {

	@Override
	public int compare(Boat o1, Boat o2) {
		if (o1.getNumMasts() > o2.getNumMasts()) {
			return 1;
		}
		else if (o1.getNumMasts() < o2.getNumMasts()) {
			return -1;
		}
		return 0;
	}

}
