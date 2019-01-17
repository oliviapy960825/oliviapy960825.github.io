//for problem 15
public class Car extends Move implements speakable{

	public Car(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
		this.color=color;
		this.name=name;
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "DIDI";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return "Wheels";
	}

}
