package week6;

public class LightStrandSegment {
    private int length;
    private int numberOfLights;
    private boolean works;
    public LightStrandSegment(int length, int numberOfLights, boolean works) {
        this.length = length;
        this.numberOfLights = numberOfLights;
        this.works = works;
    }

    public int getLength() {
        return length;
    }
    
    public int getNumberOfLights() {
        return numberOfLights;
    }
    
    public boolean isWorks() {
        return works;
    }
    
    public String toString() {
        return "LightStrandSegment [length=" + length + ", numberOfLights=" + numberOfLights + ", works=" + works + "]";
    }
}
