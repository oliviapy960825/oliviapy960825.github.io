

import junit.framework.TestCase;

public class TestPerson extends TestCase {
    public void test_Person() {
        Person p = new Person("Tiny Tim");
        assertEquals("Tiny Tim", p.getRealName());
        assertEquals("Tiny Tim", p.toString());
        
        assertTrue(p.isAfraidOf("kryptonite"));
        assertTrue(p.isAfraidOf("spiders"));
    }
    
    public void test_Spiderman() {
        Person p = new Spiderman();
        assertEquals("Peter Parker", p.getRealName());
        assertEquals("Spiderman", p.toString());
        
        assertFalse(p.isAfraidOf("kryptonite"));
        assertTrue(p.isAfraidOf("spiders"));
    }
    
    public void test_Elastigirl() {
        Person p = new Elastigirl();
        assertEquals("Helen Parr", p.getRealName());
        assertEquals("Elastigirl", p.toString());
        
        assertFalse(p.isAfraidOf("kryptonite"));
        assertFalse(p.isAfraidOf("spiders"));
    }
}
