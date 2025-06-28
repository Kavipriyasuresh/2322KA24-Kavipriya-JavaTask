package session2;
import java.util.Scanner;

public class MiniAddress{
    public static void main(String[] args) {
        final int MAX_CONTACTS = 5; // Fixed-size address book

        String[] names = new String[MAX_CONTACTS];
        String[] phones = new String[MAX_CONTACTS];
        String[] emails = new String[MAX_CONTACTS];

        Scanner sc = new Scanner(System.in);

        int count = 0;

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (count < MAX_CONTACTS) {
                        System.out.print("Enter Name: ");
                        names[count] = sc.nextLine();

                        System.out.print("Enter Phone: ");
                        phones[count] = sc.nextLine();

                        System.out.print("Enter Email: ");
                        emails[count] = sc.nextLine();

                        System.out.println("Contact added successfully.");
                        count++;
                    } else {
                        System.out.println("Address book is full!");
                    }
                    break;

                case 2:
                    System.out.println("\nAll Contacts:");
                    for (int i = 0; i < count; i++) {
                        System.out.println((i + 1) + ". " + names[i] + " | " + phones[i] + " | " + emails[i]);
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (names[i].equalsIgnoreCase(searchName)) {
                            System.out.println("Contact found: " + names[i] + " | " + phones[i] + " | " + emails[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Address Book. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

                    