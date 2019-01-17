package First;

import java.util.ArrayList;
import java.util.Collection;

public class Exam {
public static void main(String[] args){
	Collection<Movers> movers=new ArrayList<Movers>();
	movers.add(new Fish());
	movers.add(new Cat());
	for(Movers m:movers){
		m.move();
	}
}
}
