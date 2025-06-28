package session2;
import java.util.Scanner;

public class words{

public static void main(String[] args) {

Scanner sc= new Scanner(System.in);

System.out.println("Enter the sentence:");

String sentence = sc.nextLine();

String[] words = sentence.split("\\s+");

System.out.println("the words are:");

for (String word: words){

System.out.println(word);

}

System.out.println("total words:" + words.length);

}

}