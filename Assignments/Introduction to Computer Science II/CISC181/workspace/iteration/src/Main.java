import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		ArrayList<Dog> dogs = new ArrayList<Dog>(3);
		dogs.add(new Dog("Max", 3));
		dogs.add(new Dog("Max", 4));
		dogs.add(new Dog("Jake", 4));
		Collections.sort(dogs, new AnimalCompare());
		System.out.println(dogs);
		Collections.sort(dogs);
		System.out.println(dogs);
	}
}
