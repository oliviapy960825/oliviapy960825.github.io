import java.util.Comparator;

public class LegComparator implements Comparator<Cow> {

	@Override
	public int compare(Cow o1, Cow o2) {
		// TODO Auto-generated method stub
		return o1.numLegs-o2.numLegs;
	}

}
