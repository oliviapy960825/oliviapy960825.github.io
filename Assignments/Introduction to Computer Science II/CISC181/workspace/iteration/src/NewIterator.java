import java.util.Iterator;

public class NewIterator implements Iterator {//ITERATOR IS AN INTERFACE!!!
	int index=0;
	public NewIterator(){
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object next() {
		index++;
		// TODO Auto-generated method stub
		return Triple.intArray[(index-1)%3];
	}
}
