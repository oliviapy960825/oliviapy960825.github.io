
public class Horse extends Animal {

	public Horse(double weight) {
		super(weight);
	}

	@Override
	public String eats() {
		return "hay";
	}
	
	@Override
	public String speak() {
		return "Neigh, " + super.speak();
	}

}
