package Pretest;
import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest {

	@Test
	public void test() {
		int[] intArray2={1,2,3,4};
		assertEquals(2.5,Main.average(intArray2),0.01);
	}

}