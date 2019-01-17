
import java.util.Arrays;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class PS4PartATests extends TestCase {
    // helper methods so that you will get more helpful error messages
    //  when asserting two arrays to be equal
    private static void assertArrayEquals(int[] expected, int[] actual) {
        if (!Arrays.equals(expected, actual)) {
            if (expected.length != actual.length) {
                throw new AssertionFailedError("Array lengths not equal; expected:" + expected.length + " but was:" + actual.length);
            }
            else {
                for (int i = 0; i < expected.length; i++) {
                    if (expected[i] != actual[i]) {
                        throw new AssertionFailedError("arrays first differed at element ["+i+"]; expected:"+expected[i]+" but was:"+actual[i]);
                    }
                }
            }
        }
    }
    private static void assertArrayEquals(char[] expected, char[] actual) {
        if (!Arrays.equals(expected, actual)) {
            if (expected.length != actual.length) {
                throw new AssertionFailedError("Array lengths not equal; expected:" + expected.length + " but was:" + actual.length);
            }
            else {
                for (int i = 0; i < expected.length; i++) {
                    if (expected[i] != actual[i]) {
                        throw new AssertionFailedError("arrays first differed at element ["+i+"]; expected:"+expected[i]+" but was:"+actual[i]);
                    }
                }
            }
        }
    }
    
    
    // Tests for all of the static methods in ArrayStaticMethods
    public void test_mean() {
        assertEquals(3.11, ArrayStaticMethods.mean(new double[]{1.9, 2.5, 3.7, 2, 1, 6, 3, 4, 5, 2}), 0.01);
        assertEquals(3, ArrayStaticMethods.mean(new double[]{1, 5}), 0.01);
        assertEquals(1, ArrayStaticMethods.mean(new double[]{1}), 0.01);
        assertEquals(-1,ArrayStaticMethods.mean(new double[]{1,-1,-3}),0.01);
        //add a test with negative numbers

    }

    public void test_countWords() {
        assertEquals(9, ArrayStaticMethods.countWords("The quick brown fox jumps over the lazy dog.".toCharArray()));
        assertEquals(1, ArrayStaticMethods.countWords("No.".toCharArray()));
        assertEquals(7, ArrayStaticMethods.countWords("Five, three, and seven are odd numbers.".toCharArray()));
        assertEquals(0,ArrayStaticMethods.countWords("".toCharArray()));
        // add a test with no words

    }
    
    public void test_replace() {
        assertArrayEquals(new int[]{1, 6, 6, 1}, ArrayStaticMethods.replace(new int[]{1, 0, 0, 1}, 0, 6));
        assertArrayEquals(new int[]{5, 5, 5, 5}, ArrayStaticMethods.replace(new int[]{5, 0, 0, 5}, 0, 5));
        assertArrayEquals(new int[]{}, ArrayStaticMethods.replace(new int[]{}, 0, 5));
        assertArrayEquals(new int[]{1,6,6,1},ArrayStaticMethods.replace(new int[]{1,6,6,1}, 0, 6));
        // add a test where no replacements occur
        
    }
    

    public void test_evenFront() {
        assertArrayEquals(new int[]{0, 0, 1, 1}, ArrayStaticMethods.evenFront(new int[]{1, 0, 0, 1}));
        assertArrayEquals(new int[]{0, 2, 4, 1, 3}, ArrayStaticMethods.evenFront(new int[]{0, 2, 1, 4, 3}));
        assertArrayEquals(new int[]{1}, ArrayStaticMethods.evenFront(new int[]{1}));
        assertArrayEquals(new int[]{}, ArrayStaticMethods.evenFront(new int[]{}));
        //add 2 tests with: all evens, all odds
        }
    public void test_surroundedCharacter(){
        assertEquals(true, ArrayStaticMethods.surroundedCharacter("abcdc".toCharArray()));
        assertEquals(false, ArrayStaticMethods.surroundedCharacter("abccc".toCharArray()));
        // add 2 tests: with an empty array, with multiple surrounded characters

    }
}
