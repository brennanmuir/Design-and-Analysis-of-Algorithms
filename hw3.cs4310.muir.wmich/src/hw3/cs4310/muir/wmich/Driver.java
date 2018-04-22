package hw3.cs4310.muir.wmich;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/*
 * Brennan Muir
 * Gupta 4310
 * HW 3
 */

public class Driver {
	public static void main(String[] args) throws IOException{
		
		String decodedFile = "decodedFile.txt";
		PrintWriter writer = new PrintWriter(decodedFile, "UTF-8");
		
		GenerateFile gf = new GenerateFile();
		long startTime = System.nanoTime();
		Encode encode = new Encode();
		CountFrequencies cf = new CountFrequencies();
		BuildTree bt = new BuildTree();
		Decode decode = new Decode();
		
		String text = gf.inputText();
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();    
		
		map = cf.getFrequencies(text);
		Node root = bt.makeHuffmanTree(map, text);
		
		
		
		bt.postOrder(root);
		
		encode.printOut(writer);
		String encodedString = encode.encode(text);
		System.out.println(encodedString);
		gf.encodedFile(encodedString);
		
		
		String decodedString = Decode.decode(encodedString, root);
		writer.println("\n"+encodedString);
		writer.println("\n"+decodedString);
		writer.close();
		long endTime = System.nanoTime();
		long finalTime = endTime-startTime;
		System.out.println("Time completed in: " + finalTime + " nano-seconds");
	}

}
