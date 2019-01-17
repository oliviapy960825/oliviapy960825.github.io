import java.util.Comparator;

public class WombatLegsCompare implements Comparator<Wombat>{

		@Override
		public int compare(Wombat w1, Wombat w2) {
			// TODO Auto-generated method stub
			return w1.numLegs-w2.numLegs;
		}
		
}
