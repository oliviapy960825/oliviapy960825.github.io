package week1;

public class OutputVsReturn {
    public static void f(int x) {
        System.out.println("the value of x+2 is " + (x + 2));
    }

    public static int g(int x) {
        return x + 2;
    }
    
    public static int h(int x) {
//        return f(x) + 5;
        return g(x) + 5;
    }

    public static void main(String[] args) {
        f(5);
        System.out.println("the value of x+2 is " + g(5));
    }
}
