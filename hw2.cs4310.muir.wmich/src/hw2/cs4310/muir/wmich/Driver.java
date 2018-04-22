package hw2.cs4310.muir.wmich;

import java.util.Scanner;

public class Driver {

	public static long start, end;

	public static void main(String args[]) {
		startTimer();
		Scanner kb = new Scanner(System.in);
		// Fill array with X integers
		System.out.println("Select how many Integers you'd like in the array:");
		int num = kb.nextInt();
		Integer[] array = new Integer[num];

		System.out.print("\n[");

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 1000);
			System.out.print(array[i] + " ");
		}
		System.out.print("]\n");
		MergeSort ms = new MergeSort();

		ms.cloneArray(array);

		endTimer();
		System.out.println("Sorted 3 way merge sort: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}

	// Timers for calculating time complexity
	public static void startTimer() {
		start = System.nanoTime();
	}

	public static void endTimer() {
		end = System.nanoTime();
		System.out.println("\nProcessing time is " + (end - start) / 1000.0 + " us.\n");
	}
}
