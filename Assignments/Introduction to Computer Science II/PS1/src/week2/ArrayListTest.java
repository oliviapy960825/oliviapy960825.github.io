package week2;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
	public static void main(String[] args) {
		// considered unsafe typing
		ArrayList myList = new ArrayList();
		myList.add(3);
		myList.add(5);
		myList.add(7);
		
		// can do in short-form
		ArrayList myList2 = new ArrayList(Arrays.asList(3, 5, 7));
		
		// but we can add any type of data so it isn't really a list of integers
		myList.add("hi");
		myList2.add("hi");
		
		
		System.out.println(myList);
		System.out.println(myList2);
		
		// type safe version (doesn't allow us to put a String in a list of Integers)
		ArrayList<Integer> myList3 = new ArrayList<Integer>(Arrays.asList(3, 5, 7));
		
		//myList3.add("hi"); // syntax error
		System.out.println(myList3);
		
		
		// if we really did intend to have mixed data types we can do that
		ArrayList<Object> myList4 = new ArrayList<Object>(Arrays.asList(3, 5, 7));

		myList4.add("hi");
		System.out.println(myList4);
	}
}
