package Solution.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WaffleMachine extends FoodMachine {

	public WaffleMachine(List<String> availableToppings) {
		super(availableToppings);
	}
	
	@Override
	public List<FoodItem> getAllOptions() {
		return getAllOptions(null);
	}

	@Override
	public List<FoodItem> getAllOptions(List<String> excludedToppings) {

		List<FoodItem> options = new ArrayList<FoodItem>();
		
		List<String> preferredToppings = new ArrayList<String>();
		preferredToppings.addAll(availableToppings);
		
		if (excludedToppings != null) {
			preferredToppings.removeAll(excludedToppings);
		}
		
		
		Iterator<String> option1_it = preferredToppings.iterator();
		
		while (option1_it.hasNext()) {
			String option1 = (String)option1_it.next();
			Iterator<String> option2_it = preferredToppings.iterator();
			while(option2_it.hasNext()) {
				String option2 = (String)option2_it.next();
				// Add a new ice cream to the list if the
				// two option are not the same
				if (!option1.equals(option2)) {
					Waffle waffle = new Waffle(Arrays.asList(option1, option2));
					// Make sure we do not add duplicate options
					if (!options.contains(waffle)) {
						options.add(waffle);
					}
				}
			}
		}
		
		return options;
	}


}
