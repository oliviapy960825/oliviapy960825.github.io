import java.util.Iterator;

public class MyStepper implements Iterator<Integer> {
int state=0;
int step;
public MyStepper(int step){
	this.step=step;
}

public static void main(String[] args){
	for(Iterator<Integer> sIter=new MyStepper(4);sIter.hasNext();){
		System.out.println(" "+sIter.next());
	}
	System.out.println();
	for(Iterator<Integer> sIter=new MyStepper(2);sIter.hasNext();){
		System.out.println(" "+sIter.next());
	}
	System.out.println();
}

public boolean hasNext(){
	if(state>=50){
		return false;
	}
	else{
		return true;
	}
}
public Integer next(){
	state=state+step;
	return state;
}
}
