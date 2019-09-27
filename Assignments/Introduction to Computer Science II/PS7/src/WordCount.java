import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {
public Map<String, Integer> counts;
public WordCount(){
	Map<String, Integer> counts=new HashMap<String,Integer>();
	this.counts=counts;
}
public void parse(Scanner in, Pattern pattern){
	//while Scanner has more tokens
	while (in.hasNext()) {
	 // get the next token
	 String token = in.next();
	 // match the pattern within the token
	 Matcher matcher = pattern.matcher(token);
	 // process each match found in token (could be more than one)
	 while (matcher.find()) {
	     // get the String that matched the pattern
	     String s = matcher.group().trim();
	     // now do something with s
	     //System.out.println(s); // replace this line with your code
	     if(!counts.containsKey(s)){
	    	 counts.put(s,1);
	     }
	     else{
	    	 counts.put(s,counts.get(s)+1);
	     }
	   }
	}
}
public Map<String, Integer> getCounts(){
	return counts;
}
public List<String> report(PrintStream newPrintStream){
	List<String> newString=new ArrayList<String>();
	List<Map.Entry<String,Integer>> results=new ArrayList<Map.Entry<String, Integer>>(counts.entrySet());
	Collections.sort(results, Collections.reverseOrder(Map.Entry.comparingByValue()));
    for(int i=0;i<results.size();i++){
    	System.out.println(results.get(i));
    	newPrintStream.append(results.get(i).toString());
    	newPrintStream.append('\n');
     
}
    
    return newString;
}
public static void main(String[] args) throws IOException { // use the first argument as the file to read from 
	Scanner in = new Scanner(new File(args[0]));
	// use the second argument as the pattern to match 
	Pattern pattern = Pattern.compile(args[1]);
	// use the linefeed character to delimit each token in the stream 
	in.useDelimiter("\n");
	// count and report the "words" that match the given pattern in the stream 
	WordCount wc = new WordCount();
	wc.parse(in, pattern);
	wc.report(System.out);
	}
}
