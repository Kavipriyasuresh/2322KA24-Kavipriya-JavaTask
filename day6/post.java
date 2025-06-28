package session6;
public class post {
    static class BankAccount {
        private int balance = 1000;

        public synchronized void withdraw(String user, int amount) {
            System.out.println(Thread.currentThread().getName() + " trying to withdraw $" + amount);

            if (balance >= amount) {
                System.out.println("Sufficient balance. Processing for " + user + "...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Transaction interrupted for " + user);
                }

                balance -= amount;
                System.out.println("Withdrawal successful for " + user + ". Remaining balance: $" + balance);
            } else {
                System.out.println("Insufficient balance for " + user + ". Transaction failed. Remaining balance: $" + balance);
            }
        }
    }

    static class UserThread extends Thread {
        private BankAccount account;
        private String user;
        private int amount;

        public UserThread(BankAccount account, String user, int amount) {
            this.account = account;
            this.user = user;
            this.amount = amount;
            this.setName(user); 
        }

        public void run() {
            account.withdraw(user, amount);
        }
    }

 
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

       
        UserThread user1 = new UserThread(account, "Alice", 500);
        UserThread user2 = new UserThread(account, "Bob", 700);
        UserThread user3 = new UserThread(account, "Charlie", 300);

        user1.start();
        user2.start();
        user3.start();
    }
}
