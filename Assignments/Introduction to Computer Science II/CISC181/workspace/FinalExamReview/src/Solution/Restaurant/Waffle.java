package Solution.Restaurant;

import java.util.List;

public class Waffle extends FoodItem {
	
	public Waffle(List<String> toppings) {
		super(toppings);
	}
	
	public boolean equals(Object other) {
		if (other instanceof Waffle) {
			Waffle otherWaffle = (Waffle) other;
			return this.ingredients.equals(otherWaffle.ingredients);
		}
		return false;
	}

}
