package week5.music;

import junit.framework.TestCase;

public class VehicleTest extends TestCase {
    public static void test_Vehicle() {
        Horse h = new Horse("Ed", 1000);
        assertEquals(1000.0, h.getWeight(), 0.001);
        assertEquals("Ed", h.toString());
        
        Truck t = new Truck();
        assertEquals(2000.0, t.getWeight(), 0.001);
        assertEquals("Truck", t.toString());
        
        t.setCargo(500);
        assertEquals(2500.0, t.getWeight(), 0.001);
        
        
        assertFalse(t.ride(5)); // no fuel
        assertTrue(h.ride(5)); // not tired yet
        assertFalse(h.ride(5)); // now horse is tired
        
        t.refuel();
        h.refuel();
        
        assertTrue(t.ride(500)); // Truck can go up to 600 miles
        assertFalse(h.ride(500)); // Horse can't go that far even when not tired
        
//        Vehicle[] myVehicles = {h, t}; // both Horse and Truck are Vehicles
//        for (Vehicle v : myVehicles) {
//            v.refuel();
//            assertTrue(v.ride(5));
//        }
    }
}
