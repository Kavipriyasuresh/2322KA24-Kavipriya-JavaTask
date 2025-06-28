package session2;
import java.util.Scanner;

public class reverse{

public static void main(String[] args){

Scanner sc = new Scanner(System.in);

int[] arr = new int[5];

System.out.println("enter the element");

int i;

for(i=0;i<5;i++){

arr[i] = sc.nextInt();

}

System.out.println("number is reverse");

for(i=4;i>=0;i--){

System.out.print(" "+arr[i]);

}}}
