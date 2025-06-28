package session2;
import java.util.ArrayList;
import java.util.Scanner;

public class post{
    static class Book {
        private String title;
        private String author;
        private boolean isIssued;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public String getTitle() {
            return title;
        }

        public boolean isIssued() {
            return isIssued;
        }

        public void issueBook() {
            isIssued = true;
        }

        public void returnBook() {
            isIssued = false;
        }

        public void displayInfo() {
            System.out.println("Title : " + title);
            System.out.println("Author: " + author);
            System.out.println("Status: " + (isIssued ? "Issued" : "Available"));
        }
    }
    static class Library {
        private ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
            System.out.println("Book added: " + book.getTitle());
        }

        public void removeBook(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    books.remove(book);
                    System.out.println("Book removed: " + title);
                    return;
                }
            }
            System.out.println("Book not found: " + title);
        }

        public void issueBook(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title)) {
                    if (!book.isIssued()) {
                        book.issueBook();
                        System.out.println("Book issued: " + title);
                    } else {
                        System.out.println("Book already issued.");
                    }
                    return;
                }
            }
            System.out.println("Book not found: " + title);
        }

        public void displayBooks() {
            if (books.isEmpty()) {
                System.out.println("Library is empty.");
                return;
            }

            System.out.println("\nBooks in Library:");
            for (Book book : books) {
                book.displayInfo();
                System.out.println("-------------------");
            }
        }
    }
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Library System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Issue Book");
            System.out.println("4. Show All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title : ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;

                case 3:
                    System.out.print("Enter title to issue: ");
                    String issueTitle = scanner.nextLine();
                    library.issueBook(issueTitle);
                    break;

                case 4:
                    library.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting Library System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

