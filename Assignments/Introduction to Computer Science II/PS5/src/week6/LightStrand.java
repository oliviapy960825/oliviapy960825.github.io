package week6;

import java.util.LinkedList;


public class LightStrand {
    private LinkedList<LightStrandSegment> lights;
     
    public LightStrand() {
        lights = new LinkedList<LightStrandSegment>();
    }
    
    public LightStrandSegment addAtEnd(int length, int numberOfLights, boolean works) {
        lights.add(new LightStrandSegment(length, numberOfLights, works));
        return lights.getLast();
    }
    
    
    public boolean allWorking() {
        boolean result = true;
        for (LightStrandSegment current : lights) {
            result = result && current.isWorks();
        }
        return result;
    }
    
    public LightStrandSegment shortestStrand() {
        LightStrandSegment shortest = lights.get(0);
        for (LightStrandSegment current : lights) {
            if (current.getLength() < shortest.getLength()) {
                shortest = current;
            }
        }
        return shortest;
    }

    public int totalLights() {
        int result = 0;
        for (LightStrandSegment current : lights) {
            result = result + current.getNumberOfLights();
        }
        return result;
    }

    
    public String toString() {
        return "LightStrand " + lights;
    }

    public static void main(String[] args) {
        
        // manually create 3 linked strands a->b->c->null
        LightStrand a = new LightStrand();
        a.addAtEnd(15, 15, true);
        a.addAtEnd(20, 20, true);
        a.addAtEnd(8, 10, true);
        a.addAtEnd(10, 10, true);
        
        System.out.println(a.allWorking());

        System.out.println(a.shortestStrand());
        
        System.out.println(a.totalLights());
        

    }
    
}
