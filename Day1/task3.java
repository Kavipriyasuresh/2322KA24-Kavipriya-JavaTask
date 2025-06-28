package session1;
import java.util.Scanner;

public class task3 {

    public static boolean isLeapYear(int year) {
        // Correct leap year logic
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = sc.nextInt(); // Added '='

        if (isLeapYear(year)) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is not a leap year.");
        }

        sc.close(); // Good practice to close the scanner
    }
}
