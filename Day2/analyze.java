package session2;
import java.util.Scanner;

public class analyze {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sentence:");
        String sentence = sc.nextLine();

        String[] words = sentence.trim().split("\\s+");
        int wordCount = words.length;

        int charCount = 0;
        for (char ch : sentence.toCharArray()) {
            if (ch != ' ')
                charCount++;
        }

        String reversed = new StringBuilder(sentence).reverse().toString();

        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        
        System.out.println("Word count: " + wordCount);
        System.out.println("Character count (excluding spaces): " + charCount);
        System.out.println("Reversed string: " + reversed);
        System.out.println("Longest word: " + longestWord);

        
    }
}
