package week4;

import junit.framework.TestCase;

public class LightStrandTest extends TestCase {
    public void test_LightStrand() {
        // manually create 3 linked strands a->b->c->null
        LightStrand c = new LightStrand(20, 20, true, null);
        LightStrand b = new LightStrand(8, 10, true, c);
        LightStrand a = new LightStrand(15, 15, true, b);
        
        // add d at end
        LightStrand d = a.addAtEnd(10, 10, true);
        
        assertTrue(a.allWorking());
        assertTrue(c.allWorking());
        
        b.setWorks(false);
        assertFalse(a.allWorking());
        assertTrue(c.allWorking());
        
        assertSame(b, a.shortestStrand());
        
        assertEquals(30, c.totalLights());
        assertEquals(10, d.totalLights());
    }
}
