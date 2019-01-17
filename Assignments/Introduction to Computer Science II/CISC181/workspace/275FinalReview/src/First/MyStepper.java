package First;

import java.util.Iterator;

public class MyStepper implements Iterator<Integer> {
int state=0;
int step;
public MyStepper(int step){
	this.step=step;
}
@Override
public boolean hasNext() {
	if(state>=50){
		return false;
	}
	else{
		return true;
	}
}
@Override
public Integer next() {
	state+=step;
	return state;
}
}
