package hw5.cs4310.muir.wmich;

public class Knapsack {

	public static void main(String args[]) {
		int profits[] = new int[] { 40, 20, 90, 60, 30 };
		int weight[] = new int[] { 10, 20, 30, 40, 50 };
		int capacity = 100;
		int length = profits.length;

		int i, j;
		int Array[][] = new int[length + 1][capacity + 1];

		// Build Array[][] bottom-up
		for (i = 0; i <= length; i++) {
			for (j = 0; j <= capacity; j++) {
				if (i == 0 || j == 0)
					Array[i][j] = 0;
				else if (weight[i - 1] <= j) {

					// get max value
					if (profits[i - 1] + Array[i - 1][j - weight[i - 1]] > Array[i - 1][j]) {
						Array[i][j] = profits[i - 1] + Array[i - 1][j - weight[i - 1]];
					} else {
						Array[i][j] = Array[i - 1][j];
					}

					int t = (i - 1);
					System.out.println("[" + i + "," + j + "]");
					System.out.println("max(" + profits[i - 1] + " + Array[" + t + "," + (j - weight[i - 1]) + "])"
							+ ", " + Array[i - 1][j]);
					System.out.println("\t Profits:" + Array[i][j]);
				} else
					Array[i][j] = Array[i - 1][j];
			}
		}

		System.out.println(Array[length][capacity]);
	}

}
