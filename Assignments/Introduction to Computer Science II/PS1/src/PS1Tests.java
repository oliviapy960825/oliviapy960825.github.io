import junit.framework.TestCase;

/**
 * Contains tests for Practice Set 1.  To run this in Eclipse, right-click
 * anywhere in this file and choose Run As->JUnit Test.  See the PS1.pdf
 * instructions if you get a popup dialog about choosing a launcher.
 * 
 * Each problem in PS1 has a corresponding method and test.  Uncomment
 * each test as you work through by removing the block comment.
 *  
 * @author jatlas
 */
public class PS1Tests extends TestCase {
    
    // for Problem #1
    public static void test_windChillTemperature() {
        // these calls to assertEquals test whether the returned value 
        //  from your static method is within 0.001 of the expected result
        assertEquals(66.815, PS1.windChillTemperature(50, 0), 0.001);
        assertEquals(96.592, PS1.windChillTemperature(90, 40), 0.001);
        assertEquals(17.362, PS1.windChillTemperature(30, 20), 0.001);
    }
    
    // for Problem #2
    
    public static void test_teaParty() {
        assertEquals(1, PS1.teaParty(6, 8));
        assertEquals(0, PS1.teaParty(3, 8));
        assertEquals(2, PS1.teaParty(20, 6));
    }
   
    
    // for Problem #3
    
    public static void test_shareDigit() {
        assertEquals(true, PS1.shareDigit(12, 23));
        assertEquals(false, PS1.shareDigit(12, 43));
        assertEquals(false, PS1.shareDigit(12, 44));
    }
   
    
    // for Problem #4
    
    public static void test_closestFactorToSqrt() {
        assertEquals(1, PS1.closestFactorToSqrt(1));
        assertEquals(2, PS1.closestFactorToSqrt(4));
        assertEquals(2, PS1.closestFactorToSqrt(10));
        assertEquals(7, PS1.closestFactorToSqrt(70));
        assertEquals(1, PS1.closestFactorToSqrt(1427));
    }
    
    
    // for Problem #5
    
    public static void test_oddParity() {
        assertEquals(true, PS1.oddParity(5));
        assertEquals(false, PS1.oddParity(4));
        assertEquals(false, PS1.oddParity(55));
        assertEquals(true, PS1.oddParity(45));
        assertEquals(true, PS1.oddParity(4532120));
        assertEquals(false, PS1.oddParity(4532121));
    }
    
    // for Problem #6

    public static void test_countShared() {
    	assertEquals(9, PS1.countShared('A'));
    	assertEquals(6, PS1.countShared('Z'));
    	assertEquals(17, PS1.countShared('D'));
    	assertEquals(4, PS1.countShared(' '));
    }
  
}