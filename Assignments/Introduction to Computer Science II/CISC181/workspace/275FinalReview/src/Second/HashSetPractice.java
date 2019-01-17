package Second;

import java.util.HashSet;

public class HashSetPractice {
public static void main(String[] args){
	HashSet<Cow> herd=new HashSet<Cow>();
	herd.add(new Cow("A"));
	System.out.println();
	herd.add(new Cow("Alba"));
	System.out.println();
	herd.add(new Cow("A"));
	System.out.println();
	herd.add(new Cow("Aga"));
	System.out.println();
	herd.add(new Cow("A"));
	System.out.println();
	System.out.println(herd.size());
}
}
