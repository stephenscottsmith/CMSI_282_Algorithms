/* Recursive Kirkman */
public class Kirkman {
	
	int rows = 5;
	int columns = 3;
	int girls = rows * columns;
	int days = (girls - 1) / (columns - 1);
	int [][][] week = new int[days][rows][columns];
	int currentDay = 0;

	// single array for each day of who has been used
	boolean [][] touched = new boolean[girls][girls];
	boolean [][] used = new boolean[days][girls];

	public static void main(String[] args) {
		// try {
			solve(0);
		// } catch (Exception e) {
		// 	System.out.println("EXCEPTION HAS BEEN THROWN");
		// }
	}

	public static int solve (int girlToSolve) {
		// Are we done?
			// If so, print the solution
		// Else
			// For every possible girl, 
				// Possible girl = the next not used person AND who's
				// number is greater than the person above it 
				// if in column 0 else greater than the person to the left
					// Place girl
					// If placement was successful, girlToSolve += 1
						// If girlToSolve == 15, then currentDay++, girlToSolve = 0 call solve(0)
						// then solve(girlToSovle)
					// remove();
			//when done with girls
				//girlToSolve -= 1
				//if girlToSolve < 0
					//girlToSolve = 14;
					//currentDay -= 1;
				//and return;

		if (done) {
			printSolution(); throw exception;

		} else {
			for (each possible girl) {
				if (insert) {
					next call
				}
				remove
			}
			return;
		}
	}
}
