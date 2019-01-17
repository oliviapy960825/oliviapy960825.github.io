package Solution.Restaurant;

import java.util.List;


public abstract class FoodMachine {
	
	protected List<String> availableToppings;
	
	public FoodMachine(List<String> availableToppings) {
		this.availableToppings = availableToppings;
	}
	
	/**
	 * Calls the static version of this method, passing
	 * in the list of available toppings to get all the
	 * possible types of 2-topping IceCreams this machine
	 * can produce
	 * 
	 * @return
	 */
	public abstract List<FoodItem> getAllOptions();
	
	/**
	 * Get all the possible options this machine can
	 * produce excluding the ingredients given
	 * 
	 * @param excludedIngredients
	 * @return
	 */
	public abstract List<FoodItem> getAllOptions(List<String> excludedIngredients);

}
