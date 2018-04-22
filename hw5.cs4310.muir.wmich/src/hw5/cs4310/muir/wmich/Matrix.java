package hw5.cs4310.muir.wmich;

public class Matrix {

	public static void main(String args[]) {
		int matrices[] = new int[] { 3, 35, 15, 5, 10, 2, 25 };
		int size = matrices.length;

		int matrix[][] = new int[size][size];

		for (int length = 2; length < size; length++) {
			for (int i = 1; i < size - length + 1; i++) {
				int j = i + length - 1;

				// set size of matrix array
				matrix[i][j] = Integer.MAX_VALUE;

				for (int k = i; k <= j - 1; k++) {
					// m[1,3] = the minimum of [m1,1]+m[2,3]+r0r1r3
					int multi = matrix[i][k] + matrix[k + 1][j] + matrices[i - 1] * matrices[k] * matrices[j];

					//make sure our integer is smaller than the max size we set
					if (multi < matrix[i][j])
						matrix[i][j] = multi;
					// output the multiplication result
					System.out.println("m[" + i + "," + j + "] = " + multi);
				}

				System.out.println("Minimum is: " + matrix[i][j] + "\n");
			}
		}
		System.out.println("********************************");

		System.out.println("Result: " + matrix[1][size - 1] + " multiplications");
	}
}