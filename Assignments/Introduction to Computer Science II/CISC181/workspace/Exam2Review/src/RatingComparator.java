import java.util.Comparator;

public class RatingComparator implements Comparator<Rated> {

	@Override
	public int compare(Rated arg0, Rated arg1) {
		if (arg0.getRating() > arg1.getRating()) {
			return 1;
		}
		else if (arg0.getRating() < arg1.getRating()) {
			return -1;
		}
		return 0;
	}

}
