//for problem 14 and 15
public class Horse extends Move implements speakable {

	public Horse(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
		this.name=name;
		this.color=color;
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "Yuuu";
	}

	@Override
	public String move() {
		// TODO Auto-generated method stub
		return "Hooves";
	}

}
