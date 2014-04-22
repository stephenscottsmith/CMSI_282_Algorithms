import java.util.ArrayList;
import java.util.Arrays;

public class SchoolSolver {
	

	public static void main(String[] args) {
		
		Permutation perm = new Permutation(15);
		int solutions = 1;
		int [] permArray = perm.toArray();
		boolean [][] stoodTogether = new boolean [15][15];
		
		
		int [][] day1 = {Arrays.copyOfRange(permArray, 0, 3),
						Arrays.copyOfRange(permArray, 3, 6),
						Arrays.copyOfRange(permArray, 6, 9),
						Arrays.copyOfRange(permArray, 9, 12),
						Arrays.copyOfRange(permArray, 12, 15)};
		fillBoolArray(stoodTogether, day1);


		int [] test = {9, 6, 10, 12, 3, 7, 11, 4, 13, 14, 5, 8};
		Permutation testPerm = new Permutation(test);
		int [] testArray = testPerm.toArray();
		
		int [] possibleSolution = {0, testArray[0], testArray[1], 
								   1, testArray[2], testArray[3],
								   2, testArray[4], testArray[5],
								   testArray[6], testArray[7], testArray[8],
								   testArray[9], testArray[10], testArray[11]};
		Permutation newSolution = new Permutation(possibleSolution);

		while (solutions != 7) {
			possibleSolution = {0, testArray[0], testArray[1], 
								   1, testArray[2], testArray[3],
								   2, testArray[4], testArray[5],
								   testArray[6], testArray[7], testArray[8],
								   testArray[9], testArray[10], testArray[11]};

			int [][] rows = {Arrays.copyOfRange(possibleSolution, 0, 3),
							 Arrays.copyOfRange(possibleSolution, 3, 6),
							 Arrays.copyOfRange(possibleSolution, 6, 9),
							 Arrays.copyOfRange(possibleSolution, 9, 12),
							 Arrays.copyOfRange(possibleSolution, 12, 15)};

			if (isValid(rows, stoodTogether)) {
				// Add solution
				solutions++;

				// Add the people that have stood together to the 2D array
				fillBoolArray(stoodTogether, rows);
				System.out.println("SOLUTION!: " + newSolution.toString());
			}
			System.out.println(newSolution.toString());
			testPerm.advance();
		}
		


	}

	private static boolean isValid( int[][] rows, boolean[][] stoodTogether ){
		return 	isValidRow(rows[0], stoodTogether) && isValidRow(rows[1], stoodTogether) &&
				isValidRow(rows[2], stoodTogether) && isValidRow(rows[3], stoodTogether) &&
				isValidRow(rows[4], stoodTogether);
	}

	private static boolean isValidRow(int[] row, boolean [][] stoodTogether){
		for (int i = 0; i < row.length; i++) {
			for (int j = 1; j < row.length; j++) {
				if (stoodTogether[row[i]][row[j]] || stoodTogether[row[j]][row[i]]) {
					return false;
				}
			}
		}

		return true;
		
	}

	private static void fillBoolArray (boolean[][] stoodTogether, int[][] day) {
		int[] currentRow;
		for(int row = 0; row < 5; row++){
			currentRow = day[row];

			stoodTogether[currentRow[0]][currentRow[1]] = true;
			stoodTogether[currentRow[0]][currentRow[2]] = true;
			stoodTogether[currentRow[1]][currentRow[0]] = true;
			stoodTogether[currentRow[1]][currentRow[2]] = true;
			stoodTogether[currentRow[2]][currentRow[0]] = true;
			stoodTogether[currentRow[2]][currentRow[1]] = true;
		}
	}

	// public class Day {

	// 	public int [] a1;
	// 	public int [] a2;
	// 	public int [] a3;
	// 	public int [] a4;
	// 	public int [] a5;

	// 	public Day(){
	// 		a1 = {0, 1, 2};
	// 		a2 = {3, 4, 5};
	// 		a3 = {6, 7, 8};
	// 		a4 = {9, 10, 11};
	// 		a5 = {12, 13, 14};

	// 		Permutation p1 = new Permutation(a1);
	// 		Permutation p2 = new Permutation(a2);
	// 		Permutation p3 = new Permutation(a3);
	// 		Permutation p4 = new Permutation(a4);
	// 		Permutation p5 = new Permutation(a5);


	// 	}

	// 	public boolean iterate(){

	// 	}

	// 	public boolean isValid(){

	// 	}

	// }
}