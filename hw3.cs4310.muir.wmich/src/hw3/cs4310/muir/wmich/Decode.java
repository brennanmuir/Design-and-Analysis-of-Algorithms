package hw3.cs4310.muir.wmich;

import java.io.IOException;

/*
 * Brennan Muir
 * Gupta 4310
 * HW 3
 */

public class Decode {
	public static String decode(String encodedString, Node root) throws IOException {
		GenerateFile gf = new GenerateFile();

		String path = "";
		StringBuffer result = new StringBuffer("");
		Node node = root;
		
		if(encodedString.equals("0")){
			result = result.append(root.text);
			return result.toString();
		}
		else{
			for (int i = 0; i < encodedString.length(); i++) {
				path = encodedString.substring(i, i + 1);
	
				if(node.left == null && node.right == null){
					result = result.append(node.text);
					System.out.println("Printing " + node.text + " and setting node to root");
					node = root;
				}
				
				if (path.equals("1")) {
					if(node.left == null && node.right == null){
						result = result.append(node.text);
						System.out.println("Printing " + node.text + " and setting node to root");
						node = root;
					}
					else {
						node=node.right;
						System.out.println("path is " + path + " Going right.");
					}
				} else if (path.equals("0")) {
					if(node.left == null && node.right == null){
						result = result.append(node.text);
						System.out.println("Printing " + node.text + " and setting node to root");
						node = root;
					}
					else{
						node=node.left;
						System.out.println("path is " + path + " Going left.");
					}
				}
			}
			result = result.append(node.text);
			System.out.println("\n" + result.toString());
			return result.toString();
		}
	}
}
