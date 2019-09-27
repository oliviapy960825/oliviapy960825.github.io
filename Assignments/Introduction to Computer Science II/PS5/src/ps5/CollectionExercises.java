package ps5;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class CollectionExercises {

    /**
     * Returns a new List that contains all of the Integers in the
     * given List that are less than zero
     */
    public static List<Integer> lessThanZero(List<Integer> l) {
    	List<Integer> lessThanZeroList=new ArrayList<Integer>();
        for(int a:l){
        	if(a<0){
        		lessThanZeroList.add(a);
        	}
        }
        return lessThanZeroList;
    }
    
    /**
     * Mutates the given List by removing all of the Integers in the
     * List that are less than zero
     */
    public static void removeLessThanZero(List<Integer> l) {
    	 Iterator<Integer> iterator = l.iterator();
    	 while (iterator.hasNext()) {
           int num = iterator.next();
           if (num<0) {
               iterator.remove();
           }
      }
        }
        
    
    /**
     * Returns a new Set that contains all of the elements in a and
     * all of the elements in b (i.e. the union of two sets).
     */
    public static Set<Integer> union(Set<Integer> a, Set<Integer> b) {
        Set<Integer> c=new HashSet<Integer>();
        for(int num1:a){
        	for(int num2:b){
        		c.add(num2);
        	}
        	c.add(num1);
        }
        return c;
    }
    
    /**
     * Returns a new Set that contains all of the elements that are
     * in a and also in b (i.e. the intersection of two sets).
     */
    public static Set<Integer> intersection(Set<Integer> a, Set<Integer> b) {
    	Set<Integer> c=new HashSet<Integer>();
        for(int num1:a){
        	for(int num2:b){
        		if(a.contains(num2)){
        			c.add(num2);
        		}
        	}
        	
        }
        return c;
    }
    
    /**
     * Returns a new Map that contains a reverse mapping of the given map.
     * Thus each key in the given map will appear as a value in the result,
     * and each value in the given map will appear as a key in the result.
     * 
     * Because a Map contains a many to one mapping (i.e. two keys can map
     * to the same value), to properly return a reverse mapping each key
     * in the result could have multiple values. To represent this, each key
     * in the result has a Set as its mapped value where the Set contains
     * all of the multiple values.
     * 
     * See the test class for a concrete example.
     */
    public static Map<String, Set<String>> reverseMapping(Map<String, String> mapping) {
    	 Map<String, Set<String>> result = new HashMap<String, Set<String>>();
//         Set<String> values=new HashSet<String>(mapping.keySet().size());
         for (String key : mapping.keySet()) {
        	 String value = mapping.get(key);
        	 //
        	 boolean bool=result.containsKey(value);
        	 if(bool){
        		 result.get(value).add((String) key);
        	 } 
        	 else{
        		 Set<String> s = new HashSet<String>();
        		 s.add((String)key);
        		 result.put(value,s);
        	 }
         }
        
         
         return result;

    }
    
}
