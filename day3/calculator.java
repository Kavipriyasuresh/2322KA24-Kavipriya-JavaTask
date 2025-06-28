package session2;
public class calculator {

    public static void main(String[] args) {
        Employee emp = new Employee("kavipriya sureshkumar", 25, "EMP123", 30_000);
        emp.displayEmployeeDetails();
    }
}
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

class Employee extends Person {
    private String employeeId;
    private double basicSalary;
    private double hra;   
    private double da;   

    public Employee(String name, int age, String employeeId, double basicSalary) {
        super(name, age);
        this.employeeId  = employeeId;
        this.basicSalary = basicSalary;
        this.hra = 0.20 * basicSalary;
        this.da  = 0.10 * basicSalary;
    }

    public double calculateSalary() {
        return basicSalary + hra + da;
    }

    public void displayEmployeeDetails() {
        displayDetails();                   
        System.out.println("Emp‑ID        : " + employeeId);
        System.out.printf ("Basic Salary  : ₹%.2f%n", basicSalary);
        System.out.printf ("House Rent Allowance (20%%)     : ₹%.2f%n", hra);
        System.out.printf ("Dearness Allowence (10%%)     : ₹%.2f%n", da);
        System.out.printf ("Total Salary  : ₹%.2f%n", calculateSalary());
    }
}

