package week6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.TestCase;

public class SetMapExamples extends TestCase {
    
    /**
     * Returns true if a is a subset of b
     */
    public static boolean isSubset1(Set<Integer> a, Set<Integer> b) {
        boolean result = true;
        for (Integer value : a) {
            result = result && b.contains(value);
        }
        
        return result;
    }
    
    public static boolean isSubset2(Set<Integer> a, Set<Integer> b) {
        return b.containsAll(a);
    }
    
    public static void test_isSubset() {
        Set<Integer> set1 = new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 4, 5));
        
        assertFalse(isSubset1(set1, set2));
        assertTrue(isSubset1(set2, set1));
        
        assertFalse(isSubset2(set1, set2));
        assertTrue(isSubset2(set2, set1));
    }
    
    public static boolean isProperSubset(Set<Integer> a, Set<Integer> b) {
        return b.containsAll(a) && !a.equals(b);
    }

    public static void test_isProperSubset() {
        Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(1, 4, 5));
        Set<Integer> set3 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        
        assertFalse(isProperSubset(set1, set2));
        assertTrue(isProperSubset(set2, set1));

        assertTrue(isSubset1(set1, set1));
        assertFalse(isProperSubset(set1, set1));
        
        assertFalse(isProperSubset(set1, set3));

    }
    
    public static Set<String> combine(String[][] all) {
        Set<String> result = new HashSet<String>();
        for (String[] row : all) {
            for (String value : row) {
                result.add(value);
            }
        }
        return result;
    }
    
    public static void test_combine() {
        String[][] all = {{"1","2","4","8","32"},
                          {"1","one","won","whun","I"},
                          {"won","lost","draw","forfeit"}};
        
        assertEquals(new HashSet<String>(
                Arrays.asList("lost","draw","forfeit","one","won","whun","I","1","2","4","8","32")),
                combine(all));
    }

    /**
     * Assumes the input is two arrays of equal length. Produces a mapping of the
     * keys to corresponding value.
     */
    public static Map<String, String> convert(String[] keys, String[] values) {
        Map<String, String> result = new HashMap<String, String>();
        
        for (int i = 0; i < keys.length; i++) {
//            if (!result.containsKey(keys[i])) {
                result.put(keys[i], values[i]);
//            }
        }
       
        
        return result;
    }
    
    public static void test_convert() {
        String[] singers = {"Kanye", "Posh Spice", "Miley", "Dr. Dre", "Beiber"};
        String[] gradeInCISC181 = {"C+", "A", "B-", "A", "Z"};
        
        Map<String, String> gradeMap = convert(singers, gradeInCISC181);
        assertEquals("C+", gradeMap.get("Kanye"));
        assertEquals("Z", gradeMap.get("Beiber"));
        
        Map<String, String> singerMap = convert(gradeInCISC181, singers); // who got what grade?
        assertEquals("Kanye", singerMap.get("C+"));
        assertEquals("Miley", singerMap.get("B-"));
        assertEquals("Dr. Dre", singerMap.get("A")); // what happened to Posh Spice?
        
        System.out.println(singerMap.size());
    }
}
