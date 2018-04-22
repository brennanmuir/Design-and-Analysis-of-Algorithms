package hw3.cs4310.muir.wmich;

import java.util.Map.Entry;
import java.io.*;
import java.util.*;

/*
 * Brennan Muir
 * Gupta 4310
 * HW 3
 */

public class Encode {

	static Map<String, String> hm = new HashMap<String, String>();

	GenerateFile gf = new GenerateFile();
	int shiftCount = 1;

	public void compress(Node node, String string) {

			if(node.right != null){
				compress(node.right, string + "1");
			}
			if (node.left != null){
				compress(node.left, string + "0");
			}
			if (node.left == null && node.right == null){
                putMap(node.text,string);
        	}
	}

	// Put characters into a map with their character and binary code
	public void putMap(String text, String code) {
		hm.put(text, code);
	}

	// Print out what the existing Map looks like
	public void printOut(PrintWriter writer) {
		System.out.println("\nPrint out characters and their represented numbers");
		String[] letters;
		for (Entry<String, String> entry : hm.entrySet()) {
			writer.println("[" + entry.getKey() + ":" + entry.getValue().toString() + "]");
		}
	}

	// Create the encoded file, write to it using the map as a key for the text
	// entered by user in the beginning
	public String encode(String text) throws FileNotFoundException, UnsupportedEncodingException {
		System.out.println("\nPrint out encoded text and write to encodedFile.txt");
		String encodedString = null;
		String encodedFile = "encodedFile.txt";
		PrintWriter writer = new PrintWriter(encodedFile, "UTF-8");

		String[] toEncode = text.split("");
		for (int i = 0; i < text.length(); i++) {
			for (Entry<String, String> entry : hm.entrySet()) {
				if (toEncode[i].equals(entry.getKey())) {
					writer.print(entry.getValue());
//					System.out.print(entry.getValue());
					encodedString += entry.getValue();
				}
			}
		}
		if(encodedString == null){
			encodedString = "0";
			System.out.println("Cannot currently encode a one character long string.");
		}
		else
			encodedString = encodedString.split("null")[1];
		// Close file
		writer.close();
			

		return encodedString;
	}

}