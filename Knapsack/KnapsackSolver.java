import java.lang.Math.*;
import java.util.ArrayList;

public class KnapsackSolver {

    private static int[][] sack (int [][] solutions, ArrayList<Integer> weights, ArrayList<Integer> values, 
    						 int sackWeight, int sizeOfValuesArray) {
    	for (int y = 1; y < sizeOfValuesArray + 1; y++) {
			for (int x = 0; x < sackWeight + 1; x++) {
				if (weights.get(y - 1) > x) {
					solutions[x][y] = solutions[x][y - 1]; 
				} else {
					solutions[x][y] = Math.max(solutions[x][y - 1], (solutions[x - weights.get(y - 1)][y - 1] + values.get(y - 1)));
				}
			}
		}
		return solutions;
    }

    private static int[][] createDoubleArrayWithZeroFirstColumn (int sackWeight, int sizeOfValuesArray) {
    	int[][] solutions = new int[sackWeight + 1][sizeOfValuesArray + 1];

    	for (int x = 0; x < sackWeight + 1; x++) {
			for (int y = 0; y < sizeOfValuesArray + 1; y++) {
				solutions[x][y] = 0;
			}
		} 

		return solutions;
    }

    private static ArrayList<Integer> determineSackedItems(int[][] solutions, ArrayList<Integer>weights, int sackWeight, int sizeOfValuesArray) {
    	ArrayList<Integer> finalSack = new ArrayList<Integer>();

		int x = sackWeight;
		for (int y = sizeOfValuesArray; y > 0; y--) {
			if (solutions[x][y] != solutions[x][y - 1]) {
				finalSack.add(y - 1);	 
				x = x - weights.get(y - 1);
			}
		}

		return finalSack;
    }

    private static void printSolutions (int[][] solutions, ArrayList<Integer>finalSack, ArrayList<Integer>weights, ArrayList<Integer>values) {
    	
    	int weightTotal = 0;
		int valueTotal = 0;

		for (int i = finalSack.size() - 1; i >= 0; i--) {
			System.out.println("Take the " + weights.get(finalSack.get(i)) + " pound item: $" + values.get(finalSack.get(i)));
			weightTotal += weights.get(finalSack.get(i));
			valueTotal += values.get(finalSack.get(i)); 
		}

		System.out.println("------------------------------------");
		
		System.out.println("Totals: " + weightTotal + " pounds, $"+ valueTotal);
    }

    public static void main (String[] args) {
        try { 

            int argsLength = args.length;
            // Check for correct length of input data
            if (argsLength < 3 || argsLength % 2 != 1 || (argsLength - 1) < 0) {
                throw new IllegalArgumentException("INSUFFICENT OR INCORRECT DATA!");
            } 

            int sackWeight = Integer.parseInt(args[argsLength - 1]);
			ArrayList<Integer> values = new ArrayList<Integer>();
			ArrayList<Integer> weights = new ArrayList<Integer>();

			for (int i = 0, j = 0, k = 0; i < argsLength - 1; i++) {
                if (i % 2 == 0) {
                    // Fill values array
                    values.add(Integer.parseInt(args[i]));
                    j++;
                } else {
                    // Fill weights array
                    weights.add(Integer.parseInt(args[i]));
                    k++;
                }
            }

            int sizeOfValuesArray = values.size();

			int[][] solutions = sack(createDoubleArrayWithZeroFirstColumn(sackWeight, sizeOfValuesArray), 
									 weights, values, sackWeight, sizeOfValuesArray);			
			
			ArrayList<Integer> finalSack = determineSackedItems(solutions, weights, sackWeight, sizeOfValuesArray);
	 
			printSolutions(solutions, finalSack, weights, values);
			
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}