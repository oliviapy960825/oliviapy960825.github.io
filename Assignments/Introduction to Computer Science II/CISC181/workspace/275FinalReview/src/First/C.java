package First;

import java.util.HashSet;
import java.util.Set;

public class C {
public static void main(String[] args){
	Set<String> s=new HashSet<String>();
	for(String a: args){
		if(!s.add(a)){
			System.out.println("here: "+a);
		}
		System.out.println(s.size()+" there: "+s);
	}
}
}
