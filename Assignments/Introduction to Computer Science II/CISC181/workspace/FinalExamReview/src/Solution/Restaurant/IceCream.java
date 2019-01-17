package Solution.Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IceCream extends FoodItem {
	
	public IceCream(String topping1, String topping2) {
		super();
		ingredients.add(topping1);
		ingredients.add(topping2);
		Collections.sort(ingredients);
	}
	
	public boolean equals(Object other) {
		if (other instanceof IceCream) {
			IceCream otherIceCream = (IceCream) other;
			return this.ingredients.equals(otherIceCream.ingredients);
		}
		return false;
	}

}
