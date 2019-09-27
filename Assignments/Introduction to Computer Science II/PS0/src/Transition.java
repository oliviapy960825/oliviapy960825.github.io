
	import junit.framework.TestCase;
	import junit.textui.TestRunner;

	public class Transition extends TestCase {
	    public static double celsiusToFahrenheit(double cdeg) {
	        return 32.0 + (cdeg * 1.8);
	    }

	    public static void test_celsiusToFahrenheit() {
	        assertEquals(77.0, celsiusToFahrenheit(25.0), 0.01);
	    }

	    // static method using selection
	    public static int teeShirtPrice(char size) {
	        if (size == 'S') {
	            return 12;
	        }
	        else if (size == 'M') {
	            return 14;
	        }
	        else if (size == 'L') {
	            return 16;
	        }
	        else {
	            return 18;
	        }
	    }

	    // using the ternary operator
	    public static int teeShirtPrice_v2(char size) {
	        return (size == 'S') ? 12 :
	               (size == 'M') ? 14 :
	               (size == 'L') ? 16 : 
	            	   18;
	    }
	    
	    public static int teeShirtWithLogoPrice(char size, int numberOfColors) {
	        return teeShirtPrice(size) + 4 * numberOfColors;
	    }

	    public static int root(int n, int start, int end, int base) {
	        if (end <= start) {
	            return start;
	        }
	        else {
	            int mid = (end + start) / 2;
	            int guess = (int) Math.pow(mid, base);
	            if (guess < n) {
	                return root(n, mid + 1, end, base);
	            }
	            else if (guess > n) {
	                return root(n, start, mid, base);
	            }
	            else {
	                return mid;
	            }
	        }
	    }

	    // Made as an inner class just to keep this in one file
	    public static class xyvector {
	        double x;
	        double y;
	        public xyvector(double x, double y) {
	            this.x = x;
	            this.y = y;
	        }
	        public xyvector midpoint() {
	            return new xyvector(this.x / 2, 
	                    this.y / 2);
	        }
	        public double magnitude() {
	            return Math.sqrt(Math.pow(this.x, 2) 
	                    + Math.pow(this.y, 2));
	        }
	        public String toString() {
	            return "xyvector(" + this.x + ", "
	                    + this.y + ")";
	        }
	    }

	    public static void main(String[] args) {
	        System.out.println(5 + 10);

	        double LBS_TO_KILO = 0.45359237;
	        System.out.println(175 * LBS_TO_KILO);

	        int age = 19;
	        System.out.println(age);
	        age = age + 1;
	        System.out.println(age);

	        int JOE_AGE = 25;
	        if (JOE_AGE < 18) {
	            System.out.println("minor");
	        }
	        else if (JOE_AGE < 65) {
	            System.out.println("adult");
	        }
	        else {
	            System.out.println("senior");
	        }

	        System.out.println(celsiusToFahrenheit(25.0));
	        System.out.println(teeShirtWithLogoPrice('S', 2));
	        System.out.println(teeShirtWithLogoPrice('X', 3));

	        int total = 0;
	        for (int i = 0; i < 10; i++) {
	            total += i;
	        }
	        System.out.println(total);

	        int guess = 1;
	        while (guess % 7 != 0) {
	            guess = (int)(Math.random()*100);
	        }
	        System.out.println(guess);

	        System.out.println(root(16, 0, 16, 2));
	        System.out.println(root(24, 0, 24, 2));

	        xyvector SAMPLE_XY = new xyvector(10.0, 24.0);
	        System.out.println(SAMPLE_XY.midpoint());
	        System.out.println(SAMPLE_XY.magnitude());

	        TestRunner.run(Transition.class);
	    }
	}
