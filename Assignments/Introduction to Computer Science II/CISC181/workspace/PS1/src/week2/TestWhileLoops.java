package week2;

import junit.framework.TestCase;

public class TestWhileLoops extends TestCase {

	public void test_sumAccum() {
		assertEquals(45, WhileLoops.sumAccum(1, 10));
	}
	
	public void test_multipleOfSeven() {
		assertTrue(WhileLoops.guessMultipleOfSeven() % 7 == 0);
	}

    public void test_ln() {
        assertEquals(2.302585092994046, WhileLoops.ln(10, 0.000001), 0.00001);
    }

}
