package session1;
import java.util.Scanner;

public class Main {

    static int add(int a, int b) {
        return a + b;
    }

    static int sub(int a, int b) {
        return a - b;
    }

    static int multiply(int a, int b) {
        return a * b;
    }

    static double divide(int a, int b) {
        return b != 0 ? (double) a / b : 0; 
    }

    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in); 

        int a, b, choice;

        System.out.println("1. Add\n2. Subtract\n3. Multiply\n4. Divide");

        System.out.print("Enter your choice: ");
        choice = sr.nextInt();

        System.out.print("Enter two numbers: ");
        a = sr.nextInt();
        b = sr.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Result: " + add(a, b));
                break;
            case 2:
                System.out.println("Result: " + sub(a, b));
                break;
            case 3:
                System.out.println("Result: " + multiply(a, b));
                break;
            case 4:
                System.out.println("Result: " + divide(a, b));
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sr.close(); // Always close Scanner
    }
}
