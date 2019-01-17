package First;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
public static void main(String[] args){
	ArrayList<Cow> cows= new ArrayList<Cow>(2);
	cows.add(new Cow("Mary",4));
	cows.add(new Cow("Olivia",3));
	System.out.println(cows);
	Collections.sort(cows);
	System.out.println(cows);
	Collections.sort(cows,new LegComparator());
	System.out.println(cows);
	
	
	for(Iterator<Integer> sIter=new MyStepper(4);sIter.hasNext();){
		System.out.print(" "+sIter.next());
	}
	System.out.println();
	
	for(Iterator<Integer> sIter=new MyStepper(2);sIter.hasNext();){
		System.out.print(" "+sIter.next());
	}
	System.out.println();
}
}
