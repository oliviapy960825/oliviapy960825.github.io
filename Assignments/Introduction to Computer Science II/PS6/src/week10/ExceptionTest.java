package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    
    public static String readFileContents(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try {
            FileReader f = new FileReader(fileName);
            int c = f.read();
            while (c >= 0) {
                content.append((char)c);
                c = f.read();
            }
            f.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }    
        return content.toString();
    }
    
    public static List<String> readTags(String fileName) throws IOException {
        String content = readFileContents(fileName);
        List<String> tags = new ArrayList<>();
        try {
            String[] all = content.split("_");
            for (int i = 1; i < all.length; i += 2) {
                tags.add(all[i]);
            }
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
        return tags; 
        
    }

    public static void main(String[] args) {
        try {
            List<String> tags = readTags(args[0]);
            System.out.println(tags);
        } catch (Throwable t) {
            System.out.println("Caught: " + t);
        }
        System.out.println("Bye now!");
    }
}
