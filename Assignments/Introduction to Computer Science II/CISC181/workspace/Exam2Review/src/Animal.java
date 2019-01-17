
public abstract class Animal implements Mobile {
	
	public double weight;
	
	public Animal(double weight) {
		this.weight = weight;
	}
	
	public String speak() {
		return "I'm an animal";
	}
	
	public abstract String eats();
	
	public void move() {
		System.out.println("Walking to the next place...");
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof Animal) {
			Animal otherAnimal = (Animal)other;
			return this.weight == otherAnimal.weight;
		}
		else {
			return false;
		}
	}

}
