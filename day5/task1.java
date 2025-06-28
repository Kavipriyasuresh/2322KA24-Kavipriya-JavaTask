package session5;
import java.util.ArrayList;
import java.util.Iterator;

class Student {
	private String name;
	private int rollNo;

	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	public String toString() {
		return "Name: " + name + ", Roll No: " + rollNo;
	}
}

public class task1 {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Alice", 1));
		students.add(new Student("Bob", 2));
		students.add(new Student("Charlie", 3));

		
		Iterator<Student> iterator = students.iterator();

		
		System.out.println("Student List:");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
