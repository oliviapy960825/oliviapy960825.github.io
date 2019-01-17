import static org.junit.Assert.*;

import org.junit.Test;

public class MyClassTest {

	@Test
	public void test() {
		assertEquals(0,MyClass.multiply(5, 0),0.01);
	}

}
