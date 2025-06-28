package session1;
import java.util.Scanner;

public class task2{

public static void main(String[] args){

Scanner sc= new Scanner(System.in);

System.out.print("Enter the princple:");

double p = sc.nextDouble();

System.out.print("enter the no. of year:");

double n = sc.nextDouble();

System.out.print("enter the rate:");

double r = sc.nextDouble();

if(p>0 && n>0 && r>0){

double percent=((p*n*r)/100);

System.out.println("simple interest="+percent);

}

}

}