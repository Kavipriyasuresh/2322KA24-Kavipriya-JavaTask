package session4;
import java.io.*;
public class task2 {

	
	    public static void main(String[] args) {
	        String fileName = "sample.txt"; 

	        try {
	            FileReader fileReader = new FileReader(fileName);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);

	            String line;
	            System.out.println("File Content:");
	            while ((line = bufferedReader.readLine()) != null) {
	                System.out.println(line);
	            }

	            bufferedReader.close();
	        } catch (FileNotFoundException e) {
	            System.out.println("Error: File not found!");
	        } catch (IOException e) {
	            System.out.println("Error reading the file!");
	        }
	    }
	}

