package Solution.IceCreamMachine;

import java.util.Arrays;

public class IceCreamMachineDriver {
	
	public static void main(String args[]) {
		
		String[] toppings = {"Sprinkles", "Reeses", "Walnuts", "Strawberries",
				"Pizza", "Whipped Cream", "Cherries"};
		
		IceCreamMachine machine1 = new IceCreamMachine(Arrays.asList(toppings));
		
		System.out.println("These are all the types of IceCreams we can make:");
		System.out.println(machine1.getAllOptions());
		
		System.out.println("Here is an IceCeam without nuts:");
		String[] allergies = {"Reeses", "Walnuts" };
		System.out.println(machine1.getRandomIceCream(Arrays.asList(allergies)));
		
	}
}
