import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Boat implements Comparable<Boat>{// comparable<doesn't have to be Boat but if you want to compare boat you should set it to boat>
	
	private String name;
	private int numMasts;
	private double weight;
	
	

	public Boat(String name, int numMasts, double weight) {
		this.name = name;// this. differentiate the variable and properties with the same name
		this.numMasts = numMasts;
		this.weight = weight;
	}


	public String getName() {
		return name;
	}




	public int getNumMasts() {
		return numMasts;
	}




	public double getWeight() {
		return weight;
	}


	@Override
	public String toString() {
		return "Boat [name=" + name + ", numMasts=" + numMasts + ", weight=" + weight + "]";
	}


	@Override
	public int compareTo(Boat arg0) {
		return this.name.compareTo(arg0.name);
	}


	public static void main(String[] args) {
		
		ArrayList<Boat> fleet = new ArrayList<Boat>();
		fleet.add(new Boat("Harvey", 3, 126));
		fleet.add(new Boat("Atlas", 2, 167));
		fleet.add(new Boat("Roosen", 3, 154));
		
		System.out.println("Original List: " + fleet);
		Collections.sort(fleet);//How does java know you want it to sort by alphabetic order?
		System.out.println("Name-sorted List: " +  fleet);
		BoatMastComparator mastComp = new BoatMastComparator();
		fleet.sort(mastComp);
		System.out.println("Mast-sorted List: " +  fleet);
		BoatWeightComparator weightComp = new BoatWeightComparator();
		fleet.sort(weightComp);
		System.out.println("Weight-sorted List: " +  fleet);
	}


	

}
