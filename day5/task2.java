package session5;
import java.util.HashSet;
import java.util.Scanner;
public class task2 {
	    public static void main(String[] args) {
	       
	        HashSet<String> emailSet = new HashSet<>();
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Enter email addresses (type 'exit' to finish):");

	        while (true) {
	            String email = scanner.nextLine().trim();
	            
	            if (email.equalsIgnoreCase("exit")) {
	                break;
	            }

	            
	            if (emailSet.add(email)) {
	                System.out.println("Email added.");
	            } else {
	                System.out.println("Duplicate email. Not added.");
	            }
	        }

	 
	        System.out.println("\nUnique Email Addresses:");
	        for (String email : emailSet) {
	            System.out.println(email);
	        }

	        scanner.close();
	    }
	}

