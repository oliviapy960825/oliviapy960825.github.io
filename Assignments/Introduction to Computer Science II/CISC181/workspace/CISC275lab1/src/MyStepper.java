import java.util.Iterator;

public class MyStepper implements Iterator<Integer> {

	int state=0;
	int step;
	public MyStepper(int step){
		this.step=step;
	}
	
	public static void main(String[] args){
		for(Iterator<Integer> sIter =new MyStepper(4);sIter.hasNext();){
			System.out.println(" "+sIter.next());
		}
		System.out.println();
		for(Iterator<Integer> sIter =new MyStepper(2);sIter.hasNext();){
			System.out.println(" "+sIter.next());
		}
		System.out.println();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(state+step>52||state/step>=25)
		    return false;
		else
			return true;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		state=state+step;
		return state;
	}

}
