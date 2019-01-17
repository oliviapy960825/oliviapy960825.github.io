package week2;

import java.util.Random;

public class WhileLoops {
	public static int sumAccum(int i, int limit) {
		int total = 0;
		while (i < limit) {
			total = total + i;
			i = i + 1;
		}
		return total;
	}
	
	public static int guessMultipleOfSeven() {
		int guess = 1;
		Random r = new Random();
		while (guess % 7 != 0) {
		    guess = r.nextInt(100);
		}
		return guess;
	}
	
	/**
	 * Uses the Area Hyperbolic Tangent function to approximate
	 * the ln(z).  Approximation terminates when the difference between
	 * successive values in the sequence sum to less than delta.
	 * 
	 * @param z
	 * @return
	 */
	public static double ln(double z, double delta) {
		// this will make initial difference = z
		double previous = -z;
		double lnz = 0;
		// compute these ahead of time because they are commonly used terms
		double zn = (z-1.0)/(z+1.0);
		double zn1_np1_squared = zn*zn;
		double n = 1.0;
		while (lnz-previous > delta) {
			previous = lnz;
			lnz = lnz + (2.0/n)*zn;
			zn = zn*zn1_np1_squared;
			n = n + 2.0;
		}
		return lnz;
	}
	
	public static void example1() {
		int count = 0;
		int i = 0;
		while (count < 100) {
		  count = count + 10;
		  count = count - 10;
		  count = count + 1;
		  i++;
		}
		System.out.println(i);
	}
	
	public static void example2() {
	    int w = 8;
	    int x = 4;
	    while (w > x) {
	        x = (w - x) * 2;
	        w = w + 1;
	        System.out.print(w + ", ");
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(sumAccum(1, 10));
		System.out.println(guessMultipleOfSeven());
		System.out.println(ln(10, 0.000000000000001));
		
		example1();
		example2();
	}
}
