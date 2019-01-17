package Solution.IceCreamMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IceCream {
	
	private List<String> toppings;
	
	public IceCream(String topping1, String topping2) {
		toppings = new ArrayList<String>();
		toppings.add(topping1);
		toppings.add(topping2);
		Collections.sort(toppings);
	}
	
	public String toString() {
		return "IceCream with " + toppings.get(0) +
				" and " + toppings.get(1);
	}
	
	public boolean equals(Object other) {
		if (other instanceof IceCream) {
			IceCream otherIceCream = (IceCream) other;
			return this.toppings.equals(otherIceCream.toppings);
		}
		return false;
	}

}
