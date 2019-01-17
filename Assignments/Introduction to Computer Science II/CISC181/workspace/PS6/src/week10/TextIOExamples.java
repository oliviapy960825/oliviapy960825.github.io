package week10;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import week5.StringExamples;

public class TextIOExamples {
    
    public static String pigLatin(String word) {
        String trimmed = word.trim(); // make sure no spaces
        Pattern softSound = Pattern.compile("[aeiouAEIOU]+");
        Matcher matches = softSound.matcher(trimmed);

        if (trimmed.length() > 0 && matches.find()) {
            StringBuilder result = new StringBuilder();
            if (matches.start() == 0) {
                result.append(trimmed);
                result.append("-");
                result.append(trimmed, 0, matches.end());
                result.append("hay");
            }
            else {
                result.append(trimmed, matches.start(), trimmed.length());
                result.append("-");
                result.append(trimmed, 0, matches.start());
                result.append("ay");
            }
            String newWord = result.toString();

            // did it end in a comma?
            if (trimmed.endsWith(",")) {
                // move comma to end
                newWord = newWord.replace(",", "") + ",";
            }

            return newWord;
        }
        else {
            return word;
        }
    }

    public static void translateToPigLatin(Scanner p, Appendable output) throws IOException {
        p.useDelimiter("\\.");

        while (p.hasNext()) {
            String sentence = p.next();
            String[] words = sentence.split("\\s");

            for (String word : words) {
                output.append(pigLatin(word)).append(" ");
            }
            output.append(". ");
        }
    }

    public static String translateToPigLatin(String input) throws IOException {
        StringBuilder builder = new StringBuilder();
        translateToPigLatin(new Scanner(input), builder);
        return builder.toString();
    }

    public static void translateFileToPigLatin(String filename) throws IOException {
        PrintStream output = new PrintStream(filename + ".ay");
        translateToPigLatin(new Scanner(new File(filename)), output);
    }
    
    public static void main(String[] args) throws Exception {
        System.out.printf("Grand Total: %,.2f", 123.456);
        
        translateFileToPigLatin("./src/" + TextIOExamples.class.getPackage().getName().replace('.', '/') + "/alice.txt");

        File file = new File("myOutputFile.txt");
        PrintStream out = new PrintStream(file);
        out.println("test output");
    }
}
