package week4;

import java.util.Arrays;
import java.util.Random;

import junit.framework.TestCase;

// This requires JUnit 3 to be added to your project.  The code and the tests are both
// in this file.
public class ArrayLoopMethods extends TestCase {

    // version 1, iterating left-to-right
    public static double sumElements_v1(double[] myArray) {
        double result = 0.0;
        
        for (int i = 0; i < myArray.length; i++) {
            result += myArray[i];
        }
    
        return result;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // version 2, iterating right-to-left
    public static double sumElements_v2(double[] myArray) {
        double sum = 0.0;
        for (int i = myArray.length - 1; i >= 0; i--) {
            sum += myArray[i];
        }        
        return sum;
    }

    // version 3, using for-each loop (this actually generates
    //  code just like version 1)
    public static double sumElements_v3(double[] myArray) {
        double sum = 0.0;
        for (double element : myArray) {
            sum += element;
        }        
        return sum;
    }
    
    public static void test_sumElements() {
        double[] a1 = {1.0, 2.0, 5.0};
        double[] a2 = {};
        double[] a3 = {-1, -2, 6};
        
        assertEquals(8.0, sumElements_v1(a1));
        assertEquals(0.0, sumElements_v1(a2));
        assertEquals(3.0, sumElements_v1(a3));
        
        assertEquals(8.0, sumElements_v2(a1));
        assertEquals(0.0, sumElements_v2(a2));
        assertEquals(3.0, sumElements_v2(a3));

        assertEquals(8.0, sumElements_v3(a1));
        assertEquals(0.0, sumElements_v3(a2));
        assertEquals(3.0, sumElements_v3(a3));
    }
    
    // version 1, "accumulates" result in found
    public static boolean find_v1(int[] myArray, int value) {
        boolean result = false;
        
        for (int i = 0; i < myArray.length; i++) {
            result = result || myArray[i] == value;
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // version 2, uses short-circuit logic in loop continuation
    //  condition to stop if the value is found
    public static boolean find_v2(int[] myArray, int value) {
        boolean found = false;
        for (int i = 0; i < myArray.length && !found; i++) {
            found = (myArray[i] == value);
        }
        return found;
    }
    
    // version 3, uses return to stop if the value is found
    public static boolean find_v3(int[] myArray, int value) {
        for (int v : myArray) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }
    
    public static void test_find() {
        int[] a1 = {1, 2, 5};
        int[] a2 = {};
        int[] a3 = {1, 1, 1, 1};
        
        assertEquals(true, find_v1(a1, 2));
        assertEquals(false, find_v1(a1, 9));
        assertEquals(false, find_v1(a2, 2));
        assertEquals(true, find_v1(a3, 1));

        assertEquals(true, find_v2(a1, 2));
        assertEquals(false, find_v2(a1, 9));
        assertEquals(false, find_v2(a2, 2));
        assertEquals(true, find_v2(a3, 1));
        
        assertEquals(true, find_v3(a1, 2));
        assertEquals(false, find_v3(a1, 9));
        assertEquals(false, find_v3(a2, 2));
        assertEquals(true, find_v3(a3, 1));
    }
    
    public static int[] rotate(int[] myArray) {
        int[] result = new int[myArray.length];

        for (int i = 0; i < myArray.length; i++) {

        }
        return result;
    }

    public static void test_rotate() {
        int[] a1 = {1, 2, 5};
        int[] a2 = {};
        int[] a3 = {1, 1, 1, 1};
        assertTrue(Arrays.equals(new int[]{2, 5, 1}, rotate(a1)));
        assertTrue(Arrays.equals(new int[]{5, 1, 2}, rotate(rotate(a1))));
        assertTrue(Arrays.equals(a2, rotate(a2)));
        assertTrue(Arrays.equals(a3, rotate(a3)));
    }
    
    
    public static int[] generateRandom(int howMany, int low, int high) {
        int[] result = new int[howMany];
        Random r = new Random();
        int n = high - low;
        for (int i = 0; i < howMany; i++) {
            result[i] = r.nextInt(n)+low;
        }
        return result;
    }
    
    public static int[] filterLessThan(int[] values, int value) {
        int[] result = new int[values.length];
        
        return result;
        
    }
    
    public static void test_filterLessThan() {
        int[] a1 = {1, 2, 5};
        int[] a2 = {};
        int[] a3 = {4, 1, 1, 1};
        assertTrue(Arrays.equals(new int[]{1, 2}, filterLessThan(a1, 5)));
        assertTrue(Arrays.equals(new int[]{}, filterLessThan(a2, 5)));
        assertTrue(Arrays.equals(new int[]{}, filterLessThan(a3, 0)));
        assertTrue(Arrays.equals(new int[]{4, 1, 1, 1}, filterLessThan(a3, 5)));
        assertTrue(Arrays.equals(new int[]{1, 1, 1}, filterLessThan(a3, 2)));
    }
    
    /**
     * sameEnds({5, 6, 45, 99, 13, 5, 6}, 1) -> false
     * sameEnds({5, 6, 45, 99, 13, 5, 6}, 2) -> true
     * sameEnds({5, 6, 45, 99, 13, 5, 6}, 3) -> false
     * 
     * @param nums
     * @param t
     * @return
     */
    public static boolean sameEnds(int[] nums, int t) {
        return false;
    }
    
    public static void test_sameEnds() {
        assertFalse(sameEnds(new int[]{5, 6, 45, 99, 13, 5, 6}, 1));
        assertTrue(sameEnds(new int[]{5, 6, 45, 99, 13, 5, 6}, 2));
        assertFalse(sameEnds(new int[]{5, 6, 45, 99, 13, 5, 6}, 3));
    }

}
