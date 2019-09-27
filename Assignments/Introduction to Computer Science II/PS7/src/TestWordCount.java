

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

import junit.framework.TestCase;

public class TestWordCount extends TestCase {
    public void test_WordCount_parse() {
        WordCount wc = new WordCount();
        Scanner in = new Scanner("this is a simple test, but it is not simple to pass");
        Pattern pattern = Pattern.compile("[i][a-z]+");
        wc.parse(in, pattern);
        
        assertEquals((Integer)3, wc.getCounts().get("is"));
        assertEquals((Integer)2, wc.getCounts().get("imple"));
        assertEquals((Integer)1, wc.getCounts().get("it"));
       
    }
    
  public void test_WordCount_report() {
        WordCount wc = new WordCount();
        Scanner in = new Scanner("this is a simple test, but it is not simple to pass");
        Pattern pattern = Pattern.compile("[i][a-z]+");
        wc.parse(in, pattern);
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        wc.report(new PrintStream(output));
        String out = output.toString();
        String ls = System.lineSeparator();
        
        assertEquals("is=3_imple=2_it=1_".replace("_", ls), out);
    }
    
}
