package First;

import java.util.Comparator;

public class WombatLegsComparator implements Comparator<Wombat>{

	@Override
	public int compare(Wombat o1, Wombat o2) {
		// TODO Auto-generated method stub
		return o1.numLegs-o2.numLegs;
	}

}
