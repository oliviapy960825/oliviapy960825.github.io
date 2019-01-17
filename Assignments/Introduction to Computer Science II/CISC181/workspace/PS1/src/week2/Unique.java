package week2;

import junit.framework.TestCase;

public class Unique extends TestCase {

	/**
	 * This function consumes a String and a character and produces
	 * a count of how many times the character appears in the String
	 * 
	 * @param s
	 * @param c
	 * @return
	 */
	public static int count(String s, char c) {

	    return 0;
	}
	
	public static void test_count() {
		assertEquals(3, count("ffifkmi", 'f'));
		assertEquals(1, count("ffifkmi", 'k'));
		assertEquals(0, count("ffifkmi", 'x'));
	}
	
	/**
	 * This function consumes a String and produces a String containing
	 * only the characters that appear once in the String
	 * 
	 * @param s
	 * @return
	 */
	public static String unique(String s) {
	    return "";
	}
	
	public static void test_unique() {
		assertEquals("km", unique("ffifkmi"));
		assertEquals("es", unique("test"));
		assertEquals("confuse", unique("confuse"));
        assertEquals("", unique("mama"));
		assertEquals("", unique(""));
	}
	

}
