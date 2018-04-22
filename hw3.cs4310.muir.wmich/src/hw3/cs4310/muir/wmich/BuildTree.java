package hw3.cs4310.muir.wmich;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*
 * Brennan Muir
 * Gupta 4310
 * HW 3
 */

public class BuildTree {
	static Encode encode = new Encode();

	// Returns root node to pass to printFromPreOrder
	public static Node makeHuffmanTree(HashMap map, String text) {
		
		// Initialize new PriorityQueue
		PriorityQueue<Node> Q = new PriorityQueue<Node>();
		// List of characters that are allowed (a,b,c, and space) to be used for
		// printing the map
		char[] letters = text.toCharArray();
		// For each character in the string
		for (int i = 0; i < letters.length; i++) {
			int num = (int) map.get(letters[i]);
			String[] letterString = text.split("");
			// Create a single-node binary tree, storing each character.
			// Frequency element is the key.
			Node n = new Node(letterString[i], num);
			// Insert the element into Queue
			Q.add(n);
		}

		Node root = null;
		// While the Queue still exists
		while (Q.size() > 1) {
			Node smallest1 = Q.poll();
			Node smallest2 = Q.poll();
			Node combined = new Node(smallest1.frequency + smallest2.frequency);
			combined.left = smallest1;
			combined.right = smallest2;
			smallest1.parent = combined;
			smallest2.parent = combined;
			Q.add(combined);
			// Keep track until we actually find the root
			root = combined;
		}

		return root;

	}

	public static void postOrder(Node root) {

		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			encode.compress(root, "");
		}
	}

	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			encode.compress(root, "");
			inOrder(root.right);
		}
	}
	
	public static void preOrder(Node root) {
		if (root != null) {
			encode.compress(root, "");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

}

/*
 * I used the following links for reference:
 * https://stackoverflow.com/questions/6065710/how-does-javas-priorityqueue-
 * differ-from-a-min-heap
 * https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html#poll()
 */