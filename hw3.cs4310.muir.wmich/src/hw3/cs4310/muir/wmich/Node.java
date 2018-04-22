package hw3.cs4310.muir.wmich;

import java.util.*;

/*
 * Brennan Muir
 * Gupta 4310
 * HW 3
 */

public class Node implements Comparable<Node> {

	Node left;
	Node right;
	Node parent;

	String text;
	int frequency;

	// Constructor
	public Node() {
		left = null;
		right = null;
	}

	// gets node to the left
	public Node getLeft() {
		return left;
	}

	// Sets node to the left
	public void setLeft(Node left) {
		this.left = left;
	}

	// Gets node to the right
	public Node getRight() {
		return right;
	}

	// Sets node to the right
	public void setRight(Node right) {
		this.right = right;
	}

	public Node(String textTemp, int fTemp) {
		text = textTemp;
		frequency = fTemp;
	}

	public Node(int fIn) {
		text = "";
		frequency = fIn;
	}

	public int compareTo(Node n) {
		if (frequency < n.frequency) {
			return -1;
		} else if (frequency > n.frequency) {
			return 1;
		}
		return 0;
	}
}