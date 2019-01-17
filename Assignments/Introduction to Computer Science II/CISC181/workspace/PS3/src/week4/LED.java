package week4;

public class LED extends Ornament {
	private boolean on;
	public LED(String color) {
		super(color);
	}
	
	public void turnOn() {
		on = true;
	}
	
	public void turnOff() {
		on = false;
	}
	
	public boolean isOn() {
		return on;
	}
	
	public String getColor() {
		if (isOn()) {
			return super.getColor();
		}
		else {
			return "unlit";
		}
	}
}
