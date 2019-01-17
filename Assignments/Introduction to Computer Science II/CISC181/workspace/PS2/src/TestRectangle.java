import junit.framework.TestCase;


public class TestRectangle extends TestCase {

	public void test_getArea() {
		Rectangle testRect = new Rectangle(5, 10);
		assertEquals(50, testRect.getArea(), 0.1);
	}

	public void test_getPerimeter() {
		Rectangle testRect = new Rectangle(5, 10);
		assertEquals(30, testRect.getPerimeter(), 0.1);
	}
	
	public void test_makeGoldenRectangle(){
		Rectangle newGoldenRectangle;
		newGoldenRectangle=Rectangle.makeGoldenRectangle(10.0);
		assertEquals(10,newGoldenRectangle.getHeight(),0.1);
		assertEquals(6.1803,newGoldenRectangle.getWidth(),0.1);
		assertEquals(32.3607,newGoldenRectangle.getPerimeter(),0.1);
		assertEquals(61.803,newGoldenRectangle.getArea(),0.1);
		
	}
}
