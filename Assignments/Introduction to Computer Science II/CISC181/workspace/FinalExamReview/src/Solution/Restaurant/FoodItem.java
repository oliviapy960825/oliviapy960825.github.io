package Solution.Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class FoodItem {

	protected List<String> ingredients;

	public FoodItem(List<String> ingredients) {
		this.ingredients = ingredients;
		Collections.sort(ingredients);
	}

	public FoodItem() {
		this.ingredients = new ArrayList<String>();
	}

	public String toString() {
		return this.getClass().getName() + " with " + ingredients.get(0) + " and " + ingredients.get(1);
	}

}
