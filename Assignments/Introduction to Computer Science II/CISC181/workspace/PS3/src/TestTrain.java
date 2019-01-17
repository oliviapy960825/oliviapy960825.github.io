

import junit.framework.TestCase;

public class TestTrain extends TestCase {
    public void test_Train_partABC() {
        Engine e1 = new Engine(5, 1200); // 5 years, 1200hp
        Engine e2 = new Engine(0, 1500);
        Engine e3 = new Engine(15, 800);
        
        Train t1 = new Train(e1, e2, 500); // Train has 2 Engines
        Train t2 = new Train(null, e3, 500); // Train has 1 Engine at rear
        Train t3 = new Train(e3, null, 500); // Train has 1 Engine at front
        Train t4 = new Train(null, null, 500); // Train has no Engines
        assertEquals(2700, t1.totalHorsepower(), 0.01);
        assertEquals(800, t2.totalHorsepower(), 0.01);
        assertEquals(800, t3.totalHorsepower(), 0.01);
        assertEquals(0, t4.totalHorsepower(), 0.01);
    }
    
    public void test_Train_partD() {
        Engine e1 = new Engine(5, 1200); // 5 years, 1200hp
        Engine e2 = new Engine(0, 1500);
        Engine e3 = new Engine(15, 800);
        
        Train t1 = new Train(e1, e2, 500);
        Train t2 = new Train(null, e3, 500);
        Train t3 = new Train(e3, null, 500);
        Train t4 = new Train(null, null, 500);
        
        t1.replaceOldest(e3);
        assertSame(e3, t1.getFront());
        assertSame(e2, t1.getRear());
        
        t2.replaceOldest(e2);
        assertSame(e2, t2.getFront());
        assertSame(e3, t2.getRear());

        t3.replaceOldest(e2);
        assertSame(e3, t3.getFront());
        assertSame(e2, t3.getRear());

        t4.replaceOldest(e2);
        assertTrue((t4.getFront() == e2 && t4.getRear() == null)
            || (t4.getFront() == null && t4.getRear() == e2));
    }
    
    public void test_Train_partE() {
        Engine e1 = new Engine(5, 1200); // 5 years, 1200hp
        Engine e2 = new Engine(0, 1500);
        Engine e3 = new Engine(15, 800);
        Engine e4 = new Engine(1, 1600);
        
        Train t1 = new Train(e1, e2, 2500);
        Train t2 = new Train(e3, e4, 2500);
        
        assertFalse(t1.isOverloaded());
        assertTrue(t2.isOverloaded());
    }
    
    public void test_Train_partF() {
        Engine e1 = new Engine(5, 1200); // 5 years, 1200hp
        Engine e2 = new Engine(0, 1500);
        Engine e3 = new Engine(15, 800);
        Engine e4 = new Engine(1, 1600);
        Engine e5 = new Engine(2, 2000);
        
        Train t1 = new Train(e1, e2, 2500);
        Train t2 = new ExpressTrain(e3, e4, 4500, e5);
        
        assertEquals(4400, t2.totalHorsepower(), 0.01);
        assertFalse(t1.isOverloaded());
        assertTrue(t2.isOverloaded());
    }
}
