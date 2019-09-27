package week6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ColorList {
    private static List<String> createList() {
        List<String> colors = new LinkedList<String>(Arrays.asList("Red", "Rose", "Blue"));
//        colors.add("Red");
//        colors.add("Rose");
//        colors.add("Blue");
        return colors;
    }
    
    private static List<String> createList2() {
        return new ArrayList<String>(Arrays.asList("Red", "Chartreuse", "Aqua"));
    }
    
    
    public static List<String> getAllStartingWith(String s, List<String> colors) {
//        List<String> result = new LinkedList<String>();
        List<String> result = new ArrayList<String>();
        for (String color : colors) {
            if (color.startsWith(s)) {
                result.add(color);
            }   
        }
        
//        Iterator<String> iterator = colors.iterator();
//        while (iterator.hasNext()) {
//            String color = iterator.next();
//            if (color.startsWith(s)) {
//                result.add(color);
//            }
//        }
        
//        List<String> result = new ArrayList<String>(colors);
//      Iterator<String> iterator = result.iterator();
//      while (iterator.hasNext()) {
//          String color = iterator.next();
//          if (!color.startsWith(s)) {
//              iterator.remove();
//          }
//      }
        return result;
    }
    
    public static String getLongestColorname(List<String> colors) {
        return null;
    }
    
    /**
     * Produces a list that is of the same length as the given two lists where each
     * element is a string concatenation of an element from list 1 and list 2
     * 
     * @param colors1
     * @param colors2
     * @return
     */
    public static List<String> combine(List<String> colors1, List<String> colors2) {
        return null;
    }
    
    /**
     * If the color is equal at the same position, add it to the result
     * 
     * @param colors1
     * @param colors2
     * @return
     */
    public static List<String> common(List<String> colors1, List<String> colors2) {
        return null;
    }
    
    public static List<String> sorted(List<String> colors) {
        return null;
    }
    
    public static void main(String[] args) {
        List<String> colors = createList();
        System.out.println(colors);
        
        List<String> colors2 = createList2();
        
        System.out.println(getAllStartingWith("R", colors));
        System.out.println(getAllStartingWith("B", colors));
        
        System.out.println(getAllStartingWith("A", colors2));

        System.out.println(getLongestColorname(colors));
        System.out.println(getLongestColorname(colors2));
        
        System.out.println(combine(colors, colors2));
        System.out.println(common(colors, colors2));

    }
}
