package session2;
public class Overloading{

   
    public int sum(int a, int b) {
        System.out.println("Called sum(int, int)");
        return a + b;
    }

    public double sum(double a, double b) {
        System.out.println("Called sum(double, double)");
        return a + b;
    }

    public static void main(String[] args) {
    	Overloading obj = new Overloading();

        int intResult = obj.sum(10, 20);
        System.out.println("Sum of integers: " + intResult);

        double doubleResult = obj.sum(10.5, 20.75); 
        System.out.println("Sum of doubles: " + doubleResult);
    }

}

