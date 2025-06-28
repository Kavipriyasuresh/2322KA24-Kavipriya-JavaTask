package session1;
import java.util.Scanner;

public class Grade{

static void gradeResult(int mark) {

if(mark>=90)

System.out.println("Grade: A");

else if(mark>=80)

System.out.println("Grade:B");

else if(mark>=70)

System.out.println("Grade:C");

else if(mark>=60)

System.out.println("Grade:D"); else

System.out.println("Fail");

}


public static void main(String[] args){

Scanner sc= new Scanner(System.in);

System.out.println("enter the students mark:");

int num=sc.nextInt();

gradeResult(num);


}

}
