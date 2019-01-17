import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class lab1Test extends TestCase{
	 public static void test_multiply1() {
	        // these calls to assertEquals test whether the returned value 
	        //  from your static method is within 0.001 of the expected result
	        assertEquals(6, lab1.multiply(2, 3), 0.001);
	    }
	 public static void test_multiply2() {
	        // these calls to assertEquals test whether the returned value 
	        //  from your static method is within 0.001 of the expected result
	        assertEquals(5, lab1.multiply(2, 3), 0.001);
	    }
	 public static void test_concatenation1() {
	        // these calls to assertEquals test whether the returned value 
	        //  from your static method is within 0.001 of the expected result
	        assertEquals("23", lab1.concatenation("2", "3"));
	    }

	 public static void test_concatenation2() {
	        // these calls to assertEquals test whether the returned value 
	        //  from your static method is within 0.001 of the expected result
	        assertEquals("2 3", lab1.concatenation("2", "3"));
	    }
}
