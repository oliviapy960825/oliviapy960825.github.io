package week4;

public class Horse {
    private String name;
    private double weight;
    
    public Horse(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void feed() {
        this.weight = this.weight + 10;
    }

    
}
