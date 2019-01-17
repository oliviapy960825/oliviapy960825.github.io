package week3;

public class House {
    private Kitchen kitchen;
    private Bedroom bedroom;
    
    
    public House(Kitchen kitchen, Bedroom bedroom) {
		this.kitchen = kitchen;
		this.bedroom = bedroom;
	}


	public double getArea() {
    	double total = 0;
    	if (kitchen != null) {
    		total += kitchen.getArea();
    	}
    	if (bedroom != null) {
    		total += bedroom.getArea();
    	}
    	return total;
    }
}
