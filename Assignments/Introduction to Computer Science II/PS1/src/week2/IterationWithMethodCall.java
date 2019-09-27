package week2;

public class IterationWithMethodCall {
    public static int m(int x, int y) {
        x = x + y;
        return x;
    }
    
    public static void main(String[] args) {
        int x = 4;
        int[] values = { 0, 1, 2, 3 };
        for (int y : values) {
            System.out.print(m(x, y) + ",");
        }
        System.out.println();
        
        System.out.println(f(2, 0, 3));
        System.out.println(f(4, 1, 4));

        System.out.println(h(2, 0, 3));
        System.out.println(h(4, 1, 4));
    }
    
    public static int f(int a, int x, int y) {
        int r = 0;
        while (x < y) {
            r = r + g(a, x, y);
            x = x + 1;
            y = y - 1;
        }
        return r;
    }
    
    public static int g(int a, int x, int y) {
        int r = 0;
        for (int i = x; i < y; i++) {
            r = r + a;
        }
        return r;
    }
    
    public static int h(int a, int x, int y) {
        int r = 0;
        while (x < y) {
            for (int i = x; i < y; i++) {
                r = r + a;
            }
            x = x + 1;
            y = y - 1;
        }
        return r;
    }
}
