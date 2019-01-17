import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Comparisons {
public static void main(String[] args){
	ArrayList<Wombat> herd = new ArrayList<Wombat>();
	herd.add(new Wombat("aaa",4));
	herd.add(new Wombat("bbb",2));
	System.out.println(herd);
	Collections.sort(herd,new WombatLegsCompare());
	System.out.println(herd);
}
}
