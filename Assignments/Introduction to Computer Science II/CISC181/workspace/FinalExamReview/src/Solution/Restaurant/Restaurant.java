package Solution.Restaurant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
	
	private List<FoodMachine> machines;
	
	public Restaurant() {
		this.machines = new ArrayList<FoodMachine>();
	}
	
	public void addMachine(FoodMachine machine) {
		this.machines.add(machine);
	}
	
	public void removeMachine(FoodMachine machine) {
		this.machines.remove(machine);
	}
	
	public List<FoodItem> getMenu() {
		return getMenu(null);
	}
	
	public List<FoodItem> getMenu(List<String> excludedIngredients) {
		List<FoodItem> menu = new ArrayList<FoodItem>();
		
		for (FoodMachine machine: machines) {
			menu.addAll(machine.getAllOptions(excludedIngredients));
		}
		
		return menu;
	}
	
	public static void main(String args[]) {
		Restaurant restaurant = new Restaurant();
		restaurant.addMachine(new IceCreamMachine(
				Arrays.asList("Sprinkles","Strawberries","Chocolate")));
		restaurant.addMachine(new FrenchFryMachine(
				Arrays.asList("Ketchup","Chili","Cheese")));
		restaurant.addMachine(new WaffleMachine(
				Arrays.asList("Syrup","Strawberries","Whipped Cream","Chocolate Chips")));
		
		
		System.out.println(restaurant.getMenu());
	}

}
