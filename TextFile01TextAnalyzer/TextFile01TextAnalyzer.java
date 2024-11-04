import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFile01TextAnalyzer {
    public static void main(String[] args) {
        File file = new File("Jerwin.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder text = new StringBuilder();
            int wordCount = 0;
            int sentenceCount = 0;
            String longestWord = "";

            while ((line = br.readLine()) != null) {
                text.append(line).append(" ");
                
                // Clean up the line
                line = line.replaceAll("[^a-zA-Z0-9\\s.!?]", "");

                // Split into words
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount++;
                        if (word.length() > longestWord.length()) {
                            longestWord = word;
                        }
                    }
                }

                // Count sentences using a more robust regex
                String[] sentences = line.split("(?<=[.!?])\\s+");
                sentenceCount += sentences.length;
            }

            String uppercaseText = text.toString().toUpperCase();

            System.out.println("\n--- Text Analysis Results ---");
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Sentences: " + sentenceCount);
            System.out.println("Longest Word: " + longestWord);
            System.out.println("\nUppercase Text:\n" + uppercaseText);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
