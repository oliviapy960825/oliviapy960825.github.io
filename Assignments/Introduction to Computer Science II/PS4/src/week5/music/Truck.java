package week5.music;

public class Truck {
    private double miles;
    private double fuel;
    private double weight;
    private double cargoWeight;
    
    public Truck() {
        this.miles = 0;
        this.weight = 2000;
    }
    
    public double getWeight() {
        return weight + cargoWeight;
    }
    
    public boolean ride(double miles) {
        if (miles <= fuel*20) {
            fuel -= miles/20;
            this.miles += miles;
            return true;
        }
        else {
            return false;
        }
    }
    
    public void refuel() {
        this.fuel = 30;
    }
    
    public void setCargo(double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }
    
    public boolean hasCargo() {
        return this.cargoWeight > 0;
    }

    public String toString() {
        return "Truck";
    }
}
