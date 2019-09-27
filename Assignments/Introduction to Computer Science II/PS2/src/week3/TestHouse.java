package week3;
import junit.framework.TestCase;

public class TestHouse extends TestCase {
	public static void test_House_getArea() {
		House full = new House(new Kitchen(), new Bedroom(12));
		assertEquals(200.0, full.getArea(), 0.001);
		
		House half = new House(new Kitchen(), null);
		assertEquals(80.0, half.getArea(), 0.001);
		
		House empty = new House(null, null);
		assertEquals(0.0, empty.getArea(), 0.001);
	}
}
