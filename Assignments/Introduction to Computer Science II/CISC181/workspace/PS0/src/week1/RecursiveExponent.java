package week1;

public class RecursiveExponent {
	public static double exp(double base, double power) {
		if (power <= 0) {
			return 1.0;
		}
		else {
			double sub = exp(base, power - 1);
			// note: a faster algorithm would test if power is even
			return base * sub;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(exp(5, 3));
		System.out.println(exp(10, 2));
		System.out.println(exp(7, 6));
	}
}
