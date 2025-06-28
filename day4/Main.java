package session4;
import java.io.*;
import java.util.*;
public class Main {
	    public static void main(String[] args) {
	        String inputFile = "marks.txt";
	        String outputFile = "results.txt";

	        try (
	            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
	        ) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(" ");
	                String name = parts[0];

	                int total = 0;
	                for (int i = 1; i < parts.length; i++) {
	                    total += Integer.parseInt(parts[i]);
	                }

	                double average = (double) total / (parts.length - 1);
	                writer.write(name + " Total: " + total + " Average: " + String.format("%.2f", average));
	                writer.newLine();
	            }

	            System.out.println("Results written to: " + outputFile);
	        } catch (IOException e) {
	            System.out.println("File operation failed: " + e.getMessage());
	        }
	    }
	}


