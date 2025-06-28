package session6;
class TicketCounter {
    private int totalSeats = 5;

    public void bookTicket(String userName, int numberOfSeats) {
        synchronized (this) {
            System.out.println(userName + " is trying to book " + numberOfSeats + " seat(s).");

            if (numberOfSeats <= totalSeats) {
                System.out.println("Seats available. Booking now for " + userName + "...");
                try {
                    Thread.sleep(1000); // Simulate delay
                } catch (InterruptedException e) {
                    System.out.println("Booking interrupted for " + userName);
                }

                totalSeats -= numberOfSeats;
                System.out.println("Booking successful for " + userName + ". Seats remaining: " + totalSeats);
            } else {
                System.out.println("Not enough seats for " + userName + ". Booking failed. Seats remaining: " + totalSeats);
            }
        }
    }
}

class UserThread extends Thread {
    private TicketCounter ticketCounter;
    private String userName;
    private int seatsToBook;

    public UserThread(TicketCounter ticketCounter, String userName, int seatsToBook) {
        this.ticketCounter = ticketCounter;
        this.userName = userName;
        this.seatsToBook = seatsToBook;
    }

    public void run() {
        ticketCounter.bookTicket(userName, seatsToBook);
    }
}

public class main {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();

        // Multiple user threads trying to book tickets
        UserThread user1 = new UserThread(counter, "Alice", 2);
        UserThread user2 = new UserThread(counter, "Bob", 2);
        UserThread user3 = new UserThread(counter, "Charlie", 2);

        user1.start();
        user2.start();
        user3.start();
    }
}
