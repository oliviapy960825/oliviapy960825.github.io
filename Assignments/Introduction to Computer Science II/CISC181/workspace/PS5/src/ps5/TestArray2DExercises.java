package ps5;

import java.util.Arrays;

import junit.framework.TestCase;

public class TestArray2DExercises extends TestCase {

    // example arrays for testing
    private int[][] basic, allneg, nonsquare, negatives, rowmagic, 
        increase1, increase2, increase3, increase4, increase5;

    /**
     * Sets up the test fixture with some arrays to test. This method is called
     * before every test case method.
     */
    public void setUp() {
        basic = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        allneg = new int[][] { { -10, -12, -3 }, { -4, -5, -6, -8 }, { -7, -8 } };
        nonsquare = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8, 9 } };
        negatives = new int[][] { { 1, -2, 3 }, { 4, 5, 6 }, { -7, 8, -9 } };
        rowmagic = new int[][] { { 1, 2, 3 }, { -1, 5, 2 }, { 4, 0, 2 } };
        increase1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 6, 8, 9 } };
        increase2 = new int[][] { { 1, 4, 2 }, { 5, 6, 8 }, { 8, 10, 12 } };
        increase3 = new int[][] { { 1, 2, 4 }, { 5, 6, 8 }, { 0, 1, 3 } };
        increase4 = new int[][] { { 1, 2 }, { 5, 6 }, { 8, 9 }, {9, 11} };
        increase5 = new int[][] { { 1, 4, 2 }, { 5, 6, 8 }, { 8, 10, 12 } };
    }

    /**
     * Test max is found correctly (last element in the search)
     */
    public void testMaxNormal() {
        assertEquals(9, Array2DExercises.max(basic));
    }

    /**
     * Test max correct when all vals are negative
     */
    public void testMaxAllNeg() {
        assertEquals(-3, Array2DExercises.max(allneg));
    }

    /**
     * Test row sum calculated correctly including for nonsquare arrays
     */
    public void testRowSum() {
        assertEquals(6, Array2DExercises.rowSum(basic, 0));
        assertEquals(15, Array2DExercises.rowSum(basic, 1));
        assertEquals(24, Array2DExercises.rowSum(basic, 2));
        assertEquals(30, Array2DExercises.rowSum(nonsquare, 2));
    }

    /**
     * Test column sum calculated correctly for standard cases
     */
    public void testColumnSum() {
        assertEquals(12, Array2DExercises.columnSum(basic, 0));
        assertEquals(15, Array2DExercises.columnSum(basic, 1));
        assertEquals(18, Array2DExercises.columnSum(basic, 2));
    }

    /**
     * Test column sum calculated correctly for nonsquare arrays This checks for
     * sum of incomplete columns (from ragged arrays)
     */
    public void testColumnSumRagged() {
        assertEquals(11, Array2DExercises.columnSum(nonsquare, 2));
        assertEquals(9, Array2DExercises.columnSum(nonsquare, 3));
    }

    /**
     * Checks array of row sums correctly calculated
     */
    public void testAllRowSums() {
        int[] expected = new int[] { 6, 15, 24 };
        int[] actual = Array2DExercises.allRowSums(basic);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    /**
     * Test isSequence
     */
    public void test_isIncreasing() {
        assertEquals(false, Array2DExercises.isIncreasing(negatives));
        assertEquals(false, Array2DExercises.isIncreasing(rowmagic));
        assertEquals(true, Array2DExercises.isIncreasing(increase1));
        assertEquals(false, Array2DExercises.isIncreasing(increase2));
        assertEquals(false, Array2DExercises.isIncreasing(increase3));
        assertEquals(true, Array2DExercises.isIncreasing(increase4));
        assertEquals(false, Array2DExercises.isIncreasing(increase5));
    }

}