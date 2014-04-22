import java.util.Arrays;
public class Sicherman {
	public static void main(String[] args) {
		
		int [] guess = {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int position = 1;
		Boolean solutionFound = false;

		while (!solutionFound) {
			int [] guessChances = generateGuessChances(guess);
			
			if (isValidPartialSolution(guessChances) &&
				hasCorrectChances(guessChances) &&
				!hasSameDiceAsCanon(guess)) {
				solutionFound = true;
			} else if (isValidPartialSolution(guessChances)) {
				if (position < 11) {
					position++;
					guess[position]++;

					if (guess[position] > 11) {
						// backtrack
						int counter = 0;
						int index = 11;

						while (guess[index] >= 11) {
							guess[index] = 0;
							counter++;
							index--;
						} 
						position = position - counter;
						guess[position]++;
					}
				} else if (position == 11) {
					guess[position]++;

					if (guess[position] > 11) {
						//backtrack
						int counter = 0;
						int index = 11;

						while (guess[index] >= 11) {
							guess[index] = 0;
							counter++;
							index--;
						} 
						position = position - counter;
						guess[position]++;
					}
				}
			} else if (!isValidPartialSolution(guessChances)) {
				guess[position]++;
				if (guess[position] > 11) {
					// backtrack
					int counter = 0;
					int index = 11;

					while (guess[index] >= 11) {
						guess[index] = 0;
						counter++;
						index--;
					} 
					position = position - counter;
					guess[position]++;
				}
			}		
		}
		printSolution(guess);
	}

	public static int [] generateGuessChances (int [] currentGuess) {
		int [] currentGuessChances = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int sum = 0;
		// For each even, add it up with each odd
		for (int evenIndex = 0; evenIndex <= 10; evenIndex += 2) {
			for (int oddIndex = 1; oddIndex <= 11; oddIndex += 2) {
				if (currentGuess[evenIndex] == 0 || currentGuess[oddIndex] == 0) {
					continue;
				}
				sum = currentGuess[evenIndex] + currentGuess[oddIndex];
				if (sum >= 2 && sum <= 12) {
					currentGuessChances[(sum - 2)]++;
				}
			}
		}
		return currentGuessChances;
	}

	public static Boolean isValidPartialSolution (int [] guessChances) {
		int [] standardDieChances = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};

		for (int i = 0; i < standardDieChances.length; i++) {
			if (guessChances[i] > standardDieChances[i]) {
				return false;
			} 
		} 

		return true;
	}

	public static Boolean hasCorrectChances (int [] guessChances) {
		int [] standardDieChances = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
		return Arrays.equals(standardDieChances, guessChances);
	}

	public static Boolean hasSameDiceAsCanon (int[] guess) {
		int [] numberOfEachFace = {0, 0, 0, 0, 0, 0};

		for (int i = 0; i < guess.length; i++) {
			try {
				numberOfEachFace[(guess[i] - 1)] += 1;
			} catch (ArrayIndexOutOfBoundsException e) {
				return false;
			}


		}
		for (int i = 0; i < numberOfEachFace.length; i++) {
			if (numberOfEachFace[i] > 2) {
				return false;
			}
		}

		return true;
	}

	private static void printSolution (int [] guessDice) {
		System.out.println("Die 1 has values: " + guessDice[0] + ", " +
												  guessDice[2] + ", " +
												  guessDice[4] + ", " +
												  guessDice[6] + ", " +
												  guessDice[8] + ", " +
												  guessDice[10] + "\n" +
						   "Die 2 has values: " + guessDice[1] + ", " +
												  guessDice[3] + ", " +
												  guessDice[5] + ", " +
												  guessDice[7] + ", " +
												  guessDice[9] + ", " +
												  guessDice[11]);
	}
}