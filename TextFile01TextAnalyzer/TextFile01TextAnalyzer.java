import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextAnalyzer {
    public static void main(String[] args) {
        File file = new File("Marvin.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder text = new StringBuilder();
            int wordCount = 0;
            int sentenceCount = 0;
            String longestWord = "";
            
            while ((line = br.readLine()) != null) {
                text.append(line).append(" ");
                               
                line = line.replaceAll("[^a-zA-Z0-9\\s]", "");
                         
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > 0) {
                        wordCount++;
                        if (word.length() > longestWord.length()) {
                            longestWord = word;
                        }
                    }
                }
                                
                sentenceCount += line.split("[.!?]").length - 1;
            }
            br.close();
        
            String uppercaseText = text.toString().toUpperCase();
          
            System.out.println("\n--- Text Analysis Results ---");
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Sentences: " + sentenceCount);
            System.out.println("Longest Word: " + longestWord);
            System.out.println("\nUppercase Text:\n" + uppercaseText);

        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
