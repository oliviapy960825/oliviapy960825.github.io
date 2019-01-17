package week3;

public class Tornado {
	private double strength;
    public Tornado(double strength) {
        this.strength = strength;
    }
    public Tornado split() {
        this.strength = this.strength / 2;
        return new Tornado(this.strength);
    }
    public void upgrade() {
        this.strength += 20;
    }
    public double getStrength() {
        return this.strength;
    }
    
    
	public static void main(String[] args) {
		
	    Tornado a = new Tornado(10.0);
	    Tornado b = a.split();
	    b.upgrade();
	    System.out.println(b.getStrength());

	    Tornado c = b.split();
	    Tornado d = new Tornado(100.0);
	    
	    System.out.println(a.getStrength());
	    System.out.println(b.getStrength());
	    System.out.println(c.getStrength());

	    System.out.println(new Tornado(50).getStrength());
//	    System.out.println(d.upgrade().upgrade().getStrength());
	}
}
