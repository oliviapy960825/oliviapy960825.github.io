package First;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Comparison2 {
	public static void main(String[] args){
	Collection<Wombat2> herds=new ArrayList<>();
	herds.add(new Wombat2("Lily",4));
	herds.add(new Wombat2("Olivia",3));
	Collections.sort(herds);
	}
}
