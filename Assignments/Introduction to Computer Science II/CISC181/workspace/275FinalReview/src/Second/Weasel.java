package Second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Weasel {
public String name;
public static void main(String[] args){
	List<Weasel> herd=new ArrayList<>();
	Collections.sort(herd, new Comparator<Weasel>(){
		public int compare(Weasel w1, Weasel w2){
			return w1.name.compareTo(w2.name);
		}
	});
}
}
