import java.util.Iterator;

public class Triple {
	public static int[] intArray;
	public NewIterator newIterator;
	public Triple(){
		this.intArray=new int[]{1,2,3};
		this.newIterator=new NewIterator();
	}
	
	public NewIterator iterator(){
		return newIterator;
	}
	public int getElement(int index){
		return intArray[index];
	}
	
	public static void main(String[] args){
		Triple t = new Triple();
		Iterator ti=t.iterator();// t is a Triple object and it calls iterator, so Triple class should have a iterator method
		
		for(int i=0;i<10;i++){
			if(ti.hasNext()){
				System.out.print(ti.next()+" ");
				System.out.println();
			}//print 1 2 3 1 2 3 1 2 3 1
		}
	}
}
