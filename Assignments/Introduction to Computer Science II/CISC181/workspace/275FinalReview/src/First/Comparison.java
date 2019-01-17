package First;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparison {
public static void main(String[] args){
	List<Wombat> herd=new ArrayList<Wombat>();
	herd.add(new Wombat("Lily",4));
	herd.add(new Wombat("Olivia",3));
	Collections.sort(herd, new WombatLegsComparator());
	System.out.println(herd);
}
}
