// Recursive Knapsack Solver
// ONLY OUTPUTS THE OPTIMAL VALUE

import java.lang.Math.*;
import java.util.ArrayList;

public class Knapsack {

    private static int[] values;
    private static int[] weights;
    private static ArrayList<Integer> weightsKept = new ArrayList<Integer>();
    private static int previousSackWeight;

    private static int knapsack(int i, int sackWeight) {
        if (i < 0) {
            return 0;
        }
        if (weights[i] > sackWeight) {
            return knapsack(i - 1, sackWeight);
        } else {
            int firstReturned = knapsack(i - 1, sackWeight);
            int secondReturned = knapsack(i - 1, sackWeight - weights[i]);
            return Math.max(firstReturned, secondReturned + values[i]);
        }
    }

    public static void main(String[] args) {
        try { 

            int argsLength = args.length;
            // Check for correct length of input data
            if (argsLength < 3 || argsLength % 2 != 1) {
                throw new IllegalArgumentException("INSUFFICENT OR INCORRECT DATA!");
            } 

            int sackWeight = Integer.parseInt(args[argsLength - 1]);
            int newLength = (args.length - 1) / 2;
            int[] values = new int[newLength];
            int[] weights = new int[newLength];

            for (int i = 0, j = 0, k = 0; i < argsLength - 1; i++) {
                if (i % 2 == 0) {
                    // Fill values array
                    values[j] = Integer.parseInt(args[i]);
                    j++;
                } else {
                    // Fill weights array
                    weights[k] = Integer.parseInt(args[i]);
                    k++;
                }
            }

            Knapsack.values = values;
            Knapsack.weights = weights;
            System.out.println("Answer: " + knapsack((values.length - 1), sackWeight));

        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}