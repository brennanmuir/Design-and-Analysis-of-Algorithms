package hw3.cs4310.muir.wmich;

import java.io.*;
import java.util.Scanner;

/*
 * Brennan Muir
 * Gupta 4310
 * HW 3
 */
public class GenerateFile {

	public static String inputText() throws IOException{
		Scanner kb = new Scanner(System.in);
		String inputFile = "inputFile.txt";

		// Get text input from user. We assume the user will only use lowercase and the letters provided below
		System.out.println("Enter the string you would like to compress.");
		PrintWriter writer = new PrintWriter(inputFile, "UTF-8");
		
		// Store text into a string
		String text = kb.nextLine().toLowerCase();
		
		// Write the text to a file
		System.out.println("\nThe following is being printed to the file: " + inputFile + "\n" + text + "\n");
		
		writer.print(text);
		
		// Close file
		writer.close();
		System.out.println("File has been created and put into the project folder.");
		
		return text;
	}
	
	public static void encodedFile(String string) throws IOException{
		String encodedFile = "encodedFile.txt";

		PrintWriter writer = new PrintWriter(encodedFile, "UTF-8");;
		
		writer.print(string);
		// Close file
		writer.close();
		System.out.println("\nFile has been created and put into the project folder.");
	
	}	
}
