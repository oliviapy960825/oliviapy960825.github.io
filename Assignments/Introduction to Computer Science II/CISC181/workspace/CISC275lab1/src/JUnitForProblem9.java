import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class JUnitForProblem9 extends TestCase{

	@Test
	public void test() {
		int[] array=new int[]{1,2,3,4};
		assertEquals(1,pretest.smallest(array),0.01);
	}

}
