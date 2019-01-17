package week4;

import java.util.ArrayList;

public class ColorList {
    private static ArrayList<String> createList() {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Red");
        colors.add("Rose");
        colors.add("Blue");
        return colors;
    }
    
    public static ArrayList<String> getAllStartingWith(String s, ArrayList<String> colors) {
        ArrayList<String> result = new ArrayList<String>();
        for (String color : colors) {
            if (color.startsWith(s)) {
                result.add(color);
            }   
        }
        return result;
    }
    
    public static void main(String[] args) {
        ArrayList<String> colors = createList();
        
        System.out.println(getAllStartingWith("R", colors));
        System.out.println(getAllStartingWith("B", colors));
    }
}
