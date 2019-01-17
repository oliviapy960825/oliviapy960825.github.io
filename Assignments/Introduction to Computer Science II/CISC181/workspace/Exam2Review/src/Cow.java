
public class Cow extends Animal {
	
	public Cow(double weight) {
		super(weight);
	}
	
	@Override
	public String speak() {
		return "Moo, " + super.speak();
	}
	
	@Override
	public String eats() {
		return "Grass";
	}
	
	

}
