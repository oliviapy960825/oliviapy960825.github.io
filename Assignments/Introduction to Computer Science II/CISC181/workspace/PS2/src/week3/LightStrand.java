package week3;

public class LightStrand {
    private int length;
    private int numberOfLights;
    private boolean works;
    private LightStrand next;
    
    public LightStrand(int length, int numberOfLights, boolean works) {
        this(length, numberOfLights, works, null);
    }
    
    public LightStrand(int length, int numberOfLights, boolean works, LightStrand next) {
        this.length = length;
        this.numberOfLights = numberOfLights;
        this.works = works;
        this.next = next;
    }
    
    public LightStrand addAtEnd(int length, int numberOfLights, boolean works) {
        if (this.next == null) {
            this.next = new LightStrand(length, numberOfLights, works);
            return this.next;
        }
        else {
            return next.addAtEnd(length, numberOfLights, works);
        }
    }
    
    public void setWorks(boolean works) {
        this.works = works;
    }
    
    public boolean allWorking() {
        if (this.next == null) {
            return this.works;
        }
        else {
            return this.works && next.allWorking();
        }
    }
    
    public LightStrand shortestStrand() {
        return null;
    }

    public int totalLights() {
        return 0;
    }    
}
