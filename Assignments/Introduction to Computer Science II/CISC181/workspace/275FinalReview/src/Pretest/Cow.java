package Pretest;

public class Cow extends Animal implements Move {

	public Cow(String name, int legs) {
		super(name, legs);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return "hooves";
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "Moo";
	}

}
