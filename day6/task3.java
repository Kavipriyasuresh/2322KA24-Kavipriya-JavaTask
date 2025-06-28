package session6;
class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(name + " was interrupted.");
            }
        }
        System.out.println(name + " finished.");
    }
}

public class task3 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");

        System.out.println("Starting Thread-1...");
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Thread-1.");
        }

        System.out.println("Starting Thread-2 after Thread-1 finishes...");
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for Thread-2.");
        }

        System.out.println("All threads completed. Main thread ending.");
    }
}
