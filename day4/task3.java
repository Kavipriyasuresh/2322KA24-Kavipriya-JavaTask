package session4;
import java.io.*;
import java.util.Scanner;
public class task3 {
	    public static void main(String[] args) {
	        String fileName = "output.txt"; 
	        Scanner scanner = new Scanner(System.in);

	        try {
	            FileWriter fileWriter = new FileWriter(fileName);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            System.out.println("Enter lines to write to the file (type 'exit' to stop):");

	            while (true) {
	                String line = scanner.nextLine();
	                if (line.equalsIgnoreCase("exit")) {
	                    break;
	                }
	                bufferedWriter.write(line);
	                bufferedWriter.newLine(); 
	            }

	            bufferedWriter.close(); 
	            System.out.println("Strings written to " + fileName + " successfully.");

	        } catch (IOException e) {
	            System.out.println("An error occurred while writing to the file.");
	        }

	        scanner.close();
	    }
	}