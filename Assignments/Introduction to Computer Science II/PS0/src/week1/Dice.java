package week1;
import junit.framework.TestCase;

public class Dice extends TestCase {
	/**
	 * Scoring rule for a simple dice game.
	 *  3 of a kind - score 20
	 *  2 of a kind - score 10
	 *  otherwise score is the largest die roll
	 */
	public static int score(int d1, int d2, int d3) {
	    if (d1 == d2 && d2 == d3) { 
	    	return 20;
		}
	    else if (d1 == d2 || d2 == d3 || d1 == d3) {
	        return 10;
	    }
	    else {
	        return Math.max(d1, Math.max(d2, d3));
	    }
    }

	public static void test_score() {
		assertEquals(20, score(5, 5, 5));
		assertEquals(10, score(5, 5, 3));
		assertEquals(5, score(5, 3, 1));
	}
	
	public static void main(String[] args) {
		System.out.println(score(5, 5, 5));
		System.out.println(score(5, 5, 3));
		System.out.println(score(5, 3, 1));
	}
}
