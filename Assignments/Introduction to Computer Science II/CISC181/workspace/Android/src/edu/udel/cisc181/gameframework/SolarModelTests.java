package edu.udel.cisc181.gameframework;

import junit.framework.TestCase;

public class SolarModelTests extends TestCase {
    public void test_Position_move() {
        Position p = new Position(1, 1, 1);
        DirectionVector v = new DirectionVector(2, -1, 1);
        p.move(v, 0.5f);
        assertEquals(2.0, p.getX(), 0.01);
        assertEquals(0.5, p.getY(), 0.01);
        assertEquals(1.5, p.getZ(), 0.01);
    }
    
    public void test_CelestialHierarchy() {
        Sun s = new Sun();
        assertTrue(s instanceof CelestialBody);
        assertEquals(new DirectionVector(0, 0), s.getDirection());
        assertEquals(new Position(0, 0), s.getPosition());
        assertEquals(1.9891E30f, s.getMass(), 0.01);
        Planet imaginary = new Planet(1, new Position(10000000000.0f, 5000), new DirectionVector(-100, 200));
        assertTrue(imaginary instanceof CelestialBody);
        // test to make sure Planet is not a Sun
        assertFalse(imaginary.getClass().isAssignableFrom(Sun.class));
        // test to make sure Sun is not a Planet
        assertFalse(s.getClass().isAssignableFrom(Planet.class));
        assertEquals(new DirectionVector(-100, 200), imaginary.getDirection());
        assertEquals(new Position(10000000000.0f, 5000), imaginary.getPosition());
        assertEquals(1.0, imaginary.getMass(), 0.01);
    }

    public void test_updatePlanet() {
        Sun s = new Sun();
        Planet imaginary = new Planet(1, new Position(10000000000.0f, 5000), new DirectionVector(-100, 200));
        
        imaginary.updatePosition(100);
        assertEquals(new Position(9999990000.0f, 25000), imaginary.getPosition());
        assertEquals(new DirectionVector(-100, 200), imaginary.getDirection());

        imaginary.updateDirectionFromSun(s, 100);
        assertEquals(new Position(9999990000.0f, 25000), imaginary.getPosition());
        DirectionVector updatedDV = imaginary.getDirection();
        assertEquals(-232.7496, updatedDV.getX(), 0.01);
        assertEquals(199.99967, updatedDV.getY(), 0.01);
    }
    public void test_solarModel() {
        Sun s = new Sun();
        Planet imaginary = new Planet(1, new Position(10000000000.0f, 5000), new DirectionVector(-100, 200));
        SolarModel solarModel = new SolarModel(s, imaginary);
        
        solarModel.update(100.0f);

        assertEquals(new Position(9999990000.0f, 25000), imaginary.getPosition());
        DirectionVector updatedDV = imaginary.getDirection();
        assertEquals(-232.7496, updatedDV.getX(), 0.01);
        assertEquals(199.99967, updatedDV.getY(), 0.01);
    }
}
