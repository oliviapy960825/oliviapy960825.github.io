package Solution.Restaurant;

import java.util.List;

public class FrenchFry extends FoodItem{
	
	public FrenchFry(List<String> toppings) {
		super(toppings);
	}
	
	public boolean equals(Object other) {
		if (other instanceof FrenchFry) {
			FrenchFry otherFrenchFry = (FrenchFry) other;
			return this.ingredients.equals(otherFrenchFry.ingredients);
		}
		return false;
	}

}
