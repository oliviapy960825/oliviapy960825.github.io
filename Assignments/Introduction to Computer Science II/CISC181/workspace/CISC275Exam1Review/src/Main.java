import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
public static void main(String[] args){
	ArrayList herd=new ArrayList<Cow>(2);
	herd.add(new Cow("Shirley",4));
	herd.add(new Cow("WWW",3));
	Collections.sort(herd);
	System.out.println(herd);
	Collections.sort(herd, new Comparator<Cow>(){//inline method or Anonymous Classes
		public int compare(Cow c1, Cow c2){
			return c1.numLegs-c2.numLegs;
		}
	});
	System.out.println(herd);
}
int[] intArray=new int[670];
}
