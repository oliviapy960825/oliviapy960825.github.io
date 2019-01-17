package Second;

import java.util.ArrayList;

class Cat{
    @Override
    public String toString(){return "hey ima Cat";}
    
    public static void main(String[] arugula){
	System.out.println(new Cat());
	//System.out.println((new Cat()).toString(7));

	final int SIZE = 10;
	int[] data = new int[SIZE];
	for (int i = 0; i < SIZE; i++)
	    data[i] = i;

	for (int i = 0; i < SIZE; i++)
	    System.out.print(" " + data[i]);

	ArrayList<Integer> data2 = new ArrayList<Integer>();
	for (int i = 0; i < SIZE; i++)
	    data2.add(i);

	System.out.println(data2);
	
    }

}
