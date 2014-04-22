import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;

public class PentagonSolver {
	
	public static void main(String[] args) {
		Permutation p = new Permutation(10);
		Long totalPermutations = p.totalPermutations(p.toArray().length);
		int side1, side2, side3, side4, side5;
		int [] permArray;
		int numberOfSolutions = 1;
		ArrayList<String> solutions = new ArrayList<String>();
		String solutionString = "Pentagon Solutions: ";

		for (long i = 0; i < totalPermutations; i++) {
			permArray = p.toArray();
			side1 = sumSide(permArray[0], permArray[1], permArray[2]);
			side2 = sumSide(permArray[2], permArray[3], permArray[4]);
			side3 = sumSide(permArray[4], permArray[5], permArray[6]);
			side4 = sumSide(permArray[6], permArray[7], permArray[8]);
			side5 = sumSide(permArray[8], permArray[9], permArray[0]);
			String pString = p.toString();

			if ((side1 == side2) && (side2 == side3) && (side3 == side4) && (side4 == side5)) {
				if (solutions.size() == 0) {
					solutions.add(pString);
					solutionString += getStringForSolution(i, numberOfSolutions, p.toString(), side1);
				} else {
					if (!isRotation(solutions, pString)) {
						numberOfSolutions++;
						solutions.add(pString);
						solutionString += getStringForSolution(i, numberOfSolutions, p.toString(), side1);
					}
				}					
			} 

			// Should only try this because at the end it will 
			// try to advance further but will not be able to do so
			try {
				p.advance();
			} catch (Exception e) {

			}	
		}	

		System.out.println(solutionString);		
	}

	private static String getStringForSolution (long index, int solutionNumber, String permString, int sum) {
		return "\nPermutation " + index + ", Solution#" + solutionNumber + " : " + permString + 
											"\nSum of one side: " + sum;
	}

	private static boolean isRotation (ArrayList<String> solutions, String pString) {
		Object [] solutionStrings = solutions.toArray();

		for (int i = 0; i < solutionStrings.length; i++) {
			String temp = solutionStrings[i].toString() + solutionStrings[i].toString();

			if ((temp.indexOf(pString) != -1)) {
				return true;
			}
		}

		return false;
	}

	private static int sumSide(int corner1, int middle, int corner2) {
		return corner1 + middle + corner2;
	}
}







