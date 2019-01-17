package week10;

public class FinallyTest {
    public static int method1() {
        try {
            int a = 5;
            int b = 6;
            return a + b;
        }
        finally {
            System.out.println("Still got here");
            try {
                throw new IllegalStateException("this is bad too");
            }
            catch (Exception e) {
                // now really make sure you don't do anything bad
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(method1());
    }
}
