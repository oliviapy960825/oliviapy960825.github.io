import java.util.Comparator;

public class BoatWeightComparator implements Comparator<Boat> {

	@Override
	public int compare(Boat o1, Boat o2) {// can you just use compareTo() method again?
		if (o1.getWeight() > o2.getWeight()) {
			return 1;
		}
		else if (o1.getWeight() < o2.getWeight()) {
			return -1;
		}
		return 0;
	}

}
