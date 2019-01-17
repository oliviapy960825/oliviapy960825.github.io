package Solution.IceCreamMachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import Solution.Restaurant.FoodMachine;


public class IceCreamMachine {
	
	private List<String> availableToppings;
	
	public IceCreamMachine(List<String> availableToppings) {
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
	public List<IceCream> getAllOptions() {
		return getAllOptions(availableToppings);
	}
	
	/**
	 * Static method that returns a list of possible
	 * 2-toppingIceCream options given a list of toppings.
	 * 
	 * @param toppings
	 * @return
	 */
	public static List<IceCream> getAllOptions(List<String> toppings) {
		
		List<IceCream> options = new ArrayList<IceCream>();
		
		Iterator<String> option1_it = toppings.iterator();
		
		while (option1_it.hasNext()) {
			String option1 = (String)option1_it.next();
			Iterator<String> option2_it = toppings.iterator();
			while(option2_it.hasNext()) {
				String option2 = (String)option2_it.next();
				// Add a new ice cream to the list if the
				// two option are not the same
				if (!option1.equals(option2)) {
					IceCream iceCream = new IceCream(option1, option2);
					// Make sure we do add duplicate options
					if (!options.contains(iceCream)) {
						options.add(iceCream);
					}
				}
			}
		}
		
		return options;
	}
	
	/**
	 * Returns an IceCream that has been generated
	 * using a list of available toppings and a given
	 * list of toppings to exclude.
	 * 
	 * @param excludedToppings
	 * @return
	 */
	public IceCream getRandomIceCream(List<String> excludedToppings) {
		List<String> preferredToppings = new ArrayList<String>();
		preferredToppings.addAll(availableToppings);
		preferredToppings.removeAll(excludedToppings);
		
		List<IceCream> iceCreams = getAllOptions(preferredToppings);
		
		Random rand = new Random();
		int index = rand.nextInt(iceCreams.size());
		
		return iceCreams.get(index);
	}

}
